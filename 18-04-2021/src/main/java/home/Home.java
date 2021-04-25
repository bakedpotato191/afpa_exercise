package home;

import java.io.IOException;
import java.util.List;

import bean.Article;
import dao.ArticleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "Home", urlPatterns = "")
public class Home extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Home() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int page = 1;
		int recordsPerPage = 10;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		ArticleDAO article = new ArticleDAO();
		List<Article> list = article.read((page - 1) * recordsPerPage, recordsPerPage);

		int noOfRecords = article.getNumberOfRows();
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

		request.setAttribute("articleList", list);
		request.setAttribute("noOfPages", noOfPages);
		request.setAttribute("currentPage", page);

		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
