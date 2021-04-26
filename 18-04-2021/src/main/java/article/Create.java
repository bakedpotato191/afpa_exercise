package article;

import java.io.File;
import java.io.IOException;

import bean.Article;
import dao.ArticleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet(name = "Create", urlPatterns = "/create")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024
		* 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class Create extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Create() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/create.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String content = request.getParameter("content");
		String path = "assets/images/";

		String uploadPath = getServletContext().getRealPath("") + File.separator + path;
		File uploadDir = new File(uploadPath);

		if (!uploadDir.exists())
			uploadDir.mkdir();

		Part part = request.getPart("image");
		String fileName = getFileName(part);

		if (fileName != null && !fileName.isEmpty()) {
			part.write(uploadPath + File.separator + fileName);
		}

		Article article = new Article();
		article.setTitle(title);
		article.setImage(path + fileName);
		article.setDescription(description);
		article.setContent(content);

		ArticleDAO dao = new ArticleDAO();

		if (dao.create(article)) {
			request.setAttribute("success", "Artice was successfully added to the database");

		} else {
			request.setAttribute("error", "Failed to add the article");
		}

		request.setAttribute("article", article);
		request.getRequestDispatcher("/create.jsp").forward(request, response);
	}

	private String getFileName(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename"))
				return content.substring(content.indexOf("=") + 2, content.length() - 1);
		}
		return null;
	}
}
