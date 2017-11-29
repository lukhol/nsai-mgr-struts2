<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
	} else {
		div.style.display = "none";
		button.innerHTML = '<s:text name="form.addPost"/>';
	}
}

function sendForm(){
	var formData = $("#other-form").serialize();
	var addSubjectSection = document.getElementById("addSubjectSection");
	var addingPostLoader = document.getElementById("addingPostLoader");
	
	addingPostLoader.style.display = "inline-block";

	changeDivVisibility('addSubjectSection', 'addPostButton');
	
	$.ajax({
	    type : "POST",
	    url  : "postAddTeacherSubject",
	    data: formData,
	    success : function(a){
	    	var allPostsDiv = document.getElementById("all-posts"); 
	    	allPostsDiv.innerHTML = a;
	    	addingPostLoader.style.display = "none";
	    },
	    error : function(xhr, errmsg) {
	    	alert(errmsg);
	    }
	}); 
}
</script>

<style>
#addSubjectSection {
	display: none;
	background-color:rgba(0, 0, 0, 0.2);
	margin: 10px;
	margin-right: 20px;
}
#addingPostLoader{
	display: none;
}
</style>

<div>
	<div>
		<button id="addPostButton" onClick="changeDivVisibility('addSubjectSection', 'addPostButton');">Add post</button>
	</div>
	<div id="addingPostLoader">
		<div>
			Adding post..
		</div>
		<div class="loader">
		</div>
	</div>
	<div id="addSubjectSection">
		<h3><s:text name="label.addPost"/></h3>
		<s:form action="postAddTeacherSubject" namespace="/" id="other-form">
		
			<s:textfield class="subjectName" name="post.title" placeholder="%{getText('post.name')}"/>
			<s:textarea class="subjectDescription" name="post.textContent" placeholder="%{getText('post.content')}"/>
			
			<s:hidden name="subject.subjectId" />
		</s:form>
		<button onClick ="sendForm();"><s:text name="form.add"/></button>
	</div>
</div>