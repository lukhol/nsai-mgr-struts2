<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<link rel="stylesheet" type="text/css" href="views/css/subject.css">
<div>
	<h1>
		<s:property value="subject.name"/>
	</h1>
</div>
<jsp:include page="subjectAjax.jsp" />