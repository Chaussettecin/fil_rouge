package UI;

import java.awt.event.KeyEvent;

import UI.Screen;

import Main.PlayScreen;
import asciiPanel.AsciiPanel;
import Serialization.Serialiser;


/*
 * Comme son nom l'indique Affichage Lose
 */
public class LoseScreen  implements Screen {

	PlayScreen screenBefore;
	
	@Override
	public void displayOutput(AsciiPanel terminal) {
		
		terminal.write("GAME OVER", 1, 1);
		terminal.writeCenter("R.I.P.", 3);
        terminal.writeCenter("-- Entrer pour commencer  --", 22);
		
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
