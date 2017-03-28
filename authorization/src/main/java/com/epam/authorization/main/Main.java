package com.epam.authorization.main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epam.authorization.config.AppConfig;
import com.epam.authorization.service.AccountService;

public class Main {
	public static void main(String[] args)  {

	    ApplicationContext ctx = new AnnotationConfigApplicationContext(
	        AppConfig.class);
	    AccountService s = (AccountService) ctx.getBean("accountService");
	    s.findByLogin("login");

	  }
}
