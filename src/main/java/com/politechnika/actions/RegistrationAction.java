package com.politechnika.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.politechnika.models.User;
import com.politechnika.services.CaptchaService;
import com.politechnika.services.StudentService;
import com.politechnika.services.UserService;

public class RegistrationAction extends ActionSupport implements ServletRequestAware {
	private static final long serialVersionUID = 4872981664283281427L;
	
	private static final String ACTIVATED = "activated";
	private static final String ACTIVATION_ERROR = "activationError";

	@Autowired
	StudentService studentService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	CaptchaService captchaService;
	
	private HttpServletRequest request;
	private String activationCode;
	private String username;
	private User user;

	public String form() throws Exception {
		return INPUT;
	}
	
	public String register() throws Exception {
		
		String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
		
		if(!captchaService.verifyCaptcha(gRecaptchaResponse)) {
			//Add error message;
			return ERROR;
		}
		
		studentService.addStudent(user);
		//addActionMessage(getText("registration.success") + " " + user.getEmail());
		addFieldError("registrationSuccess", getText("registration.success"));// + " " + user.getEmail());
		return SUCCESS;
	}
	
	public String activate() throws Exception{
		User user = userService.findByUsername(username);
		if(user == null) {
			addFieldError("userNotExist", getText("errors.activation.userNotExist"));
			return ACTIVATION_ERROR;
		}
		
		if(!userService.activateUser(user, activationCode)) {
			addFieldError("cannotActivate", getText("errors.activation.cannotActivate"));
			return ACTIVATION_ERROR;
		}
		
		return ACTIVATED;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getServletRequest() {
		return this.request;
	}
}
