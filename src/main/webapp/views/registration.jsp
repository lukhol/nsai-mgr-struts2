<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- Google recaptcha scripts: -->
<script src='https://www.google.com/recaptcha/api.js'></script>

<div id="loginBox">
	<s:form action="registerRegistration" namespace="/">
		<s:textfield placeholder="%{getText('user.username')}" name="user.username" class="inputItemTwo"/>
		<s:password placeholder="%{getText('user.password')}" name="user.password" class="inputItemTwo"/>
		<s:textfield placeholder="%{getText('user.email')}" name="user.email" type="email" class="inputItemTwo"/>
		<s:textfield placeholder="%{getText('user.firstname')}" name="user.firstname" class="inputItemTwo"/>
		<s:textfield placeholder="%{getText('user.lastname')}" name="user.lastname" class="inputItemTwo"/>
	    <div class="g-recaptcha" data-sitekey="6LedvzcUAAAAAAmGg7uoftMqfP4M50UCNTg9ndTG"></div>
	    <s:submit key="form.submit"/>
	</s:form>
</div>