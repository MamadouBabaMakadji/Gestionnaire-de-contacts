<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ page import="DAO.ContactDAO"%>
<%@ page import="model.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet"
	href="http://www.w3schools.com/lib/w3-theme-black.css">
<title><bean:message key="modifier.supprimer" /></title>
<style>
input {
	padding: 10px;
}
</style>
</head>
<body>
	<ul class="nav nav-pills">
		<li role="presentation" class="active"><a href="Main.jsp"><bean:message
					key="main.page.accueil" /></a></li>
		<li role="presentation"><a href="contact.jsp"><bean:message
					key="main.contacts" /></a></li>
		<li role="presentation"><a href="MainGroupContact.jsp"><bean:message
					key="main.groupes.contacts" /></a></li>
	</ul>
	<br />
	<br />
	<br />
	<div class="w3-container w3-black">
		<center>
			<h1>
				<bean:message key="main.modifier.supprimer.contact" />
			</h1>
		</center>
	</div>
	<table class="w3-table w3-bordered w3-red w3-card-4 w3-hover-classes">
		<tr class="w3-dark-grey">
			<td><bean:message key="nom" /></td>
			<td><bean:message key="prenom" /></td>
			<td><bean:message key="mail" /></td>
			<td><bean:message key="tel" /></td>
			<td><bean:message key="action" /></td>
		</tr>
		<%
			try {
				ContactDAO dao = new ContactDAO();
				List<Contact> contacts = new ArrayList<Contact>();
				contacts = dao.getAllContacts();
				Iterator<Contact> iter = contacts.iterator();
				while (iter.hasNext()) {
					Contact contact = iter.next();
					Adress adress = contact.getAdress();
					Set<PhoneNumber> phones = contact.getPhones();
					out.print("<tr><td>" + contact.getNom() + "</td><td>" + contact.getPrenom() + "</td><td>"
							+ contact.getMail() + "</td><td>");
					Object[] phoneObjects = phones.toArray();
					for (int i = 0; i < phoneObjects.length; i++) {
						PhoneNumber phone = (PhoneNumber) phoneObjects[i];
						out.print("\n" + phone.getPhoneNumber() + "\n");
					}
					out.print("</td><td><a href='EditContact.jsp?id=" + contact.getContact_ID()
							+ "'>Modifier</a></td></tr>");
				}
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		%>
	</table>
</body>
</html>