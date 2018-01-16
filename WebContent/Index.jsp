<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title><bean:message key="index.page.title" /></title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<div class="container">
		<div class="wrapper">
			<div class="form-signin">

				<html:form action="LoginForm.do">

					<h3 class="form-signin-heading">
						<bean:message key="index.SeConnecter" />
					</h3>
					<hr class="colorgraph">
					<br>
					<div class="form-control">
						<bean:message key="nom" />
						<center>
							<html:text property="nom"></html:text>
						</center>
					</div>
					<div class="form-control">
						<bean:message key="index.password" />
						<center>
							<html:password property="password"></html:password>
						</center>
					</div>
					<br>
					<center>
						<input type="submit" class="btn btn-primary"
							value=" <bean:message key="index.submit"/>" />
					</center>

				</html:form>

			</div>
		</div>
	</div>


</body>
</html>