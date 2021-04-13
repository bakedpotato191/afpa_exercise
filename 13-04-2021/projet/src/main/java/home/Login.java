package home;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.UserDAO;

@WebServlet("/Login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 7548535999683319806L;

	public Login() {
    	super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String email = request.getParameter("email");
    	String password = request.getParameter("password");
    	
    	if (email.isBlank() || password.isBlank()) {
    		RequestDispatcher req = request.getRequestDispatcher("fail.jsp");
    		req.include(request, response);
    	}
    	else {
    		
    		UserDAO user = new UserDAO();
    		
    		if (user.userExists(email, password)) {
        		RequestDispatcher req = request.getRequestDispatcher("welcome.jsp");
        		req.include(request, response);
        	}
        	else {
        		RequestDispatcher req = request.getRequestDispatcher("fail.jsp");
        		req.include(request, response);
        	}
    	}	
	}

}
