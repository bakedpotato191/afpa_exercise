package article;

import java.io.IOException;

import dao.ArticleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet

public class Show extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Show() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (request.getParameter("id") == null || request.getParameter("id").isBlank()) {
			
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
		else {
			ArticleDAO article = new ArticleDAO();
			String id = request.getParameter("id");

			request.setAttribute("article", article.readById(id));

			request.getRequestDispatcher("/show.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("action").equals("Edit article")) {

			response.sendRedirect(request.getContextPath() + "/edit" + "?id=" + request.getParameter("id"));
		}

		if (request.getParameter("action").equals("Delete article")) {

			ArticleDAO article = new ArticleDAO();

			if (article.delete(request.getParameter("id"))) {
				request.getRequestDispatcher("").forward(request, response);
			} else {
				response.sendRedirect(request.getRequestURI());
			}
		}
	}
}
