package com.politechnika.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.politechnika.dao.UserDAO;
import com.politechnika.models.User;
import com.politechnika.models.UserRole;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	UserDAO userDAO;
	
	@Override
	@Transactional
	public void addStudent(User user) {
		user.setPassword(hashPassword(user.getPassword()));
		user.setUserRole(UserRole.STUDENT);
		userDAO.addStudent(user);
	}
	
	private String hashPassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(password);
	}
}
