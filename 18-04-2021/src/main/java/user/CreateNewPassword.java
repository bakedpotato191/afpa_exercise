package user;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.security.crypto.bcrypt.BCrypt;

import com.google.common.hash.Hashing;

import bean.User;
import dao.TokenDAO;
import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "CreateNewPassword", urlPatterns = "/password_reset")
public class CreateNewPassword extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public CreateNewPassword() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("token") != null) {

			String token = request.getParameter("token");
			String hash = Hashing.sha512().hashString(token, StandardCharsets.UTF_8).toString();

			TokenDAO tk = new TokenDAO();

			if (tk.isValid(hash) != null) {

				HttpSession session = request.getSession();
				session.setAttribute("token", hash);
				session.setAttribute("email", tk.isValid(hash).getEmail());

				request.getRequestDispatcher("/passwordReset.jsp").forward(request, response);
				return;
			}
		}
		response.sendRedirect(request.getContextPath() + "/password_reset");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if (session != null && session.getAttribute("email") != null) {
			String password = request.getParameter("password");
			String repeat = request.getParameter("passwordRepeat");

			if (password.equals(repeat)) {
				String email = (String) session.getAttribute("email");
				String token = (String) session.getAttribute("token");
				String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));

				User user = new User();
				user.setEmail(email);
				user.setPassword(hashedPassword);

				UserDAO dao = new UserDAO();
				dao.update(user);

				TokenDAO tkn = new TokenDAO();
				tkn.invalidate(token);

				session.invalidate();
				request.setAttribute("success",
						"Password was successfully updated. You may now sign in.");
				request.getRequestDispatcher("/passwordReset.jsp").forward(request, response);

			} else {
				request.setAttribute("error", "Session has expired.");
				request.getRequestDispatcher("/passwordReset.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("error", "Passwords are not identical. Please retry.");
			request.getRequestDispatcher("/passwordReset.jsp").forward(request, response);
		}
	}
}
