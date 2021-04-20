<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en-US">
<head>
<meta charset="utf-8">
<title>${title}</title>
<link rel="stylesheet" href="<%= request.getContextPath() +"/assets/css/article.css" %>">
</head>

<body>
<%@ include file="/header/header.jsp" %>

<div class="container">
  <article>
    <h1>${article.title}</h1>
    <span>Date: ${article.date}</span>
    <img src="${article.image}" alt="article_image">
    <span>${article.description}</span>
    <p id="content">${article.content}</p>
  </article>
  <div id="panel">

	<form method="post">
	
    <input id="editbtn" type="submit" name="action" value="Edit article"/>
    <input id="deletebtn" type="submit" name="action" value="Delete article"/>
    
	</form>
	
	<div id="status" role="alert">
	  ${message}
	</div>
</div>
</div>
</body>
</html>
