<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	 <script src="views/js/foundation.min.js"></script>
	 <link rel="stylesheet" type="text/css" href="views/css/foundation.min.css">
</head>
<body>

<script>
  function setEditTeacher(val)
   {    
       document.getElementById("teacherField").value=val;
       document.teachersList.action="editTeacher.action";
       document.teachersList.submit();
       return true;
   };
   function setRemoveTeacher(val)
   {    
       document.getElementById("teacherField").value=val;
       document.teachersList.action="deleteTeacher.action";
       document.teachersList.submit();
       return true;
   };
</script>

<h1><s:text name="teacher.list" />:</h1>
	<table>
		<thead>
    		<tr>
      			<th><s:text name="teacher.firstname" /></th>
      			<th><s:text name="teacher.lastname" /></th>
	  			<th><s:text name="teacher.username" /></th>
	  			<th><s:text name="teacher.password" /></th>
	  			<th><s:text name="teacher.email" /></th>
	  			<th></th>
	  			<th></th>
    		</tr>
  		</thead>
  		<tbody>
  			<s:form id="teachersAdd" action="addTeacher" namespace="/">
	  			<tr>
	  				<td><s:textfield name="teacher.firstname"/></td>
	  				<td><s:textfield name="teacher.lastname"/></td>
	  				<td><s:textfield name="teacher.username"/></td>
	  				<td><s:textfield name="teacher.password"/></td>
	  				<td><s:textfield name="teacher.email"/></td>
	  				<td><s:submit key="form.submit"/></td>
	  				<td></td>
	  			</tr>
  			</s:form>
  			<s:form id="teachersList" name="teachersList">
  				<s:hidden name="teacher" id="teacherField"/>
	  			<s:iterator value="teachers" var="tempTeacher">
	  				<tr> 
	  					<td><s:property value="#tempTeacher.firstname" /></td>
	  					<td><s:property value="#tempTeacher.lastname" /></td>
	  					<td><s:property value="#tempTeacher.username" /></td>
	  					<td>*******</td>
	  					<td><s:property value="#tempTeacher.email" /></td>
	  					<td><s:submit action="editTeacher" cssClass="ButtonSmall" value="edit" onclick="return setEditTeacher('%{#tempTeacher}')"/></td>
	  					<td><s:submit action="deleteTeacher" cssClass="ButtonSmall" value="delete" onclick="return setRemoveTeacher('%{#tempTeacher}')"/></td>
	  				</tr>
	 			</s:iterator>
 			</s:form>
  		</tbody>
  	</table>
  </body>
  </html>