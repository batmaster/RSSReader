package view;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * A panel showing channel description.
 * 
 * @author Poramate Homprakob 5510546077
 *
 */
public class ChannelPanel extends JPanel {
	
	private String title;
	private String description;
	private String link;
	
	/**
	 * Constructor requiring all attribute date in Channel object.
	 * @param title title of the channel
	 * @param description description of the channel
	 * @param link link of the channel
	 */
	public ChannelPanel(String title, String description, String link) {
		set("Please input RSS link.", "", "");
		initComponents();
		setVisible(true);
	}

	/**
	 * Initializes components.
	 */
	private void initComponents() {
		setLayout(new FlowLayout(FlowLayout.LEADING, 10, 0));
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e))
					try {
						Desktop.getDesktop().browse(new URI(ChannelPanel.this.link));
					} catch (IOException | URISyntaxException e1) {
						JOptionPane.showMessageDialog(ChannelPanel.this, e1.getMessage(), "Something happened", JOptionPane.WARNING_MESSAGE);
					}
			}
			
			@Override
			public void mousePressed(MouseEvent e) { }
			
			@Override
			public void mouseExited(MouseEvent e) { }
			
			@Override
			public void mouseEntered(MouseEvent e) { }
			
			@Override
			public void mouseClicked(MouseEvent e) { }
		});
	}
	
	/**
	 * Set description information of the channel.
	 * @param title title of the channel
	 * @param description description of the channel
	 * @param link link of the channel
	 */
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
