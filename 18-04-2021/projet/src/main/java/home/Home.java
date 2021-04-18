package home;

import java.io.IOException;

import dao.ArticleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Home")
public class Home extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Home() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArticleDAO article = new ArticleDAO();

		request.setAttribute("list", article.read());
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
