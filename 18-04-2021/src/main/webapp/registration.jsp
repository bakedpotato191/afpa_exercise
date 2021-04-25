<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en-US">
<head>
<meta charset="utf-8">
<title>Registration Page</title>
<link rel="stylesheet" type="text/css"
	href="<%= request.getContextPath() +"/assets/css/header.css" %>">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() + "/assets/css/forms.css"%>">

</head>
<body>

	<%@ include file="/header/header.jsp"%>

	<div class="flex-container">
		<div class="container">
			<form method="post">
				<h2>Registration</h2>

				<div id="nom">
					<input type="text" id="nomInput" name="nom" placeholder="Nom"
						required autocomplete="off"></input>
				</div>

				<div id="prenom">
					<input type="text" id="prenomInput" name="prenom"
						placeholder="Prenom" required autocomplete="off"></input>
				</div>

				<div id="email">
					<input type="email" id="emailInput" name="email"
						placeholder="Email address" required autocomplete="off"></input>
				</div>

				<div id="password">
					<input type="password" id="passwordInput" name="password"
						placeholder="Password" required autocomplete="off"></input>
				</div>
				<button type="submit">Submit</button>
			</form>

			<div id="options">
				<label>or <a id="option-login"
					href="<%=request.getContextPath() + "/login"%>">Login as
						Existing Customer</a></label>
			</div>

			<c:if test="${not empty error}">
				<div class="error" role="alert">${error}</div>
			</c:if>

			<c:if test="${not empty success}">
				<div class="success" role="alert">${success}</div>
			</c:if>
		</div>
	</div>

</body>
</html>