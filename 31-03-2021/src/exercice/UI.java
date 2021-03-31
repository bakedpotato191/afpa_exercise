package exercice;

import java.awt.BorderLayout;
import java.io.Serial;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class UI extends JFrame {

	private JTextField emailField;
	private JPasswordField passwordField;

	@Serial
	private static final long serialVersionUID = -9186552663722811462L;

	public UI(String title) {
		super(title);
		this.setSize(290, 190);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLookAndFeel();
		this.getContentPane().add(panel(), BorderLayout.CENTER);
	}

	private JPanel panel() {
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel.add(emailLabel());
		panel.add(emailField());
		panel.add(passwordLabel());
		panel.add(passwordField());
		panel.add(connectButton());

		return panel;
	}

	private JTextField emailField() {
		emailField = new JTextField();
		emailField.setBounds(66, 32, 198, 20);
		emailField.setColumns(10);

		return emailField;
	}

	private JLabel emailLabel() {
		JLabel eLabel = new JLabel("Email");
		eLabel.setBounds(10, 35, 46, 14);

		return eLabel;
	}

	private JLabel passwordLabel() {
		JLabel pLabel = new JLabel("Password");
		pLabel.setBounds(10, 77, 46, 14);

		return pLabel;
	}

	private JPasswordField passwordField() {
		passwordField = new JPasswordField();
		passwordField.setBounds(66, 74, 198, 20);

		return passwordField;
	}

	private JButton connectButton() {
		JButton connect = new JButton("Connect");

		connect.addActionListener(e -> {
			String em = emailField.getText();
			String pw = String.valueOf(passwordField.getPassword());

			if (em.equals("") || pw.equals("")) {
				JOptionPane.showMessageDialog(connect, "Veuillez remplir tous les champs");
			} else {
				UserDAO user = new UserDAO();
				User u = new User(em, pw);
				if (user.readEmail(u).isEmpty()) {
					JOptionPane.showMessageDialog(connect, "Login ou mot de passe incorrects");
				} else {
					JOptionPane.showMessageDialog(connect, "Bienvenue");
				}

			}
		});

		connect.setBounds(92, 119, 89, 23);

		return connect;
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
