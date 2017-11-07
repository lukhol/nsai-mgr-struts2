<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div>
	Home page!
	
	<s:url action="formLogin" namespace="/" var="loginTag"/>
	<s:url action="formRegistration" namespace="/" var="registerTag" />
	
	<br>
	<a href="<s:property value="#loginTag" />" >Sign in</a>
	<br>
	<a href="<s:property value="#registerTag" />" >Register</a>

</div>