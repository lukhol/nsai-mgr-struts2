package com.politechnika.dao;

import java.util.List;

import com.politechnika.models.Note;
import com.politechnika.models.Subject;
import com.politechnika.models.User;

public interface NoteDAO {
	void create(Note note);
	List<Note> findAll(User student, Subject subject);
}
