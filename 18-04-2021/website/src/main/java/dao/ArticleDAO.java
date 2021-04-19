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

	private static final String WHEREID = " WHERE id=?";

	public boolean create(Article object) {

		boolean created = false;

		try (Connection conn = DataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(
						"INSERT INTO articles (date, title, image, description, content) VALUES (?,?,?,?,?)")) {

			ps.setString(1, object.getDate());
			ps.setString(2, object.getTitle());
			ps.setString(3, object.getImage());
			ps.setString(4, object.getDescription());
			ps.setString(5, object.getContent());
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
						"UPDATE articles SET date=?, title=?, image=?, description=?, content=?" + WHEREID)) {

			ps.setString(1, object.getDate());
			ps.setString(2, object.getTitle());
			ps.setString(3, object.getImage());
			ps.setString(4, object.getDescription());
			ps.setString(5, object.getContent());
			ps.setString(6, object.getId());

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
				PreparedStatement ps = conn.prepareStatement("DELETE FROM articles" + WHEREID)) {

			ps.setString(1, id);
			ps.executeUpdate();
			deleted = true;

		} catch (SQLException ex) {
			ex.getMessage();
		}

		return deleted;
	}

	public List<Article> read() {

		List<Article> liste = new ArrayList<>();

		try (Connection conn = DataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM articles")) {

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
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM articles" + WHEREID)) {

			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return new Article(id, rs.getString("date"), rs.getString("title"), rs.getString("image"),
						rs.getString("description"), rs.getString("content"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
}