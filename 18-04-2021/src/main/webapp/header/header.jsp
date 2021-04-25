<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<header>
	<nav>
		<ul>
			<li id="articles">
				<a href="<%= request.getContextPath() + "" %>">Home</a>
			</li>
			
			<li id="propos">
				<a href="<%= request.getContextPath() + "/about" %>">A propos</a>
			</li>
			
			<c:if test="${empty utilisateur}">
				<li id="register">
		      		<a href="<%= request.getContextPath()+"/signup"%>">Create account</a>
		      	</li>
			
				<li id="login">
		      		<a href="<%= request.getContextPath()+"/login"%>">Sign-In</a>
		      	</li>
		    </c:if>
		    
		    <c:if test="${not empty utilisateur}">
		    	<li id="createArticle">
					<a href="<%= request.getContextPath() + "/create" %>">Create article</a>
				</li>
		    
		    	<li id="disconnect">
		      		<a href="<%= request.getContextPath()+"/logout"%>">Disconnect</a>
		      	</li>
		    </c:if>

		</ul>
	</nav>
</header>