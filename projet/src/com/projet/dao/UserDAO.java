package com.projet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.projet.datasource.DataSource;
import com.projet.model.User;

import at.favre.lib.crypto.bcrypt.BCrypt;
import at.favre.lib.crypto.bcrypt.BCrypt.Result;

public class UserDAO implements IDAO<User> {

	Connection conn = DataSource.getConnection();

	public void create(User object) {

		try (PreparedStatement ps = conn
				.prepareStatement("INSERT INTO users (nom, prenom, email, password) VALUES (?,?,?,?)")) {

			ps.setString(1, object.getNom());
			ps.setString(2, object.getPrenom());
			ps.setString(3, object.getEmail());
			ps.setString(4, object.getPassword());

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

	public boolean userExists(String email, String password) {

		boolean exists = false;

		try (PreparedStatement ps = conn.prepareStatement("SELECT password from users" + " WHERE email=?")) {

			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Result result = BCrypt.verifyer().verify(password.toCharArray(), rs.getString("password"));
				exists = result.verified;
			}

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

		return exists;
	}

}
