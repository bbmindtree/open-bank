package com.openbank.security;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ModelMap;

import com.openbank.controller.HomeController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SecurityControllerTest {
	
	@Autowired
	HomeController homeController;
	
	

	@Test
	public void testMyEvents() throws Exception {
		
        Authentication auth = new UsernamePasswordAuthenticationToken("admin", "admin");
        
        SecurityContext securityContext = SecurityContextHolder.getContext();
        
        securityContext.setAuthentication(auth);
        
        ModelMap modelMap =new ModelMap();
        
        String response=homeController.home(modelMap);
        
        assertNotNull(response);
        
        SecurityContextHolder.clearContext();
	}
	
	@Test  
	public void testForbiddenEvents() throws Exception {
		
		ModelMap modelMap =new ModelMap();
		
		 String response=homeController.home(modelMap);
		 
	     assertNotNull(response);
	}

	@Test
	public void testWrongUserEvents() throws Exception {
		
        Authentication auth = new UsernamePasswordAuthenticationToken("admin", "admin");
        
        SecurityContext securityContext = SecurityContextHolder.getContext();
        
        securityContext.setAuthentication(auth);

        ModelMap modelMap =new ModelMap();
        
        String response=homeController.home(modelMap);
        
        assertNotNull(response);
        
        SecurityContextHolder.clearContext();
	}
}
