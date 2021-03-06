<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<meta http-equiv="Cache-control" content="no-cache">

<link rel="stylesheet" type="text/css" href="views/css/subject.css">
<script src="views/js/subjectList.js"></script>

<div class="subjectsListBox">
	<div style="background-color: #5cb85c; width: 100%; height=50px; margin-top: 0px;">
		<h2>Welcome <s:property value="user.firstname"/>. Your subjects:</h2> 
	</div>
	<table id="orderedList">
		<s:iterator value="subjects" status="ctr">
			<tr class="listItem">
				<s:url action="inputTeacherSubject" namespace="/" var="InputTeacherSubjectTag">
					<s:param name="subject.subjectId"><s:property value="subjectId"/></s:param>
				</s:url>
				
				<s:url action="deleteTeacherSubject" namespace="/" var="DeleteTeacherSubjectTag">
					<s:param name="subject.subjectId"><s:property value="subjectId"/></s:param>
				</s:url>
				
				<s:url action="subjectManageTeacherSubject" namespace="/" var="ManageTeacherSubjectTag">
					<s:param name="subject.subjectId"><s:property value="subjectId"/></s:param>
				</s:url>
				
				<s:url action="studentsListTeacherSubject" namespace="/" var="studentsTeacherSubjectTag">
					<s:param name="subject.subjectId"><s:property value="subjectId"/></s:param>
				</s:url>
				
				<td class="subjectNameItem"><s:property value="%{#ctr.index + 1}"/>. <s:property value="name"/></td>
				<td class="subjectButtons">
					<a class="subjectBtn" href="<s:property value="#InputTeacherSubjectTag" />"><s:text name="form.edit"/></a> 
					<a class="subjectBtn" href="<s:property value="#DeleteTeacherSubjectTag" />"><s:text name="form.delete" /></a>
					<a class="subjectBtn" href="<s:property value="#ManageTeacherSubjectTag" />"><s:text name="form.manage" /></a>
					<a class="subjectBtn" href="<s:property value="#studentsTeacherSubjectTag" />"><s:text name="form.studentsList" /></a>
				</td>
			</tr>
		</s:iterator>
	</table>
	<div style="background-color: #5cb85c; width: 100%; height=50px;">
		<button id="myBtn" class="buttonStyle"><s:text name="form.add"/></button>
	</div>
</div>


<!-- The Modal -->
<div id="myModal" class="modal">
  <div class="modal-content">
    <div class="modal-header">
      <span class="close">&times;</span>
      	<h2><s:text name="label.addSubject"/></h2>
    </div>
    <div class="modal-body">
		<s:form action="addTeacherSubject" namespace="/">
		
			<s:textfield id="subjectNameId" class="subjectName" name="subject.name" placeholder="%{getText('subject.name')}"/>
			<s:textarea id="subjectDescriptionId" class="subjectDescription" name="subject.description" placeholder="%{getText('subject.description')}"/>
			<s:hidden name="subject.subjectId" />
			<s:submit key="label.add" />
		</s:form>
    </div>
  </div>
</div>

<script>
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
	var subjectNameTextField = document.getElementById("subjectNameId");
	subjectNameTextField.value = "";
	var descriptionNameTextArea = document.getElementById("subjectDescriptionId");
	descriptionNameTextArea.value = "";
	
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>
