<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en-US">
<head>
<meta charset="utf-8">
<title>${id}</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() + "/assets/css/edit.css"%>">
</head>
<body>
	<%@ include file="/header/header.jsp"%>

	<div class="wrapper">
		<div class="edit">
			<form method="post" action="edit" enctype="multipart/form-data">
				<h2 id="editForm">Edit article</h2>
				<div>
					<label for="imageInput">Date:</label> <input type="datetime-local"
						id="dateInput" name="date" placeholder="Date"
						value="<c:out value="${article.date}"/>" required
						autocomplete="off"></input>
				</div>

				<div>
					<label for="imageInput">Title:</label> <input type="text"
						id="titleInput" name="title" placeholder="Title"
						value="<c:out value="${article.title}"/>" required
						autocomplete="off"></input>
				</div>

				<div>
					<label for="imageInput">Upload image</label> <input type="file"
						id="image" name="image" accept="image/png, image/jpeg"
						value="<c:out value="${article.image}"/>"
						accept="image/png, image/jpeg">
				</div>

				<div>
					<label for="imageInput">Description:</label>
					<textarea id="descriptionInput" name="description"
						placeholder="Description" required autocomplete="off"><c:out
							value="${article.description}" /></textarea>
				</div>

				<div>
					<label for="imageInput">Content:</label>
					<textarea id="contentInput" name="content" placeholder="Content"
						required autocomplete="off"><c:out
							value="${article.content}" /></textarea>
				</div>

				<input type="submit" id="saveButton" name="action" value="Save">

				<c:if test="${not empty success}">
					<div id="success" role="alert">${success}</div>
				</c:if>

				<c:if test="${not empty error}">
					<div id="error" role="alert">${error}</div>
				</c:if>
			</form>
		</div>
	</div>

</body>
</html>