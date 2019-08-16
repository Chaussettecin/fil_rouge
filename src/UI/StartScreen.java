package UI;

import java.awt.event.KeyEvent;


import asciiPanel.AsciiPanel;

/*
 * Screen n 1 = Lancement du jeu --
 * Ecran de du commencement
 * qui affiche des informations et nous met en mode "play" 
 * lorsque l'utilisateur appuie sur ENTRER.
 */

public class StartScreen implements Screen {

	
/*
 * --- Display number 1 -
 */
	@Override
	public void displayOutput(AsciiPanel terminal) {
		
		terminal.writeCenter("Bienvenue",10);
		terminal.writeCenter("Nouvelle partie",15);
		terminal.writeCenter("Charger une nouvelle partie, appuyer sur L",19);	
	}
	

/*
 * --- Méthode clavier le display 	
 */
	@Override
	public Screen respondToUserInput(KeyEvent key) {
			
			if (key.getKeyCode() == KeyEvent.VK_ENTER)
				return new GetNomScreen();
			
			else if(key.getKeyCode() == KeyEvent.VK_L) {
				return new SavLoaderScreen();
			}
				
			else
			return this;
		
		
	}

}

