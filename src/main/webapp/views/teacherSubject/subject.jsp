<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<link rel="stylesheet" type="text/css" href="views/css/subject.css">
<jsp:include page="ajax/subjectPostAdd.jsp" />
<div>
	<h1>
		<s:property value="subject.name"/>
	</h1>
</div>
<jsp:include page="ajax/subjectPostDelete.jsp" />