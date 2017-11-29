<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<link rel="stylesheet" type="text/css" href="views/css/subject.css">
<script src="views/js/jspdf.js"></script>
<script src="views/js/from_html.js"></script>
<script src="views/js/split_text_to_size.js"></script>
<script src="views/js/standard_fonts_metrics.js"></script>
<script>
function myPrintFunction() {
	var doc = new jsPDF();          
 	var elementHandler = {
 	  '#subjectPosts': function (element, renderer) {
 	    return true;
 	  }
 	};
	var source = window.document.getElementById("subjectPosts");
	doc.fromHTML(
	    source,
	    10,
 	    10,
 	    {
 	      'width': 180 ,'elementHandlers': elementHandler
	    });

	doc.output("dataurlnewwindow");
}
</script>

<div>
	<h1>
		<s:property value="subject.name"/>
	</h1>
</div>
<div id="subjectPosts">
<s:iterator value="subject.posts">
	<div class="subjectsListBox">
		<div style="background-color: #5cb85c; width: 100%; height=50px; margin-top: 0px;">
			<h2><s:property value="title"/>:</h2>
		</div>
		<div style="padding-bottom: 15px;">
			<pre><s:property value="textContent"/></pre>
		</div>
	</div>
	<div>
		<br>
	</div>
</s:iterator>
</div>
<div>
	<button onclick="myPrintFunction()">Print to PDF</button>
</div>