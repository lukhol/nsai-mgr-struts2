<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="views/css/layout.css">
		<title>Struts 2 NSAI</title>
	</head>
	<body id="all-body">
		<sj:head />
		<div id="app-header">
			<tiles:insertAttribute name="header" />
		</div>
		<div style="clear:both"></div>
		<div id="app-menu">
			<tiles:insertAttribute name="menu" />
		</div>

		<div id="app-body">
			<tiles:insertAttribute name="body" />
			<div style="clear:both"></div>
		</div>
		<div style="clear:both"></div>

		<div id="app-footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</body>
</html>