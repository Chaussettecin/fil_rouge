package UI;

import java.awt.event.KeyEvent;

import Main.PlayScreen;
import Serialization.Serialiser;
import asciiPanel.AsciiPanel;

/*
 * Comme son nom l'indique Affichage Win
 */
public class WinScreen  implements Screen{
	
	PlayScreen screenBefore;
	

	@Override
	public void displayOutput(AsciiPanel terminal) {

		terminal.write("Tu as gagné.", 1, 1);
        terminal.writeCenter("-- [Entrer] pour recommencer--", 22);
	}
	
	
	@Override
	public Screen respondToUserInput(KeyEvent key) {
		
		if(key.getKeyCode()==KeyEvent.VK_ENTER) {
			return screenBefore;
		
		} else if (key.getKeyChar()=='s') {
			
			new Serialiser(screenBefore,"testSav.json");
		
		}
		
		return this;
	}

}
