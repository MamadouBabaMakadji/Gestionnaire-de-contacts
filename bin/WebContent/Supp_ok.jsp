<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<title><bean:message key="supprimer" /></title>
</head>
<body>

<ul class="nav nav-pills">
  <li role="presentation" class="active"><a href="Main.jsp"><bean:message key="main.page.accueil" /></a></li>
  <li role="presentation"><a href="FormEditContact.jsp"><bean:message key="main.contacts" /></a></li>
  <li role="presentation"><a href="MainGroupContact"><bean:message key="main.groupes.contacts" /></a></li>
</ul>
<br/>
<br/>
<br/>
<p class="bg-success"><bean:message key="supp.contact" /></p>
</body>
</html>