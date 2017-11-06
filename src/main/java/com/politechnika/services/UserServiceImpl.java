package com.politechnika.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public void addUser(User user) {
		UserRole userRole = userDAO.findRoleByName("ROLE_USER");
		user.getUserRole().add(userRole);
		userDAO.addUser(user);
	}

	@Override
	@Transactional
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

	@Override
	@Transactional
	public void addRole(UserRole userRole) {
		userDAO.addRole(userRole);	
	}

	@Override
	@Transactional
	public List<UserRole> listUserRole() {
		return userDAO.listUserRole();
	}

	@Override
	@Transactional
	public void removeUserRole(int id) {
		userDAO.removeUserRole(id);
	}

	@Override
	@Transactional
	public UserRole getUserRole(int id) {
		return userDAO.getUserRole(id);
	}

	@Override
	@Transactional
	public UserRole findRoleByName(String role) {
		return userDAO.findRoleByName(role);
	}

	@Override
	@Transactional
	public User findByLogin(String login) {
		return userDAO.findByLogin(login);
	}

}
