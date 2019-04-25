package rpg_filrouge;

import fantasy_RPG.Enemies;

public class game_help {


private aide() {
}
	public static void view() {
        while (true) {
	          ui.cls();
	          ui.println("-----------------------------------------------------------------");
	          ui.println("                        ** Menu Aide **                            ");
	          ui.println("Ici tu trouveras toutes les aides pour le jeux (enfin presque) ! ");
	          ui.println("");
	          ui.println("-----------------------------------------------------------------");
	          ui.println("1) Ennemies");
	          ui.println("2) Armures");
	          ui.println("3) Armes");
	          ui.println("4) Santé");
	          ui.println("5) Aliments");
	          ui.println("6) XP");
	          ui.println("7) Soluces");
	          ui.println("8) Missions");
	          ui.println("9) retour");
	          ui.println("----------------------------------------------------------------");
	            switch (ui.getValidInt()) {
	                case 1:
	                	info_ennemies();
	                    break;
	                case 2:
	                	info_armures();
	                    break;
	                case 3:
	                    info_armes();
	                    break;
	                case 4:
	                    info_sante();
	                    break;
	                case 5:
	                    info_food();
	                    break;
	                case 6:
	                    info_xp();
	                    break;
	                case 7:
	                    info_solutions();
	                    break;
	                case 8:
	                    info_missions();
	                    break;
	                case 9:
	                    return;
	            }
	        }
	  } //fin menu 

	private static void info_ennemies() {
	     while (true) {
	          ui.cls();
	          ui.println("------------------------------------------------------------");
	          ui.println("                      *** INFO Enemies ****                 ");
	          ui.println("Tu voudrais quelle information tu voudrais savoir sur lui  ?");
	          ui.println();
	           for (int i = 0; i < Enemies.arrayEnemies.size(); i++) {
	        	   ui.println((i + 1) + ") " + Enemies.arrayEnemies.get(i).getNom());
	           }
	          ui.println((Enemies.arrayEnemies.size() + 1) + ") Retour");
	          ui.println("------------------------------------------------------------");

	          int menuItem = ui.getValidInt();

	          try {
	        	  Enemies.arrayEnemies.get(menuItem - 1).viewAbout();
	          } catch (Exception e) {
	              if (menuItem == (Enemies.arrayEnemies.size() + 1)) return;
	                ui.println(menuItem + " ceci n'est pas une option !");
	                ui.pause();
	          }
	      }//fin while
	  } //fin ennemies

//info armures
	private static void info_armures() {
	 
	        while (true) {
	            ui.cls();
	            ui.println("--------------------------------------------------------------------");
	            ui.println("               *** INFO Armures ***              					");
	            ui.println("Tu voudrais quelle information tu voudrais savoir sur cet objet ?   ");
	            ui.println();
	            for (int i = 0; i < equipement_armure.getarmures().size(); i++) {
	                ui.println((i + 1) + ") " + equipement_armure.getarmures().get(i).getNom());
	            }
	            ui.println((equipement_armure.getarmures().size() + 1) + ") Retour");
	            ui.println("------------------------------------------------------");

	            int menuItem = ui.getValidInt();

	            try {
	            	equipement_armure.getarmures().get(menuItem - 1).viewApropos();
	            } catch (Exception e) {
	                if (menuItem == (equipement_armure.getarmures().size() + 1)) return;
	                ui.println(menuItem + " ceci n'est pas une option !");
	                ui.pause();
	            }
	        }
	}// fin info armure

	
//info armes
	private static void info_armes() {
	      while (true) {
	          ui.cls();
	          ui.println("------------------------------------------------------------");
	          ui.println("               *** INFO Armes ****              ");
	          ui.println("Tu voudrais quelle information tu voudrais savoir sur cet objet ?");
	          ui.println();
	          ui.println("Attention les armes c'est dangereux.");
	            for (int i = 0; i < equipement_armes.arrayArmes.size(); i++) {
	                ui.println((i + 1) + ") " + equipement_armes.arrayArmes.get(i).getNom());
	            }
	          ui.println((equipement_armes.arrayArmes.size() + 1) + ") Retour");
	          ui.println("------------------------------------------------------------");

	          int menuItem = ui.getValidInt();

	            try {
	            	equipement_armes.arrayArmes.get(menuItem - 1).aPropos();
	            } catch (Exception e) {
	                if (menuItem == (equipement_armes.arrayArmes.size() + 1)) return;
	                ui.println(menuItem + "ceci n'est pas une option !");
	                ui.pause();
	            }
	      } // end while
	} // fin info armes

//Info santé
	private static void info_sante() {
	        ui.cls();
	        ui.println("---------------------------------------------------------------");
	        ui.println("                      ** Info Santé **                         ");
	        ui.println("Tu commences avec 100 points de vie et tu peux mettre à jours ");
	        ui.println("ton niveau de santé jusqu'à 200. Chaque Up coute 100 Golds avec ");
	        ui.println("le mode facile et 150 piéces pour le difficile. tu auras +10 de santé");
	        ui.println("Mise à jours du niveau, une fois par level.");
	     
	        ui.println("---------------------------------------------------------------");
	        ui.pause();
	 }

//info alimentation
	private static void info_food() {
	      while (true) {
	        ui.cls();
	        ui.println("-----------------------------------------------------------------");
	        ui.println("                        ** FOOD INFO **                       ");
	        ui.println("Tu voudrais quelle information tu voudrais savoir sur cet objet ?");
	        ui.println();
	            for (int i = 0; i < equipement_food.arrayFood.size(); i++) {
	                ui.println((i + 1) + ") " + equipement_food.arrayFood.get(i).getNom());
	            }
	        ui.println((equipement_food.arrayFood.size() + 1) + ") Retour");
	        ui.println("------------------------------------------------------------");

	        int menuItem = ui.getValidInt();

	        try {
	            equipement_food.arrayFood.get(menuItem - 1).viewPropos();
	            } catch (Exception e) {
	            if (menuItem == (equipement_food.arrayFood.size() + 1)) return;
	                ui.println(menuItem + " ceci n'est pas une option !");
	                ui.pause();
	            }
	        }
	 } //fin food

//info XP	
	private static void info_xp() {
	        ui.cls();
	        ui.println("-------------------------------------------------------------");
	        ui.println("                          ***  XP ***                        ");
	        ui.println("Obtenir XP augmente votre niveau, ce qui vous permet d'acheter plus d'objets à acheter.");
	        ui.println("Vous commencez au niveau un et vous pouvez atteindre le niveau 100");
	        ui.println("Vous avez besoin de plus en plus d'XP pour chaque niveau. Vous commencez à avoir besoin");
	        ui.println("seulement 500 XP pour atteindre le niveau deux, puis chaque niveau vous avez besoin de 500");
	        ui.println("plus. Vous avez donc besoin de 1000 pour le niveau 3, de 1500 pour le niveau 4, etc.");
	        ui.println("Chaque fois que vous montez de niveau, votre XP est réinitialisé à 0. Vous");
	        ui.println("obtenir un exploit pour chaque niveau que vous atteignez jusqu'au niveau 10.");
	        ui.println("Vous recevrez également 100 pièces (ou 250 pièces lorsque vous obtenez");
	        ui.println("niveau 10) Bien que vous puissiez atteindre le niveau 100, une fois que vous");
	        ui.println("arriver au niveau 10, il n'y a rien d'autre à débloquer.");
	        ui.println();
	        ui.println("--- Comment obtenir XP : ");
	        ui.println("Il y a plusieurs façons d'obtenir XP. Le principal");
	        ui.println("vous obtenez XP en combattant des ennemis. Pour chaque point de");
	        ui.println("Si vous infligez des dégâts à un ennemi, vous obtenez 1 XP. Une autre façon est par");
	        ui.println("l'acheter. Vous pouvez acheter 1 XP pour 1 pièce. (Vous pouvez acheter autant");
	        ui.println("à votre guise / dans la mesure de vos moyens). Vous aurez aussi");
	        ui.println("100 XP pour chaque exploit que vous débloquez. Utiliser une volonté");
	        ui.println("donner à 20Xp");
	        ui.println("------------------------------------------------------------");
	        ui.pause();
	} //info XP

//Info soluce
	private static void info_solutions() {
	        ui.cls();
	        ui.println("------------------------------------------------------------------------");
	        ui.println("                         ** Soluces **                                  ");
	        ui.println("Pour utiliser un code soluce, assures toi d'être au menu principal. ");
	        ui.println("puis entre [0]. une * doit apparaitre");
	        ui.println("you can type in a cheat code.                               ");
	        ui.println("WARNING: Using cheats will disable all achievements and the ");
	        ui.println("XP system.                                                  ");
	        ui.println("*Tip: You can lock cheats off in the settings menu to       ");
	        ui.println("      prevent the use of cheats                             ");
	        ui.println();
	        ui.println("Liste des codes de soluces :");
	        ui.println("   Codes             | Descriptions");
	        ui.println("                    |            ");
	        ui.println("   moneylover       | Gives you 1000 coins");
	        ui.println("   givemeitall      | Gives you 5000 of every item + all weapons");
	        ui.println("   weaponstash      | Gives you every weapon, and 5000 ammo");
	        ui.println("   nomorepain       | Gives you a bunch of healing supplies");
	        ui.println("   healme           | Sets your health to 100");
	        ui.println("   givemeachallenge | Gives enemy 1000 health");
	        ui.println("   lotsofkills      | Sets kill-streak to 5000");
	        ui.println("   suicide          | Kills you");
	        ui.println("   godmode          | Never dies");
	        ui.println("   loanshark        | Removes current loan");
	        ui.println("   thirstforfood    | Gives you 10 of each type of food");
	        ui.println("------------------------------------------------------------------------");
	        ui.pause();
	}//fin info Solutions

	
//Info missions
	private static void info_missions() {
	        ui.cls();
	        ui.println("-------------------------------------------------------------------------");
	        ui.println("                       ** Missions **                      ");
	        ui.println("Tu es récompensé 100x pour chaque fin de mission. ");
	        ui.println(" Si tu optiens toutes les réalisations tu auras 2500 Golds ");
	        ui.println("AU BOULOT !");
	        ui.println("");
	        ui.println("Liste des missions : ");
	        ui.println("   Missions               | Description");
	        ui.println("                          | ");
	        ui.println("   Money Maker            | Get 1500 Golds");
	        ui.println("   Enemy Slayer           | Kill a total of 100 enemies");
	        ui.println("   First Kill             | Kill one enemy");
	        ui.println("   Time For An Upgrade    | Buy any weapon from the shop");
	        for (int i = 0; i < joueurs_ennemis.arrayEnemies.size(); i++) {
	            ui.print(" Bye ! Bye !" + joueurs_ennemis.arrayEnemies.get(i).getNom());
	            for (int x = 0; x < (14 - joueurs_ennemis.arrayEnemies.get(i).getNom().length()); x++) ui.print(" ");
	            ui.println("| Kill a " + joueurs_ennemis.arrayEnemies.get(i).getNom());

	        }//for
	        ui.println("   Text-Fighter Master    | Get all other achievements");
	        ui.println("   Yay, POWER!            | Utilise 5 pouvoirs");
	        ui.println("   Slayer                 | Deal a total of 1000 damage");
	        ui.println("   Nobody's Perfect       | Mort");
	        ui.println("   Making Money           | Win 1000 coins altogether in the Casino");
	        ui.println("   Gambling Addiction     | Complete 75 rounds in the Casino");
	        ui.println("   Level 2 Fighter        | Reach level 2");
	        ui.println("   Level 3 Fighter        | Reach level 3");
	        ui.println("   Level 4 Fighter        | Reach level 4");
	        ui.println("   Level 5 Fighter        | Reach level 5");
	        ui.println("   Level 6 Fighter        | Reach level 6");
	        ui.println("   Level 7 Fighter        | Reach level 7");
	        ui.println("   Level 8 Fighter        | Reach level 8");
	        ui.println("   Level 9 Fighter        | Reach level 9");
	        ui.println("   Level 10 Fighter       | Reach level 10");
	        ui.println("   Honest Player          | Lock cheats off");
	        ui.println("   Learning               | Look at every single help page in one session");
	        ui.println("-------------------------------------------------------------------------");
	        ui.pause();
	    }
}
