package UI;

import Inventory.Potion;
import Perso.Perso;

/*
 * Affichage de consommation des potions
 */
public class DisplayPotion {
	
	// Display affichage conso Potion
	 public static void usePotion(Potion potion, Perso perso, String use) {
	     
		 if (potion.getNom() != null) {
		 			
		 	System.out.println("--------------------------------------------------------");
		 	System.out.println("Tu n'as pas " + use + " potions!");
		 	System.out.println("Va faire un tour dans la boutique pou en avoir plus !   ");
		 	System.out.println("--------------------------------------------------------");            
		 		
		 } else if (perso.getPtv() == perso.getPtvMin()) {
		 			
		 		System.out.println("-------------------------------------------------------");
		    	System.out.println("Tu es déjà en pleine forme ! Tu n'est pas un chat");
		    	System.out.println("Donc tu n'as pas besoin d'utiliser " + use + " potion!");
		    	System.out.println("-------------------------------------------------------");
		    	System.out.println("Ta santé actuelle :  " + perso.getPtv());
		    	System.out.println( use + "Potions : " + potion.getNom());

		 } else {
		    
		        int soin = 0;
		       
		         System.out.println("----------------------------------------------------");
		         System.out.println("Tu viens de consommer : " + potion.getNom() + " potion.");
		         System.out.println("Te voilà en pleine forme avec : " + soin + " sante.	");
		         System.out.println("----------------------------------------------------");
		         System.out.println("Ta santé est de: " + perso.getPtv());
		         System.out.println(use + " Potions: " + potion.getNom());
		         System.out.println("----------------------------------------------------");
		        
		     }
		  }//fin */

	 
}

