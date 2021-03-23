package com.bakedpotato.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientDAO implements IDAO<Client> {

	Connection conn = Connect.getConnection();

	@Override
	public void create(Client object) {

		try {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO client" + "(nom, prenom) VALUES (?,?) ");

			ps.setString(1, object.getNom());
			ps.setString(2, object.getPrenom());

			ps.executeUpdate();
			ps.clearParameters();
			ps.close();

			System.out.println("Insertion OK");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
		} finally {
			try {
				conn.close();
				System.out.println("Connection closed");
			} catch (SQLException ex) {
				ex.getMessage();
			}
		}
	}
}
