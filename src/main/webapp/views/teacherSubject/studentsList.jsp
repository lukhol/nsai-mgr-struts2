<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<link rel="stylesheet" type="text/css" href="views/css/subject.css">

<table class="subjectsListBox2" width="100%">
	<tr>
	<td colspan="2" style="background-color: #5cb85c; width: 100%; height=50px; margin-top: 0px;">
		<h2><s:property value="subject.name"/></h2> 
	</td>
	</tr>
	<s:iterator value="subject.students" status="ctr">
		<tr>
			<td class="studentNames"><strong><s:property value="%{#ctr.index + 1}"/>. <s:property value="firstname"/>   <s:property value="lastname"/></strong></td><td class="studentEmails">   <s:property value="email"/></td>  
		</tr>
	</s:iterator>
</table>