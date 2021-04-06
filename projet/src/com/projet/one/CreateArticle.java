package com.projet.one;

import java.awt.BorderLayout;
import java.io.Serial;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CreateArticle extends JFrame {

	@Serial
	private static final long serialVersionUID = 870166882634383680L;

	private JTextField dateField;
	private JTextField titleField;
	private JTextField imageField;
	private JTextField descriptionField;
	private JTextArea contentArea;

	public CreateArticle() {

		super();
		this.setName("Create");
		this.setSize(600, 600);
		this.setResizable(true);
		this.setLocationRelativeTo(rootPane);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		getContentPane().add(panel(), BorderLayout.CENTER);
	}

	private JPanel panel() {

		JPanel panel = new JPanel();
		panel.setLayout(null);

		panel.add(dateLabel());
		panel.add(titleLabel());
		panel.add(imageLabel());
		panel.add(descriptionLabel());
		panel.add(contentLabel());
		panel.add(dateField());
		panel.add(titleField());
		panel.add(imageField());
		panel.add(descriptionField());
		panel.add(contentArea());
		panel.add(createButton());
		panel.add(cancelButton());

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

	private JTextField dateField() {

		dateField = new JTextField();
		dateField.setBounds(130, 70, 408, 20);
		dateField.setColumns(10);

		return dateField;
	}

	private JTextField titleField() {

		titleField = new JTextField();
		titleField.setColumns(10);
		titleField.setBounds(130, 120, 408, 20);

		return titleField;
	}

	private JTextField imageField() {

		imageField = new JTextField();
		imageField.setColumns(10);
		imageField.setBounds(130, 170, 408, 20);

		return imageField;
	}

	private JTextField descriptionField() {

		descriptionField = new JTextField();
		descriptionField.setColumns(10);
		descriptionField.setBounds(130, 225, 408, 20);

		return descriptionField;
	}

	private JTextArea contentArea() {

		contentArea = new JTextArea();
		contentArea.setBounds(130, 280, 408, 195);

		return contentArea;
	}

	private JButton createButton() {

		JButton createButton = new JButton("Create");
		createButton.addActionListener(e -> {

			String date = dateField.getText();
			String title = titleField.getText();
			String image = imageField.getText();
			String description = descriptionField.getText();
			String content = contentArea.getText();

			if (date.equals("") || title.equals("") || image.equals("") || description.equals("")
					|| content.equals("")) {
				JOptionPane.showMessageDialog(createButton, "Please fill all the fields");
			} else {

				int confirm = JOptionPane.showConfirmDialog(createButton, "êtes vous sûr de vouloir sauvegarder",
						"Confirmation sauvegarder", JOptionPane.YES_NO_OPTION);

				if (confirm == JOptionPane.YES_OPTION) {

					Article article = new Article();
					article.setDate(dateField.getText());
					article.setTitle(titleField.getText());
					article.setImage(imageField.getText());
					article.setDescription(descriptionField.getText());
					article.setContent(contentArea.getText());

					ArticleDAO a = new ArticleDAO();
					a.create(article);
				}
			}
		});

		createButton.setBounds(140, 507, 89, 23);

		return createButton;
	}

	private JButton cancelButton() {

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(e -> dispose());
		cancelButton.setBounds(350, 507, 89, 23);

		return cancelButton;
	}

}