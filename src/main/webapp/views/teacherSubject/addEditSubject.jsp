<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
	
<link rel="stylesheet" type="text/css" href="views/css/subject.css">

<div id="addEditFormDiv">
	<s:if test="subject.subjectId == 0">
		<h2><s:text name="label.addSubject"/></h2>
		<s:form action="addTeacherSubject" namespace="/">
		
			<s:textfield class="subjectName" name="subject.name" placeholder="%{getText('subject.name')}"/>
			<s:textarea class="subjectDescription" name="subject.description" placeholder="%{getText('subject.description')}"/>
			
			<s:hidden name="subject.subjectId" />
			
			<s:submit key="label.add" />
		</s:form>
	</s:if>
	<s:else>
		<h2><s:text name="label.editSubject"/></h2>
		<s:form action="editTeacherSubject" namespace="/">
			<s:textfield class="subjectName" name="subject.name" placeholder="%{getText('subject.name')}"/>
			<s:textarea class="subjectDescription" name="subject.description" placeholder="%{getText('subject.description')}"/>
			
			<s:hidden name="subject.subjectId" />
			<s:submit key="label.edit" />
		</s:form>
	</s:else>
</div>