<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<header>
	<nav>
		<ul>
			<li id="articles">
				<a href="<%= request.getContextPath() + "/Home" %>">Home</a>
			</li>
			
			<c:if test="${empty utilisateur}">
				<li id="register">
		      		<a href="<%= request.getContextPath()+"/Registration"%>">Create account</a>
		      	</li>
			
				<li id="login">
		      		<a href="<%= request.getContextPath()+"/Login"%>">Sign-In</a>
		      	</li>
		    </c:if>
		    
		    <c:if test="${not empty utilisateur}">
		    	<li id="disconnect">
		      		<a href="<%= request.getContextPath()+"/Logout"%>">Disconnect</a>
		      	</li>
		    </c:if>

		</ul>
	</nav>
</header>