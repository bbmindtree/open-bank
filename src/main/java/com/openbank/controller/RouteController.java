package com.openbank.controller;

public interface RouteController {

	public String getAllTranscations();

	public String getFilteredTranscations(String type );

	public String getTotalAmt(String type );
}
