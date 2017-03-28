package com.epam.authorization.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan({ "com.epam.authorization.dao.*" })
@ComponentScan({ "com.epam.authorization.service.*" })
@Import({ EntityManagerConfig.class })
public class AppConfig {
	
	@Bean
	public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
		propertyPlaceholderConfigurer.setLocation(new ClassPathResource("db.properties"));
		return propertyPlaceholderConfigurer;
	}
	

	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource(
			@Value("${db.driver}") String driverClass, 
			@Value("${db.url}") String jdbcUrl,
			@Value("${db.user}") String user, 
			@Value("${db.password}") String password) {
	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();	    
	    driverManagerDataSource.setDriverClassName(driverClass);
	    driverManagerDataSource.setUrl(jdbcUrl);
	    driverManagerDataSource.setUsername(user);
	    driverManagerDataSource.setPassword(password);
	    return driverManagerDataSource;
	}

}
