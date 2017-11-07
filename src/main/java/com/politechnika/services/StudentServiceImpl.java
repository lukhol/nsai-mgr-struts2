package com.politechnika.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.politechnika.dao.UserDAO;
import com.politechnika.models.Activator;
import com.politechnika.models.User;
import com.politechnika.models.UserRole;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	UserDAO userDAO;
	
	@Autowired
	EmailSender emailSender;
	
	@Override
	@Transactional
	public void addStudent(User user) {
		user.setPassword(hashPassword(user.getPassword()));
		user.setUserRole(UserRole.STUDENT);
		
		Activator activator = new Activator();
		activator.setUser(user);
		Integer code = user.getEmail().hashCode();
		activator.setCode(code.toString());
		userDAO.addActivator(activator);
		userDAO.addStudent(user);
		
		StringBuilder messageBuilder = new StringBuilder();
		messageBuilder
			.append("http://localhost:8080/nsai-struts2/activateRegistration?activationCode=")
			.append(activator.getCode())
			.append("&username=")
			.append(user.getUsername());
		
		emailSender.sendEmail(user.getEmail(), "Edu nsai - activate mail", "Click to activate your account: " + messageBuilder.toString());
	}
	
	private String hashPassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(password);
	}

	@Override
	@Transactional
	public Activator getActivatorByUser(User user) {
		return userDAO.getActivatorByUser(user);
	}

	@Override
	@Transactional
	public Activator getActivatorByCode(String code) {
		return userDAO.getActivatorByCode(code);
	}

	@Override
	@Transactional
	public void removeActivator(Activator activator) {
		userDAO.removeActivator(activator);
	}
}
