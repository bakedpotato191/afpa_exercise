package article;

import java.io.IOException;

import dao.ArticleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "Show", urlPatterns = "/show")
public class Show extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Show() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("id") == null || request.getParameter("id").isBlank()) {

			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		} else {
			ArticleDAO article = new ArticleDAO();
			String id = request.getParameter("id");

			request.setAttribute("article", article.readById(id));
			request.getRequestDispatcher("/show.jsp").forward(request, response);
		}
	}
}
