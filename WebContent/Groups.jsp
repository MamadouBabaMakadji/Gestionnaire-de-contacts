<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Set"%>
<%@ page import="model.*"%>
<%@ page import="service.*"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>

<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
	<link rel="stylesheet"
		href="http://www.w3schools.com/lib/w3-theme-black.css">
	<title><bean:message key="groupe.contact" /></title>
	</head>
	<body>
	
		<ul class="nav nav-pills">
			<li role="presentation"><a href="Main.jsp"><bean:message key="main.page.accueil" /></a></li>
			<li role="presentation"><a href="FormEditContact.jsp"><bean:message key="main.contacts" /></a></li>
			<li role="presentation" class="active"><a href="Groups.jsp"><bean:message key="main.groupes.contacts" /></a></li>
		</ul>
		
		<div class="list-group">
			<a href="#" class="list-group-item"><img src="images/group.jpg" />
			<bean:message key="nouveau.group.contact" /></a> <br />
			<html:errors />
			<html:form action="CreateGroupForm.do">
				<bean:message key="nom.group" />
				<html:text property="nom"></html:text>
				<input type="submit" class="btn btn-primary" value="<bean:message key="creer"/>" />
			</html:form>
			<a>
				<bean:message key="mes.group.contact" />
			</a>
		</div>
		
		<table class="w3-table w3-bordered w3-red w3-card-4 w3-hover-classes">
			<tr class="w3-dark-grey">
				<td><bean:message key="nom" /></td>
				<td><bean:message key="action"/></td>
				<td></td>
			</tr>
	
<%-- 			
			<logic:iterate id="group" name="listGroups">
				<tr>
					<td><bean:write name="group" property="groupName" /></td>
					<td><html:link href="/group.jsp?id=">Afficher le groupe</html:link></td>
					<td><html:link href="/deleteGroup.jsp?id=${group_ID}">Supprimer le groupe</html:link></td>
				</tr>
			</logic:iterate> 
--%>
				
			<%
				try
				{	
					ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
					IContactService service = (IContactService) context.getBean("service");
					Set<Group> gp = service.getAllGroups();
	 				for(Group var : gp)
	 				{
	 					out.print("<tr><td>"+var.getGroupName()+"</td>" +
	 					"<td><a href='deleteGroup.jsp?id="+var.getGroup_ID()+"'>Supprimer</a></td>" +
	 					"<td><a href='group.jsp?id="+var.getGroup_ID()+"'+>Afficher le Groupe</a></td></tr>");
	 				}
				}		
				catch(Exception e){
					e.printStackTrace();
				}			
			%> 
			
		</table>
	
	</body>
</html>