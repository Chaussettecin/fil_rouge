package Screen;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;
import serialisation.Serialiser;

public class pauseScreen implements Screen {
	PlayScreen screenBefore;
	
	
	public pauseScreen(PlayScreen before) {
		
		this.screenBefore=before;
	}
	@Override
	public Screen respondToUserInput(KeyEvent key) {
		if(key.getKeyChar()=='s') {
			try{
				new Serialiser(screenBefore);
				return screenBefore;
			}catch(Exception e) {}
			
		}else if(key.getExtendedKeyCode()==KeyEvent.VK_ESCAPE) {
			System.exit (0);
		}else if (key.getExtendedKeyCode()==KeyEvent.VK_ENTER) {
			return screenBefore;
		}
		
		return this;
	}

	@Override
	public void displayOutput(AsciiPanel terminal) {
		terminal.writeCenter("----- PAUSE -----", 3);
		terminal.writeCenter("SAUVEGARDER LA PARTIE EN COURS? s", 6);
		terminal.writeCenter("RETOUR A LA PARTIE? ENTREE", 9);
		terminal.writeCenter("QUITTER? ESC", 12);

	}

}
