package inventory;

import Gold.gold;
import Player.Player;
import main.Game;
import perso.perso;
import resource.Statistics;

public class potions {

	 private final String name;
	 private final String type;
	 private final String description;
	 
	 public static int svUtiliser = 0;
	 public static int svNiveau;
	 public static int svPrix;
//-- ajoute des potion pour soigner les statuts 
//-- ajouter une potion qui donne au perso un coup de pouce temp (avec + de dégâts)

	 public static int 		restoUtiliser = 0;
	 public static int 		restNiveau;
	 public static int 		restPrix;
	 private static int 	potionSuvie; //potion + 25% sante
	 private static int 	potionRestau; //potion + 75% santé

//-- Constructor --- 
	 public potions(String name, String type, String description) {
	        this.name = name;
	        this.type = type;
	        this.description = description;
	  }

	   
//-- Utilisation potion	 
	 public static void usePotion(String t) {
	     String trouver = t.trim().substring(0, 1).toUpperCase()
	                	+ t.substring(1).toLowerCase();
	     
	     if (get(trouver) <= 0) {
	    	 System.out.println("--------------------------------------------------------");
	    	 System.out.println("Tu n'as pas " + trouver + " potions!");
	    	 System.out.println("Va faire un tour dans la boutique pou en avoir plus !   ");
	    	 System.out.println("--------------------------------------------------------");            
	         //ui.pause();

	     } else if (perso.getSante() == 100) {
	    	 System.out.println("-------------------------------------------------------");
	    	 System.out.println("Tu es déjà en pleine forme ! Tu n'est pas un chat");
	    	 System.out.println("Donc tu n'as pas besoin d'utiliser " + trouver + " potion!");
	    	 System.out.println("-------------------------------------------------------");
	    	 System.out.println("Ta santé actuelle :  " + perso.getSante());
	    	 System.out.println(trouver + "Potions : " + get(trouver));
	    	 System.out.println("-------------------------------------------------------");
	        // ui.pause();

	     } else {
	    	 set(trouver, -1, true);
	         int soin = (int) Math.round(soinPar(trouver));
	         perso(soin)/;
	         aUtiliser(trouver);

	         System.out.println("----------------------------------------------------");
	         System.out.println("Tu viens de consommer : " + trouver + " potion.");
	         System.out.println("Te voilà en pleine forme avec : " + soin + " sante.	");
	         System.out.println("----------------------------------------------------");
	         System.out.println("Ta santé est de: " + perso.getSante());
	         System.out.println(trouver + " Potions: " + get(trouver));
	         System.out.println("----------------------------------------------------");
	         //ui.pause();
	     }
	  }//fin 

	    
	 private static int get(String trouver) {
	// TODO Auto-generated method stub
	return 0;
}


	public static void addPotion(int numOfPotions, perso Perso) {
	        
		 for (int i = 0; i < numOfPotions; i++) {
	            Perso.inventory;
	        }
	    
	 }

	 
	private static Item potion() {
	        return new Item("Potion", "Potion", " a small vial filled with a "
	                + "translucent red liquid. Heals 20 HP.");
	    }

	    
	private static Item superPotion() {
	       return new Item("Super Potion", "Potion", " a medium sized vial filled"
	                + " with a translucent red liquid. Heals 40 HP.");
	    }

	    
	public static Item newRandomItem() {
	        
	    	
		Item randomItem = null;
	    int random = Game.RAND.nextInt(3) + 1; 
	        
	        switch (random) {
	            case 1:
	                randomItem = (potion());
	            case 2:
	                randomItem = (superPotion());;
	        }
	        return randomItem;
	    }

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


//-- soin -- 
	 /* public static double soinPar(String trouver) {
	      
		  switch (trouver.toLowerCase()) {
	         case "Survie":
	              return perso.getOutOf() * .25;
	         case "Restauration":
	              return perso.getOutOf() * .75;
	         default:
	              return 0;
	      }
	  }// soinPAr*/

	
//-- utiliser les potions --
	  public static void aUtiliser(String trouver) {
	      switch (trouver.toLowerCase()) {
	         case "Survie":
	            svUtiliser++;
	         case "Restauration":
	        	 restoUtiliser++;
	      }
	   }//fin aUtiliser()

	
//--- achats potions --
	  public static void achat(String trouver) {

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
	 } // classe Trouver

	 
//-- recup les niveau des potions -
	  public static int getLevel(String trouver) {
	    
	  	switch (trouver.toLowerCase()) {
	  			
	  	case "Survie":
	  				return svNiveau;
	  	case "Restauration":
	  				return restNiveau;
	  				default:
	  				return 0; 
	     }
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

	    
	  
	  public String getName() {
	        return name;
	    }

	   
	  public String getType() {
	        return type;
	    }

	    
	  public String getDescription() {
	        return description;
	    }
	    
}
