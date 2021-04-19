package user;

import java.io.IOException;

import org.springframework.security.crypto.bcrypt.BCrypt;

import bean.User;
import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Registration")
public class Registration extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Registration() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/registration.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User user = new User();
		String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));

		user.setNom(request.getParameter("nom"));
		user.setPrenom(request.getParameter("prenom"));
		user.setEmail(email);
		user.setPassword(hashedPassword);

		UserDAO register = new UserDAO();

		if (register.create(user)) {
			request.setAttribute("message", "Féliciation l'utilisateur a été bien ajouté");
		} else {
			request.setAttribute("message", "Oups, erreur lors de la création de compte");
		}

		request.getRequestDispatcher("/registration.jsp").forward(request, response);
	}
}
