<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<link rel="stylesheet" type="text/css" href="views/css/subject.css">

<div class="subjectsListBox">
	<div style="background-color: #5cb85c; width: 100%; height=50px; margin-top: 0px;">
		<h2><s:property value="subject.name"/>:</h2>
	</div>
	<div style="padding-bottom: 15px;">
		<s:property value="subject.description"/>
	</div>
	<div style="background-color: #5cb85c; width: 100%; height=50px;">
		<s:url action="saveToSubjectStudentSubject" namespace="/" var = "SaveToSubjectTag">
			<s:param name="subject.subjectId"><s:property value="subject.subjectId"/></s:param>
		</s:url>
		<a href="<s:property value="#SaveToSubjectTag" />">
			<button class="buttonStyle">
				<span><s:text name="label.saveToSubject"/></span>
			</button>
		</a>
	</div>
</div>