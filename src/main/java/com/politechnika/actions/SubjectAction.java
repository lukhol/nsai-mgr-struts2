package com.politechnika.actions;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.politechnika.models.Note;
import com.politechnika.models.Subject;
import com.politechnika.models.User;
import com.politechnika.services.NoteService;
import com.politechnika.services.StudentService;
import com.politechnika.services.SubjectService;

public class SubjectAction extends ActionSupport implements TeacherAware {

	private static final long serialVersionUID = 7164702001289608229L;
	
	private User teacher;
	private List<Subject> subjects;
	
	private String noteValue;
	private Long studentId;
	private Long subjectId;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private NoteService noteService;
	
	public String list() throws Exception {
		
		subjects = subjectService.findAll(teacher.getUserId());
		return INPUT;
	}
	
	public String addNote() throws Exception {
		
		Subject subject = subjects.stream().filter(s -> s.getSubjectId().equals(subjectId)).collect(Collectors.toList()).get(0);
		subject.setTeacher(teacher);
		User student = subject.getStudents().stream().filter(s -> s.getUserId().equals(studentId)).collect(Collectors.toList()).get(0);
		
		Note note = new Note();
		note.setDate(Calendar.getInstance().getTime());
		note.setSubject(subject);
		note.setStudent(student);
		note.setValue(noteValue);

		noteService.addNote(note);
		
		return SUCCESS;
	}
	
	@Override
	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}

	public User getTeacher() {
		return teacher;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
}
