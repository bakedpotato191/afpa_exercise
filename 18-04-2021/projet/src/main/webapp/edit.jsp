<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en-US">
<head>
<meta charset="ISO-8859-1">
<title>Edit Article</title>
<link rel="stylesheet" href="<%= request.getContextPath() +"/assets/css/edit.css" %>">
</head>
<body>
<%@ include file="/header/header.jsp" %>

<div class="grandParentContainer">
	<div class="parentContainer">
		<form method="post">
				<h2 id="editForm"> Edit article</h2>

			<div id="dateContainer">
				<label for="imageInput">Date:</label>
				<input type="datetime-local" id="dateInput" name="date" value="${date}" required autocomplete="off"></input>
			</div>
		
			<div id="titleContainer">
				<label for="imageInput">Title:</label>
				<input type="text" id="titleInput" name="title" placeholder="Title" value="${title}" required autocomplete="off"></input>
			</div>
			
			<div id="imageContainer">
				<label for="imageInput">Upload image</label>
				<input type="file" id="image" name="image" value="${image}" accept="image/png, image/jpeg">
			</div>
			
			<div id="descriptionContainer">
				<label for="imageInput">Description:</label>
				<textarea id="descriptionInput" name="description" placeholder="Description" required autocomplete="off">${description}</textarea>
			</div>
			
			<div id="contentContainer">
				<label for="imageInput">Content:</label>
				<textarea id="contentInput" name="content" placeholder="Content" required autocomplete="off">${content}</textarea>
			</div>
			
				<input type="submit" id="saveButton" name="save" value="Save">
				<input type="submit" id="cancelButton" name="cancel" value="Cancel">
				
			<div id="error" role="alert">
	  			${message}
			</div>
		</form>
	</div>
</div>

</body>
</html>