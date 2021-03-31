package exercice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IDAO<User> {

	Connection conn = Connect.getConnection();
	PreparedStatement ps;

	@Override
	public List<User> readEmail(String email) {
		List<User> liste = new ArrayList<>();

		try {
			ps = conn.prepareStatement("SELECT * FROM user WHERE email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setEmail(rs.getString("email"));
				liste.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException ex) {
				ex.getMessage();
			}
		}

		return liste;
	}

}
