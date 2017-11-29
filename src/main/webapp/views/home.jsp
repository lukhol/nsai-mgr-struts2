<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<style>
.errorMessage{
	color: white;
}
</style>

<div>
	<h4><s:fielderror fieldName="registrationSuccess"/></h4>
	<h1><s:text name="label.home" /></h1>
	
	<s:url action="inputLogin" namespace="/" var="loginTag"/>
	<s:url action="formRegistration" namespace="/" var="registerTag" />
	
	<br>
	<a href="<s:property value="#loginTag" />" ><s:text name="label.login" /></a>
	<br>
	<a href="<s:property value="#registerTag" />" ><s:text name="label.register" /></a>

</div>