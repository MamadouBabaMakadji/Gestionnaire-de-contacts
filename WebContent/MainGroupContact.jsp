<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="model.*"%>
<%@page import="service.*"%>
<%@page import="DAO.*"%>

<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
		<link rel="stylesheet" href="http://www.w3schools.com/lib/w3-theme-black.css">
	<title><bean:message key="groupe.contact" /></title>
	</head>
	<body>
		
		<ul class="nav nav-pills">
		  <li role="presentation" class="active"><a href="Main.jsp"><bean:message key="main.page.accueil" /></a></li>
		  <li role="presentation"><a href="FormEditContact.jsp"><bean:message key="main.contacts" /></a></li>
		  <li role="presentation"><a href="MainGroupContact.jsp"><bean:message key="main.groupes.contacts" /></a></li>
		</ul>
		<div class="list-group">
		<a href="#" class="list-group-item"><img src="images/group.jpg" /><bean:message key="nouveau.group.contact" /></a>
		<br/>
		<html:errors/>
			<html:form action="GroupContactForm.do">
			<bean:message key="nom.group" /><html:text property="nom"></html:text>
			<input type="submit" class="btn btn-primary" value="<bean:message key="creer"/>" />
			</html:form>
			<a><!-- href="#" class="list-group-item"><img src="images/ico_group2_modified.jpg"/> -->
				<bean:message key="mes.group.contact"/>
			</a>
		</div>
		<table class="w3-table w3-bordered w3-red w3-card-4 w3-hover-classes">
				<tr class="w3-dark-grey">
				<td><bean:message key="nom"/></td>
				<td><bean:message key="action"/></td>
				<td></td>
				</tr>
				<%@page import="java.sql.*"%>
		<%
			try
			{	
				IContactService cs = new ContactServiceImpl();
				Set<Group> gp = cs.getAllGroups();
 				for(Group var : gp)
 				{
 					out.print("<tr><td>"+var.getGroupName()+"</td><td><a href='deleteGroup.jsp?id="+var.getGroup_ID()+
 							"'>Supprimer</a></td><td><a href='GroupContact.jsp?id="+var.getGroup_ID()+"&name="+var.getGroupName()+"'+>Afficher le Groupe</a></td></tr>");
 				}
			}			
			catch(Exception e){
				e.printStackTrace();
			}			
		%>
				
				
		</table>
			
	</body>
</html>