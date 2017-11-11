<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:url id="loginEN" namespace="/" action="Locale">
	<s:param name="request_locale">en</s:param>
</s:url>
<s:url id="loginPL" namespace="/" action="Locale">
	<s:param name="request_locale">pl</s:param>
</s:url>

<div>
	<div id="languages">
		<span> <s:a href="%{loginEN}">English</s:a></span> 
		<span> <s:a href="%{loginPL}">Polski</s:a></span>
	</div>
	
	<div id="home">
		<span> <a href="<s:url action="home" namespace="/" />"> Home</a> </span>
		<s:if test="%{#session.USER != null}">
			<span> <a href="<s:url action="logoutLogin" namespace="/" />"><s:text name="label.logout" /></a> </span>
		</s:if>
		<s:else>
			<span> <a href="<s:url action="inputLogin" namespace="/" />"><s:text name="label.login" /></a> </span>
		</s:else>
	</div>
	
	<div id="teachers">
		<s:url action="listTeacher" namespace="/" var="TeacherTag"/>	
		<br>
		<a href="<s:property value="#TeacherTag" />" ><s:text name="label.teacher" /></a>
	</div>
</div>
<div id="header">
	NSAI - Struts2
</div>


<div style="clear: both;"></div>

