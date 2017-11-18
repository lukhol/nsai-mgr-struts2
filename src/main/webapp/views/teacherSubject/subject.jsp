<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<link rel="stylesheet" type="text/css" href="views/css/subject.css">
<div>
	<h1>
		<s:property value="subject.name"/>
	</h1>
</div>
<s:iterator value="subject.posts">
	<div class="subjectsListBox">
	
		<div style="background-color: #5cb85c; width: 100%; height=50px; margin-top: 0px;">
			<h2><s:property value="title"/>:</h2>
		</div>
		
		<div style="padding-bottom: 15px;">
			<s:property value="textContent"/>
		</div>
		
		<div>
			<s:url action="postDeleteTeacherSubject" namespace="/" var = "DeletePostTag" escapeAmp="false">
				<s:param name="post.postId"><s:property value="postId"/></s:param>
				<s:param name="subjectToEditId"><s:property value="subject.subjectId"/></s:param>
			</s:url>
			
			<a href="<s:property value="#DeletePostTag" />">
				<button class="buttonStyle">
					<span><s:text name="label.deletePost"/></span>
				</button>
			</a>
		</div>
		
	</div>
	<div>
		</br>
	</div>
</s:iterator>