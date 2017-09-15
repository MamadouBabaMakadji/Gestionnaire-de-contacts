<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@page import="java.sql.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.*"%>
<%@page import="service.*"%>
<%@page import="DAO.*"%>

<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel = "stylesheet" href ="http://www.w3schools.com/lib/w3.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<title>Résultat de la recherche</title>
</head>
<body>
<ul class="nav nav-pills">
  <li role="presentation" class="active"><a href="Main.jsp"><bean:message key="main.page.accueil" /></a></li>
  <li role="presentation"><a href="#"><bean:message key="main.contacts" /></a></li>
  <li role="presentation"><a href="MainGroupContact.jsp"><bean:message key="main.groupes.contacts" /></a></li>
</ul>
<br>
	<div class="w3-container w3-teal">
	<% 
		String var = request.getParameter("name");
		request.setAttribute("var", var);	
	%>
		<h2>Mes contacts</h2>
	</div>
		
		<table class="w3-table w3-bordered w3-red w3-card-4 w3-hover-classes">
				<tr class="w3-black">
				<td><bean:message key="nom"/></td>
				<td><bean:message key="prenom"/></td>
				<td><bean:message key="mail"/></td>
				<td><bean:message key="tel"/></td>
				<td><bean:message key="ville"/></td>
				<td><bean:message key="adresse"/></td>
				<td><bean:message key="code_postal"/></td>
				<td><bean:message key="pays"/></td>
				
				
				</tr>
		<%
		String driver= "com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost/contact_db";
		String login="root";
		String mdp="root";
		String requete ="select * from contact c, adress a,phonenumber p where c.id=p.id and c.id=a.id ";
		Statement stmt = null;
		Connection connect = null;
				Class.forName(driver);
				connect= DriverManager.getConnection(url,login,mdp);
				stmt=connect.createStatement();
				ResultSet rs=stmt.executeQuery(requete); // Exécute la requête
				while(rs.next()){
					int id = rs.getInt("id");
					String name= rs.getString("nom");
					String first_name= rs.getString("prenom");
					String mail= rs.getString("mail");
					out.print("<tr><td>"+name+"</td><td>"+first_name+"</td><td>"+mail+"</td><td>"+rs.getString("phoneNumber")+"</td><td>"+rs.getString("city")+"</td><td>"+rs.getString("street")+"</td><td>"+rs.getString("zip")+"</td><td>"+rs.getString("country")+"</td></tr>");
				}
			
		%>
		
		
		</table>
	</div>
	  
</body>
</html>