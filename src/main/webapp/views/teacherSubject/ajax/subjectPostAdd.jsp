<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<link rel="stylesheet" type="text/css" href="views/css/subject.css">

<script>
function changeDivVisibility(divId, buttonId){
	var div = document.getElementById(divId);
	var button = document.getElementById(buttonId);
	
	if(div.style.display === "none"){
		div.style.display = "inline-block";
		button.innerHTML = '<s:text name="form.hideForm"/>';
		//button.style.display = "inline-block";
	} else {
		div.style.display = "none";
		button.innerHTML = '<s:text name="form.addPost"/>';
		//button.style.display = "inlie-block";
	}
}
</script>

<style>
#addSubjectSection {
	display: none;
	background-color:rgba(0, 0, 0, 0.2);
	margin: 10px;
	margin-right: 20px;
}
</style>

<div>
	<div>
		<button id="addPostButton" onClick="changeDivVisibility('addSubjectSection', 'addPostButton');">Add post</button>
	</div>
	<div id="addSubjectSection">
		<h3><s:text name="label.addPost"/></h3>
		<s:form action="postAddTeacherSubject" namespace="/">
		
			<s:textfield class="subjectName" name="post.title" placeholder="%{getText('post.name')}"/>
			<s:textarea class="subjectDescription" name="post.textContent" placeholder="%{getText('post.content')}"/>
			
			<s:hidden name="subject.subjectId" />
			
			<s:submit key="label.add" />
		</s:form>
	</div>
</div>