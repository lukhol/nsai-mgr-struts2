<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<style>
.menuDiv ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

.menuDiv li {
    float: left;
}

.menuDiv li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

.menuDiv li a:hover {
    background-color: #111;
}

.menuDiv li {
    border-right: 1px solid #bbb;
}

.menuDiv li:last-child {
    border-right: none;
}

</style>

<div class="menuDiv" style=" display: inline-block;">
	<ul>
	  	<li>
	  		<a href="<s:url action="home" namespace="/" />"> Home</a>
	  	</li>
	  	
	  	<li>
	  		<s:if test="%{#session.USER != null}">
				<span> <a href="<s:url action="logoutLogin" namespace="/" />"><s:text name="label.logout" /></a> </span>
			</s:if>
			<s:else>
				<span> <a href="<s:url action="inputLogin" namespace="/" />"><s:text name="label.login" /></a> </span>
			</s:else>
		</li>
	  	
	  	<s:if test="%{#session.USER != null && #session.USER.userRole.toString() == 'ADMIN'}">
			<li>
				<s:url action="listTeacher" namespace="/" var="TeacherTag"/>	
				<a href="<s:property value="#TeacherTag" />" ><s:text name="label.teacher" /></a>
			</li>
		</s:if>
		
		<s:if test="%{#session.USER != null && #session.USER.userRole.toString() == 'TEACHER'}">
			<li>
				<s:url action="listTeacherSubject" namespace="/" var="TeacherSubjectTag"/>	
				<a href="<s:property value="#TeacherSubjectTag" />" ><s:text name="label.subjects"/></a>
			</li>
		</s:if>
		
		<s:if test="%{#session.USER != null && #session.USER.userRole.toString() == 'STUDENT'}">
			<li>
				<s:url action="listAllStudentSubject" namespace="/" var="StudentSubjectTag"/>	
				<a href="<s:property value="StudentSubjectTag" />" ><s:text name="label.subjects"/></a>
			</li>
		</s:if>
		
		<li>
			<a href="<s:url action="formRegistration" namespace="/" />"><s:text name="label.registration" /></a>
		</li>
	</ul>
</div>