package UI;

import java.awt.event.KeyEvent;

import Inventory.Potion;
import Maps.PlayScreen;
import Perso.Perso;
import Serialization.Serialiser;
import asciiPanel.AsciiPanel;

/*
 * Affichage de consommation des potions
 */
public class PotionScreen implements Screen {
	
	String use;
	static Potion potion;
	Perso perso;
	static PlayScreen screenBefore;
	
	// Display affichage conso Potion
	 
	public static void usePotion(PlayScreen before, int po) {
	     
		 screenBefore=before;
	
		//this.=new Adventure(screenBefore.getPersoArray(),npc);
		
		screenBefore.map.map
		[screenBefore.botOther.get(po).position.dy]
		[screenBefore.botOther.get(po).position.dx]=' ';
		screenBefore.botOther.remove(po);
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
 * Affichage du interface d'interaction d'une potion - 
 */	 
	@Override
	public void displayOutput(AsciiPanel terminal) {

		terminal.writeCenter("Potion ", 1);
		//if (potion.getNom() != null) {
		terminal.writeCenter("Tu n'as pas" + use + " potions!", 2);
		terminal.writeCenter("Va faire un tour dans la boutique pou en avoir plus !", 3);
		
		 //} else if (perso.getPtv() == perso.getPtvMin()) {
		
		terminal.writeCenter("Tu es déjà en pleine forme ! Tu n'est pas un chat", 4);
		terminal.writeCenter("Donc tu n'as pas besoin d'utiliser" + use + " potion!", 5);
		terminal.writeCenter("Ta santé actuelle :  " + perso.getPtv(), 6);	
		    	
		    
		// } else {
		    
		        //int soin = 0;
		       
		        /* System.out.println("----------------------------------------------------");
		         System.out.println("Tu viens de consommer : " + potion.getNom() + " potion.");
		         System.out.println("Te voilà en pleine forme avec : " + soin + " sante.	");
		         System.out.println("----------------------------------------------------");
		         System.out.println("Ta santé est de: " + perso.getPtv());
		         System.out.println(use + " Potions: " + potion.getNom());
		         System.out.println("----------------------------------------------------");*/
		        
		     }

	 
}

