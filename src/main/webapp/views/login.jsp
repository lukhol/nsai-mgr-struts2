<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="login">
	<s:actionerror/>
	<s:fielderror fieldName="userNotExist"/>
	<s:fielderror fieldName="cannotActivate"/>
	<s:form action="loginLogin" namespace="/">
		<s:fielderror fieldName="userNotActivated" />
	    <s:textfield key="user.username" name="username"/>
	    <s:password key="user.password" name="password"/>
	    <s:submit key="submit"/>
	</s:form>
	<a href="<s:url action="formRegistration" namespace="/" />"><s:text name="label.registration" /></a>
</div>
