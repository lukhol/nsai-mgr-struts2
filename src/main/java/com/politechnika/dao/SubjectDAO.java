package com.politechnika.dao;

import java.util.List;

import com.politechnika.models.Post;
import com.politechnika.models.Subject;
import com.politechnika.models.User;

public interface SubjectDAO {
	
	boolean create(Subject subject);
	boolean updateSuject(Subject subject);
	boolean removeSubject(Subject subject);
	
	Subject getSubject(long subjectId);
	List<Subject> findAllByTeacher(User teacher);
	List<Subject> getAllSubjects();
	List<Subject> getSubjectByStudent(User student);
	
	boolean removePost(long postId);
	void addPost(Post post);
}
