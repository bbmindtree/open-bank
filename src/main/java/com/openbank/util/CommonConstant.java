package com.openbank.util;

public class CommonConstant {

	private CommonConstant(){}
	
	public static final String TRANSATION_FILTER="transactiontype";
	
	public static final String FILTER_TRANSACTION_URI ="getfiltertransactions";
	
	public static final String REDIRECT_LOGIN_MSG="Redirecting to login page";
	
	public static final String TRANSACTION_TYPE="sandbox-payment";
	
	public static final String LOGIN="login";
	
	public static final String HOME="home";
	
	public static final String ALL_TRANSACTIONS_DIRECT="direct://allTransactions";
	
	public static final String FILTERED_TRANSACTIONS_DIRECT="direct://filteredTransactions";
	
	public static final String FILTERED_TRANSACTIONS_TOTAL_AMT_DIRECT="direct://filteredTransactionsTotalAmt";
	
	public static final String ALL_TRANSACTIONS_MAPPING="/rest/gettransactions";
	
	public static final String FILTERED_TRANSACTIONS_MAPPING="/rest/getfiltertransactions";
	
	public static final String FILTERED_TRANSACTIONS_TOTAL_AMT_MAPPING="/rest/gettotalamount";

}
