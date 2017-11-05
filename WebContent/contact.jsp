<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.hibernate.HibernateException"%>
<%-- <%@page import="org.hamcrest.core.IsInstanceOf"%> --%>
<%@page import="java.util.*"%>
<%@page import="model.*"%>
<%@page import="service.*"%>
<%@page import="DAO.*"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<title><bean:message key="search.result" /></title>
</head>
<body>
	<ul class="nav nav-pills">
		<li role="presentation" class="active"><a href="Main.jsp"><bean:message
					key="main.page.accueil" /></a></li>
		<li role="presentation"><a href="#"><bean:message
					key="main.contacts" /></a></li>
		<li role="presentation"><a href="MainGroupContact.jsp"><bean:message
					key="main.groupes.contacts" /></a></li>
	</ul>
	<br>
	<div class="w3-container w3-teal">
		<%
			String var = request.getParameter("name");
			request.setAttribute("var", var);
		%>
		<h2>
			<bean:message key="MesContacts" />
		</h2>
	</div>
	<div>
		<table class="w3-table w3-bordered w3-red w3-card-4 w3-hover-classes">
			<tr class="w3-black">
				<td><bean:message key="nom" /></td>
				<td><bean:message key="prenom" /></td>
				<td><bean:message key="mail" /></td>
				<td><bean:message key="tel" /></td>
				<td><bean:message key="ville" /></td>
				<td><bean:message key="adresse" /></td>
				<td><bean:message key="code_postal" /></td>
				<td><bean:message key="pays" /></td>
			</tr>
			<%
				try {
					ContactDAO dao = new ContactDAO();
					List<Object[]> contacts = new ArrayList<Object[]>();
					contacts = dao.executerRequete("from Contact, Adress, PhoneNumber");
					Iterator<Object[]> iter = contacts.iterator();
					while (iter.hasNext()) {
						Object[] objects = iter.next();
						Contact contact = (Contact) objects[0];
						Adress adress = (Adress) objects[1];
						PhoneNumber phone = (PhoneNumber) objects[2];
						out.print("<tr><td>" + contact.getNom() + "</td><td>" + contact.getPrenom() + "</td><td>"
								+ contact.getMail() + "</td><td>" + phone.getPhoneNumber() + "</td><td>" + adress.getCity()
								+ "</td><td>" + adress.getStreet() + "</td><td>" + adress.getZip() + "</td><td>"
								+ adress.getCountry() + "</td></tr>");
					}
				} catch (Exception e) {
					throw new Exception(e.getMessage());
				}
			%>
		</table>
	</div>
</body>
</html>