package com.epam.authorization.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class EntityManagerConfig {
	
	@Autowired
	DataSource dataSource;
	
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();	 
		entityManagerFactory.setDataSource(dataSource);
		entityManagerFactory.setPackagesToScan("com.epam.spring_security_test.domain");
		entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactory.setJpaPropertyMap(new HashMap<String, String>(){{

	        put("hibernate.hbm2ddl.auto", "create-drop"); 

	        put("hibernate.dialect","org.hibernate.dialect.Oracle9Dialect"); 
	    }});
		return entityManagerFactory;
	}
}
