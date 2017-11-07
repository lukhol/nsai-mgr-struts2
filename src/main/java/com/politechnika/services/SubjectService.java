package com.politechnika.services;

import java.util.List;

import com.politechnika.models.Subject;

public interface SubjectService {

	List<Subject> findAll(Long teacherId);
}
