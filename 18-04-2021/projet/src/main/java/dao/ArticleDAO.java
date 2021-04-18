package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datasource.DataSource;
import model.Article;

public class ArticleDAO implements IDAO<Article> {

	private static final String WHEREID = " WHERE id=?";
	boolean success;

	Connection conn = DataSource.getConnection();

	public boolean create(Article object) {

		success = false;

		try (PreparedStatement ps = conn.prepareStatement(
				"INSERT INTO articles (date, title, image, description, content) VALUES (?,?,?,?,?)")) {

			ps.setString(1, object.getDate());
			ps.setString(2, object.getTitle());
			ps.setString(3, object.getImage());
			ps.setString(4, object.getDescription());
			ps.setString(5, object.getContent());
			ps.executeUpdate();

			success = true;

			conn.close();

		} catch (SQLException ex) {
			ex.getMessage();
		}

		return success;
	}

	public boolean update(Article object) {

		success = false;

		try (PreparedStatement ps = conn
				.prepareStatement("UPDATE articles SET date=?, title=?, image=?, description=?, content=?" + WHEREID)) {

			ps.setString(1, object.getDate());
			ps.setString(2, object.getTitle());
			ps.setString(3, object.getImage());
			ps.setString(4, object.getDescription());
			ps.setString(5, object.getContent());
			ps.setString(6, object.getId());

			ps.executeUpdate();
			success = true;
			conn.close();

		} catch (SQLException ex) {
			ex.getMessage();
		}

		return success;
	}

	public boolean delete(String id) {

		success = false;

		try (PreparedStatement ps = conn.prepareStatement("DELETE FROM articles" + WHEREID)) {

			ps.setString(1, id);
			ps.executeUpdate();

			conn.close();

		} catch (SQLException ex) {
			ex.getMessage();
		}

		return success;
	}

	public List<Article> read() {

		List<Article> liste = new ArrayList<>();

		try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM articles")) {

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

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return liste;

	}

	public Article readById(String id) {

		try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM articles" + WHEREID)) {

			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return new Article(id, rs.getString("date"), rs.getString("title"), rs.getString("image"),
						rs.getString("description"), rs.getString("content"));
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
}