<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="en-US">
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<link rel="stylesheet" href="<%= request.getContextPath() +"/css/style.css" %>">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

</head>
<body>

<%@ include file="/header/header.jsp" %>

<div class="container">
<form method="post">
	<div class="mb-3">
    	<label for="exampleInputNom" class="form-label">Nom</label>
    	<input class="form-control " id="exampleInputNom" name="nom" aria-describedby="nomHelp" required>
  	</div>
  	<div class="mb-3">
    <label for="exampleInputPrenom" class="form-label">Prenom</label>
    <input class="form-control " id="exampleInputPrenom" name="prenom" aria-describedby="prenomHelp" required>
  	</div>
  	<div class="mb-3">
    	<label for="exampleInputEmail1" class="form-label">Email address</label>
    	<input type="email" class="form-control " id="exampleInputEmail1" name="email" aria-describedby="emailHelp" required>
    	<div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
  	</div>
  	<div class="mb-3">
    	<label for="exampleInputPassword1" class="form-label">Password</label>
    	<input type="password" class="form-control" id="exampleInputPassword1" name="password" required>
  	</div>
  	<div class="mb-3 form-check">
    	<input type="checkbox" class="form-check-input" id="exampleCheck1">
    	<label class="form-check-label" for="exampleCheck1">Check me out</label>
  	</div>
  	<button type="submit" class="btn btn-primary btn-margin">Submit</button> 
  	<div class="alert alert-light" role="alert">
	  ${message}
	</div>
</form>
</div>

</body>
</html>