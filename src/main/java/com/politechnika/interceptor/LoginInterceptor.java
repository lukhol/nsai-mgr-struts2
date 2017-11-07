package com.politechnika.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.politechnika.actions.LocaleAction;
import com.politechnika.actions.LoginAction;
import com.politechnika.actions.RegistrationAction;

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
		if (validateAction && (sessionAttributes == null || sessionAttributes.get(USER) == null)) {
			action.addActionError(action.getText("errors.sessionExpired"));

			// if session expired then move user to the login page
			// @see global-results in the struts.xml file
			return Action.LOGIN;
		}

		/*
		 * Action action = (Action) invocation.getAction(); if(action instanceof
		 * JAKAS_AKCJA_KTORA_POTRZEBUJE_USERA) { ((JAKAS_AKCJA_KTORA_POTRZEBUJE_USERA)
		 * action).setUser(user)
		 */
		return invocation.invoke();

	}
}