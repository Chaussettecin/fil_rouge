package UI;

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;

/*
 * Interface Screen avec les m�thodes Keyvent et AsciiPanel
 */
public interface Screen {
	
// méthode displayOutput prend AsciiPanel pour s’afficher lui-même et le
//respondToUserInput prend le KeyEvent et retourne le nouvel écran. 
	
	public Screen respondToUserInput(KeyEvent key);
	
	
	
	public void displayOutput(AsciiPanel terminal);

	


}
