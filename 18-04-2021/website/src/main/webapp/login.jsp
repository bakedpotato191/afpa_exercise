<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="en-US">
<head>
<meta charset="utf-8">
<title>Login Page</title>

<link rel="stylesheet" href="<%= request.getContextPath() +"/assets/css/forms.css" %>">

</head>
<body>

<%@ include file="/header/header.jsp" %>
	<div class="flex-container">
		<div class="container">
		<form method="POST">
				<h2 id="loginForm"> Please sign in</h2>

			<div id="email">
				<input type="email" id="emailInput" name="email" placeholder="Email address" required autocomplete="off"></input>
			</div>
		
			<div id="password">
				<input type="password" id="passwordInput" name="password" placeholder="Password" required autocomplete="off"></input>
			</div>
				<button type="submit" id="loginButton">Sign In</button> 
		</form>
		
			<div id="options">
			<label>or <a id="option-register" href="<%= request.getContextPath() +"/Registration" %>">Create a new account</a> | <a>Forgot Password?</a></label>
			</div>
		
		<c:if test="${not empty message}">
		<div class="error" role="alert">
	  		${message}
		</div>
		</c:if>
		
		</div>
	</div>
</body>

<script src="/assets/js/jquery-3.6.0.min.js"></script>
</html>