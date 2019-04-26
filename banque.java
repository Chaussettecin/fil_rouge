package rpg_filrouge;


public class banque {

	
private static double interet;
private static int balance;

	public static void menu() {
	
		int montant;

	//--Verifie que le joueur est bien au niveau 2 
		if (perso_xp.getLevel() < 2) {
			ui.msg("");
			return;
		}

		while (true) {

            ui.cls();
            ui.println("---------------------------------------");
            ui.println("                ** Banque **            ");
            ui.println();
            ui.println("Donnes nous tes Golds");
            ui.println("Ils seront bien au chaud !");
            ui.println("Mais si tu meurt, ton compte aussi");
            ui.println("payer" + (interet * 100) + "% de ton compte.");
            ui.println("Tout le temps ");
            ui.println("");
            ui.println();
            ui.println("Balance : " + get());
            ui.println("Gold(s): " + gold.get());
            ui.println();
            ui.println("1) Depot !");
            ui.println("2) Liquide !");
            ui.println("3) Prêts !");
            ui.println("4) retour");
            ui.println("---------------------------------------");

            switch (ui.getValidInt()) {
                case 1:
                    if (banque_pret.hasLoan()) {
                        ui.msg("Crédit ?!");
                        break;
                    }
                    ui.println("Combien tu veux déposer ? (Tu devrais payer" + (interet * 100) + "% de )");
                    ui.println("Actuellement tu as " + gold.get() + "Golds.");
                    do {
                    	montant = ui.getValidInt();
                    	if (montant > gold.get()) {
                    		ui.println("oh oh tu n'as pas assez d'argent. Tu as seulement " + gold.get() + " Gold.");
                    		montant = -1;
                        }
                    } while (montant < 0);
                    if (montant == 0) return;

                    //Depot
                    depot(montant, interet);
                    break; //fin cas 1
               case 2:   
               ui.cls();
               ui.println("Tu veux combien de liquide ?");
               ui.println("Actuellement tu as " + get() + " Golds dans ta banque.");
               do {
                   montant = ui.getValidInt();
                   if (montant > get()) {
                      ui.println("Remts de l'argent dans ton compte. Car tu n'as que" + get() + " Golds.");
                      montant = -1;
                   }
               } while (montant < 0);

               //Argent liquide
               liquideMoney(montant);
               		break; //fin cas 2
               case 3:
                    banque_pret.menu();
                    break;
               case 4:
                    return;
            } //fin switch
        }//fin while
    } //fin menu 

    public static int get() {
        return balance;
    }

    public static void set(int montant, boolean add) {
        if (!add) {
            balance = montant;
        } else {
            balance += montant;
            if (balance < 0) balance = 0;
        }
    }

    public static void setInteret(double prix) {
    	interet = prix;
    }

    private static void liquideMoney(int montant) {
     //calcule de l'argent liquide
     gold.set(montant, true);
     set(-montant, true);

     //Resultats
     ui.cls();
     ui.println("Montant : " + montant);
     ui.println("Balance en court : " + get());
     ui.pause();
    }

    private static void depot(int montant, double interet) {
        
    	interet = interet * montant;
        if (montant < 10) interet = 1;

      //-- prend l'argent du joueur --
        gold.set(-montant, true);

        montant -= Math.round(interet);
        
     //-- Recup les tats - 
        perso_stats.totalGoldDepenser += Math.round(interet);
        perso_stats.golddepenserInteret += Math.round(interet);
      
        set(montant, true);

     //-- Affichage -- 
        ui.cls();
        ui.println("Montant déposé : " + montant + " Golds");
        ui.println("Intérêt en court : " + Math.round(interet) + " Golds");
        ui.println("l'état de ta balance : " + get() + "Golds");
        ui.pause();
    } // fin depot
}
