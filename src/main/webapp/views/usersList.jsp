<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
List of users:
</br>
<ol>
	<s:iterator value="users">    
		<li>       
		    <s:property value="name" />
		    <s:property value="email" />
	    </li>
	</s:iterator>
</ol>