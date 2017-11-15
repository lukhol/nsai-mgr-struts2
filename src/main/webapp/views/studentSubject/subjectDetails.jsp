<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<link rel="stylesheet" type="text/css" href="views/layout/subject.css">

<div id="subjectsListBox">
	<div style="background-color: #5cb85c; width: 100%; height=50px; margin-top: 0px;">
		<h2><s:property value="subject.name"/>:</h2>
	</div>
	<div style="padding-bottom: 15px;">
		<s:property value="subject.description"/>
	</div>
	<div style="background-color: #5cb85c; width: 100%; height=50px;">
		<button class="buttonStyle"><s:text name="label.saveToSubject"/></button>
	</div>
</div>