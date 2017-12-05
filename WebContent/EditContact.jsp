<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page import="util.HibernateUtil"%>
<%@ page import="DAO.*"%>
<%@ page import="service.*"%>
<%@ page import="model.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<title><bean:message key="modifier.contact" /></title>
</head>
<body>
	<ul class="nav nav-pills">
		<li role="presentation" class="active"><a href="Main.jsp"><bean:message
					key="main.page.accueil" /></a></li>
		<li role="presentation"><a href="FormEditContact.jsp"><bean:message
					key="main.contacts" /></a></li>
		<li role="presentation"><a href="MainGroupContact.jsp"><bean:message
					key="main.groupes.contacts" /></a></li>
	</ul>
	<br />
	<br />
	<br />
	<%
		String id = request.getParameter("id");
		ContactService service = new ContactService();
		long contact_ID = Long.parseLong(id);
		
		Contact contact = service.getContact(contact_ID);
		Adress adress = contact.getAdress();
		Set<PhoneNumber> phones = contact.getPhones();
		Set<Group> groups = contact.getGroups();
		
		int versionContact		= contact.getVersion();
		String nom 				= contact.getNom();
		String prenom 			= contact.getPrenom();
		String mail 			= contact.getMail();
		long adressId			= adress.getAdress_ID();
		String street 			= adress.getStreet();;
		String ville 			= adress.getCity();
		String code_postal 		= adress.getZip();
		String pays 			= adress.getCountry();
		
		request.setAttribute("nom", nom);
		request.setAttribute("prenom", prenom);
		request.setAttribute("mail", mail);
		request.setAttribute("street", street);
		request.setAttribute("ville", ville);
		request.setAttribute("code_postal", code_postal);
		request.setAttribute("pays", pays);
		request.setAttribute("contact_ID", contact_ID);
		request.setAttribute("version", versionContact);
		request.setAttribute("groups", groups);
		request.setAttribute("phones", phones);
		
	%>
	<h2>
		<center>
			<bean:message key="modifier.contact" />
		</center>
	</h2>
	<html:form action="EditContactForm.do" method="post">
		<table align="center">
			<tr>
				<html:hidden property="contactId" value="${contact_ID}" />
				<html:hidden property="versionContact" value="${version}" />
				<td><bean:message key="nom" /></td>
				<td><br /> <html:text property="nom" value="${nom}" /><br />
					<br /></td>
				<td><bean:message key="adresse" /></td>
				<td><br /> <html:text property="adress" value="${street}" /><br />
					<br /></td>
			</tr>
			<tr>
				<td><bean:message key="prenom" /></td>
				<td><br /> <html:text property="prenom" value="${prenom}" /><br />
					<br /></td>
				<td><bean:message key="code_postal" /></td>
				<td><br /> <html:text property="code_postal"
						value="${code_postal}" /><br /> <br /></td>
			</tr>
			<tr>
				<td><bean:message key="mail" /></td>
				<td><br /> <html:text property="mail" value="${mail}" /><br />
					<br /></td>
				<td><bean:message key="ville" /></td>
				<td><br /> <html:text property="ville" value="${ville}" /><br />
					<br /></td>
			</tr>
			
			
			<% int t=0; request.setAttribute("t", t); %> 
			<logic:iterate name="phones" id="phone">
				<% if ((t%2) == 0 ){out.print("<tr>");} %>
						<td><bean:message key="tel" /></td>
						<td><br/><html:text property="phonesNumber" value="${phone.getPhoneNumber()}"/><br/><br/></td>		
				<% if ((t%2) == 1 ){out.print("</tr>");} t++;%>
			</logic:iterate>


			<tr>
				<td><bean:message key="pays" /></td>
				<td><br/><html:text property="pays" value="${pays}"/><br/><br/></td>				
			</tr>
			
			
			<% int g=0; request.setAttribute("g", g); %> 
			<logic:iterate name="groups" id="group">
				<% if ((g%2) == 0){out.print("<tr>");} %>	
						<td><bean:message key="group" /></td>
						<td><br/><html:text property="groupsName" value="${group.getGroupName()}"/><br/><br/></td>		
				<% if ((g%2) == 1 ){out.print("</tr>");} g++;%>
			</logic:iterate>	
			
			<tr>
				<td></td>
				<td><br /> <input type="submit" class="btn btn-primary"
					value="<bean:message key="enreg.modif"/>" /></td>
			</tr>
		</table>
	</html:form>
</body>
</html>