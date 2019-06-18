package UI;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;
import Serialization.Serialiser;

public class rencontreScreen implements Screen {
	
	PlayScreen screenBefore;
	
	public rencontreScreen(PlayScreen before, int ennemie) {
		
		this.screenBefore=before;
		screenBefore.map.map[screenBefore.bot.get(ennemie).position.dy][screenBefore.bot.get(ennemie).position.dx]=' ';;
		screenBefore.bot.remove(ennemie);
	
	}
	
	
	@Override
	public Screen respondToUserInput(KeyEvent key) {
		if(key.getKeyCode()==KeyEvent.VK_ENTER) {
			
			return screenBefore;
		}else if (key.getKeyChar()=='s') {
			new Serialiser(screenBefore,"testSav.json");
		}	
		return this;
	}

	@Override
	public void displayOutput(AsciiPanel terminal) {
		terminal.writeCenter("INTERACTION AVEC ", 14);
		//terminal.writeCenter("La sauvegarde ------- s ------" , 18);

	}

}
