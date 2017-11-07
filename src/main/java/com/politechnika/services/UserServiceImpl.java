package com.politechnika.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.politechnika.dao.UserDAO;
import com.politechnika.models.Activator;
import com.politechnika.models.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO userDAO;

	@Override
	@Transactional
	public User findByUsername(String username) {
		return userDAO.findByUsername(username); 
	}

	@Override
	@Transactional
	public boolean activateUser(User user, String activationCode) {
		try {
			Activator activator = userDAO.getActivatorByUser(user);
			if(activator.getCode().equals(activationCode)) {
				userDAO.removeActivator(activator);
				user.setActivated(true);
				userDAO.editUser(user);
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return false;
	}
}
