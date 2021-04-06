package com.projet.one;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO {

	private static final String WHEREID = " WHERE id=?";

	Connection conn = DataSource.getConnection();

	public void create(Article object) {

		try (PreparedStatement ps = conn.prepareStatement(
				"INSERT INTO articles (date, title, image, description, content) VALUES (?,?,?,?,?)")) {

			ps.setString(1, object.getDate());
			ps.setString(2, object.getTitle());
			ps.setString(3, object.getImage());
			ps.setString(4, object.getDescription());
			ps.setString(5, object.getContent());
			ps.executeUpdate();

		} catch (SQLException ex) {
			ex.getMessage();
		}

		finally {
			try {
				conn.close();
			} catch (SQLException ex) {
				ex.getMessage();
			}
		}
	}

	public void update(Article object) {

		try (PreparedStatement ps = conn
				.prepareStatement("UPDATE articles SET date=?, title=?, image=?, description=?, content=?" + WHEREID)) {

			ps.setString(1, object.getDate());
			ps.setString(2, object.getTitle());
			ps.setString(3, object.getImage());
			ps.setString(4, object.getDescription());
			ps.setString(5, object.getContent());
			ps.setString(6, object.getId());

			ps.executeUpdate();

		} catch (SQLException ex) {
			ex.getMessage();
		}

		finally {
			try {
				conn.close();
			} catch (SQLException ex) {
				ex.getMessage();
			}
		}
	}

	public void delete(String id) {

		try (PreparedStatement ps = conn.prepareStatement("DELETE FROM articles" + WHEREID)) {

			ps.setString(1, id);
			ps.executeUpdate();

		} catch (SQLException ex) {
			ex.getMessage();
		}

		finally {
			try {
				conn.close();
			} catch (SQLException ex) {
				ex.getMessage();
			}
		}
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

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				conn.close();
			} catch (SQLException ex) {
				ex.getMessage();
			}
		}

		return liste;

	}

	public Article readById(String id) {

		Article article = null;

		try (PreparedStatement ps = conn
				.prepareStatement("SELECT id,date,title,image,description,content FROM articles" + WHEREID)) {

			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				article = new Article();
				article.setId(rs.getString("id"));
				article.setDate(rs.getString("date"));
				article.setTitle(rs.getString("title"));
				article.setImage(rs.getString("image"));
				article.setDescription(rs.getString("description"));
				article.setContent(rs.getString("content"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				conn.close();
			} catch (SQLException ex) {
				ex.getMessage();
			}
		}

		return article;

	}
}
