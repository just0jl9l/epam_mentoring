package com.epam.authorization.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

public class WebInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {


        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));


        FilterRegistration.Dynamic securityFilter = servletContext.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class);
        securityFilter.addMappingForUrlPatterns(null, false, "/*");

    }
}
