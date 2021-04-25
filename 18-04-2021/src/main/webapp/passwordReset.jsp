<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update your password</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() + "/assets/css/forms.css"%>">
</head>
<body>
	<%@ include file="/header/header.jsp"%>
	<div class="flex-container">
		<div class="container">
			<form method="POST">
				<h2>Please enter your new password</h2>

				<div id="password">
					<input type="password" id="passwordInput" name="password"
						placeholder="Password" required autocomplete="off"></input>
				</div>

				<div id="passwordRepeat">
					<input type="password" id="passwordRepeatInput"
						name="passwordRepeat" placeholder="Repeat your password" required
						autocomplete="off"></input>
				</div>
				<button type="submit">Update Password</button>
			</form>

			<c:if test="${not empty success}">
				<div class="success" role="alert">${success}</div>
			</c:if>

			<c:if test="${not empty error}">
				<div class="error" role="alert">${error}</div>
			</c:if>

		</div>
	</div>
</body>
</html>