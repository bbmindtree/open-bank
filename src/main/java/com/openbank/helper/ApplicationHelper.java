package com.openbank.helper;

import java.util.ArrayList;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.openbank.model.Account;
import com.openbank.model.Transactions;
import com.openbank.util.CommonConstant;

public class ApplicationHelper {

	private ApplicationHelper(){};
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationHelper.class);
	
	public static double setFilterTransaction(Account account, String type) {

		double totalAmmount = 0.0;

		ArrayList<Transactions> filterTransactions = new ArrayList<>();

		for (Transactions transaction : account.getTransactions()) {

			if (transaction != null && transaction.getDetails() != null && transaction.getDetails().getType() != null
					&& transaction.getDetails().getType().equals(type)) {

				filterTransactions.add(transaction);

				if (transaction.getDetails().getValue() != null)
					totalAmmount += transaction.getDetails().getValue().getAmount();
			}
		}

		account.setTransactions(filterTransactions);
		
		logger.info("set filtered transactions into account");
		
		return totalAmmount;
	}

	public static void setExchangeBody(Exchange exchange, Account account, double totalAmmount) {
				
		if (exchange.getFromEndpoint().getEndpointUri().contains(CommonConstant.FILTER_TRANSACTION_URI)) {

			exchange.getOut().setBody(account);
			
			logger.info("set filter transactions into body");
			
		} else {

			StringBuilder builder = new StringBuilder();

			builder.append("{ \"totalamount\" : " + totalAmmount + "}");

			exchange.getOut().setBody(builder.toString());
			
			logger.info("set total amount of filtered transactions into body");
			
		}
	}
}
