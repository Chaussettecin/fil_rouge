package UI;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;
import Serialization.Serialiser;

import Enemy.Enemy;
import Enemy.Cultiste;

import Main.PlayScreen;
import Battle.BattleFight;

/*
 * Screen Intro d'interaction avec un Cultiste 
 */
public class MeetCultScreen implements Screen {

	Cultiste cult;
	BattleFight fight;
	PlayScreen screenBefore;
	
//----   Constructor ----
	public MeetCultScreen(PlayScreen before, int enn) {	
							
		this.screenBefore=before;
		
		cult = PlayScreen.meetCultiste(); 
		
		this.fight = new BattleFight(screenBefore.getPersoArray(),cult);
		
		screenBefore.map.map
		[screenBefore.cultMouv.get(enn).position.dy]
		[screenBefore.cultMouv.get(enn).position.dx]=' ';
		screenBefore.cultMouv.remove(enn);
	
	}
	

/*
 * Attend la reponse du joueur 
 * Entrer pour Ok 
 * S pour Sauvegarger ? 
 */
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
 * Interaction avec un cultistes sur la maps 
 * voir classe PlayScreen 
 * 
 * Screen #1 avant le debut du combat avec un cultiste
 */
	@Override
	public void displayOutput(AsciiPanel terminal) {
		
		terminal.writeCenter("INTERACTION AVEC "+ cult.getNom(), 2);
		terminal.writeCenter("Point de vie : "+ Enemy.getPtv(), 20);
		PlayScreen.meetCultiste();
	
	}


}
