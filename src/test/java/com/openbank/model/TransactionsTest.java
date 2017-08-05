package com.openbank.model;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openbank.helper.ApplicationHelper;
import com.openbank.util.CommonConstant;

public class TransactionsTest {

	File JSONFile;
	
	@Before
	public void setup() throws IOException{
		
		JSONFile=new ClassPathResource("transactions-mock.json").getFile();
	}
	
	/*
	 *  Test Total Amount logic on mock JASON
	 */
	
	@Test
	public void totalAmount()throws Exception{
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		Account account=objectMapper.readValue(Files.readAllBytes(JSONFile.toPath()), Account.class);
		
		double totalAmount=ApplicationHelper.setFilterTransaction(account, CommonConstant.TRANSACTION_TYPE);
		
		assertTrue(totalAmount == 73.75999999999999);
	}
	
	/*
	 *  Test the Filter logic on mock JASON
	 */
	
	@Test
	public void filteredTransactions()throws Exception{
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		Account account=objectMapper.readValue(Files.readAllBytes(JSONFile.toPath()), Account.class);
		
		int allAccountTransactionSize=account.getTransactions().size();
		
		ApplicationHelper.setFilterTransaction(account, CommonConstant.TRANSACTION_TYPE);
		
		int filteredTransactionsListSize=account.getTransactions().size();
		
		assertTrue(allAccountTransactionSize>filteredTransactionsListSize);
		
		assertTrue(filteredTransactionsListSize == 19);
		
		
	}
	
}
