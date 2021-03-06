package com.politechnika.actions.teacher;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.politechnika.actions.UserAwareAction;
import com.politechnika.interceptor.Role;
import com.politechnika.models.Post;
import com.politechnika.models.RoleName;
import com.politechnika.models.Subject;
import com.politechnika.models.User;
import com.politechnika.services.SubjectService;

@Role(roleNames= {RoleName.TEACHER})
public class TeacherSubjectAction extends UserAwareAction {

	private static final long serialVersionUID = 7164702001289608229L;
	
	@Autowired
	private SubjectService subjectService;
	
	private List<Subject> subjects;
	private Subject subject;
	private Post post;
	private long subjectToEditId;
	
	private boolean isSubjectAllowed() {
		if(subject != null) {
			Subject findSubject = subjectService.getSubject(subject.getSubjectId());
			if(findSubject != null) {
				User teacher = findSubject.getTeacher();
				if(getUser().getUserId().equals(teacher.getUserId())) {
					return true;
				}
			}
		} 
		if(subjectToEditId != 0) {
			Subject findSubject = subjectService.getSubject(subjectToEditId);
			if(findSubject != null) {
				User teacher = findSubject.getTeacher();
				if(getUser().getUserId().equals(teacher.getUserId())) {
					return true;
				}
			}
		}
		return false;
	}
	
	public String subjectManage() throws Exception {
		if(!isSubjectAllowed()) {
			return LOGIN;
		}
		subject = subjectService.getSubject(subject.getSubjectId());
		List<Post> posts = subjectService.getPosts(subject.getSubjectId());
		Collections.reverse(posts);
		subject.setPosts(posts);
		return "subjectManage";
	}
	
	public String studentsList() throws Exception {
		if(isSubjectAllowed()) {
			subject = subjectService.getSubject(subject.getSubjectId());
			List<User> students = subjectService.getStudents(subject.getSubjectId());
			subject.setStudents(students);
			return "studentsList";
		} else {
			return LOGIN;
		}
	}
	
	public String postAdd() throws Exception {
		if(!isSubjectAllowed()) {
			return LOGIN;
		}
		subject = subjectService.getSubject(subject.getSubjectId());
		post.setSubject(subject);
		post.setCreationDate(Calendar.getInstance().getTime());
		subjectService.addPost(post);
		
		//Clear post for form.
		post = null;
		
		subject = subjectService.getSubject(subject.getSubjectId());
		List<Post> posts = subjectService.getPosts(subject.getSubjectId());
		Collections.reverse(posts);
		subject.setPosts(posts);
		return "deletePostAjax";
	}
	
	public String postDelete() throws Exception {
		if(!isSubjectAllowed()) {
			return LOGIN;
		}
		subjectService.removePost(post, getUser());
		subject = subjectService.getSubject(subjectToEditId);
		List<Post> posts = subjectService.getPosts(subjectToEditId);
		subject.setPosts(posts);
		return "subjectManage";
	}
	
	public String postDeleteAjax() throws Exception {
		if(!isSubjectAllowed()) {
			return LOGIN;
		}
		subjectService.removePost(post, getUser());
		subject = subjectService.getSubject(subjectToEditId);
		List<Post> posts = subjectService.getPosts(subjectToEditId);
		subject.setPosts(posts);
		return "deletePostAjax";
	}
	
	public String list() throws Exception {
		subjects = subjectService.findAllByTeacher(this.getUser());
		return SUCCESS;
	}
	
	public String input() throws Exception {
		if(subject == null) {
			subject = new Subject();
			subject.setSubjectId(0l);
		}
		
		if(subject.getSubjectId() != 0) {
			subjects = subjectService.findAllByTeacher(this.getUser());
			subject = subjects
							.stream()
							.filter(s -> s.getSubjectId() == subject.getSubjectId())
							.findFirst()
							.get();
		}
			
		return INPUT;
	}
	
	public String delete() throws Exception {
		if(!isSubjectAllowed()) {
			return LOGIN;
		}
		if(subject.getSubjectId() != 0) {
			subjects = subjectService.findAllByTeacher(this.getUser());
			subject = subjects
							.stream()
							.filter(s -> s.getSubjectId() == subject.getSubjectId())
							.findFirst()
							.get();
			
			if(subject.getTeacher().getUserId() == this.getUser().getUserId()) {
				subjectService.removeSubject(subject);
				subjects.remove(subject);
			}
		}
		
		return SUCCESS;
	}
	
	public String add() throws Exception {
		if(!validateSubject()) {
			subject.setSubjectId(0l);
			return INPUT;
		}
		
		User teacher = this.getUser();
		
		if(teacher == null)
			return Action.LOGIN;
		
		subject.setTeacher(teacher);
		boolean addingResult = subjectService.addSubject(subject);
		
		if(!addingResult)
			return INPUT;
		
		subjects = subjectService.findAllByTeacher(teacher);
		
		return SUCCESS;
	}
	
	public String edit() throws Exception{
		if(!isSubjectAllowed()) {
			return LOGIN;
		}
		if(!validateSubject())
			return INPUT;
		
		User teacher = this.getUser();
		
		if(teacher == null)
			return Action.LOGIN;
		
		Subject oldSubject = subjectService.getSubject(subject.getSubjectId());
		
		subject.setStudents(oldSubject.getStudents());
		subject.setTeacher(oldSubject.getTeacher());
		
		boolean updateResult = subjectService.updateSubject(subject);
		
		if(!updateResult)
			return INPUT;

		subjects = subjectService.findAllByTeacher(teacher);
		
		return SUCCESS;
	}
	
	private boolean validateSubject() {
		boolean validationResult = true;
		
		if(subject == null)
			return false;
		
		if(subject.getName() == null || subject.getName().length() == 0) {
			addFieldError("subject.name", "name cannot be empty");
			validationResult = false;
		}
		
		if(subject.getDescription() == null || subject.getDescription().length() == 0) {
			addFieldError("subject.description", "description cannot be empty");
			validationResult = false;
		}
		
		return validationResult;
	}
	
	/* GETTERS AND SETTERS: */
	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	@Override
	public User getUser() {
		return super.getUser();
	}
	
	public long getSubjectToEditId() {
		return subjectToEditId;
	}

	public void setSubjectToEditId(long subjectToEditId) {
		this.subjectToEditId = subjectToEditId;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
}
