package com.politechnika.services;

import java.util.List;

import com.politechnika.models.Activator;
import com.politechnika.models.Note;
import com.politechnika.models.Subject;
import com.politechnika.models.User;

public interface StudentService {

	void addStudent(User user);
	List<Note> getAllNotes(User student, Subject subject);

	Activator getActivatorByUser(User user);
	Activator getActivatorByCode(String code);
	void removeActivator(Activator activator);
}
