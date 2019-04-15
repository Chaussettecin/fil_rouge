package fantasy_RPG;

public class equipement_pouvoirs {
	
	public static int aUtiliser = 0;
    public static int prix;
    public static int level;
    private static int pouvoir;

    
   public static int get() {
     return pouvoir;
    }

    public static void set(int montant, boolean add) {
        if (!add) {
        	pouvoir = montant;
        } else {
        	pouvoir += montant;
            if (pouvoir < 0) pouvoir = 0;
        }
    }
    
    public static void use() {
    	ui.cls();
        
    	if (pouvoir <= 0) {
            ui.println("---------------------------------------------------------");
            ui.println("Tu n'as plus de MANA !");
            ui.println("Hop ! Fais un tour en boutique pour refaire, le plein.");
            ui.println("---------------------------------------------------------");
            ui.pause();

    	} else {
    	  pouvoir--;
    	  aUtiliser++;
    	joueurs_xp.set(20, true);
        joueurs_ennemis.get().prendDegats(joueurs_ennemis.get().getSante());
          ui.println("----------------------------------------------------");
          ui.println("Tu viens d'utiliser un pouvoir.");
          ui.println("Ta victime est totalement morte.");
          ui.println("----------------------------------------------------");
          ui.println("Ennemies santé : " + joueurs_ennemis.get().getSanteStr());
          ui.println("Pouvoir : " + pouvoir);
          ui.println("----------------------------------------------------");
          ui.pause(); 
      } //fin if
    } //fin Use
    
    public static void achats() {
        if (joueurs_xp.getLevel() < level) {
            ui.println("tu n'a pas le niveau minimum " + level + " pour acher ce produit!");
            ui.pause();
        } else if (prix <= gold.get()) {
            gold.set(-prix, true);
            stats.totalGoldepenserprSante += prix;
            set(1, true);
            ui.println(" Merci pour ton achat ! ");
            ui.pause();
        } else {
            ui.println("La maison ne fait pas crédit !");
            ui.pause();
        }
    }
}
