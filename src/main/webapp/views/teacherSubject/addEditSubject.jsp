<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
	
<style>
	.errorMessage {
		color: #d80000;
	}
</style>

<s:if test="subject.subjectId == 0">
	<s:form action="addTeacherSubject" namespace="/">
		<s:textfield key="subject.name" />
		<s:textarea key="subject.description" />
		
		<s:hidden name="subject.subjectId" />
		
		<s:submit key="submit" name="submit" />
	</s:form>
</s:if>
<s:else>
	<s:form action="editTeacherSubject" namespace="/">
		<s:textfield key="subject.name" />
		<s:textarea key="subject.description" />
		
		<s:hidden name="subject.subjectId" />
		
		<s:submit key="submit" name="submit" />
	</s:form>
</s:else>