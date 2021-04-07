package com.projet.swing;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.projet.dao.UserDAO;
import com.projet.model.User;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class Registration extends JFrame {

	private static final long serialVersionUID = -8950325453643220704L;

	private JTextField nomField;
	private JTextField prenomField;
	private JTextField emailField;
	private JPasswordField passwordField;
	private static final String SANSSERIF = "SansSerif";

	public Registration() {

		this.setSize(320, 270);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		setLookAndFeel();
		getContentPane().add(panel(), BorderLayout.CENTER);

	}

	private JPanel panel() {

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.add(nomLabel());
		panel.add(prenomLabel());
		panel.add(emailLabel());
		panel.add(passwordLabel());
		panel.add(nomField());
		panel.add(prenomField());
		panel.add(emailField());
		panel.add(passwordField());
		panel.add(registerButton());

		return panel;
	}

	private JLabel nomLabel() {

		JLabel nom = new JLabel("Nom");
		nom.setFont(new Font(SANSSERIF, Font.PLAIN, 14));
		nom.setBounds(10, 30, 69, 14);

		return nom;
	}

	private JLabel prenomLabel() {

		JLabel prenom = new JLabel("Prenom");
		prenom.setFont(new Font(SANSSERIF, Font.PLAIN, 14));
		prenom.setBounds(10, 70, 69, 14);

		return prenom;
	}

	private JLabel emailLabel() {

		JLabel email = new JLabel("Email");
		email.setFont(new Font(SANSSERIF, Font.PLAIN, 14));
		email.setBounds(10, 110, 69, 14);

		return email;
	}

	private JLabel passwordLabel() {

		JLabel password = new JLabel("Password");
		password.setFont(new Font(SANSSERIF, Font.PLAIN, 14));
		password.setBounds(10, 150, 69, 14);

		return password;
	}

	private JTextField nomField() {

		nomField = new JTextField();
		nomField.setBounds(80, 29, 190, 20);
		nomField.setColumns(10);

		return nomField;
	}

	private JTextField prenomField() {

		prenomField = new JTextField();
		prenomField.setBounds(80, 69, 190, 20);
		prenomField.setColumns(10);

		return prenomField;
	}

	private JTextField emailField() {

		emailField = new JTextField();
		emailField.setBounds(80, 109, 190, 20);
		emailField.setColumns(10);

		return emailField;
	}

	private JPasswordField passwordField() {

		passwordField = new JPasswordField();
		passwordField.setBounds(80, 149, 190, 20);

		return passwordField;
	}

	private JButton registerButton() {

		JButton registerButton = new JButton("Register");

		registerButton.addActionListener(e -> {

			String nom = nomField.getText();
			String prenom = prenomField.getText();
			String email = emailField.getText().toLowerCase();
			String password = String.valueOf(passwordField.getPassword());

			if (nom.equals("") || prenom.equals("") || email.equals("") || password.equals("")) {
				JOptionPane.showMessageDialog(null, "Please fill in all fields");
			} else {

				UserDAO register = new UserDAO();
				String hashedPassword = BCrypt.withDefaults().hashToString(12, password.toCharArray());

				User user = new User();
				user.setNom(nom);
				user.setPrenom(prenom);
				user.setEmail(email);
				user.setPassword(hashedPassword);

				register.create(user);
			}
		});

		registerButton.setFont(new Font(SANSSERIF, Font.PLAIN, 14));
		registerButton.setBounds(110, 195, 89, 23);

		return registerButton;
	}

	private void setLookAndFeel() {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

}
