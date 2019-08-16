package UI;

import java.awt.event.KeyEvent;

import Perso.Perso;
import Main.PlayScreen;
import Inventory.Potion;
import asciiPanel.AsciiPanel;
import Serialization.Serialiser;

/*
 * Affichage de consommation des potions
 */
public class PotionScreen implements Screen {
	
	Perso perso;
	String potionUse;
	static Potion potion;
	static PlayScreen screenBefore;

//--- Constructor
	public static void usePotion(PlayScreen before, int po) {
	     
		 
	}
		  
/*
 * Reponse de l'utilisateur - 
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
 * Affichage du interface d'interaction d'une potion - 
 */	 
	@Override
	public void displayOutput(AsciiPanel terminal) {

		terminal.writeCenter("Potion ", 1);
		
		if (potion.getNom() != null) {
			
			terminal.writeCenter("Tu n'as pas" + potionUse + " potions!", 2);
			terminal.writeCenter("Va faire un tour dans la boutique pou en avoir plus !", 3);
		
		 } else if (Perso.getPtv() == Perso.getPtv()) {
		
			 terminal.writeCenter("Tu es déjà en pleine forme ! Tu n'est pas un chat", 4);
			 terminal.writeCenter("Donc tu n'as pas besoin d'utiliser :" + potionUse + "potion!", 5);
			 terminal.writeCenter("Ta santé actuelle :  " + Perso.getPtv(), 6);	
		    	
		 } else {
		    
		      int soin = 0;
		        
		      terminal.writeCenter("Tu viens de consommer:" + potion.getNom() + "potion.", 4);
		      terminal.writeCenter("Te voilà en pleine forme avec:" + soin + " sante.", 5);
		      terminal.writeCenter("Ta santé actuelle :  " + Perso.getPtv(), 6);
		      terminal.writeCenter(potionUse + " Potions: " + potion.getNom(),7);

		 }

	}
}

