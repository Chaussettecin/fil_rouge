package UI;

import java.awt.event.KeyEvent;

import Adventure.Adventure;
import Adventure.Npc;
import Maps.PlayScreen;
import Serialization.Serialiser;
import asciiPanel.AsciiPanel;


/*
 * Screen Intro d'interaction w/ PNJ
 */
public class MeetNpcScreen implements Screen {
	
	Npc npc;
	PlayScreen screenBefore;
	
/*
 * Constructor - 	
 */
	public MeetNpcScreen(PlayScreen before,int np ) {	
								
		this.screenBefore=before;
			
		npc = Adventure.getRandNpc(); 
			
		this.npc=new Npc(screenBefore.getPersoArray(),npc);
			
			screenBefore.map.map
			[screenBefore.botOther.get(np).position.dy]
			[screenBefore.botOther.get(np).position.dx]=' ';
			screenBefore.botOther.remove(np);
		
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

	
	@Override
	public void displayOutput(AsciiPanel terminal) {
		// TODO Auto-generated method stub
		
	}

}
