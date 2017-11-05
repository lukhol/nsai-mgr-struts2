<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="login">
	<s:form name="loginFrom" action="/login" method="POST">
	    <s:textfield key="user.login" name="username"/>
	    <s:password key="user.password" name="password"/>
		<input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    <s:submit key="submit"/>
	</s:form>
	
	<p>
		<a href="<s:url action='showUsersList'/>">List of users</a>
	</p>
</div>
