package UI;

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;

/*
 * Interface Screen avec les m�thodes Keyvent et AsciiPanel
 */
public interface Screen {
	
	public Screen respondToUserInput(KeyEvent key);
	
	public void displayOutput(AsciiPanel terminal);

}
