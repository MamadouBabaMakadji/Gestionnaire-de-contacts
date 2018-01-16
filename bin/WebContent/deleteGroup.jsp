<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<title></title>
</head>
<body>

<ul class="nav nav-pills">
  <li role="presentation" class="active"><a href="Main.jsp"><bean:message key="main.page.accueil" /></a></li>
  <li role="presentation"><a href="FormEditContact.jsp"><bean:message key="main.contacts" /></a></li>
  <li role="presentation"><a href="MainGroupContact.jsp"><bean:message key="main.groupes.contacts" /></a></li>
</ul>
<br/>
<br/>
<br/>
<%@page import="java.sql.*" %>
<% 
String id= request.getParameter("id");

String driver= "com.mysql.jdbc.Driver";
String url="jdbc:mysql://localhost/contact_db";
String login="root";
String mdp="root";
String requete = "delete from contact_group where id='"+id+"'";

//System.out.println(requete);

Statement stmt = null;
Connection connect = null;

try{
	Class.forName(driver);
	connect= DriverManager.getConnection(url,login,mdp);
	stmt=connect.createStatement();
	stmt.executeUpdate(requete); // Exécute la requête
	}catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Echec de la connexion");
	}finally{
		try{

			if(stmt !=null){
				stmt.close();
			}	
			if(connect !=null){
				connect.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	
	}
%>
<p class="bg-success"><bean:message key="supp.group" /></p>
</body>
</html>