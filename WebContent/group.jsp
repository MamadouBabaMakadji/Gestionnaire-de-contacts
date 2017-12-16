<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@page import="java.sql.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="model.*"%>
<%@ page import="service.*"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>

<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<% 
		String var = request.getParameter("name");
		request.setAttribute("var", var);
		long groupId = Long.parseLong(request.getParameter("id"));
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		IContactService service = (IContactService) context.getBean("service");
		List<Contact> contacts = new ArrayList<Contact>(service.getContactsByGroupId(groupId));
		request.setAttribute("contacts", contacts);
		
	%>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel = "stylesheet" href ="http://www.w3schools.com/lib/w3.css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<title>Groupe ${var}</title>
	</head>
	<body>
		<ul class="nav nav-pills">
			<li role="presentation" class="active"><a href="Main.jsp"><bean:message key="main.page.accueil" /></a></li>
			<li role="presentation"><a href="ViewContactForm.do"><bean:message key="main.contacts" /></a></li>
			<li role="presentation"><a href="MainGroupContact.jsp"><bean:message key="main.groupes.contacts" /></a></li>
		</ul>
	<br>
		<div class="w3-container w3-teal">

			<h2>Contacts du groupe ${var}</h2>
		</div>
			
		<table class="w3-table w3-bordered w3-red w3-card-4 w3-hover-classes">
			<tr class="w3-dark-grey">
				<td><bean:message key="nom" /></td>
				<td><bean:message key="prenom" /></td>
				<td><bean:message key="mail" /></td>
				<%-- <td><bean:message key="tel" /></td> --%>
				<td><bean:message key="adresse" /></td>
				<td><bean:message key="ville" /></td>
				<td><bean:message key="code_postal" /></td>
				<td><bean:message key="pays" /></td>
			</tr>
			
			<logic:iterate id="contact" name="contacts">
				<tr>
					<td><bean:write name="contact" property="prenom" /></td>
					<td><bean:write name="contact" property="nom" /></td>
					<td><bean:write name="contact" property="mail" /></td>
					<td><bean:write name="contact" property="adress.street" /></td>
					<td><bean:write name="contact" property="adress.city" /></td>
					<td><bean:write name="contact" property="adress.country" /></td>
					<td><bean:write name="contact" property="adress.zip" /></td>
				</tr>
			</logic:iterate>
		
		</table>
	</body>
</html>