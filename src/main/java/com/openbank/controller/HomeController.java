package com.openbank.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openbank.util.CommonConstant;

/**
 * @author Prakhar
 * 
 */

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/")
	public String home(ModelMap modelMap) {
		
		logger.info("Redirecting to home page");
		
		return CommonConstant.HOME;
	}
	
	
}
