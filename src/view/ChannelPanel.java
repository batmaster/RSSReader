package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Channel;

public class ChannelPanel extends JPanel {
	
	private String title;
	private String description;
	private String link;
	
	public ChannelPanel(String title, String description, String link) {
		set("Please input RSS link.", "", "");
		initComponents();
		setVisible(true);
	}

	private void initComponents() {
		setLayout(new FlowLayout());
		setBorder(BorderFactory.createEmptyBorder());
	}
	
	public void set(String title, String description, String link) {
		this.title = title;
		this.description = description;
		this.link = link;
		removeAll();
		JLabel titleLabel = new JLabel(title);
		titleLabel.setPreferredSize(new Dimension(750, 12));
		this.add(titleLabel);
		
		JLabel descriptionLabel = new JLabel(description);
		descriptionLabel.setPreferredSize(new Dimension(750, 12));
		this.add(descriptionLabel);
		
		JLabel linkLabel = new JLabel(link);
		linkLabel.setPreferredSize(new Dimension(750, 12));
		this.add(linkLabel);
	}
}
