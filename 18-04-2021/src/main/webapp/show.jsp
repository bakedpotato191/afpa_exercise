<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en-US">
<head>
<meta charset="utf-8">
<title>${title}</title>
<link rel="stylesheet"
	href="<%=request.getContextPath() + "/assets/css/article.css"%>">
</head>

<body>
	<%@ include file="/header/header.jsp"%>

	<div class="container">
		<article>
			<div id="title">
				<h1>${article.title}</h1>
			</div>
			<div id="date">Date: ${article.date}</div>
			<div id="image">
				<a href="<%=request.getContextPath()%>/${article.image}"><img src="${article.image}" alt="article_image"></a>
			</div>
			<div id="description">${article.description}</div>
			<div id="content">
				<p id="content">${article.content}</p>
			</div>
		</article>
		<c:if test="${not empty utilisateur}">
			<div id="panel">
				<a id="editbtn"
					href="<%= request.getContextPath() %>/edit?id=${article.id}">Edit
					Article</a> <a id="deletebtn"
					href="<%= request.getContextPath() %>/delete?id=${article.id}">Delete
					Article</a>
			</div>
		</c:if>
	</div>
</body>
</html>
