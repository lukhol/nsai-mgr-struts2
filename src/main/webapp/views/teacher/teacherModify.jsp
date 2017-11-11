<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<script src="views/js/foundation.min.js"></script>
	<link rel="stylesheet" type="text/css" href="views/css/foundation.min.css">
	<link rel="stylesheet" type="text/css" href="views/css/teacher.css">
</head>
<body>
	<h4><s:actionmessage/></h4>
	<h1><s:text name="teacher.modify" /></h1>
	<s:form id="teacherModify" action="editCompleteTeacher" namespace="/">
		<s:hidden name="teacher.userId"></s:hidden>
		<s:hidden name="teacher.password"></s:hidden>
		<div class="row">
			<div class="large-2 columns">
				<s:textfield name="teacher.firstname"/>
			</div>
			<div class="large-2 columns">
	  			<s:textfield name="teacher.lastname"/>
	  		</div>
	  		<div class="large-2 columns">
	  			<s:textfield name="teacher.username"/>
	  		</div>
	  		<div class="large-2 columns">
	  			<s:textfield name="teacher.email"/>
	  		</div>
	  		<div class="large-2 columns">
	  			<s:submit key="form.save"/>
	  		</div>
		</div>
	</s:form>
</body>
</html>