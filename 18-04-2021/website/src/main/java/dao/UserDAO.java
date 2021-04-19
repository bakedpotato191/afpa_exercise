package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.security.crypto.bcrypt.BCrypt;

import bean.User;
import datasource.DataSource;

public class UserDAO implements IDAO<User> {

	@Override
	public boolean create(User object) {

		boolean created = false;

		try (Connection conn = DataSource.getConnection();
				PreparedStatement ps = conn
						.prepareStatement("INSERT INTO users (nom, prenom, email, password) VALUES (?,?,?,?)")) {

			ps.setString(1, object.getNom());
			ps.setString(2, object.getPrenom());
			ps.setString(3, object.getEmail());
			ps.setString(4, object.getPassword());

			ps.executeUpdate();
			created = true;

		} catch (SQLException ex) {
			ex.getMessage();
		}

		return created;

	}

	public User login(String email, String password) {

		try (Connection conn = DataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM users" + " WHERE email=?")) {

			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			if (rs.next() && BCrypt.checkpw(password, rs.getString("password"))) {
				return new User(rs.getString("nom"), rs.getString("prenom"), rs.getString("email"),
						rs.getString("password"));
			}

		} catch (SQLException ex) {
			ex.getMessage();
		}

		return null;
	}

}
