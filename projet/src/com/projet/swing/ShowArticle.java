package com.projet.swing;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ShowArticle extends JFrame {

	private static final long serialVersionUID = 4156345119854595234L;

	public ShowArticle(String date, String title, String image, String description, String content) {

		super("Article Viewer");
		this.setSize(750, 800);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		setLookAndFeel();

		getContentPane().add(panel(image, description, title, content, date), BorderLayout.CENTER);

	}

	private JPanel panel(String image, String description, String title, String content, String date) {

		JPanel panel = new JPanel();

		panel.setLayout(null);
		panel.add(imageLabel(image));
		panel.add(descriptionLabel(description));
		panel.add(titleLabel(title));
		panel.add(contentArea(content));
		panel.add(dateLabel(date));

		return panel;

	}

	private JLabel imageLabel(String image) {

		BufferedImage img = scaleImage(550, 300, image);
		ImageIcon ii = new ImageIcon(img);

		JLabel imageLabel = new JLabel(ii);
		imageLabel.setBounds(95, 80, 550, 291);

		return imageLabel;
	}

	private JLabel descriptionLabel(String description) {

		JLabel descriptionLabel = new JLabel(description);
		descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		descriptionLabel.setVerticalAlignment(SwingConstants.TOP);
		descriptionLabel.setBounds(95, 382, 550, 41);

		return descriptionLabel;
	}

	private JLabel titleLabel(String title) {

		JLabel titleLabel = new JLabel(title);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		titleLabel.setBounds(30, 26, 694, 43);

		return titleLabel;
	}

	private JTextArea contentArea(String content) {

		JTextArea contentArea = new JTextArea(content);
		contentArea.setLineWrap(true);
		contentArea.setEditable(false);
		contentArea.setOpaque(false);
		contentArea.setBounds(30, 434, 694, 291);

		return contentArea;
	}

	private JLabel dateLabel(String date) {

		JLabel dateLabel = new JLabel(date);
		dateLabel.setHorizontalAlignment(SwingConstants.LEFT);
		dateLabel.setVerticalAlignment(SwingConstants.TOP);
		dateLabel.setBounds(30, 736, 694, 14);

		return dateLabel;
	}

	public BufferedImage scaleImage(int width, int height, String filename) {

		BufferedImage bi = null;

		try {
			ImageIcon ii = new ImageIcon(filename);// path to image
			bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D g2d = bi.createGraphics();
			g2d.addRenderingHints(
					new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
			g2d.drawImage(ii.getImage(), 0, 0, width, height, null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return bi;
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