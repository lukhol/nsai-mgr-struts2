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
	
	<div class="headerLeftItem">
		<span> <a href="<s:url action="home" namespace="/" />"> Home</a> </span>
	</div>
	
	<div class="headerLeftItem">
		<s:if test="%{#session.USER != null}">
			<span> <a href="<s:url action="logoutLogin" namespace="/" />"><s:text name="label.logout" /></a> </span>
		</s:if>
		<s:else>
			<span> <a href="<s:url action="inputLogin" namespace="/" />"><s:text name="label.login" /></a> </span>
		</s:else>
	</div>
	<s:if test="%{#session.USER != null && #session.USER.userRole.toString() == 'ADMIN'}">
		<div class="headerLeftItem">
			<s:url action="listTeacher" namespace="/" var="TeacherTag"/>	
			<a href="<s:property value="#TeacherTag" />" ><s:text name="label.teacher" /></a>
		</div>
	</s:if>
	<s:if test="%{#session.USER != null && #session.USER.userRole.toString() == 'TEACHER'}">
		<div class="headerLeftItem">
			<s:url action="listTeacherSubject" namespace="/" var="TeacherSubjectTag"/>	
			<a href="<s:property value="#TeacherSubjectTag" />" ><s:text name="label.subjects"/></a>
		</div>
	</s:if>
</div>
<div style="clear: both;"></div>
<div id="header">
	NSAI - Struts2
</div>



