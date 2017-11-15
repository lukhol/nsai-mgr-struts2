<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<meta http-equiv="Cache-control" content="no-cache">
<link rel="stylesheet" type="text/css" href="views/layout/subject.css">

<div id="subjectsListBox">
	<div style="background-color: #5cb85c; width: 100%; height=50px; margin-top: 0px;">
		<h2><s:text name="label.subjects"/>:</h2>
	</div>
	<ol>
		<s:iterator value="allSubjects">
			<li>
				<s:url action="subjectDetailsStudentSubject" namespace="/" var="SubjectDetailsTag">
					<s:param name="subject.subjectId"><s:property value="subjectId"/></s:param>
				</s:url>
				<a href="<s:property value="#SubjectDetailsTag" />"><s:property value="name"/></a>
				(<s:property value="teacher.firstname"/> <s:property value="teacher.lastname" />)
			</li>
		</s:iterator>
	</ol>
	<div style="background-color: #5cb85c; width: 100%; height=50px;">
		<br></br>
	</div>
</div>