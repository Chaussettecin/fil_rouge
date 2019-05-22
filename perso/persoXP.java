package perso;

import javax.swing.JOptionPane;

public class persoXP extends perso {
	
	//Variables
			private static int xp;
			private static int combatXP;
			private static int xpManquant;
			private static int level;
			public static int totale;

	public persoXP(String id, String nom, String description, int level, Race race, int ptv, int ptvMin, boolean dead,
					int minDamage, int maxDamage, int gold, int attaque, int bonusAttaque, int defense, int accuracy,
					int bonusDefense, int xp, int maxXP, int previousXP, boolean presenceArmure, boolean mainslivre) {
		
		
		super(id, nom, description, level, ptv, ptvMin, dead, minDamage, maxDamage, defense, accuracy);
		
	}

	
//--- Level up --- 
	private static void levelUp() {
		    
		if (level == 9) {
		        System.out.printf("Vous avez gagné un niveau !\n Tu as gagné 250 Golds!", "Level Up !");
		        level = 10;
		        Gold.gold.set(250, true);

		} else if(level > 100){
				System.out.printf("Erreur- Les niveau de ce jeu ne dépasse pas 100");
		        level = 100;
		        
		} else if(level == 99){
		        level = 100;
		        xp = 49000;
		        
		}else {
				System.out.printf("Level Up ! Maintenant tu es" + (level + 1) + "!\n Tu remportes 100 Golds!","Level Up !");
				xp = 0;
				xpManquant += 500;
				level++;
				Gold.gold.set(100, true);
		}//Fin if
		        
			//quetes.check();
	}//fin levelUp()

			
		
	public static void setXP(int montant, boolean add) {
		     
		     if (add){
		         xp += montant;
		         totale += montant;
		     } else {
		         xp = montant;
		     }
		        
			if ((xp >= xpManquant) && (xpManquant != 0)){
				int xpRestant = xp - xpManquant;
		        levelUp();
		        setXP(xpRestant, true);
			}
			
	}//fin set
			
		
	public static int getCombatXp() {
			return combatXP;
	}
			
		
	public static void setCombatXp(int montant, boolean add) {
				
		if(add) {
				combatXP += montant;
		} else {
				combatXP = montant;
		}
	} //fin setCombatXP

		
	public void setLevel(int lvl){
			level = lvl;
	}
			
		
	public static void setOutOf(int outOf){
			xpManquant = outOf;
	}
			
		
	public static void setAll(int actuel, int outOf, int lvl){
		    xp = actuel;
		    xpManquant = outOf;
		    level = lvl;
	}

		
	public static int getXP(){
			return xp;
	}

		
	public static int getOutOf(){
			return xpManquant;
	}

		
	public int getLevel(){
			return level;
	}

		
	public static String getFull(){
			return xp + "/" + xpManquant + " xp";
	}

		
	public static int get(String trouver) {
		     
			switch (trouver.toLowerCase()) {
		        case "Survie":
		           return potionSuvie;
		        case "Restauration":
		           return potionRestau;
		        default:
		           return 0; 
		    }

		} // fin getTrouver

		
	public static void set(String trouver,int montant, boolean add) {
		     
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
		           game_support.error("Cette potion n'existe pas." + trouver);
		     }//fin switch
		 }
		
	//-- Utiliser un soin
		 public static void use(String t) {
		     String trouver = t.trim().substring(0, 1).toUpperCase()
		                	+ t.substring(1).toLowerCase();
		     ui.cls();

		     if (get(trouver) <= 0) {
		         ui.println("--------------------------------------------------------");
		         ui.println("Tu n'as pas " + trouver + " potions!");
		         ui.println("Va faire un tour dans la boutique pou en avoir plus !   ");
		         ui.println("--------------------------------------------------------");            
		         ui.pause();

		     } else if (perso_sante.get() == 100) {
		    	 ui.println("-------------------------------------------------------");
		         ui.println("Tu es déjà en pleine forme ! Tu n'est pas un chat");
		         ui.println("Donc tu n'as pas besoin d'utiliser " + trouver + " potion!");
		         ui.println("-------------------------------------------------------");
		         ui.println("Ta santé actuelle :  " + perso_sante.getStr());
		         ui.println(trouver + "Potions : " + get(trouver));
		         ui.println("-------------------------------------------------------");
		         ui.pause();

		     } else {
		    	 set(trouver, -1, true);
		         int soin = (int) Math.round(soinPar(trouver));
		         perso_sante.gains(soin);
		         aUtiliser(trouver);

		         ui.println("----------------------------------------------------");
		         ui.println("Tu viens de consommer : " + trouver + " potion.");
		         ui.println("Te voilà en pleine forme avec : " + soin + " sante.	");
		         ui.println("----------------------------------------------------");
		         ui.println("Ta santé est de: " + perso_sante.getStr());
		         ui.println(trouver + " Potions: " + get(trouver));
		         ui.println("----------------------------------------------------");
		         ui.pause();
		     }
		  }//fin use

	//-- soin -
		  public static double soinPar(String trouver) {
		      
			  switch (trouver.toLowerCase()) {
		         case "Survie":
		              return perso_sante.getOutOf() * .25;
		         case "Restauration":
		              return perso_sante.getOutOf() * .75;
		         default:
		              return 0;
		      }
		  }// soinPAr

	//-- utiliser les potions -
		  public static void aUtiliser(String trouver) {
		      
			  switch (trouver.toLowerCase()) {
		         case "Survie":
		            svUtiliser++;
		         case "Restauration":
		        	 restoUtiliser++;
		      }
		   }//fin aUtiliser()

	//-- achats  -
		 public static void achat(String trouver) {

		      int level = getLevel(trouver);
		      int prix = getPrix(trouver);

		     if (perso_xp.getLevel() < level) {
		         ui.println("Tu n'est pas encore prêt pour ça :" + level + " pour acheter ça!");
		         ui.pause();
		     
		     } else if (prix <= gold.get()) {
		    	 gold.set(-prix, true);
		         perso_stats.totalGoldepenserprSante += prix;
		         set(trouver, 1, true);
		         ui.println("Merci pour ton achat. A bientôt! ");
		         ui.pause();
		     
		     } else {
		         ui.println("Tu n'as pas assez d'argent et ce n'est pas Noel!");
		         ui.pause();
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

}
