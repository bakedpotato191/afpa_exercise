package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Article;
import datasource.DataSource;

public class ArticleDAO implements IDAO<Article> {

	public boolean create(Article object) {

		boolean created = false;

		try (Connection conn = DataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(
						"INSERT INTO articles (title, image, description, content) VALUES (?,?,?,?)")) {

			ps.setString(1, object.getTitle());
			ps.setString(2, object.getImage());
			ps.setString(3, object.getDescription());
			ps.setString(4, object.getContent());
			ps.executeUpdate();

			created = true;

		} catch (SQLException ex) {
			ex.getMessage();
		}

		return created;
	}

	public boolean update(Article object) {

		boolean updated = false;

		try (Connection conn = DataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(
						"UPDATE articles SET title=?, image=?, description=?, content=? WHERE id=?")) {

			ps.setString(1, object.getTitle());
			ps.setString(2, object.getImage());
			ps.setString(3, object.getDescription());
			ps.setString(4, object.getContent());
			ps.setString(5, object.getId());

			ps.executeUpdate();
			updated = true;

		} catch (SQLException ex) {
			ex.getMessage();
		}

		return updated;
	}

	public boolean delete(String id) {

		boolean deleted = false;

		try (Connection conn = DataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement("DELETE FROM articles WHERE id=?")) {

			ps.setString(1, id);
			ps.executeUpdate();
			deleted = true;

		} catch (SQLException ex) {
			ex.getMessage();
		}

		return deleted;
	}

	public List<Article> read(int pageNumber, int numberOfArticles) {

		List<Article> liste = new ArrayList<>();

		try (Connection conn = DataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(
						"SELECT * FROM articles ORDER BY date DESC LIMIT ? OFFSET ?")) {

			ps.setInt(1, numberOfArticles);
			ps.setInt(2, pageNumber);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Article article = new Article();
				article.setId(rs.getString("id"));
				article.setDate(rs.getString("date"));
				article.setTitle(rs.getString("title"));
				article.setImage(rs.getString("image"));
				article.setDescription(rs.getString("description"));
				article.setContent(rs.getString("content"));

				liste.add(article);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return liste;

	}

	public Article readById(String id) {

		try (Connection conn = DataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM articles WHERE id=?")) {

			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return new Article(id, rs.getString("date"), rs.getString("title"),
						rs.getString("image"), rs.getString("description"),
						rs.getString("content"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public Integer getNumberOfRows() {

		try (Connection conn = DataSource.getConnection();
				PreparedStatement ps = conn
						.prepareStatement("SELECT COUNT(id) as count FROM articles")) {

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				return rs.getInt("count");
			}

		} catch (SQLException ex) {
			ex.getMessage();
		}

		return null;
	}
}