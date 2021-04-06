package com.projet.one;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class HomePage extends JFrame {

	@Serial
	private static final long serialVersionUID = -9113718066475175162L;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				HomePage frame = new HomePage();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public HomePage() {

		super("Home Page");
		this.setSize(700, 300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		setLookAndFeel();

		getContentPane().add(panel(), BorderLayout.CENTER);
	}

	private JPanel panel() {

		JPanel panel = new JPanel();
		panel.setLayout(null);

		panel.add(scrollPane());
		panel.add(refreshButton());
		panel.add(editButton());
		panel.add(deleteButton());
		panel.add(newButton());
		panel.add(readButton());

		return panel;
	}

	private JButton refreshButton() {

		JButton refreshButton = new JButton("Refresh");
		refreshButton.addActionListener(e -> table.setModel(liste()));

		refreshButton.setBounds(30, 225, 89, 23);

		return refreshButton;
	}

	private JButton editButton() {

		JButton editButton = new JButton("Edit");
		editButton.addActionListener(e -> {

			if (table.getSelectedRow() != -1) {

				String id = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();

				ArticleDAO edit = new ArticleDAO();
				Article article = edit.readById(id);

				EditArticle frame = new EditArticle(id, article.getDate(), article.getTitle(), article.getImage(),
						article.getDescription(), article.getContent());
				frame.setVisible(true);

			} else {
				JOptionPane.showMessageDialog(editButton, "No article selected. Please retry");
			}
		});

		editButton.setBounds(450, 225, 89, 23);

		return editButton;
	}

	private JButton deleteButton() {

		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(e -> {

			if (table.getSelectedRow() != -1) {

				String id = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
				int confirm = JOptionPane.showConfirmDialog(deleteButton, "êtes vous sûr de vouloir supprimer",
						"Confirmation suppression", JOptionPane.YES_NO_OPTION);

				if (confirm == JOptionPane.YES_OPTION) {

					ArticleDAO article = new ArticleDAO();
					article.delete(id);
				}
			}

		});
		deleteButton.setBounds(584, 225, 89, 23);

		return deleteButton;
	}

	private JButton newButton() {

		JButton newButton = new JButton("New");
		newButton.addActionListener(e -> {
			CreateArticle article = new CreateArticle();
			article.setVisible(true);
		});
		newButton.setBounds(310, 225, 89, 23);

		return newButton;
	}

	private JButton readButton() {

		JButton readButton = new JButton("Read");

		readButton.addActionListener(e -> {

			if (table.getSelectedRow() != -1) {
				String id = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();

				ArticleDAO read = new ArticleDAO();
				Article article = read.readById(id);

				ShowArticle frame = new ShowArticle(article.getDate(), article.getTitle(), article.getImage(),
						article.getDescription(), article.getContent());
				frame.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(readButton, "No article selected. Please retry");
			}
		});

		readButton.setBounds(171, 225, 89, 23);

		return readButton;
	}

	private JTable table() {

		table = new JTable();
		table.setModel(liste());

		return table;
	}

	private JScrollPane scrollPane() {

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 700, 200);
		scrollPane.setViewportView(table());

		return scrollPane;
	}

	private DefaultTableModel liste() {

		String[] col = { "Id", "Date", "Title" };
		DefaultTableModel tab = new DefaultTableModel(null, col);
		ArticleDAO article = new ArticleDAO();

		List<Article> listArticle = new ArrayList<>();
		listArticle.addAll(article.read());

		for (Article cli : listArticle) {
			Vector<String> vect = new Vector<>();
			vect.add(cli.getId());
			vect.add(cli.getDate());
			vect.add(cli.getTitle());

			tab.addRow(vect);
		}

		return tab;
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
