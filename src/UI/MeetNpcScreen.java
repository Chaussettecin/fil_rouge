package UI;

import java.awt.event.KeyEvent;

import Npc.Npc;
import Main.PlayScreen;


import asciiPanel.AsciiPanel;
import Serialization.Serialiser;


/*
 * Screen Intro d'interaction w/ PNJ
 */
public class MeetNpcScreen implements Screen {
	
	Npc pnj;
	PlayScreen screenBefore;
	

//--- Constructor - 	
	public MeetNpcScreen(PlayScreen before,int np ) {	
								
		this.screenBefore=before;
			
		pnj = PlayScreen.meetNpc(); 
	
		screenBefore.map.map
		[screenBefore.npcMouv.get(np).position.dy]
		[screenBefore.npcMouv.get(np).position.dx]=' ';
		
		screenBefore.npcMouv.remove(np);
		
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
 * Interaction avec un PNJ -
 * voir classe PlayScreen 
 */
	@Override
	public void displayOutput(AsciiPanel terminal) {
		
		terminal.writeCenter("Tu viens de croiser" + pnj.getNamNpc(), 1);
		terminal.writeCenter("Que veux tu faire: ", 2);
		terminal.writeCenter("Recupérer une quête? ", 3);
		terminal.writeCenter("Ignorer", 4);
		PlayScreen.meetNpc();
		
	}

}
