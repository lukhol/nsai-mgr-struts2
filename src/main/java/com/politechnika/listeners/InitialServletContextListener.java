package com.politechnika.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.beans.factory.annotation.Autowired;

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
//		System.out.println("Started adding role");
//		
//		//Enable spring autowired in servlet context listener:
//		WebApplicationContextUtils
//        	.getRequiredWebApplicationContext(arg0.getServletContext())
//        	.getAutowireCapableBeanFactory()
//        	.autowireBean(this);
//		
//		List<UserRole> userRoles = userService.listUserRole();
//		if(userRoles == null || userRoles.size() == 0) {
//			UserRole roleAdmin = new UserRole();
//			roleAdmin.setRole("ROLE_ADMIN");
//			userService.addRole(roleAdmin);
//			
//			UserRole roleUser = new UserRole();
//			roleUser.setRole("ROLE_USER");
//			userService.addRole(roleUser);
//		}
	}

}
