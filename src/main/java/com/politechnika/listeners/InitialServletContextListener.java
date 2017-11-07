package com.politechnika.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.web.context.support.WebApplicationContextUtils;

@WebListener
public class InitialServletContextListener implements ServletContextListener {
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Started adding role");
		
		//Enable spring autowired in servlet context listener:
		WebApplicationContextUtils
        	.getRequiredWebApplicationContext(arg0.getServletContext())
        	.getAutowireCapableBeanFactory()
        	.autowireBean(this);
	}

}
