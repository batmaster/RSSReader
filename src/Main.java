import controller.RssReaderController;
import view.MainFrame;

/**
 * First run class of application.
 * 
 * @author Poramate Homprakob 5510546077
 *
 */
public class Main {
	
	public static void main(String[] args) {
		MainFrame main = new MainFrame(RssReaderController.getInstance());
	}
}
