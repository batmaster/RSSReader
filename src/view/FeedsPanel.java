package view;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import model.Item;

/**
 * A panel contains list of ItemLabels.
 * 
 * @author Poramate Homprakob 5510546077
 *
 */
public class FeedsPanel extends JPanel {

	/**
	 * Constructor.
	 */
	public FeedsPanel() {
		setBounds(new Rectangle(50, 50));
		initComponents();
		setVisible(true);
	}

	private void initComponents() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	/**
	 * Add a item to be shown in the list.
	 * @param item Item object
	 */
	public void addItem(Item item) {
		add(new ItemLabel(item.getTitle(), item.getLink(), item.getDescription(), item.getPubDate(), item.getEnclosure()));
	}
	
	/**
	 * Remove all items in the list.
	 */
	public void clear() {
		removeAll();
	}
}
