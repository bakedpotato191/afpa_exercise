package home;

import java.io.IOException;

import dao.ArticleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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

		request.setAttribute("date", article.readById(request.getParameter("id")).getDate());
		request.setAttribute("title", article.readById(request.getParameter("id")).getTitle());
		request.setAttribute("description", article.readById(request.getParameter("id")).getDescription());
		request.setAttribute("image", article.readById(request.getParameter("id")).getImage());
		request.setAttribute("content", article.readById(request.getParameter("id")).getContent());

		request.getRequestDispatcher("/article.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("action").equals("Edit article")) {
			System.out.println(request.getParameter("action"));
			request.getRequestDispatcher("/Edit").forward(request, response);
		}
		if (request.getParameter("action").equals("Delete article")) {
			request.getRequestDispatcher("/Home").forward(request, response);
		}
	}

}
