package com.politechnika.services;

import com.politechnika.models.Activator;
import com.politechnika.models.User;

public interface StudentService {

	void addStudent(User user);

	Activator getActivatorByUser(User user);
	Activator getActivatorByCode(String code);
	void removeActivator(Activator activator);
}
