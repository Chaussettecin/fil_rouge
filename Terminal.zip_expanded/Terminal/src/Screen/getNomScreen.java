package Screen;

import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import asciiPanel.AsciiPanel;

public class getNomScreen implements Screen {
	private String nom="";
	
	
		

	
	
	public Screen respondToUserInput(KeyEvent key) {
		if(nom.length()<10) {
			char c = key.getKeyChar();
			if(Character.isLetter(c)) {
				nom+=c;
			}
		}
		
		switch(key.getKeyCode()) {
			case KeyEvent.VK_ENTER :
				return new PlayScreen(nom);
				
			case KeyEvent.VK_BACK_SPACE:
				nom="";
				break;
			case KeyEvent.VK_ESCAPE:
				return new StartScreen();
		}
		return this;
	}

	@Override
	public void displayOutput(AsciiPanel terminal) {
		terminal.writeCenter("Entrer votre nom", 3);
		terminal.writeCenter("Joueur : "+nom, 6);
		terminal.writeCenter("Appuyer sur ENTREE pour commencer", 9);
		
	}

}
