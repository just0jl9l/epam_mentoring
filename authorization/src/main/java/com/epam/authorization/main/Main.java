package com.epam.authorization.main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epam.authorization.config.AppConfig;
import com.epam.authorization.dao.exception.DaoException;
import com.epam.authorization.service.exception.DataNotFoundException;
import com.epam.authorization.service.exception.GettingDataException;
import com.epam.authorization.service.exception.WrongDataException;

public class Main {
	public static void main(String[] args) throws DaoException, WrongDataException, GettingDataException, DataNotFoundException {

	    ApplicationContext ctx = new AnnotationConfigApplicationContext(
	        AppConfig.class);

	  }
}
