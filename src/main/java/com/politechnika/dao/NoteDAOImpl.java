package com.politechnika.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.politechnika.models.Note;
import com.politechnika.models.Subject;
import com.politechnika.models.User;

@Repository
public class NoteDAOImpl implements NoteDAO {

	@Override
	public void create(Note note) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Note> findAll(User student, Subject subject) {
		// TODO Auto-generated method stub
		return null;
	}

}
