<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="loginBox">
	<s:actionerror/>
	<s:fielderror fieldName="userNotExist"/>
	<s:fielderror fieldName="cannotActivate"/>
	<s:form action="loginLogin" namespace="/">
		<s:fielderror fieldName="userNotActivated" />
	    <s:textfield placeholder="%{getText('user.username')}" name="username" class="inputItem"/>
	    <s:password placeholder="%{getText('user.password')}" name="password" class="inputItem"/>
	    <s:submit key="label.login" style="width: 100%"/>
	</s:form>
	<a href="<s:url action="formRegistration" namespace="/" />"><s:text name="label.registration" /></a>
</div>
