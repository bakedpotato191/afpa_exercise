package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import bean.Token;
import bean.User;
import datasource.DataSource;

public class TokenDAO implements IDAO<Token> {

	@Override
	public boolean create(Token object) {

		try (Connection conn = DataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(
						"INSERT INTO tokens (email, token, expiryDate, tokenUsed) VALUES (?,?,?,?)")) {

			ps.setString(1, object.getEmail());
			ps.setString(2, object.getToken());
			ps.setTimestamp(3, object.getExpirationDate());
			ps.setBoolean(4, object.isTokenUsed());

			ps.executeUpdate();

		} catch (SQLException ex) {
			ex.getMessage();
		}
		return false;

	}

	public User isValid(String token) {

		try (Connection conn = DataSource.getConnection();
				PreparedStatement ps = conn
						.prepareStatement("SELECT * FROM tokens WHERE token=?")) {

			ps.setString(1, token);

			ResultSet rs = ps.executeQuery();

			if (rs.next() && (new Timestamp(System.currentTimeMillis())
					.before(rs.getTimestamp("expiryDate")) && !rs.getBoolean("tokenUsed"))) {

				User user = new User();
				user.setEmail(rs.getString("email"));

				return user;
			}

		} catch (SQLException ex) {
			ex.getMessage();
		}
		return null;

	}

	public void invalidate(String token) {

		try (Connection conn = DataSource.getConnection();
				PreparedStatement ps = conn
						.prepareStatement("UPDATE tokens SET tokenUsed=true WHERE token=?")) {

			ps.setString(1, token);
			ps.executeUpdate();

		} catch (SQLException ex) {
			ex.getMessage();
		}
	}
}
