package UI;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;
import Serialization.Serialiser;
import Adventure.Adventure;
import Enemy.Cultiste;
import Maps.PlayScreen;

/*
 * Screen Intro d'interaction 
 */
public class RencontreScreen implements Screen {

	Cultiste cult;
	Adventure fight;
	PlayScreen screenBefore;
	
/*
 * Constructor - 	
 */
	public RencontreScreen(PlayScreen before,int enn ) {	
							
		this.screenBefore=before;
		cult = Adventure.getRandCultiste(); 
		
		this.fight=new Adventure(screenBefore.getPersoArray(),cult);
		
		screenBefore.map.map
		[screenBefore.botOther.get(enn).position.dy]
		[screenBefore.botOther.get(enn).position.dx]=' ';
		screenBefore.botOther.remove(enn);
	
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

/*
 * Interaction avec un perso de la map
 * voir classe PlayScreen 
 */
	@Override
	public void displayOutput(AsciiPanel terminal) {
		
		terminal.writeCenter("INTERACTION AVEC "+cult.getNom(), 1);
		terminal.writeCenter("Point de vie : "+Cultiste.getPtv(), 20);
		Adventure.getRandCultiste();
	}
}
