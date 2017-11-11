package com.politechnika.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.politechnika.actions.LoginAction;
import com.politechnika.models.RoleName;
import com.politechnika.models.User;
import com.politechnika.services.UserService;

@WebListener
public class InitialServletContextListener implements ServletContextListener {
	
	private static final Logger logger = Logger.getLogger(LoginAction.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		logger.info("Adding admin...");
		
		//Enable spring autowired in servlet context listener:
		WebApplicationContextUtils
        	.getRequiredWebApplicationContext(arg0.getServletContext())
        	.getAutowireCapableBeanFactory()
        	.autowireBean(this);
		
		addUser(RoleName.ADMIN, "nsai.activatorsender@gmail.com", "admin", "admin");
		addUser(RoleName.TEACHER, "nsai.activatorsender2@gmail.com", "teacher", "teacher");
		addUser(RoleName.STUDENT, "nsai.activatorsender3@gmail.com", "student", "student");
	}
	
	private void addUser(RoleName roleName, String email, String username, String password) {
		try {
			User user = new User();
			user.setActivated(true);
			user.setUserRole(roleName);
			user.setEmail(email);
			user.setUsername(username);
			user.setPassword(passwordEncoder.encode(password));
			userService.addUser(user);
		} catch (Exception e) {
			logger.info("Cannot add admin " + username + " during server startup. Probably exist in datase");
		}
	}
}
