package com.openbank.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.openbank.helper.ApplicationHelper;
import com.openbank.model.Account;
import com.openbank.util.CommonConstant;

public class AccountTypeProcessor implements Processor {

	private static final Logger logger = LoggerFactory.getLogger(AccountTypeProcessor.class);
	
	@Override
	public void process(Exchange exchange) throws Exception {
		
		logger.info("get filter object from header");

		String type = (String) exchange.getIn().getHeader(CommonConstant.TRANSATION_FILTER);

		logger.info("get all transactions from body");
		
		Account account = exchange.getIn().getBody(Account.class);
		
		double totalAmmount=0.0;
		
		if (type != null) {

			 totalAmmount=ApplicationHelper.setFilterTransaction(account, type);
		}
		
		logger.info("set filtered transactions into body");

		ApplicationHelper.setExchangeBody(exchange, account, totalAmmount);
	}

}
