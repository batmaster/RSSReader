package view;

import java.awt.Label;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ItemLabel extends JLabel {
	
	public ItemLabel(String title, String link, String description, String pubDate) {
		setText("<html>" +
	"<h2>" + title + "</h2><br>" +
	"<h4>" + pubDate + "</h4><br>" +
	"<h3>" + description + "</h3><br>" +
	"<h5>" + link + "</h5>" +
	"</html>");

		setVisible(true);
	}
}
