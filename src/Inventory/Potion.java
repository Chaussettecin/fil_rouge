package Inventory;

import Perso.Gold;
import Perso.Perso;
import java.util.Map;

import Battle.Effect;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import Utils.SingleTonRandom;
import asciiPanel.AsciiPanel;


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

	Map map;
	
	private Map<String, Color> potionColors;
	private List<String> potionAppearances;
	
	
// --- Constructor -- 		
	public Potion(Integer id, String nom, Integer prix, String description, Map map) {
			 		
		 super(id, ItemType.POTION, nom, prix, color, description);	
	     
		 this.map = map;
		
		 setUpPotionAppearances();
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
	                + "liquide rouge translucide. Soigne 20 points de vie.", map));
			
			possiblePotions.put("potCrit", new Potion(0, "Potion", 30, "une petite forme ovale"
		                + " flacon rempli d'un liquide bleu bouillonnant. Augmente les chances de critique"
		                + "par 10%", map ));
			
			possiblePotions.put("potTel", new Potion(0, "Potion", 50, "Potion utilis�e"
	                	+ "t�l�porter au d�but du donjon.", map));
	 	 }
	 	 
	 	
	 private void setUpPotionAppearances(){
			
		 potionColors = new HashMap<String, Color>();
		 potionColors.put("red potion", AsciiPanel.brightRed);
		 potionColors.put("bleu potion", AsciiPanel.blue);
		 potionColors.put("green potion", AsciiPanel.brightGreen);
			
		 potionAppearances = new ArrayList<String>(potionColors.keySet());
		 Collections.shuffle(potionAppearances);
		
	 }
		
	
	 public Item newPotionDeSante(){
		
		String appearance = potionAppearances.get(0);
		
		final Item item = new Item(0,ItemType.POTION,"", 20, potionColors.get(appearance), "Potion de sante");
				item.setQuaffEffect(new Effect(1){

					public void start(Perso perso){
						
						if (Perso.getPtv() == Perso.setPtv(valeurFood(), desc));
							return;
					}
				}
			);
				
			//world.addAtEmptyLocation(item, depth);
			return item;
	}
			
			
	public Item newPotionDeMana(){
				
		String appearance = potionAppearances.get(1);
		final Item item = new Item(1, ItemType.POTION,"", 50, potionColors.get(appearance), "Potion restau");
				item.setQuaffEffect(new Effect(2){
					
				public void start(Perso perso){
						
					if (perso.mana() == perso.mana())
						return;
						
					perso.modifMana(10);
					//perso.doAction(item, "look restored");
				}
			}
		);
				
		//world.addAtEmptyLocation(item, depth);
		return item;
	}
		
		  
	public Item randomPotion(){
				
		switch ((int)(Math.random() * 9)){
				
			 	case 0: return newPotionDeMana();
				case 1: return newPotionDeSante();
				
		}
			 
		return newPotionDeSante();
	}

	
	   
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

	 
	/*public static void addPotion(int numPotions, Perso perso) {
	        
		 for (int i = 0; i < numPotions; i++) {
			
			 perso.getInventaire(desc).addItem(potion());
		 }
	 }*/


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


	 public static void setFoundPotion(String trouver,int montant, boolean add) {
			 							 
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
	 public String getNom() { return nom;}

	public String getDescription() { return nom;}

	public static int svUtiliser() { return potionSuvie; }

	public static int getPotionSuvie() { return potionSuvie; }

	public static void setPotionSuvie(int potionSuvie) {
		Potion.potionSuvie = potionSuvie;
	}

	public static int getPotionRestau() {return potionRestau; }

	public static void setPotionRestau(int potionRestau) {
		Potion.potionRestau = potionRestau;
	}

	    
}
