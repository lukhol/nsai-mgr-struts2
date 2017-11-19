<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<link rel="stylesheet" type="text/css" href="views/css/subject.css">

<script>

function deletePost(postId, subjectId, divNo){	
	var postContentDivId = "postContent" + divNo;
	var buttonContentId = "buttonContent" + divNo;
	
	$.ajax({
	    type : "GET",
	    url  : "postDeleteAjaxTeacherSubject?post.postId="+postId+"&subjectToEditId="+subjectId,
	    success : function(a){
	    	var allPostsDiv = document.getElementById("all-posts"); 
	    	allPostsDiv.innerHTML = a;
	    },
	    error : function(xhr, errmsg) {
	    	alert("No values found!");
	    }
	}); 
	
	var removingPostContentDiv = document.getElementById(postContentDivId);
	removingPostContentDiv.innerHTML = '<div><s:text name="label.deletingPost"/></div><div class="loader"></div>';
	
	var removingButton = document.getElementById(buttonContentId);
	removingButton.style.display = "none"; 
}

</script>
<div id="all-posts">
	<s:iterator value="subject.posts" status="rowStatusNo">
		<div class="subjectsListBox">
		
			<div style="background-color: #5cb85c; width: 100%; height=50px; margin-top: 0px;">
				<h2><s:property value="title"/>:</h2>
			</div>
			
			<div style="padding-bottom: 15px;" id="postContent<s:property value="%{#rowStatusNo.index}" />" >
				<s:property value="textContent"/>
			</div>
			
			<div>
				<s:url action="postDeleteAjaxTeacherSubject" namespace="/" var = "DeletePostTag" escapeAmp="false" id="deletePostUrl">
					<s:param name="post.postId"><s:property value="postId"/></s:param>
					<s:param name="subjectToEditId"><s:property value="subject.subjectId"/></s:param>
				</s:url>
				
				<button id="buttonContent<s:property value="%{#rowStatusNo.index}" />" class="buttonStyle" onClick="deletePost('<s:property value="postId"/>', '<s:property value="subject.subjectId"/>', '<s:property value="%{#rowStatusNo.index}" />');">
					<span><s:text name="label.deletePost"/></span>
				</button>
			</div>
			
		</div>
		<div>
			<br/>
		</div>
	</s:iterator>
</div>