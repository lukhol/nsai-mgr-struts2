package com.politechnika.dao;

import java.util.List;
import com.politechnika.models.User;

public interface UserDAO {
	public void addUser(User user);
	public List<User> getAllUsers();
}
