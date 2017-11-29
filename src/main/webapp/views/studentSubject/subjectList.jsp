<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<meta http-equiv="Cache-control" content="no-cache">
<link rel="stylesheet" type="text/css" href="views/css/subject.css">

<script>
function myFunction(param) {
    var x = document.getElementById("divId" + param);
    if (x.style.display === "none") {
        x.style.display = "inline-block";
    } else {
        x.style.display = "none";
    }
}
</script>
<style>
.test{
	width: 200px;
    text-align: center;
    background-color: lightblue;
    display: none;
}
</style>

<div class="subjectsListBox">
	<div style="background-color: #5cb85c; width: 100%; height=50px; margin-top: 0px;">
		<h2>Twoje przedmioty:</h2>
	</div>
	<ol>
		<s:if test="savedStudentSubjects.size == 0">
			Brak przedmiotow.
		</s:if>
	
		<s:iterator value="savedStudentSubjects" status="status">
			<li>
				<s:url action="subjectPageStudentSubject" namespace="/" var="SubjectStudentSubjectTag">
					<s:param name="subject.subjectId"><s:property value="subjectId"/></s:param>
				</s:url>
				<div style="text-align: left; width:400px; display: inline-block;">
					<a href="<s:property value="SubjectStudentSubjectTag" />"><s:property value="name"/></a>
				</div>
			</li>
			<s:div id="divId%{#status.count}" class="test">
					<s:property value="description"/>
				</s:div>
		</s:iterator>
	</ol>
	<div style="background-color: #5cb85c; width: 100%; height=50px;">
		<br></br>
	</div>
</div>

<div>
	<br></br>
</div>

<div class="subjectsListBox">
	<div style="background-color: #5cb85c; width: 100%; height=50px; margin-top: 0px;">
		<h2><s:text name="label.subjects"/>:</h2>
	</div>
	
	<s:if test="allSubjects.size == 0">
			Brak przedmiotow.
		</s:if>
	
	<ol>
		<s:iterator value="allSubjects">
			<li>
				<s:url action="subjectDetailsStudentSubject" namespace="/" var="SubjectDetailsTag">
					<s:param name="subject.subjectId"><s:property value="subjectId"/></s:param>
				</s:url>
				<div style="text-align: left; width:400px; display: inline-block;">
					<a href="<s:property value="#SubjectDetailsTag" />"><s:property value="name"/></a>
					(<s:property value="teacher.firstname"/> <s:property value="teacher.lastname" />)
				</div>
			</li>
		</s:iterator>
	</ol>
	<div style="background-color: #5cb85c; width: 100%; height=50px;">
		<br></br>
	</div>
</div>