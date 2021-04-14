package home;

import java.io.IOException;

import at.favre.lib.crypto.bcrypt.BCrypt;
import dao.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet("/Registration")
public class Registration extends HttpServlet {

	private static final long serialVersionUID = -612078339961973191L;

	public Registration() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");

		if (email.isBlank() || password.isBlank() || nom.isBlank() || prenom.isBlank()) {
			RequestDispatcher req = request.getRequestDispatcher("fail.jsp");
			req.include(request, response);
		} else {

			User user = new User();
			String hashedPassword = BCrypt.withDefaults().hashToString(12, password.toCharArray());

			user.setNom(nom);
			user.setPrenom(prenom);
			user.setEmail(email);
			user.setPassword(hashedPassword);

			UserDAO register = new UserDAO();

			if (register.create(user)) {
				request.setAttribute("message", "Féliciation l'utlisateur " + prenom + " " + nom + "a été bien ajouté");
			} else {
				request.setAttribute("message", "Oups, erreur lors de la création de compte");
			}

			request.getRequestDispatcher("/registration.jsp").forward(request, response);
		}
	}
}
