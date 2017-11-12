<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<link rel="stylesheet" type="text/css" href="views/teacherSubject/teacherSubject.css">

<h1>Welcome <s:property value="user.firstname"/>. Your subjects:</h1>
<ol>
	<s:iterator value="subjects" status="ctr">
		<li>
			<s:url action="inputTeacherSubject" namespace="/" var="InputTeacherSubjectTag">
				<s:param name="subject.subjectId"><s:property value="subjectId"/></s:param>
			</s:url>
			
			<s:url action="deleteTeacherSubject" namespace="/" var="DeleteTeacherSubjectTag">
				<s:param name="subject.subjectId"><s:property value="subjectId"/></s:param>
			</s:url>
			
			<s:property value="name"/>
			<a href="<s:property value="#InputTeacherSubjectTag" />">[<s:text name="form.edit"/>]</a> 
			<a href="<s:property value="#DeleteTeacherSubjectTag" />">[<s:text name="form.delete" />]</a>
		</li>
	</s:iterator>
</ol>

<input id="addButton" type = "button" value = <s:text name="form.add"/> onclick = "javascript:location.href='inputTeacherSubject';" />
	