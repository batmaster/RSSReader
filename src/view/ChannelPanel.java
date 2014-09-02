package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import model.Channel;

public class ChannelPanel extends JPanel {
	
	private String title;
	private String description;
	private String link;
	
	public ChannelPanel(String title, String description, String link) {
		set(title, description, link);
//		setPreferredSize(new Dimension(750, 30));
		initComponents();
		setVisible(true);
	}

	private void initComponents() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	public void set(String title, String description, String link) {
		this.title = title;
		this.description = description;
		this.link = link;
		removeAll();
		this.add(new Label(title));
		this.add(new Label(description));
		this.add(new Label(link));
	}
}
