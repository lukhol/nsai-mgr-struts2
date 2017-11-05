<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div>
	<s:form action="registerExecute">
	    <s:textfield key="user.username"/>
	    <s:password key="user.password"/>
	    <input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    <s:submit key="submit"/>
	</s:form>
</div>