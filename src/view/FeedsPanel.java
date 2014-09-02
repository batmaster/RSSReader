package view;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import model.Item;

public class FeedsPanel extends JPanel {

	public FeedsPanel() {
		setBounds(new Rectangle(50, 50));
		initComponents();
		setVisible(true);
	}

	private void initComponents() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	public void addItem(Item item) {
		add(new ItemLabel(item.getTitle(), item.getLink(), item.getDescription(), item.getPubDate()));
	}
	
	public void clear() {
		removeAll();
	}
}
