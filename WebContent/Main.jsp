<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<title><bean:message key="main.page.accueil" /></title>
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
	<a><img src="images/contact.jpg" /></a>
	<div class="list-group">
		<a href="FormNewContact.jsp" class="list-group-item"><img
			src="images/newContact.png" /> <bean:message
				key="main.nouveau.contact" /></a> <a href="ViewEditContactForm.do"
			class="list-group-item"><img src="images/edit-contact.png" /> <bean:message
				key="modifier.contact" /></a> <a href="FormSuppContact.jsp"
			class="list-group-item"><img src="images/delete.png" /> <bean:message
				key="main.supprimer.contact" /></a> <a href="#" class="list-group-item"><img
			src="images/chercher-contact.png" /> <bean:message
				key="main.rechercher.contact" /> <html:errors /> <html:form
				action="SearchForm.do">
				<html:text property="nom"></html:text>
				<input type="submit" class="btn btn-primary"
					value="<bean:message key="main.search.rechercher"/>" />
			</html:form> </a>
	</div>

</body>
</html>