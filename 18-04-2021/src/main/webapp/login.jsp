<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en-US">
<head>
<meta charset="utf-8">
<title>Login Page</title>
<link rel="stylesheet" type="text/css"
	href="<%= request.getContextPath() +"/assets/css/header.css" %>">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() + "/assets/css/forms.css"%>">

</head>
<body>

	<%@ include file="/header/header.jsp"%>
	<div class="flex-container">
		<div class="container">
			<form method="POST">
				<h2>Please sign in</h2>

				<div id="email">
					<input type="email" id="emailInput" name="email"
						placeholder="Email address" required autocomplete="off"></input>
				</div>

				<div id="password">
					<input type="password" id="passwordInput" name="password"
						placeholder="Password" required autocomplete="off"></input>
				</div>
				<button type="submit">Sign In</button>
			</form>

			<div id="options">
				<label>or <a id="option-register"
					href="<%=request.getContextPath() + "/signup"%>">Create a new
						account</a> | <a id="option-register"
					href="<%=request.getContextPath() + "/recoveryEmail"%>">Forgot
						password</a></label>
			</div>

			<c:if test="${not empty message}">
				<div class="error" role="alert">${message}</div>
			</c:if>

		</div>
	</div>
</body>

</html>