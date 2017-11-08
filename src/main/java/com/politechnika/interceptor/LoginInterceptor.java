package com.politechnika.interceptor;

import java.lang.annotation.Annotation;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.politechnika.actions.LocaleAction;
import com.politechnika.actions.LoginAction;
import com.politechnika.actions.RegistrationAction;
import com.politechnika.actions.UserAwareAction;
import com.politechnika.models.RoleName;
import com.politechnika.models.User;

public class LoginInterceptor implements Interceptor {

	private static final long serialVersionUID = -8700326539812410581L;
	private static final String USER = "USER";

	public LoginInterceptor() {
	}

	public void destroy() {

	}

	public void init() {

	}

	public String intercept(ActionInvocation invocation) throws Exception {

		final ActionContext context = invocation.getInvocationContext();
		Map<String, Object> sessionAttributes = context.getSession();

		ActionSupport action = (ActionSupport) invocation.getAction();

		// validates all actions except LoginAction and RegisterAction
		boolean validateAction = !(action instanceof LoginAction || action instanceof RegistrationAction
				|| action instanceof LocaleAction);

		// check if session has expired
		/*
		if (validateAction && (sessionAttributes == null || sessionAttributes.get(USER) == null)) {
			action.addActionError(action.getText("errors.sessionExpired"));

			// if session expired then move user to the login page
			// @see global-results in the struts.xml file
			return Action.LOGIN;
		}
		*/
		
		User user = (User) sessionAttributes.get(USER);
		if(action instanceof UserAwareAction) {
			((UserAwareAction) action).setUser(user);
		}
		
		Class<? extends ActionSupport> actionClass = action.getClass();
		
		if(actionClass.isAnnotationPresent(Role.class)) {
			if(user == null)
				return Action.LOGIN;
			
			if(user.getUserRole().equals(RoleName.ADMIN))
				return invocation.invoke();
			
			Annotation annotation = actionClass.getAnnotation(Role.class);
			Role role = (Role) annotation;
			boolean userHasPrivileges = false;
			for(RoleName temp : role.roleNames()) {
				if(temp.equals(user.getUserRole())) {
					userHasPrivileges = true;
					break;
				}
			}
			if(!userHasPrivileges) {
				action.addActionError(action.getText("errors.accessDenied"));
				// if user is not teacher -> to the login page
				return Action.LOGIN;
			}
		}

		return invocation.invoke();

	}
}