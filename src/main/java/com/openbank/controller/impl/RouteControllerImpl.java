package com.openbank.controller.impl;

import org.apache.camel.Produce;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.openbank.controller.RouteController;
import com.openbank.route.AllTransactionRouteProxy;
import com.openbank.route.FilteredTransactionsRouteProxy;
import com.openbank.route.FilteredTransactionsTotalAmtRouteProxy;
import com.openbank.util.CommonConstant;

@Controller
public class RouteControllerImpl implements RouteController {

	@Produce(uri = CommonConstant.ALL_TRANSACTIONS_DIRECT)
	private AllTransactionRouteProxy allTransactionRoute;

	@Produce(uri = CommonConstant.FILTERED_TRANSACTIONS_DIRECT)
	private FilteredTransactionsRouteProxy filteredTransactionsRoute;

	@Produce(uri = CommonConstant.FILTERED_TRANSACTIONS_TOTAL_AMT_DIRECT)
	private FilteredTransactionsTotalAmtRouteProxy filteredTransactionsTotalAmtRoute;;

	@Override
	@RequestMapping(value = CommonConstant.ALL_TRANSACTIONS_MAPPING, method = RequestMethod.GET)
	public @ResponseBody String getAllTranscations() {

		return allTransactionRoute.getAllTransactions();
	}

	@Override
	@RequestMapping(value = CommonConstant.FILTERED_TRANSACTIONS_MAPPING, method = RequestMethod.GET)
	public @ResponseBody String getFilteredTranscations(@RequestHeader(CommonConstant.TRANSATION_FILTER) String type) {

		return filteredTransactionsRoute.getFilteredTransactions(type, null);
	}

	@Override
	@RequestMapping(value = CommonConstant.FILTERED_TRANSACTIONS_TOTAL_AMT_MAPPING, method = RequestMethod.GET)
	public @ResponseBody String getTotalAmt(@RequestHeader(CommonConstant.TRANSATION_FILTER) String type) {

		return filteredTransactionsTotalAmtRoute.getFilteredTransactionTotalAmt(type, null);
	}

}
