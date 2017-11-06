package com.politechnika.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
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
		// Code

		User user = (User) sessionAttributes.get(USER);

		if (user == null) {
			// User not logged in. Go to login page!
			return Action.LOGIN;
		} else {
			/*
			 * Action action = (Action) invocation.getAction(); if(action instanceof
			 * JAKAS_AKCJA_KTORA_POTRZEBUJE_USERA) { ((JAKAS_AKCJA_KTORA_POTRZEBUJE_USERA)
			 * action).setUser(user)
			 */
			return invocation.invoke();
		}

	}
}