package com.openbank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.openbank.util.CommonConstant;

/**
 * @author Prakhar
 * 
 */
@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		
		logger.info(CommonConstant.REDIRECT_LOGIN_MSG);
		
		return CommonConstant.LOGIN;
	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		
		logger.info(CommonConstant.REDIRECT_LOGIN_MSG);
		
		return CommonConstant.LOGIN;
		
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		
		logger.info(CommonConstant.REDIRECT_LOGIN_MSG);
		
		return CommonConstant.LOGIN;
	}
}
