package com.politechnika.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.politechnika.models.Post;
import com.politechnika.models.Subject;
import com.politechnika.models.User;

@Repository
public class SubjectDAOImpl implements SubjectDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean create(Subject subject) {
		try {
			sessionFactory.getCurrentSession().save(subject);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Subject> findAllByTeacher(User teacher) {
		return sessionFactory.getCurrentSession().createQuery("from Subject where teacher=?").setParameter(0, teacher).list();
	}

	@Override
	public boolean updateSuject(Subject subject) {
		try {
			sessionFactory.getCurrentSession().merge(subject);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean removeSubject(Subject subject) {
		try {
			sessionFactory.getCurrentSession().delete(subject);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Subject getSubject(long subjectId) {
		Subject subject =  (Subject)sessionFactory.getCurrentSession().get(Subject.class, subjectId);
		return subject;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Subject> getAllSubjects() {
		return sessionFactory.getCurrentSession().createQuery("from Subject order by subjectId").list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Subject> getSubjectByStudent(User student) {
		return sessionFactory.getCurrentSession().createQuery("from Subject S where ? member of S.students").setParameter(0, student).list();
	}

	@Override
	public boolean removePost(long postId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Post post = (Post)session.get(Post.class, postId);
			session.delete(post);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void addPost(Post post) {
		sessionFactory.getCurrentSession().save(post);
	}
}
