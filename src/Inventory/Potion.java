package Inventory;

import java.util.HashMap;
import java.util.Map;

import Main.Game;


public class Potion extends Item {
	
//-- ajoute des potion pour soigner les statuts 
//-- ajouter une potion qui donne au perso un 
	//coup de pouce temp (avec + de dégâts)

	public static int 	svUtiliser = 0;
	public static int 	svNiveau;
	public static int 	svPrix;
	public static int 	restoUtiliser = 0;
	public static int 	restNiveau;
	public static int 	restPrix;
	private static int 	potionSuvie; //potion + 25% sante
	private static int 	potionRestau; //potion + 75% santé

	
//-- Constructor --- 
	 public Potion(Integer id, String nom, Integer prix, String description) {
			 		
		 super(id, ItemType.POTION, nom, prix);	
	       
	 }
	   


	 /**
	  * Choose a random potion among the available potions
	  * @return a potion object randomly chosen
	  */
	 public static Item generateRandomPotion() {
	    int random = Game.RAND.nextInt(possiblePotions.size()); 
	    return possiblePotions.get(possiblePotions.keySet().toArray()[random]);
	}
	 
	 private static Map<String,Potion> possiblePotions = new HashMap<String,Potion>();
		
	 	
	 public void initPossiblePotions() {
		 
			possiblePotions.put("potVie", new Potion(0, "Potion", 15,"une petite fiole remplie d'un "
	                + "liquide rouge translucide. Soigne 20 points de vie."));
			
			possiblePotions.put("potCrit", new Potion(0, "Potion", 30, "une petite forme ovale"
		                + " flacon rempli d'un liquide bleu bouillonnant. Augmente les chances de critique"
		                + "par 10%" ));
			
			possiblePotions.put("potTel", new Potion(0, "Potion", 50, "Potion utilisée"
	                	+ "téléporter au début du donjon."));
	 }

	 
	 @Override
	 public String toString() {
	     return id + "Nom Potion: " + nom + ", prix: " + prix + ", restauration Pts de vie: ";
	 }
	   

//-- Recup les Prix des potions -
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

	 
	/* public static void addPotion(int numDePotions, Perso Perso) {
	        
		 for (int i = 0; i < numDePotions; i++) {
			
			 //Perso.getInventaire(desc).addItem(potion());
		 }
	 }*/
/*
//---  objet Trouver 
	 public static int getFoundItem(String trouver) {
	     
	    	switch (trouver.toLowerCase()) {
	    		case "Survie":
	    			return potionSuvie;
	    		case "Restauration":
	    			return potionRestau;
	    		default:
	    			return 0; 
	        }
	 } // fin getTrouver
*/
	 /*
	 public static void setFound(String trouver,int montant, boolean add) {
	     
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
*/
	 /*

//-- potions qui ont été utilsées --
	 public static void aUtiliser(String trouver) {
	      
		switch (trouver.toLowerCase()) {
	         
			case "Survie":
	            svUtiliser++;
	         
			case "Restauration":
	        	 restoUtiliser++;
	    }
		
	}//fin aUtiliser()
*/
//--- achats potions --
	/* public static void achat(String trouver) {

	    int level = getLevel(trouver);
	    int prix = getPrix(trouver);

	    if (perso.getLevel() < level) {
	         System.out.println("Tu n'est pas encore prêt pour ça :" + level + "pour acheter ça!");
	         
	     } else if (prix <= gold.get()) {
	    	 
	    	 gold.set(-prix, true);
	         Statistics.totalGoldepenserprSante += prix;
	         setFound(trouver, 1, true);
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

	 public static void svUtiliser() {
		return;
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
