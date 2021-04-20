<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Create article</title>
<link rel="stylesheet" href="<%= request.getContextPath() +"/assets/css/edit.css" %>">
</head>
<body>
<%@ include file="/header/header.jsp" %>


<c:if test="${empty utilisateur}">
		
		<div class="wrapper">
		<div class="edit">
				<h1>Vous devez être connecter pour acceder à cette page</h1>
		</div>
		</div>
		
</c:if>


<c:if test="${not empty utilisateur}">

<div class="wrapper">
	<div class="edit">
		<form method="post">
				<h2 id="editForm">Create article</h2>

			<div>
				<label for="imageInput">Date:</label>
				<input type="datetime-local" id="dateInput" name="date" placeholder="Date" required autocomplete="off"></input>
			</div>
		
			<div>
				<label for="imageInput">Title:</label>
				<input type="text" id="titleInput" name="title" placeholder="Title" required autocomplete="off"></input>
			</div>
			
			<div>
				<label for="imageInput">Upload image</label>
				<input type="text" id="image" name="image" placeholder="/assets/images/image1.jpg" accept="image/png, image/jpeg">
			</div>
			
			<div>
				<label for="imageInput">Description:</label>
				<textarea id="descriptionInput" name="description" placeholder="Description" required autocomplete="off"></textarea>
			</div>
			
			<div>
				<label for="imageInput">Content:</label>
				<textarea id="contentInput" name="content" placeholder="Content" required autocomplete="off"></textarea>
			</div>
			
				<input type="submit" id="saveButton" name="action" value="Submit">

			<c:if test="${not empty success}">
				<div id="success" role="alert">
					${success}
				</div>
		    </c:if>
			
			<c:if test="${not empty error}">
				<div id="error" role="alert">
					${error}
				</div>
		    </c:if>
		    
		</form>
	</div>
</div>
</c:if>

</body>
</html>