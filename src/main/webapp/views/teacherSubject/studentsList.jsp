<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<div>
	<h1>
		<s:property value="subject.name"/>
	</h1>
</div>
<div>
	<s:iterator value="subject.students" status="rowStatusNo">
		<div>
			<h5><s:property value="firstname"/> <s:property value="lastname"/> <s:property value="email"/> </h5> 
		</div>
	</s:iterator>
</div>