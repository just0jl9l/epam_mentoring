package com.epam.authorization.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epam.authorization.config.AppConfig;
import com.epam.authorization.domain.Account;
import com.epam.authorization.service.AccountService;

public class Main {
	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		AccountService s = (AccountService) ctx.getBean("accountService");
		Account a = new Account();
		a.setId(52);
		a.setLogin("lala");
		a.setPassword("hoho");
		s.delete(52);
	}
}
