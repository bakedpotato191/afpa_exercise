package home;

import java.io.IOException;

import dao.ArticleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Article;

@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String EDITJSP = "/edit.jsp";

	public Edit() {
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

		request.getRequestDispatcher("/edit.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String date = request.getParameter("date");
		String title = request.getParameter("title");
		String image = request.getParameter("image");
		String description = request.getParameter("description");
		String content = request.getParameter("content");

		if (request.getParameter("save") != null) {

			Article edit = new Article(id, date, title, image, description, content);
			ArticleDAO article = new ArticleDAO();

			if (article.update(edit)) {
				request.setAttribute("reply", "Successfully updated the article");
				request.getRequestDispatcher(EDITJSP).forward(request, response);
			} else {
				request.setAttribute("reply", "Failed to update the article");
				request.getRequestDispatcher(EDITJSP).forward(request, response);
			}
		}

		if (request.getParameter("cancel") != null) {
			request.getRequestDispatcher("/Home").forward(request, response);
		}
	}

}
