<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<title></title>
</head>
<body>

	<ul class="nav nav-pills">
		<li role="presentation" class="active"><a href="Main.jsp"><bean:message
					key="main.page.accueil" /></a></li>
		<li role="presentation"><a href="ViewContactForm.do"><bean:message
					key="main.contacts" /></a></li>
		<li role="presentation"><a href="MainGroupContact.jsp"><bean:message
					key="main.groupes.contacts" /></a></li>
	</ul>
	<br />
	<br />
	<br />
	<%
		String id = request.getParameter("id");
	%>
	<p class="bg-success">
		<bean:message key="supp.group" />
	</p>
</body>
</html>