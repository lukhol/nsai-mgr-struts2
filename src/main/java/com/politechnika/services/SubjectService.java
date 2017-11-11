package com.politechnika.services;

import java.util.List;

import com.politechnika.models.Subject;
import com.politechnika.models.User;

public interface SubjectService {

	List<Subject> findAll(User teacher);
}
