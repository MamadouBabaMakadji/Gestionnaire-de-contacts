<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<title><bean:message key="modifier.contact"/></title>
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
<%@page import="java.sql.*" %>
<% 
String id= request.getParameter("id");

String driver= "com.mysql.jdbc.Driver";
String url="jdbc:mysql://localhost/contact_db";
String login="root";
String mdp="root";
String requete = "select * from contact,adress,phonenumber where contact.id='"+id+"' and adress.id='"+id+"' and phonenumber.id='"+id+"'";

//System.out.println(requete);

Statement stmt = null;
Connection connect = null;

try{
	Class.forName(driver);
	connect= DriverManager.getConnection(url,login,mdp);
	stmt=connect.createStatement();
	ResultSet rs = stmt.executeQuery(requete); // Exécute la requête
	while(rs.next()){
		int id_c=rs.getInt("id");
		String nom= rs.getString("nom");
		String prenom= rs.getString("prenom");
		String mail= rs.getString("mail");
		String adress= rs.getString("street");
		String ville= rs.getString("city");
		String code_postal= rs.getString("zip");
		String pays= rs.getString("country");
		String tel= rs.getString("phonenumber");
		request.setAttribute("nom", nom);
		request.setAttribute("prenom", prenom);
		request.setAttribute("mail", mail);
		request.setAttribute("adress", adress);
		request.setAttribute("ville", ville);
		request.setAttribute("code_postal", code_postal);
		request.setAttribute("pays", pays);
		request.setAttribute("tel", tel);
		request.setAttribute("id_c", id_c);
	}
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
<h2>
<center><bean:message key="main.supprimer.contact"/></center>
</h2>
<html:form action="SuppContactForm.do" method="post">
<table align="center">
<tr>
	<html:hidden property="identifiant" value="${id_c}"/>
	<td><bean:message key="nom" /></td><td><br/><html:text property="nom" value="${nom}"/><br/><br/></td>
	<td><bean:message key="adresse" /></td><td><br/><html:text property="adress" value="${adress}"/><br/><br/></td>
	</tr>
	<tr>
	<td><bean:message key="prenom" /></td><td><br/><html:text property="prenom" value="${prenom}"/><br/><br/></td>
	<td><bean:message key="code_postal" /></td><td><br/><html:text property="code_postal" value="${code_postal}"/><br/><br/></td>
	</tr>
	<tr>
	<td><bean:message key="mail" /></td><td><br/><html:text property="mail" value="${mail}"/><br/><br/></td>
	<td><bean:message key="ville" /></td><td><br/><html:text property="ville" value="${ville}"/><br/><br/></td>
	</tr>
	<tr>
	<td><bean:message key="tel" /></td><td><br/><html:text property="tel" value="${tel}"/><br/><br/></td>
	<td><bean:message key="pays" /></td><td><br/><html:text property="pays" value="${pays}"/><br/><br/></td>
	</tr>
	<tr>
	<td>  </td>
	<td>
	<br/>
	<html:submit><bean:message key="supprimer" /></html:submit>
	</td>
	</tr>
</table>
</html:form>
</body>
</html>