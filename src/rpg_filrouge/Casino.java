package rpg_filrouge;


public class Casino {


private static final String MONEY_HEADER = "------------------------------------------------------------------\n" +
            "                        $$  Machine à sous  $$                          \n" +
            "------------------------------------------------------------------";
private static final String DES_HEAD = "------------------------------------------------------------------\n" +
            "                            Jeux de Dés                             \n" +
            "------------------------------------------------------------------";
public static int totalGoldrecup = 0;
public static int jeuxJouer = 0;

public static void menuJeux() {
    	
	//Permet au joueurs de choisir des petits jeux pour se faire des golds
    while (true) {
        ui.cls();
        ui.println("------------------------------------------------------------------");
        ui.println("                    *** Welcome au Casino ***                     ");
        ui.println();
        ui.println("     Golds : " + gold.get());
        ui.println("------------------------------------------------------------------");
        ui.println("1) Jeux de dés");
        ui.println("2) Machine à sous");
        ui.println("3) Retour");
        ui.println("------------------------------------------------------------------");

        int choixMenu = ui.getValidInt();
           switch (choixMenu) {
               case 1:
                    des();
                    break;
               case 2:
                	jouerSlots();
                    break;
               case 3:
                    return;
               default:
                    break;
           }
        }//fin while
    }//fin menujeux

   private static void des() {
        
	   while (true) {
            ui.cls();
            ui.println(DES_HEAD);
            ui.println("     Golds : " + gold.get());
            ui.println("-----------------------------------------------------------------------");
            ui.println("                      --- Les régles ---                               ");
            ui.println();
            ui.println("-- Pour ce jeux, tu dois choisir un nombre entre 1 et 6.");
            ui.println("-- Les deux dés seront lancés virtuellement. Si l'un des dés correspond");
            ui.println("-- correspond à un des deux chiffres, tu gagnes le double de Golds pariés ");
            ui.println("-- Si vos deux numéros correspondent, tu gagnes 5x le montant de       ");
            ui.println("-- de Golds mise à jeux. Dans l'autre cas si aucun dés ne correspondent");
            ui.println("-- à aucun chiffres. Alors tu perds tout ce que tu as mis en jeux !    ");
            ui.println("-----------------------------------------------------------------------");
            ui.println("1) Jouons !                                                            ");
            ui.println("2) Retour à l'accueil du Casino. $$$$                                       ");
            ui.println("-----------------------------------------------------------------------");

            int choixMenu = ui.getValidInt();

            switch (choixMenu) {
                case 1:
                    jeuxDes();
                    break;
                case 2:
                	 moneygame();
                    return;
                default:
                    break;
            }
        }
    }

    private static void moneygame() {
        
    	while (true) {

            ui.cls();
            ui.println(MONEY_HEADER);
            ui.println("     Gold : : " + gold.get());
            ui.println("-------------------------------------------------------------------------");
            ui.println("                      ---- Comment Jouer ? ----                         |");
            ui.println();
            ui.println("Au commencement ! Choisis ton montant de Gold que tu veux mettre en jeux" );
            ui.println("Chaque Slots contient 5 possibilités. Tu gagneras les Golds en fonction"  );
            ui.println("de la quantité du même article que vous tournez.                       	" );
            ui.println();
            ui.println("     -> 0 identique : Tu perds le montant mis en jeu.                    ");
            ui.println("     ->	2 identiques : Tu perds le montant mis en jeu.                    ");
            ui.println("     ->	3 identiques : Tu gagnes 4 fois le montant mis en jeu.            ");
            ui.println("     ->	4 identiques : Tu gagnes 8 fois le montant mis en jeu.            ");
            ui.println("-------------------------------------------------------------------");
            ui.println("1) Allez jouons !                                                  ");
            ui.println("2) Retour à l'accueil du Casino. $$$$$                             ");
            ui.println("-------------------------------------------------------------------");

            int choixMenu = ui.getValidInt();
            	switch (choixMenu) {
                	case 1:
                		jouerSlots();
                		break;
                	case 2:
                		return;
                	default:
                		break;
            	}
        	}//fin while
    }

    private static void jeuxDes() {
        int paris;
        int premNbre;
        int secoNbre;
        int des1;
        int des2;
        int goldGagne = 0;

        ui.cls();
        ui.println(DES_HEAD);
        ui.println();
        ui.println("Golds : " + gold.get());
        ui.println();
        ui.println("Au commencement : Entre le montant des golds que tu veux mettre en jeux ");
        ui.println("le nombre de Golds doit être entre entre 10 et 250."); 
        ui.println("[0] pour revenir au menu");
       
        do {
            paris = ui.getValidInt();
            if (paris == 0) return;
            if (paris > gold.get()) {
            	ui.cls();
                paris = 0;
                ui.println("Tu n'as pas assez de Gold. SVP entrer une plus petite quantité ou [0] pour revenir au menu.");
            }
        } while (paris < 10 || paris > 250);

        gold.set(-paris, true);

        //1er nombre
        do {
            ui.cls();
            ui.println(DES_HEAD);
            ui.println();
            ui.println("Maintenant ! Choisis ton premier chiffres ?");
            ui.println("Entre 1 et 6.");
            premNbre = ui.getValidInt();
        } while (premNbre < 1 || premNbre > 6);
        
       do {
    	   //2nd nbre
            ui.cls();
            ui.println(DES_HEAD);
            ui.println();
            ui.println("Maintenant ! Choisis ton premier chiffres ?");
            ui.println("Entre 1 et 6.");
            secoNbre = ui.getValidInt();
        } while (secoNbre < 1 || secoNbre > 6);

     //Lancer dés
       ui.cls();
       ui.println("Roulement de dés...(oupss de tambour !)");
       
       try {
            Thread.sleep(3000);
       } catch (InterruptedException e) {
            support.error(e.toString());
       }
       des1 = random.RInt(6);
       des2 = random.RInt(6);
       ui.println("Resultats prêt! [Entrée] pour continuer !..");
       ui.pause();

       //Resulats
        boolean fNum = false, sNum = false;
        if (premNbre == des1 || premNbre == des2) fNum = true;
        if (secoNbre == des1 || secoNbre == des2) sNum = true;
        if (fNum ^ sNum) goldGagne = paris * 2;
        if (fNum && sNum) goldGagne = paris * 5;
        
        ui.cls();
        ui.println(DES_HEAD);
        ui.println("Tu paris : " + paris);
        ui.println("Ton premier nombre : " + premNbre);
        ui.println("Ton second nombre : " + secoNbre);
        ui.println();
        ui.println("Dés 1: " + des1);
        ui.println("Dés 2: " + des2);
        ui.println();
        ui.println("Golds gagnés : " + goldGagne);
        gold.set(goldGagne, true);
        totalGoldrecup += goldGagne;
        jeuxJouer++;
        stats.jeuxdedesJouer++;
        ui.pause();
    }//fin de jeux des

    private static void jouerSlots() {
        int paris;
        int monnaie;
        int goldgagner = 0;
        String slots[] = {"", "", "", "", ""};
        int s[] = {0, 0, 0, 0, 0, 0};

        ui.cls();
        ui.println(MONEY_HEADER);
        ui.println();
        ui.println("Gold : " + gold.get());
        ui.println();
        ui.println("Pour commencer, entres le montant de Golds que tu voudrais jouer : ");
        ui.println("C'est mieux entre  10 et 250.");
        
        do {
            paris = ui.getValidInt();
            if (paris == 0) return;
            if (paris > gold.get()) {
                paris = 0;
                	ui.msg("Tu n'as pas assez d'argent. Soit moins gourmands ou rien.");
            }
        } while (paris < 10 || paris > 250);
        gold.set(-paris, true);

      //Slots
        //1
        monnaie = random.RInt(5);
        if (monnaie == 1) slots[1] = "$";
        if (monnaie == 2) slots[1] = "%";
        if (monnaie == 3) slots[1] = "&";
        if (monnaie == 4) slots[1] = "*";
        if (monnaie == 5) slots[1] = "@";
      //2
        monnaie = random.RInt(5);
        if (monnaie == 1) slots[2] = "$";
        if (monnaie == 2) slots[2] = "%";
        if (monnaie == 3) slots[2] = "&";
        if (monnaie == 4) slots[2] = "*";
        if (monnaie == 5) slots[2] = "@";
      //3
        monnaie = random.RInt(5);
        if (monnaie == 1) slots[3] = "$";
        if (monnaie == 2) slots[3] = "%";
        if (monnaie == 3) slots[3] = "&";
        if (monnaie == 4) slots[3] = "*";
        if (monnaie == 5) slots[3] = "@";
      //4
        monnaie = random.RInt(5);
        if (monnaie == 1) slots[4] = "$";
        if (monnaie == 2) slots[4] = "%";
        if (monnaie == 3) slots[4] = "&";
        if (monnaie == 4) slots[4] = "*";
        if (monnaie == 5) slots[4] = "@";

      //Resultats
        ui.cls();
        ui.println("Tic Tac Tic ...");
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            support.error(e.toString());
        }

        for (int i = 1; i < 5; i++) {
            if (slots[i].equals("$")) s[1]++;
            if (slots[i].equals("%")) s[2]++;
            if (slots[i].equals("&")) s[3]++;
            if (slots[i].equals("*")) s[4]++;
            if (slots[i].equals("@")) s[5]++;
        }
        
        for (int i = 1; i < 5; i++) {
            if (s[i] == 3) goldgagner = paris * 4;
        }
        
        for (int i = 1; i < 5; i++) {
            if (s[i] == 4) goldgagner = paris * 8;
        }
        
        ui.println("Resultats prêt! [Entrée] pour continuer !.");
        ui.pause();
        ui.println(MONEY_HEADER);
        ui.println("Ton pari : " + paris);
        ui.println();
        ui.println("tic tic : " + slots[1] + "  " + slots[2] + "  " + slots[3] + "  " + slots[4]);
        ui.println();
        ui.println("Golds gagnés : " + goldgagner);
        gold.set(goldgagner, true);
        totalGoldrecup += goldgagner;
        jeuxJouer++;
        stats.jeuxSlotJouer++;
        ui.pause();
    }
}
