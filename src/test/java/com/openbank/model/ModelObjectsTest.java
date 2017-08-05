package com.openbank.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ModelObjectsTest {
	
	
	
		File JSONFile;
		
		@Before
		public void setup() throws IOException{
			
			JSONFile=new ClassPathResource("transactions-mock.json").getFile();
		}
		
		/*
		 * Test to load JASON File
		 */
		
		@Test
		public void loadMockJsonintoFile()throws Exception{
			
			assertNotNull(JSONFile); 
			
		    assertTrue("transactions-mock.json".equals(JSONFile.getName()));
		}
		
		/*
		 * Test check data from JASON file
		 */
		
		@Test
		public void readJsonDataFromFile()throws Exception{
			
			byte[] jsonData = Files.readAllBytes(JSONFile.toPath());
			
			assertNotNull(jsonData);
		}
		
		/*
		 * Test Unmarshalling JASON File to Account object
		 */
		
		@Test
		public void unmarshal()throws Exception{
			
			ObjectMapper objectMapper = new ObjectMapper();
			
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			
			Account account=objectMapper.readValue(Files.readAllBytes(JSONFile.toPath()), Account.class);
			
			assertNotNull(account);
			
		}
	
		/*
		 * Test marshalling Account object to JASON string
		 */
		
		@Test
		public void marshal()throws Exception{
			
			ObjectMapper objectMapper = new ObjectMapper();
			
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			
			Account account=objectMapper.readValue(Files.readAllBytes(JSONFile.toPath()), Account.class);
			
			String transactionJSON=objectMapper.writeValueAsString(account);
			
			assertNotNull(transactionJSON);
			
		}
		
}
