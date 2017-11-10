<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- Google recaptcha scripts: -->
<script src='https://www.google.com/recaptcha/api.js'></script>

<div id="login">
	<s:form action="registerRegistration" namespace="/">
		<s:textfield key="user.username" />
		<s:password key="user.password"/>
		<s:textfield key="user.email" type="email"/>
	    <div class="g-recaptcha" data-sitekey="6LedvzcUAAAAAAmGg7uoftMqfP4M50UCNTg9ndTG"></div>
	    <s:submit key="submit"/>

	</s:form>
</div>