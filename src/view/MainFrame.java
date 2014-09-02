package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.xml.bind.JAXBException;

import controller.RssReader;
import model.Channel;
import model.Item;
import model.Rss;

public class MainFrame extends JFrame {
	
	private JPanel topPanel;
	private JTextField urlTextField;
	private JButton fetchButton;
	private ChannelPanel channelPanel;
	private FeedsPanel feedPanel;
	
	public MainFrame() {
		super("RSS Reader");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(750, 670));
		setResizable(false);
		
		initComponents();
		pack();
		setVisible(true);
	}

	private void initComponents() {
		setLayout(new FlowLayout());
		
		topPanel = new JPanel(new FlowLayout());
		
		urlTextField = new JTextField(50);
		urlTextField.setText("http://feeds.bbci.co.uk/news/education/rss.xml");
		urlTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) { }
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					fetch();
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) { }
		});
		topPanel.add(urlTextField);
		
		fetchButton = new JButton("Fetch");
		fetchButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				fetch();
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
		topPanel.add(fetchButton);
		
		add(topPanel);
		
		channelPanel= new ChannelPanel("Title", "description", "link");
		channelPanel.setPreferredSize(new Dimension(750, 60));
		add(channelPanel);
		
		feedPanel = new FeedsPanel();
		JScrollPane scrollPane = new JScrollPane(feedPanel);
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Feeds"));
		scrollPane.setPreferredSize(new Dimension(750, 500));
		add(scrollPane);
		
		JLabel footer = new JLabel("Right-click to open in browser.");
		add(footer);
	}

	private void fetch() {
		Rss rss;
		try {
			rss = RssReader.getInstance().getRss(new URL(urlTextField.getText()));
			Channel channel = rss.getChannel();
			channelPanel.set(channel.getTitle(), channel.getDescription(), channel.getLink());
			feedPanel.clear();
			
			List<Item> items = channel.getItems();
			for (Item item : items)  {
				feedPanel.addItem(item);
			}
			revalidate();
			repaint();
			
		} catch (MalformedURLException | JAXBException e) {
			e.printStackTrace();
		}
	}
}
