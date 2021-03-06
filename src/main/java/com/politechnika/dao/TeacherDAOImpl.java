package com.politechnika.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.politechnika.models.RoleName;
import com.politechnika.models.User;

@Repository
@Transactional
public class TeacherDAOImpl implements TeacherDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		List<User> users = sessionFactory.getCurrentSession().createQuery("from User where userRole=?").setParameter(0, RoleName.TEACHER).list();

		if (users.size() > 0) {
			return users;
		} else {
			return new ArrayList<User>();
		}
	}

	@Override
	public void save(User newTeacher) {
		sessionFactory.getCurrentSession().save(newTeacher);
	}

	@Override
	public void delete(Long teacherId) {
		sessionFactory.getCurrentSession().createQuery("delete from User where userId=?").setParameter(0, teacherId).executeUpdate();
	}

	@Override
	@SuppressWarnings("unchecked")
	public User find(Long teacherId) {
		List<User> users = sessionFactory.getCurrentSession().createQuery("from User where userId=?").setParameter(0, teacherId).list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void edit(User teacher) {
		User oldTeacher = find(teacher.getUserId());
		oldTeacher.setEmail(teacher.getEmail());
		oldTeacher.setFirstname(teacher.getFirstname());
		oldTeacher.setLastname(teacher.getLastname());
		oldTeacher.setUsername(teacher.getUsername());
		sessionFactory.getCurrentSession().save(oldTeacher);
	}

}
