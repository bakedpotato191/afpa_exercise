<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en-US">
<head>
<meta charset="utf-8">
<title>Home Page</title>
<link rel="stylesheet" type="text/css"
	href="<%= request.getContextPath() +"/assets/css/header.css" %>">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() + "/assets/css/home.css"%>">

</head>
<body>
	<%@ include file="/header/header.jsp"%>

	<section>
		<c:forEach var="article" items="${articleList}">

			<c:url var="loadArticle" value="/show">
				<c:param name="id" value="${article.id}" />
			</c:url>

			<a href="${loadArticle}">
				<div class="article">
					<img src="${article.image}" alt="image">
					<h2>${article.title}</h2>
				</div>
			</a>
		</c:forEach>
	</section>

	<c:choose>
		<c:when test="${currentPage == 1}">
			<a href="${request.contextPath}?page=${currentPage + 1}"><button
					style="cursor: pointer;">Next Page</button></a>
		</c:when>

		<c:when test="${(currentPage != 1) and (currentPage < noOfPages)}">
			<a href="${request.contextPath}?page=${currentPage - 1}"><button
					style="cursor: pointer;">Previous</button></a>
			<a href="${request.contextPath}?page=${currentPage + 1}"><button
					style="cursor: pointer;">Next Page</button></a>
		</c:when>

		<c:otherwise>
			<a href="${request.contextPath}?page=${currentPage - 1}"><button
					style="cursor: pointer;">Previous</button></a>
			<a href="${request.contextPath}?page=${currentPage + 1}"><button
					style="cursor: default;" disabled>Next Page</button></a>
		</c:otherwise>
	</c:choose>

</body>

</html>
