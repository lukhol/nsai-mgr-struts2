<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div>
	Home page!
	
	<s:url action="login" var="loginTag"/>
	<s:url action="login?logout" var="logoutTag" />
	<s:url action="register" var="registerTag" />
	</br>
	<a href="<s:property value="#loginTag" />" >Sign in</a>
	</br>
	<a href="<s:property value="#logoutTag" />" >Logout</a>
	</br>
	<a href="<s:property value="#registerTag" />" >Register</a>
	
</div>