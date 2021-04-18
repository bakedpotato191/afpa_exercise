<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en-US">
<head>
<meta charset="ISO-8859-1">
<title>${title}</title>
<link rel="stylesheet" href="<%= request.getContextPath() +"/assets/css/article.css" %>">
</head>

<body>
<%@ include file="/header/header.jsp" %>

<div class="container">
  <article>
    <h1>${title}</h1>
    <span>Date: ${date}</span>
    <img src="${image}" alt="article_image">
    <span>${description}</span>
    <p id="content">${content}</p>
  </article>

  <div id="panel">
	<form action="" method="post">
    <input id="editbtn" type="submit" name="action" value="Edit article"/>
	</form>
	
	<form action="" method="post">
    <input id="deletebtn" type="submit" name="action" value="Delete article"/>
	</form>
</div>
</div>
</body>
</html>
