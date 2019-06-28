package UI;

import java.awt.event.KeyEvent;

import Adventure.Npc;
import Maps.PlayScreen;
import Serialization.Serialiser;
import Adventure.Adventure;
import asciiPanel.AsciiPanel;

public class NpcScreen implements Screen {

	static Npc npc;
	Adventure npcList;
	static PlayScreen screenBefore; //-- 
	
	public static void NPC(PlayScreen before, int np) {
		
		screenBefore=before;
		npc = Adventure.getRandNpc();
		
		//this.=new Adventure(screenBefore.getPersoArray(),npc);
	
		screenBefore.map.map
		[screenBefore.botOther.get(np).position.dy]
		[screenBefore.botOther.get(np).position.dx]=' ';
		screenBefore.botOther.remove(np);
		
	}
	

/*
 * Reponse de l'utilisateur -- 
 */
	@Override
	public Screen respondToUserInput(KeyEvent key) {
		
		if(key.getKeyCode()==KeyEvent.VK_ENTER) {
			return screenBefore;
		
		} else if (key.getKeyChar()=='s') {
			//-- S -- Sauvegarde 
			new Serialiser(screenBefore,"testSav.json");
		}
		
		return this;
	}

	
/*
 * Affichage du interface d'interaction avec un NPC - 
*/	
	@Override
	public void displayOutput(AsciiPanel terminal) {
		
		terminal.writeCenter("Voici le Npc  "+ npc.getNamNpc(), 1);
		terminal.writeCenter("Que veux tu faire : ", 2);
		terminal.writeCenter("Recupérer une quête ? ", 3);
		terminal.writeCenter("Ignorer ", 4);
		
	}
	
	 
}
