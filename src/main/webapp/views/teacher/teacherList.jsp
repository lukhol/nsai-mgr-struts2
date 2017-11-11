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
       document.getElementById("teacherIdField").value=val;
       document.teachersList.action="editTeacher.action";
       document.teachersList.submit();
       return true;
   };
   function setRemoveTeacher(val)
   {    
       document.getElementById("teacherIdField").value=val;
       document.teachersList.action="deleteTeacher.action";
       document.teachersList.submit();
       return true;
   };
</script>

<h1><s:text name="teacher.list" />:</h1>
	<table>
		<thead>
    		<tr style="background: #6fdbe4;">
      			<th><s:text name="label.teacher.firstname" /></th>
      			<th><s:text name="label.teacher.lastname" /></th>
	  			<th><s:text name="label.teacher.username" /></th>
	  			<th><s:text name="label.teacher.password" /></th>
	  			<th><s:text name="label.teacher.email" /></th>
	  			<th></th>
	  			<th></th>
    		</tr>
  		</thead>
  		<tbody>
  			<s:form theme="simple" id="teachersAdd" action="saveTeacher" namespace="/">
	  			<tr">
	  				<td><s:textfield name="teacher.firstname"/></td>
	  				<td><s:textfield name="teacher.lastname"/></td>
	  				<td><s:textfield name="teacher.username"/></td>
	  				<td><s:password name="teacher.password"/></td>
	  				<td><s:textfield name="teacher.email"/></td>
	  				<td><s:submit key="form.add"/></td>
	  				<td></td>
	  			</tr>
  			</s:form>
  			<s:form theme="simple" id="teachersListId" name="teachersList" namespace="/">
  				<s:hidden name="teacherId" id="teacherIdField"/>
	  			<s:iterator value="teachers" var="tempTeacher" status="incr">
	  				<tr> 
	  					<td><s:property value="#tempTeacher.firstname" /></td>
	  					<td><s:property value="#tempTeacher.lastname" /></td>
	  					<td><s:property value="#tempTeacher.username" /></td>
	  					<td>*******</td>
	  					<td><s:property value="#tempTeacher.email" /></td>
	  					<td><s:submit action="editTeacher"  namespace="/" cssClass="ButtonSmall" key="form.edit" onclick="return setEditTeacher('%{#tempTeacher.userId}')"/></td>
	  					<td><s:submit action="deleteTeacher"  namespace="/" cssClass="ButtonSmall" key="form.delete" onclick="return setRemoveTeacher('%{#tempTeacher.userId}')"/></td>
	  				</tr>
	 			</s:iterator>
 			</s:form>
  		</tbody>
  	</table>
  </body>
  </html>