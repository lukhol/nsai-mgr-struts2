<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div>
	Home page!
	
	<s:url action="login" var="loginTag"/>
	<s:url action="register" var="registerTag" />
	
	<br>
	<a href="<s:property value="#loginTag" />" >Sign in</a>
	<br>
	<a href="<s:property value="#registerTag" />" >Register</a>

</div>