package UI;

import java.awt.event.KeyEvent;

import Maps.PlayScreen;
import asciiPanel.AsciiPanel;
import Serialization.Serialiser;

/*
 * Screen Pause // le joueur peut faire 
 * pause en appuyant sur le S 
 */
public class PauseScreen implements Screen {
	
	PlayScreen screenBefore;
	
	public PauseScreen(PlayScreen before) {
		this.screenBefore=before;
	}
	
	
	@Override
	public Screen respondToUserInput(KeyEvent key) {
		
		if(key.getKeyChar()=='s') {
			
			try {
				new Serialiser(screenBefore);
				return screenBefore;
			
			} catch(Exception e) {}
			
		} else if(key.getExtendedKeyCode()==KeyEvent.VK_ESCAPE) {
			System.exit (0);
		
		} else if (key.getExtendedKeyCode()==KeyEvent.VK_ENTER) {
			return screenBefore;
		
		}
		
		return this;
	}

/*
 * UI Display interraction - 
 */
	@Override
	public void displayOutput(AsciiPanel terminal) {
		
		terminal.writeCenter("----- PAUSE -----", 3);
		terminal.writeCenter("SAUVEGARDER LA PARTIE EN COURS? s", 6);
		terminal.writeCenter("RETOUR A LA PARTIE? ENTREE", 9);
		terminal.writeCenter("QUITTER? ESC", 12);

	}

}
