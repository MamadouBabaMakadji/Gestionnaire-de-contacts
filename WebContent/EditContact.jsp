<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
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
		Adress contact_adress = contact.getAdress();
		Set<PhoneNumber> phones = contact.getPhones();
		Set<Group> groups = contact.getGroups();
		Iterator<PhoneNumber> iterPhone = phones.iterator();
		if (!groups.isEmpty()) {
			Iterator<Group> iterGroup = groups.iterator();
			Group groupe = iterGroup.next();
			String group = groupe.getGroupName();
			request.setAttribute("group", group);
		}

		PhoneNumber phone = iterPhone.next();
		if (iterPhone.hasNext()) {
			PhoneNumber phone2 = iterPhone.next();
			String tel2 = phone2.getPhoneNumber();
			request.setAttribute("tel2", tel2);
		}

		String nom 			= contact.getNom();
		String prenom 		= contact.getPrenom();
		String mail 		= contact.getMail();
		String adress 		= contact_adress.getStreet();
		String ville 		= contact_adress.getCity();
		String code_postal 	= contact_adress.getZip();
		String pays 		= contact_adress.getCountry();
		String tel 			= phone.getPhoneNumber();
		int version			= contact.getVersion();
		
		request.setAttribute("nom", nom);
		request.setAttribute("prenom", prenom);
		request.setAttribute("mail", mail);
		request.setAttribute("adress", adress);
		request.setAttribute("ville", ville);
		request.setAttribute("code_postal", code_postal);
		request.setAttribute("pays", pays);
		request.setAttribute("tel", tel);
		request.setAttribute("id_c", contact_ID);
		request.setAttribute("version", version);
	%>
	<h2>
		<center>
			<bean:message key="modifier.contact" />
		</center>
	</h2>
	<html:form action="EditContactForm.do" method="post">
		<table align="center">
			<tr>
				<html:hidden property="identifiant" value="${id_c}" />
				<html:hidden property="version" value="${version}" />
				<td><bean:message key="nom" /></td>
				<td><br /> <html:text property="nom" value="${nom}" /><br />
					<br /></td>
				<td><bean:message key="adresse" /></td>
				<td><br /> <html:text property="adress" value="${adress}" /><br />
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
			<tr>
				<td><bean:message key="tel" /></td>
				<td><br /> <html:text property="tel" value="${tel}" /><br />
					<br /></td>
				<td><bean:message key="tel2" /></td>
				<td><br /> <html:text property="tel2" value="${tel2}" /><br />
					<br /></td>
			</tr>

			<tr>
				<td><bean:message key="pays" /></td>
				<td><br /> <html:text property="pays" value="${pays}" /><br />
					<br /></td>
				<td><bean:message key="group" /></td>
				<td><br /> <html:text property="group" value="${group}" /><br />
					<br /></td>
			</tr>

			<tr>
				<td></td>
				<td><br /> <input type="submit" class="btn btn-primary"
					value="<bean:message key="enreg.modif"/>" /></td>
			</tr>
		</table>
	</html:form>
</body>
</html>