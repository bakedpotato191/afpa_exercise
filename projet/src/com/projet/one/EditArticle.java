package com.projet.one;

import java.awt.BorderLayout;
import java.io.Serial;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class EditArticle extends JFrame {

	@Serial
	private static final long serialVersionUID = 870166882634383680L;

	private JTextField dateField;
	private JTextField idField;
	private JTextField titleField;
	private JTextField imageField;
	private JTextField descriptionField;
	private JTextArea contentArea;

	public EditArticle(String id, String date, String title, String image, String description, String content) {

		super("Edit");
		this.setSize(600, 600);
		this.setResizable(true);
		this.setLocationRelativeTo(rootPane);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		getContentPane().add(panel(id, date, title, image, description, content), BorderLayout.CENTER);
	}

	private JPanel panel(String id, String date, String title, String image, String description, String content) {

		JPanel panel = new JPanel();
		panel.setLayout(null);

		panel.add(dateLabel());
		panel.add(titleLabel());
		panel.add(imageLabel());
		panel.add(descriptionLabel());
		panel.add(contentLabel());
		panel.add(dateField(date));
		panel.add(titleField(title));
		panel.add(imageField(image));
		panel.add(descriptionField(description));
		panel.add(scrollPane(content));
		panel.add(saveButton());
		panel.add(cancelButton());
		panel.add(idLabel());
		panel.add(idField(id));

		return panel;
	}

	private JLabel dateLabel() {

		JLabel dateLabel = new JLabel("Date");
		dateLabel.setBounds(10, 73, 80, 14);

		return dateLabel;
	}

	private JLabel titleLabel() {

		JLabel titleLabel = new JLabel("Title");
		titleLabel.setBounds(10, 123, 80, 14);

		return titleLabel;
	}

	private JLabel imageLabel() {

		JLabel imageLabel = new JLabel("Image");
		imageLabel.setBounds(10, 173, 80, 14);

		return imageLabel;
	}

	private JLabel descriptionLabel() {

		JLabel descriptionLabel = new JLabel("Description");
		descriptionLabel.setBounds(10, 228, 80, 14);

		return descriptionLabel;
	}

	private JLabel contentLabel() {
		JLabel contentLabel = new JLabel("Content");
		contentLabel.setBounds(10, 285, 80, 14);

		return contentLabel;
	}

	private JTextField dateField(String date) {

		dateField = new JTextField();
		dateField.setBounds(130, 70, 408, 20);
		dateField.setColumns(10);
		dateField.setText(date);

		return dateField;
	}

	private JTextField titleField(String title) {

		titleField = new JTextField();
		titleField.setColumns(10);
		titleField.setBounds(130, 120, 408, 20);
		titleField.setText(title);

		return titleField;
	}

	private JTextField imageField(String image) {

		imageField = new JTextField();
		imageField.setColumns(10);
		imageField.setBounds(130, 170, 408, 20);
		imageField.setText(image);

		return imageField;
	}

	private JTextField descriptionField(String description) {

		descriptionField = new JTextField();
		descriptionField.setHorizontalAlignment(SwingConstants.LEFT);
		descriptionField.setColumns(15);
		descriptionField.setBounds(130, 225, 408, 44);
		descriptionField.setText(description);

		return descriptionField;
	}

	private JScrollPane scrollPane(String content) {

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(130, 280, 408, 195);
		scrollPane.setViewportView(contentArea(content));

		return scrollPane;
	}

	private JTextArea contentArea(String content) {

		contentArea = new JTextArea();
		contentArea.setLineWrap(true);
		contentArea.setText(content);

		return contentArea;
	}

	private JButton saveButton() {

		JButton save = new JButton("Save");
		save.addActionListener(e -> {

			int confirm = JOptionPane.showConfirmDialog(save, "êtes vous sûr de vouloir sauvegarder",
					"Confirmation sauvegarder", JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				Article article = new Article();
				article.setId(idField.getText());
				article.setDate(dateField.getText());
				article.setTitle(titleField.getText());
				article.setImage(imageField.getText());
				article.setDescription(descriptionField.getText());
				article.setContent(contentArea.getText());

				ArticleDAO edit = new ArticleDAO();
				edit.update(article);
			}
		});

		save.setBounds(140, 507, 89, 23);

		return save;
	}

	private JButton cancelButton() {

		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(e -> dispose());
		cancel.setBounds(350, 507, 89, 23);

		return cancel;
	}

	private JLabel idLabel() {

		JLabel id = new JLabel("Id");
		id.setBounds(10, 25, 46, 14);

		return id;
	}

	private JTextField idField(String id) {

		idField = new JTextField();
		idField.setBounds(130, 22, 86, 20);
		idField.setEditable(false);
		idField.setText(id);
		idField.setColumns(10);

		return idField;
	}

}
