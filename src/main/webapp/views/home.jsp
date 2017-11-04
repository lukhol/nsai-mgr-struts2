<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="login">
	<s:form action="Login">
		<s:textfield key="user.name"/>
		<s:textfield key="user.email"/>
		<s:submit key="submit"/>
	</s:form>
</div>
