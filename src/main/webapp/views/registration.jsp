<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div>
	<s:form action="registerRegistration" namespace="/">
	    <s:textfield key="user.username" />
	    <s:password key="user.password"/>
	    <s:textfield key="user.email" type="email"/>
	    <s:submit key="submit"/>
	</s:form>
</div>