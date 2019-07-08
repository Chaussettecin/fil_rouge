package Inventory;

import Perso.Gold;
import Perso.Perso;
import java.util.Map;
import java.util.HashMap;
import Utils.SingleTonRandom;


public class Potion extends Item {
	
/*
 * Class Potion fille de la classe Item
 * ** Add potion qui permet de soigner le perso
 * 			** Restau totale
 * 			** Restau partielle
 */
	private static int 	potionRestau; //potion + 75% sant�
	public static int 	restoUtiliser = 0;
	public static int 	restNiveau;
	public static int 	restPrix;

	private static int 	potionSuvie; //potion + 25% sante
	public static int 	svUtiliser = 0;
	public static int 	svNiveau;
	public static int 	svPrix;


	
//-- Constructor --- 	
	public Potion(Integer id, String nom, Integer prix, String description) {
			 		
		 super(id, ItemType.POTION, nom, prix, description);	
	       
	 }
	   
	


/**
 	* Choose a random potion among the available potions
 	* @return a potion object randomly chosen
*/
	 public static Item generateRandomPotion() {
		
		 int random = SingleTonRandom.getRandom(possiblePotions.size()); 
	    
		 return possiblePotions.get(possiblePotions.keySet().toArray()[random]);
	
	 }
	 
	 
	 private static Map<String,Potion> possiblePotions = new HashMap<String,Potion>();
		
	 	 public void initPossiblePotions() {
		 
			possiblePotions.put("potVie", new Potion(0, "Potion", 15,"une petite fiole remplie d'un "
	                + "liquide rouge translucide. Soigne 20 points de vie."));
			
			possiblePotions.put("potCrit", new Potion(0, "Potion", 30, "une petite forme ovale"
		                + " flacon rempli d'un liquide bleu bouillonnant. Augmente les chances de critique"
		                + "par 10%" ));
			
			possiblePotions.put("potTel", new Potion(0, "Potion", 50, "Potion utilis�e"
	                	+ "t�l�porter au d�but du donjon."));
	 	 }
	 	 
	 	
	 	 
	
	   

/*
 * getPrix
 * Recup prix potion
*/
	 public static int getPrix(String trouver) {
	    
	  		switch (trouver.toLowerCase()) {
	  			case "Survie":
	  				return svPrix;
	  			case "restauration":
	  				return restPrix;
	  			default:
	  				return 0; 
	  		}
	}//recup prix 

	 
	public static void addPotion(int numPotions, Perso perso) {
	        
		 for (int i = 0; i < numPotions; i++) {
			
			 //perso.getInventaire(desc).addItem(potion());
		 }
	 }


/*
 * foundPotion
 */
	 public static int getFoundPotion(String trouver) {
	     
	    switch (trouver.toLowerCase()) {
	    		
	    	case "Survie":
	    			return potionSuvie;
	    		
	    	case "Restauration":
	    			return potionRestau;
	    		
	    	default:
	    			return 0; 
	    }
	} // fin getTrouver


	 public static void setFoundPotion(String trouver,
			 							int montant, 
			 							boolean add) {
	     
		 switch (trouver.toLowerCase()) {
	        
		 	case "survie":
					
				if (!add) {
						potionSuvie = montant;
	            
				} else {
						potionSuvie += montant;
						if (potionSuvie < 0) potionSuvie = 0;
	            
				}
			break;
	        
		 	case "Restauration":
	            
		 		if (!add) {
						potionRestau = montant;
	            
				} else {
						potionRestau += montant;
						if (potionRestau < 0) potionRestau= 0;
					
				}
				break;
		 		default:
						System.out.print("cette potion n'existe pas"  + trouver);
	     
	    	}//fin switch
	  }

	
/*
 * Potion à utiliser 	  
*/
	public static void aUtiliser(String trouver) {
	      
		switch (trouver.toLowerCase()) {
	         
			case "Survie":
	            svUtiliser++;
	         
			case "Restauration":
	        	 restoUtiliser++;
	    }
		
	}//fin aUtiliser()


/*
 * Potion acheter  
*/
	public static void achatPotion(String trouver) {

	    int level = Perso.getLevel();
	    int prix = getPrix(trouver);

	    if (Perso.getLevel() < level) {
	         System.out.println("Tu n'est pas encore prêt pour ça :" 
	        		 			+ level + "pour acheter ça!");
	         
	     } else if (prix <= Gold.get()) {
	    	 
	    	 Gold.set(-prix, true);
	         System.out.println("Merci pour ton achat. A bientôt! ");
	        
	     } else {
	    	 System.out.println("Tu n'as pas assez d'argent et ce n'est pas Noel!");
	         
	     }
	    
	 } // classe Trouver*/

	
//-- GETTER & SETTER	 
	 public String getNom() {
	        return nom;
	}

	 public String getDescription() {
	    return nom;
	}

	 public static int svUtiliser() {
		return potionSuvie;
	}

	public static int getPotionSuvie() {
		return potionSuvie;
	}

	public static void setPotionSuvie(int potionSuvie) {
		Potion.potionSuvie = potionSuvie;
	}

	public static int getPotionRestau() {
		return potionRestau;
	}

	public static void setPotionRestau(int potionRestau) {
		Potion.potionRestau = potionRestau;
	}
	 
	
	    
}
