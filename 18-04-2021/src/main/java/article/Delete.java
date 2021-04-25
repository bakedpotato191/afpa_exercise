package article;

import java.io.IOException;

import dao.ArticleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "Delete", urlPatterns = "/delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Delete() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("id") == null || request.getParameter("id").isBlank()) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		} else {
			String id = request.getParameter("id");
			ArticleDAO article = new ArticleDAO();
			article.delete(id);
			response.sendRedirect("/home");
		}
	}
}
