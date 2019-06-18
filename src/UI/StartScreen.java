package UI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import asciiPanel.AsciiPanel;
import Serialization.Deserialiser;

public class StartScreen implements Screen {

	
	@Override
	public void displayOutput(AsciiPanel terminal) {
		terminal.writeCenter("Bienvenue",10);
		terminal.writeCenter("Pour commencer la partie, appuyer sur entrée",15);
		terminal.writeCenter("Pour charger la dernière partie, appuyer sur L",19);
		
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		
		if (key.getKeyCode() == KeyEvent.VK_ENTER)
			return new getNomScreen();
		
		else if(key.getKeyCode() == KeyEvent.VK_L) {
			return new SavLoaderScreen();
			//return new PlayScreen(new Deserialiser("sav.json").getDonnees());
		}
			
		else
			return this;
		
	}

}
