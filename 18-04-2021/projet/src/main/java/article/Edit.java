package article;

import java.io.IOException;

import bean.Article;
import dao.ArticleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Edit")
public class Edit extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Edit() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/edit.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Article edited = new Article(request.getParameter("id"), request.getParameter("date"),
				request.getParameter("title"), request.getParameter("image"), request.getParameter("description"),
				request.getParameter("content"));

		ArticleDAO article = new ArticleDAO();

		if (article.update(edited)) {

			request.setAttribute("message", "Artice edited successfully");
			request.getRequestDispatcher("/edit.jsp").forward(request, response);
		} else {

			request.setAttribute("message", "Failed to edit the article");
			request.getRequestDispatcher("/edit.jsp").forward(request, response);
		}
	}
}
