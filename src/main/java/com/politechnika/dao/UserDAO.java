package com.politechnika.dao;

import java.util.List;
import com.politechnika.models.User;
import com.politechnika.models.UserRole;

public interface UserDAO {
	public void addUser(User user);
	public List<User> getAllUsers();
	public User findByLogin(String login);
	
	public void addRole(UserRole userRole);
	public List<UserRole> listUserRole();
	public void removeUserRole (int id);
	public UserRole getUserRole(int id);
	public UserRole findRoleByName(String role);
}
