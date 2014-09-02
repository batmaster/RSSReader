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
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ItemLabel extends JLabel {
	
	private String title;
	private String link;
	private String description;
	private String pubDate;
	private boolean swit = false;
	
	public ItemLabel(String title, String link, String description, String pubDate) {
		this.title = title;
		this.link = link;
		this.description = description;
		this.pubDate = pubDate;
		setContent();
		setVisible(true);
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e))
					try {
						Desktop.getDesktop().browse(new URI(ItemLabel.this.link));
					} catch (IOException | URISyntaxException e1) {
						e1.printStackTrace();
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
			setText(String.format("<html><div style='background:#62C2CC; width:550px; margin:4px; padding:4px'> <h2>%s</h2><br> <i><p>%s</p></i><br> <h3>%s</h3><br> <p>%s</p> </div></html>", title, pubDate, description, link));
		else
			setText(String.format("<html><div style='background:#E4F6F8; width:550px; margin:4px; padding:4px'> <h2>%s</h2><br> <i><p>%s</p></i><br> </div></html>", title, pubDate));
		
	}
	
	private void switchDetail() {
		swit = !swit;
		setContent();
	}
}
