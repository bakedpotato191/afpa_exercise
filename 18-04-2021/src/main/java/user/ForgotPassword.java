package user;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;

import com.google.common.hash.Hashing;

import bean.Token;
import dao.TokenDAO;
import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import smtp.Mail;

@WebServlet(name = "PasswordRecovery", urlPatterns = "/recoveryEmail")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ForgotPassword() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/recoveryEmail.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");

		UserDAO user = new UserDAO();

		if (user.exists(email)) {
			String token = RandomStringUtils.random(64, 0, 0, true, true, null, new SecureRandom());
			String hash = Hashing.sha512().hashString(token, StandardCharsets.UTF_8).toString();

			Timestamp date = new Timestamp(
					System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(30));
			Token tkn = new Token(email, hash, date, false);

			TokenDAO dao = new TokenDAO();
			dao.create(tkn);

			Mail mail = new Mail();
			mail.send(email, token);
		}
		request.setAttribute("message",
				"Password Recovery link was sent to your email. Don't forget to check the spam folder.");
		request.getRequestDispatcher("/recoveryEmail.jsp").forward(request, response);
	}
}
