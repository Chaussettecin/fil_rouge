package UI;

import java.awt.event.KeyEvent;

import Main.PlayScreen;
import asciiPanel.AsciiPanel;

/*
 * ScreenPlay 2 
 * Demande au joueur son nom
 */

public class GetNomScreen implements Screen {
	
	private String nomJ="";

	public Screen respondToUserInput(KeyEvent key) {
		
		if(nomJ.length()<10) {
			
			char c = key.getKeyChar();
			
			if(Character.isLetter(c)) {
				nomJ+=c;
			}
		
		}
		
		switch(key.getKeyCode()) {
			
			case KeyEvent.VK_ENTER :
					return new PlayScreen(nomJ);
				
			case KeyEvent.VK_BACK_SPACE:
					nomJ="";
					break;
			
			case KeyEvent.VK_ESCAPE:
					return new StartScreen();
		}
		return this;
	}

	@Override
	public void displayOutput(AsciiPanel terminal) {
		
		terminal.writeCenter("Entrer votre nom", 3);
		terminal.writeCenter("Joueur : "+ nomJ, 6);
		terminal.writeCenter("Appuyer sur ENTREE pour commencer", 9);
		
	}

}
