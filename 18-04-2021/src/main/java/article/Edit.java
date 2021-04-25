package article;

import java.io.File;
import java.io.IOException;
import java.io.Serial;

import bean.Article;
import dao.ArticleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet(name = "Edit", urlPatterns = "/edit")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024
		* 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class Edit extends HttpServlet {

	@Serial
	private static final long serialVersionUID = 1L;

	public Edit() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		if (id == null || id.isBlank()) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		} else {
			ArticleDAO article = new ArticleDAO();

			request.setAttribute("article", article.readById(id));
			request.getRequestDispatcher("/edit.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		String id = (String) session.getAttribute("id");
		String date = request.getParameter("date");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String content = request.getParameter("content");
		String default_location = "assets/images/";

		String uploadPath = getServletContext().getRealPath("") + File.separator + default_location;
		File uploadDir = new File(uploadPath);

		if (!uploadDir.exists())
			uploadDir.mkdir();

		Part part = request.getPart("image");
		String fileName = getFileName(part);

		if (fileName != null && !fileName.isEmpty()) {
			part.write(uploadPath + File.separator + fileName);
		}

		Article edited = new Article(id, date, title, default_location + fileName, description,
				content);
		ArticleDAO article = new ArticleDAO();

		if (article.update(edited)) {
			request.setAttribute("success", "Artice edited successfully");

		} else {
			request.setAttribute("error", "Failed to edit the article");
		}
		request.getRequestDispatcher("/edit.jsp").forward(request, response);
	}

	private String getFileName(Part part) {

		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename"))
				return content.substring(content.indexOf("=") + 2, content.length() - 1);
		}
		return null;
	}
}
