package com.politechnika.services;

import java.util.List;

import com.politechnika.models.Post;
import com.politechnika.models.Subject;
import com.politechnika.models.User;

public interface SubjectService {
	boolean addSubject(Subject subject);
	boolean updateSubject(Subject subject);
	boolean removeSubject(Subject subject);
	
	Subject getSubject(long subjectId);
	List<Subject> findAllByTeacher(User user);
	List<Subject> getAllSubjects();
	List<Subject> getSubjectByStudent(User student);
	
	List<Post> getPosts(long subjectId);
	boolean removePost(Post post, User teacher);
	void addPost(Post post);
	List<User> getStudents(Long subjectId);
}
