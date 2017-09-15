<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ page import= "DAO.ContactDAO"%>
<%@ page import= "model.Contact"%>
<%@ page import= "java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
	<link rel="stylesheet" href="http://www.w3schools.com/lib/w3-theme-black.css">
	
	<title><bean:message key="modifier.supprimer" /></title>
	<style> 
		input{
			padding: 10px;
			
		}
	</style>
</head>
<body>

<ul class="nav nav-pills">
  <li role="presentation" class="active"><a href="Main.jsp"><bean:message key="main.page.accueil" /></a></li>
  <li role="presentation"><a href="contact.jsp"><bean:message key="main.contacts" /></a></li>
  <li role="presentation"><a href="MainGroupContact.jsp"><bean:message key="main.groupes.contacts" /></a></li>
</ul>
<br/>
<br/>
<br/>

	<div class ="w3-container w3-black">
		<center><h1> <bean:message key="main.modifier.supprimer.contact" /></h1></center>
	</div>
	<table class="w3-table w3-bordered w3-red w3-card-4 w3-hover-classes">
		<tr class="w3-dark-grey">
		<td><bean:message key="nom"/></td>
		<td><bean:message key="prenom"/></td>
		<td><bean:message key="mail"/></td>
		<td><bean:message key="action"/></td>
		</tr>
		<%@page import="java.sql.*"%>
<%

		String driver= "com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost/contact_db";
		String login="root";
		String mdp="root";
		String requete ="select * from contact";
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
					out.print("<tr><td>"+name+"</td><td>"+first_name+"</td><td>"+mail+"</td><td><a href='EditContact.jsp?id="+id+"'>Modifier</a></td></tr>");
				}
%>
		
		
	</table>
	
	
</body>
</html>