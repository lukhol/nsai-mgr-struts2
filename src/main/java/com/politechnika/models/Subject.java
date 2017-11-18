package com.politechnika.models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SUBJECTS")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long subjectId;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String description;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		      name="STUD_SUBJ",
		      joinColumns=@JoinColumn(name="subjectId", referencedColumnName="subjectId"),
		      inverseJoinColumns=@JoinColumn(name="studentId", referencedColumnName="userId"))
	private List<User> students;
	
	@ManyToOne
	@JoinColumn(name="teacherId")
	private User teacher;
	
	@OneToMany(mappedBy="subject")
	private List<Post> posts;

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getStudents() {
		return students;
	}

	public void setStudents(List<User> students) {
		this.students = students;
	}

	public User getTeacher() {
		return teacher;
	}

	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
}
