package com.politechnika.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.politechnika.services.UserService;

@WebListener
public class InitialServletContextListener implements ServletContextListener {
	
	@Autowired
	UserService userService;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Adding admin...");
		
		//Enable spring autowired in servlet context listener:
		WebApplicationContextUtils
        	.getRequiredWebApplicationContext(arg0.getServletContext())
        	.getAutowireCapableBeanFactory()
        	.autowireBean(this);
	}

}
