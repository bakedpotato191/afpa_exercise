package article;

import java.io.IOException;

import bean.Article;
import dao.ArticleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet
public class Create extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Create() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/create.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArticleDAO article = new ArticleDAO();

		Article edited = new Article(null, request.getParameter("date"), request.getParameter("title"),
				request.getParameter("image"), request.getParameter("description"), request.getParameter("content"));

		article.create(edited);
		request.getRequestDispatcher("/create.jsp").forward(request, response);

	}

}
