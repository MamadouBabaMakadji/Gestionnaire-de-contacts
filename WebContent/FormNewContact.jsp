<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="html-el" uri="http://struts.apache.org/tags-html-el" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ page language="java"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="service.*"%>
<%@ page import="DAO.*"%>
<%@ page import="model.*"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<title><bean:message key="FormNewContact.nouveau.contact" /></title>
</head>
	<body onload="noDisplay()">
	
	<ul class="nav nav-pills">
	  <li role="presentation" class="active"><a href="Main.jsp"><bean:message key="main.page.accueil" /></a></li>
	  <li role="presentation"><a href="contact.jsp"><bean:message key="main.contacts" /></a></li>
	  <li role="presentation"><a href="MainGroupContact.jsp"><bean:message key="main.groupes.contacts" /></a></li>
	</ul>
	<br/>
	<br/>
	<br/>
	<script type="text/javascript">
	function addTel(){
		var x = document.getElementById('tel2');
	    if (x.style.visibility === 'hidden') {
	        x.style.visibility = 'visible';
	    } else {
	        x.style.visibility = 'hidden';
	    }
	}
	function noDisplay(){
		document.getElementById('tel2').style.visibility = 'hidden';
	}
	</script>
	<h2>
	<center><bean:message key="FormNewContact.nouveau.contact" /></center>
	<br>
	</h2>
	<html:errors/>
		<html:form action="NewContactForm.do">
			<table align="center">
				<tr>
				<td><bean:message key="nom" /></td><td><br/><html:text property="nom"/><br/><br/></td>
				<td><bean:message key="adresse" /></td><td><br/><html:text property="adresse" /><br/><br/></td>
				</tr>
				<tr>
				<td><bean:message key="prenom" /></td><td><br/><html:text property="prenom" /><br/><br/></td>
				<td><bean:message key="code_postal" /></td><td><br/><html:text property="code_postal" /><br/><br/></td>
				</tr>
				<tr>
				<td><bean:message key="mail" /></td><td><br/><html:text property="mail"/><br/><br/></td>
				<td><bean:message key="ville" /></td><td><br/><html:text property="ville" /><br/><br/></td>
				</tr>
				<tr>
				<td><bean:message key="tel" /></td><td><br/><html:text property="tel"/><br/><br/></td>
				<td><input type="button" onclick="addTel()" class="btn btn-primary" value="+" /></td>
				<td><br/><html:text property="tel2" styleId="tel2"/><br/><br/></td>
				</tr>
				<tr>
				<td><bean:message key="group" /></td><td><br/><html:text property="group" /><br/><br/></td>
				<td><bean:message key="pays" /></td><td><br/><html:text property="pays"/><br/><br/></td>
				</tr>
				<tr>
				<td>  </td>
				<td>
				<br/>
				<input type="submit" class="btn btn-primary" value=" <bean:message key="enregistrer" />" />
				<input type="reset" class="btn btn-primary" value="<bean:message key="annuler" />" />
				</td>
				</tr>
			</table>
		</html:form>
				 
	</body>
</html>