<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en-US">
<head>
<meta charset="utf-8">
<title>Home Page</title>
<link rel="stylesheet" href="<%= request.getContextPath() +"/assets/css/home.css" %>">

</head>
<body>

<%@ include file="/header/header.jsp" %>

	<section>
 	<c:forEach var="article" items="${list}">

 		<c:url var="loadArticle" value="/show">
            <c:param name="id" value="${article.id}"/>
        </c:url>

    	<a href="${loadArticle}">
 		<div class="article">
   			<img src="${article.image}" alt="image">
   			<h2>${article.title}</h2>
 		</div>
 		</a>
	</c:forEach>
 	</section>
</body>
</html>
