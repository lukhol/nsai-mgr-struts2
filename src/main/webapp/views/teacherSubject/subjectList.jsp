<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<meta http-equiv="Cache-control" content="no-cache">

<link rel="stylesheet" type="text/css" href="views/teacherSubject/teacherSubject.css">
<script src="views/teacherSubject/teacherSubject.js"></script>

<div id="subjectsListBox">
	<div style="background-color: #5cb85c; width: 100%; height=50px; margin-top: 0px;">
		<h2>Welcome <s:property value="user.firstname"/>. Your subjects:</h2> 
	</div>
	<ol>
		<s:iterator value="subjects" status="ctr">
			<li>
				<s:url action="inputTeacherSubject" namespace="/" var="InputTeacherSubjectTag">
					<s:param name="subject.subjectId"><s:property value="subjectId"/></s:param>
				</s:url>
				
				<s:url action="deleteTeacherSubject" namespace="/" var="DeleteTeacherSubjectTag">
					<s:param name="subject.subjectId"><s:property value="subjectId"/></s:param>
				</s:url>
				
				<s:property value="name"/>
				<a href="<s:property value="#InputTeacherSubjectTag" />">[<s:text name="form.edit"/>]</a> 
				<a href="<s:property value="#DeleteTeacherSubjectTag" />">[<s:text name="form.delete" />]</a>
			</li>
		</s:iterator>
	</ol>
	<div style="background-color: #5cb85c; width: 100%; height=50px;">
		<button id="myBtn"><s:text name="form.add"/></button>
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
	// Get the modal
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