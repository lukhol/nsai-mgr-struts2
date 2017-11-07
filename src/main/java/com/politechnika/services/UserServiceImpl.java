package com.politechnika.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.politechnika.dao.UserDAO;
import com.politechnika.models.User;
import com.politechnika.models.UserRole;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO userDAO;

	@Override
	@Transactional
	public User findByUsername(String username) {
		return userDAO.findByUsername(username); 
	}


}
