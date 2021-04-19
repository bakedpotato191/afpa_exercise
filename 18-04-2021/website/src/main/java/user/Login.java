package user;

import java.io.IOException;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserDAO user = new UserDAO();

		if (user.login(email, password) != null) {

			HttpSession session = request.getSession();
			session.setAttribute("utilisateur", user.login(email, password).getEmail());

			request.getRequestDispatcher("/Home").forward(request, response);

		} else {
			request.setAttribute("message", "Invalid email or password.	");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
}