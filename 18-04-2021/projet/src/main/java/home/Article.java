package home;

import java.io.IOException;

import dao.ArticleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Article")

public class Article extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Article() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArticleDAO article = new ArticleDAO();
		article.readById(request.getParameter("id"));

		HttpSession session = request.getSession();

		session.setAttribute("date", article.readById(request.getParameter("id")).getDate());
		session.setAttribute("title", article.readById(request.getParameter("id")).getTitle());
		session.setAttribute("description", article.readById(request.getParameter("id")).getDescription());
		session.setAttribute("image", article.readById(request.getParameter("id")).getImage());
		session.setAttribute("content", article.readById(request.getParameter("id")).getContent());

		request.getRequestDispatcher("/article.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("action").equals("Edit article")) {

			response.sendRedirect(request.getContextPath() + "/Edit" + "?id=" + request.getParameter("id"));
		}

		if (request.getParameter("action").equals("Delete article")) {

			ArticleDAO article = new ArticleDAO();

			if (article.delete(request.getParameter("id"))) {
				request.getRequestDispatcher("/Home").forward(request, response);
			} else {
				response.sendRedirect(request.getRequestURI());
			}
		}
	}
}
