package com.projet.swing;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serial;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.DefaultEditorKit;

import com.projet.dao.UserDAO;

public class Login extends JFrame {

	@Serial
	private static final long serialVersionUID = 3974485002841632213L;

	private static final String SANSSERIF = "SansSerif";
	private JTextField emailField;
	private JPasswordField passwordField;

	public Login() {

		super("Sign-In");
		this.setSize(330, 300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLookAndFeel();
		getContentPane().add(panel(), BorderLayout.CENTER);
		this.setJMenuBar(menuBar());

	}

	private JPanel panel() {

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.add(emailLabel());
		panel.add(passwordLabel());
		panel.add(passwordField());
		panel.add(emailField());
		panel.add(separator());
		panel.add(registerLabel());
		panel.add(connectButton());

		return panel;
	}

	private JPasswordField passwordField() {

		passwordField = new JPasswordField();
		passwordField.setBounds(84, 111, 210, 25);

		return passwordField;
	}

	private JLabel passwordLabel() {

		JLabel pl = new JLabel("Password");
		pl.setBounds(10, 112, 64, 19);
		pl.setFont(new Font(SANSSERIF, Font.PLAIN, 14));

		return pl;
	}

	private JLabel emailLabel() {

		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(10, 51, 56, 19);
		emailLabel.setFont(new Font(SANSSERIF, Font.PLAIN, 14));

		return emailLabel;
	}

	private JTextField emailField() {

		emailField = new JTextField();
		emailField.setBounds(84, 50, 210, 25);
		emailField.setColumns(10);

		return emailField;
	}

	private JButton connectButton() {

		JButton connectButton = new JButton("Sign-In");
		connectButton.setBounds(114, 156, 80, 27);
		connectButton.setFont(new Font(SANSSERIF, Font.PLAIN, 14));
		connectButton.setHorizontalAlignment(SwingConstants.LEADING);

		connectButton.addActionListener(e -> {

			String emailText = emailField.getText().toLowerCase();
			String password = String.valueOf(passwordField.getPassword());

			if (emailText.equals("") || password.equals("")) {
				JOptionPane.showMessageDialog(null, "Email or Password field is empty");
			} else {

				UserDAO connection = new UserDAO();

				if (connection.userExists(emailText, password)) {
					dispose();
					HomePage home = new HomePage();
					home.setVisible(true);

				} else {
					JOptionPane.showMessageDialog(null, "Incorrect email or password");
				}
			}
		});

		return connectButton;
	}

	private JSeparator separator() {

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 194, 297, 2);

		return separator;
	}

	private JLabel registerLabel() {

		JLabel registerLabel = new JLabel("Create account");
		registerLabel.setBounds(109, 209, 96, 18);
		registerLabel.setFont(new Font(SANSSERIF, Font.PLAIN, 13));
		registerLabel.setForeground(UIManager.getColor("textHighlight"));
		registerLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Registration reg = new Registration();
				reg.setVisible(true);
			}
		});

		return registerLabel;
	}

	private JMenuBar menuBar() {

		JMenuBar mB = new JMenuBar();
		mB.add(editMenu());
		mB.add(aboutMenu());

		return mB;
	}

	private JMenu editMenu() {

		JMenu edit = new JMenu("Edit");
		edit.add(copy());
		edit.add(paste());
		edit.add(cut());

		return edit;
	}

	private Action copy() {

		Action copyAction = new DefaultEditorKit.CopyAction();
		copyAction.putValue(Action.NAME, "Copy");

		return copyAction;
	}

	private Action paste() {

		Action pasteAction = new DefaultEditorKit.PasteAction();
		pasteAction.putValue(Action.NAME, "Paste");

		return pasteAction;
	}

	private Action cut() {

		Action cutAction = new DefaultEditorKit.CutAction();
		cutAction.putValue(Action.NAME, "Cut");

		return cutAction;
	}

	private JMenu aboutMenu() {

		JMenu about = new JMenu("Help");

		about.add(helpMenuItem());
		about.add(aboutMenuItem());

		return about;

	}

	private JMenuItem helpMenuItem() {

		return new JMenuItem("Help");
	}

	private JMenuItem aboutMenuItem() {

		return new JMenuItem("About");
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
