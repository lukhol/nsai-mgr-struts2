<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="loginBox">
	<s:fielderror fieldName="userNotExist"/>
	<s:fielderror fieldName="cannotActivate"/>
	<div>
		<s:form action="loginLogin" namespace="/" style="display: inline-block;">
			<s:fielderror fieldName="userNotActivated" />
		    <s:textfield placeholder="%{getText('user.username')}" name="username" class="inputItem"/>
		    <s:password placeholder="%{getText('user.password')}" name="password" class="inputItem"/>
		    <s:submit key="label.login" style="width: 100%"/>
		</s:form>
	</div>
	<a href="<s:url action="formRegistration" namespace="/" />"><s:text name="label.registration" /></a>
</div>
