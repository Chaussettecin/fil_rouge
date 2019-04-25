package rpg_filrouge;


//-- Potions qui permet de boosté les capacités physiques du personnage

public class equipement_potionS {

	public static int utiliser = 0;
	public static int prix;
	public static int level;    
	private static int rechargeS;

	private equipement_potionS() {}

	public static int get() {
	    return rechargeS;
	 }

	 public static void set(int montant, boolean add) {
	    if (!add) {
	    	rechargeS =montant ;
	    } else {
	    	rechargeS += montant;
	    	if (rechargeS < 0) rechargeS = 0;
	    }
	 }


	 public static void utiliser() {

	    ui.cls();
	        
	    if (get() <= 0) {
	            
	    	ui.println("----------------------------------------------------");
	        ui.println("Tu n'as plus de Boost !");
	        ui.println("Vas dans la boutique pour te refaire une santé.");
	        ui.println("----------------------------------------------------");
	        ui.pause();

	    } else if (perso_sante.get() == 100) {

	    	ui.println("----------------------------------------------------");
	        ui.println("Tu es en parfaite santé !");
	        ui.println("Tu n'a pas besoin de te recharger !");
	        ui.println("----------------------------------------------------");
	        ui.println("Te voici en forme avec :  " + perso_sante.getStr());
	        ui.println("Kit de 1er secours : " + get());
	        ui.println("----------------------------------------------------");
	        ui.pause();

	    } else {

	        set(-1, true);
	        perso_sante.gains(20);
	        utiliser++;
	            
	        ui.println("----------------------------------------------------");
	        ui.println("Tu viens de te recharger.");
	        ui.println("Ta santé est restaurée complétement.");
	        ui.println("----------------------------------------------------");
	        ui.println("Ta santé actuelle : " + perso_sante.getStr());
	        ui.println("Refais toi une santé: " + get());
	        ui.println("----------------------------------------------------");
	        ui.pause();
	        
	    }
	 } // fin utiliser

	    
	 public static void achat() {
	        if (perso_xp.getLevel() < level) {
	            ui.println("Tu n'as pas le bon niveau" + level + " pour acheter ça!");
	            ui.pause();
	    	} else if (prix <= gold.get()) {
	            gold.set(-prix, true);
	            perso_stats.totalGoldepenserprSante += prix;
	            set(1, true);
	            ui.println("Merci pour ton achat. A très bientôt! ");
	            ui.pause();
	    	} else {
	            ui.println("oh oh ! la maison ne fait pas crédit !");
	            ui.pause();
	    	}
	}//fin achat

}
