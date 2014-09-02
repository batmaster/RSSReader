package view;

import java.awt.Desktop;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import model.Enclosure;

/**
 * Item label that will be shown in a list of FeedsPanel.
 * 
 * @author Poramate Homprakob 5510546077
 *
 */
public class ItemLabel extends JLabel {
	
	private String title;
	private String link;
	private String description;
	private String pubDate;
	private Enclosure enclosure;
	private boolean swit = false;
	
	private static String enc = "<img src='http://png-3.findicons.com/files/icons/1580/devine_icons_part_2/128/windows_media_player.png' height='32' width='32'>";
	
	/**
	 * Constructor requiring all attribute date in Item object.
	 * @param title title of item
	 * @param link link of item
	 * @param description description of item
	 * @param pubDate publish date of item
	 * @param enclosure enclosure in item
	 */
	public ItemLabel(String title, String link, String description, String pubDate, Enclosure enclosure) {
		this.title = title;
		this.link = link;
		this.description = description;
		this.pubDate = pubDate;
		this.enclosure = enclosure;
		setContent();
		setVisible(true);
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e))
					try {
						Desktop.getDesktop().browse(new URI(ItemLabel.this.link));
					} catch (IOException | URISyntaxException e1) {
						JOptionPane.showMessageDialog(ItemLabel.this, e1.getMessage(), "Something happened", JOptionPane.WARNING_MESSAGE);
					}
				else
					ItemLabel.this.switchDetail();
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
	
	private void setContent() {
		if (swit)
			setText(String.format("<html><div style='background:#62C2CC; width:550px; margin:4px; padding:4px'> <h2>%s</h2><br> <i><p>%s</p></i><br> <h3>%s</h3><br> <p>%s</p> </div></html>", title, pubDate, (enclosure == null ? "" : "<a href='" + enclosure.getUrl() + "'>" + enc + "</a> ") + description, link));
		else
			setText(String.format("<html><div style='background:#E4F6F8; width:550px; margin:4px; padding:4px'> <h2>%s</h2><br> <i><p>%s</p></i><br> </div></html>", title, pubDate));
	}
	
	private void switchDetail() {
		swit = !swit;
		setContent();
	}
}
