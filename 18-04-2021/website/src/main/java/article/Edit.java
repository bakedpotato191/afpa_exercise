package article;

import java.io.IOException;

import bean.Article;
import dao.ArticleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet
public class Edit extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String EDIT_JSP = "/edit.jsp";

	public Edit() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		HttpSession session = request.getSession();

		ArticleDAO article = new ArticleDAO();

		session.setAttribute("article", article.readById(id));

		request.getRequestDispatcher(EDIT_JSP).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Article edited = new Article(request.getParameter("id"), request.getParameter("date"),
				request.getParameter("title"), request.getParameter("image"), request.getParameter("description"),
				request.getParameter("content"));

		ArticleDAO article = new ArticleDAO();

		if (article.update(edited)) {

			request.setAttribute("success", "Artice edited successfully");
			request.getRequestDispatcher(EDIT_JSP).forward(request, response);
		} else {

			request.setAttribute("error", "Failed to edit the article");
			request.getRequestDispatcher(EDIT_JSP).forward(request, response);
		}
	}
}
