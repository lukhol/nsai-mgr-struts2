package com.politechnika.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.politechnika.dao.SubjectDAO;
import com.politechnika.models.Post;
import com.politechnika.models.RoleName;
import com.politechnika.models.Subject;
import com.politechnika.models.User;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectDAO subjectDAO;
	
	@Override
	@Transactional
	public List<Subject> findAllByTeacher(User teacher) {
		if(teacher.getUserRole().equals(RoleName.TEACHER)) {
			return subjectDAO.findAllByTeacher(teacher);
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public boolean addSubject(Subject subject) {
		return subjectDAO.create(subject);
	}

	@Override
	@Transactional
	public boolean updateSubject(Subject subject) {
		return subjectDAO.updateSuject(subject);
	}

	@Override
	@Transactional
	public boolean removeSubject(Subject subject) {
		return subjectDAO.removeSubject(subject);
	}

	@Override
	@Transactional
	public Subject getSubject(long subjectId) {
		Subject subject = subjectDAO.getSubject(subjectId);
		return subject;
	}

	@Override
	@Transactional
	public List<Subject> getAllSubjects() {
		return subjectDAO.getAllSubjects();
	}

	@Override
	@Transactional
	public List<Subject> getSubjectByStudent(User student) {
		return subjectDAO.getSubjectByStudent(student);
	}

	@Override
	@Transactional
	public List<Post> getPosts(long subjectId) {
		Subject subject = getSubject(subjectId);
		List<Post> posts = new ArrayList<>();
		for(Post post : subject.getPosts()) {
			posts.add(post);
		}
		return posts;
	}

	@Override
	@Transactional
	public boolean removePost(Post post, User teacher) {
		try {
			//TO DO: Check if post belong to the teacher subject.
			subjectDAO.removePost(post.getPostId());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional
	public void addPost(Post post) {
		subjectDAO.addPost(post);
	}
}
