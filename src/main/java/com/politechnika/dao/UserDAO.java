package com.politechnika.dao;

import java.util.List;

import com.politechnika.models.Activator;
import com.politechnika.models.User;
import com.politechnika.models.RoleName;

public interface UserDAO {
	
	public void addStudent(User user);
	public User findByUsername(String username);
	public List<User> findAll(RoleName role);
	public void editUser(User user);
	
	public Activator getActivatorByUser(User user);
	public Activator getActivatorByCode(String code);
	public void removeActivator(Activator activator);
	public void addActivator(Activator activator);
	
}
