package rpg_filrouge;

public class equipement_sort {

	public static int aUtiliser = 0;
    public static int prix;
    public static int level;
    private static int sort;

    
   public static int get() {
     return sort;
    }

    public static void set(int montant, boolean add) {
        if (!add) {
        	sort = montant;
        } else {
        	sort += montant;
            if (sort < 0) sort = 0;
        }
    }
    
    public static void use() {
    	ui.cls();
        
    	if (sort <= 0) {
            ui.println("---------------------------------------------------------");
            ui.println("Tu n'as plus de MANA !");
            ui.println("Hop ! Fais un tour en boutique pour refaire, le plein.");
            ui.println("---------------------------------------------------------");
            ui.pause();

    	} else {
    	  sort--;
    	  aUtiliser++;
    	joueurs_xp.set(20, true);
        Enemies.get().prendDegats( Enemies.get().getSante());
          ui.println("----------------------------------------------------");
          ui.println("Tu viens d'utiliser un pouvoir.");
          ui.println("Ta victime est totalement morte.");
          ui.println("----------------------------------------------------");
          ui.println("Ennemies santé : " +  Enemies.get().getSanteStr());
          ui.println("Pouvoir : " + sors);
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
