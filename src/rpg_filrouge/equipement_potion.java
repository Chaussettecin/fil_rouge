package rpg_filrouge;

public class equipement_potion {

	public static int svUtiliser = 0;
    public static int svNiveau;
    public static int svPrix;
 //-- ajoute des potion pour soigner les statuts 
 //-- ajouter une potion qui donne au perso un coup de pouce temp (avec + de dégâts)

    public static int 	restoUtiliser = 0;
    public static int 	restNiveau;
    public static int 	restPrix;
    private static int 	potionSuvie; //potion + 25% sante
    private static int 	potionRestau; //potion + 75% santé
	
private equipement_potion() {}
    
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

//-- soin -- 
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

     if (perso_xp.getLevel() < level) {
         ui.println("Tu n'est pas encore prêt pour ça :" + level + "pour acheter ça!");
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
