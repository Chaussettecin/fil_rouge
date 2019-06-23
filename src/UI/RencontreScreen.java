package UI;

import java.awt.event.KeyEvent;

import Enemy.Enemy;
import asciiPanel.AsciiPanel;
import Serialization.Serialiser;


/*
 * Screen interaction 
 */

public class RencontreScreen implements Screen {
	
	PlayScreen screenBefore;
	
	public RencontreScreen(PlayScreen before,int enn) {
		
		this.screenBefore=before;
		screenBefore.map.map[screenBefore.bot.get(enn).position.dy][screenBefore.bot.get(enn).position.dx]=' ';;
		screenBefore.bot.remove(enn);
	
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

//--Interaction avec un perso de la map ...  
	//voir classe PlayScreen 

	@Override
	public void displayOutput(AsciiPanel terminal) {
		terminal.writeCenter("INTERACTION AVEC ", 14);
		terminal.writeCenter("Vous avez rencontrer, Que voulez vous faire", 5);
		
	
	}

}
