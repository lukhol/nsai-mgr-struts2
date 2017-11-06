<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:url id="loginEN" namespace="/" action="Locale">
	<s:param name="request_locale">en</s:param>
</s:url>
<s:url id="loginPL" namespace="/" action="Locale">
	<s:param name="request_locale">pl</s:param>
</s:url>

<c:url var="logoutUrl" value="/login?logout"/>
<form action="${logoutUrl}" id="logout" method="post">
   	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

<div id="header">
	Header
</div>

<div class="nav-item" id="languages">
	<span> <s:a href="%{loginEN}">English</s:a></span> 
	<span> <s:a href="%{loginPL}">Polski</s:a></span>
	<sec:authorize access = "hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
		<a href="#" onclick="document.getElementById('logout').submit();">Logout</a>
	</sec:authorize>
</div>

<div style="clear: both;"></div>

