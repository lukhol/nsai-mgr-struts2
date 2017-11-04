<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:url id="loginEN" namespace="/" action="Locale">
	<s:param name="request_locale">en</s:param>
</s:url>
<s:url id="loginPL" namespace="/" action="Locale">
	<s:param name="request_locale">pl</s:param>
</s:url>

<div id="header">
	Header
</div>

<div class="nav-item" id="languages">
	<span> <s:a href="%{loginEN}">English</s:a></span> 
	<span> <s:a href="%{loginPL}">Polski</s:a></span>
</div>

<div style="clear: both;"></div>

