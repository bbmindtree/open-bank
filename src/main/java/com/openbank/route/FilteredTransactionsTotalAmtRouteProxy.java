package com.openbank.route;

import org.apache.camel.Body;
import org.apache.camel.Header;

import com.openbank.util.CommonConstant;

public interface FilteredTransactionsTotalAmtRouteProxy {
	
	public String getFilteredTransactionTotalAmt(@Header(CommonConstant.TRANSATION_FILTER) String type, @Body String body);
}
