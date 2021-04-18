<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="en-US">
<head>
<meta charset="utf-8">
<title>Registration Page</title>

<link rel="stylesheet" href="<%= request.getContextPath() +"/assets/css/forms.css" %>">

</head>
<body>

<%@ include file="/header/header.jsp" %>

<div class="grandParentContainer">
	<div class="parentContainer">
		<form method="post">
			<h2 id="registrationForm">Registration</h2>
			
			<div id="nomContainer">
				<input type="text" id="nomInput" name="nom" placeholder="Nom" required autocomplete="off"></input>
			</div>
			
			<div id="prenomContainer">
				<input type="text" id="prenomInput" name="prenom" placeholder="Prenom" required autocomplete="off"></input>
			</div>
			
			<div id="emailContainer">
				<input type="email" id="emailInput" name="email" placeholder="Email address" required autocomplete="off"></input>
			</div>
		
			<div id="passwordContainer">
				<input type="password" id="passwordInput" name="password" placeholder="Password" required autocomplete="off"></input>
			</div>
				<button type="submit" id="registrationButton">Submit</button> 
				
			<div id="error" role="alert">
	  			${message}
			</div>
		</form>
	</div>
</div>

</body>
</html>