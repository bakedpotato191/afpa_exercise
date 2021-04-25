<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html lang="en-US">
<head>
<meta charset="utf-8">
<title>Password Recovery</title>
<link rel="stylesheet"
	href="<%= request.getContextPath() +"/assets/css/header.css" %>">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() +"/assets/css/forms.css" %>">

</head>
<body>

<%@ include file="/header/header.jsp" %>
	<div class="flex-container">
		<div class="container">
		<form method="POST">
				<h2> Please enter your email address</h2>

			<div id="email">
				<input type="email" id="emailInput" name="email" placeholder="Email address" required autocomplete="off"></input>
			</div>
				<button type="submit">Reset Password</button> 
		</form>
		
			<div id="options">
			<label>or <a id="option-register" href="<%= request.getContextPath() +"/signup" %>">Create a new account</a> | <a id="option-register" href="<%= request.getContextPath() +"/login" %>">Login</a></label>
			</div>
		
		<c:if test="${not empty message}">
		<div class="success" role="alert">
	  		${message}
		</div>
		</c:if>
		</div>
	</div>
</body>
</html>