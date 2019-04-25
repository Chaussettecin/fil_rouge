package rpg_filrouge;

import java.util.Scanner;


public class game {

private game() {
}

//--- Liste des Boss 
public static Boss Torbrion;
public static Boss Ellyrion;
public static Boss Khaine;
public static Boss NAAGGROTH;


//--- Armes 
public static equipement_armes poing;
public static equipement_armes épée;
public static equipement_armes lame;
public static equipement_armes masse;


//---- Armures
public static equipement_armure sans = new equipement_armure("Sans", 0, 0, 1);
public static equipement_armure simple = new equipement_armure("simple", 400, 15, 5);
public static equipement_armure avancée = new equipement_armure("avancée", 750, 30, 7);

//Aliments 
//Quand le StatusEffect syst est implémenter, l'effet change
public static equipement_food apple       	= new equipement_food("Pomme","Une jolie petite Pomme.",joueurs_statusEffets.type.SANTE, equipement_food.type.FRUIT_MAGIQUE,5);
public static equipement_food orange      	= new equipement_food("Bonbon","Aussi sucré mais moins naturel.",joueurs_statusEffets.type.SANTE, equipement_food.type.FRUIT_MAGIQUE,5);
public static equipement_food fruitDragon 	= new equipement_food("Fruit du Dragon","Ceci est un fruit mais absolument pas un vrai dragon.",  joueurs_statusEffets.type.SANTE, equipement_food.type.FRUIT_MAGIQUE,10);
public static equipement_food humains       = new equipement_food("Humains, humain", "Bien quoi ?.", joueurs_statusEffets.type.SANTE, equipement_food.type.VIANDE_HUMAINE,15);
public static equipement_food shitake    	= new equipement_food("Shitake","C'est un très bon aliment !",joueurs_statusEffets.type.SANTE, equipement_food.type.FRUIT_MAGIQUE,5);
public static equipement_food Seitan        = new equipement_food("Seitan", "Ce trouve un peu partout.",joueurs_statusEffets.type.SANTE, equipement_food.type.VIANDE_HUMAINE,15);

private static Scanner scan = new Scanner(System.in);

public static void start() {	
	
//Lance le jeux
	
	ui.cls();
	ui.println("  _________________________________________  ");		
	ui.println("|                                           |");
	ui.println("|      C'est partis pour le jeux  !         |");
	ui.println("|            Prêts ?                        |");
	ui.println("|                                           |");
	ui.println("|                                           |");
	ui.println("| 1) Commencer !                            |");
	ui.println("|              -----                        |");
	ui.println("| 2) Menu                                   |");
	ui.println("|                                           |");
	ui.println("| 3) Casino                                 |");
	ui.println("| 4) Aide                                   |");
	ui.println("| _________________________________________ |");
	
	int menuDiff = ui.getValidInt();
	
	switch (menuDiff) {
		case 1:
			//if (!scan.hasNextInt()) {
				//ui.cls();
			//} 
			jeux.gogo();
			//if(menuDiff != 1) {
				//joueurs_ennemis.rencontreNewEnnemies();
			//}
			break;
		case 2 :
			jeux.home();
			break;
		case 3 :
			casino.menuJeux();
		case 4:
			aide.view();
			break;
	}
	
}//fin Start

private static void gogo() {
	
	ui.cls();
	ui.println("------------------------------------------------------------------");
	ui.println(" Rentres ton petit nom  : " + joueurs.nom());
	ui.println("                                                                 " );
	ui.println(" Si je comprend bien ton nom est : " + joueurs.nom());
	ui.println("                                                                 " );
	ui.println("               --- Bienvenue ---                                 " );
	ui.println("                                                                 " );
	ui.println("  Maintenant choisis ta race :                                   " );
	ui.println("  Ta race choisie :                                              " );
	ui.println("                                                                 " );
	ui.println("  Encore une petite question...                                  " );
	ui.println("  Choisis ton métier :                                           " );
	ui.println("  Ton métier         :                                           " );
	ui.println("                                                                 " );
	ui.println("  C'est parti pour le jeux :                                     " );
	
	ui.println("                                                                 " );
	ui.println("  Un peu d'organisation....                                      " );
	ui.println("  Passes à la boutique pour t'équiper :                          " );
	ui.println("  Car je ne te conseil pas de jouer à poils !                    " );
	ui.println("                                                                 " );
	ui.println("                                                                 " );
	ui.println("1) Jouer !");
	ui.println("2) Retour ");
			
		 int menuStart = ui.getValidInt();
		 switch (menuStart) {
			case 1:
				perso_ennemis;
				break;
			case 2:
				jeux.start();
				break;
			default:
				break;
		 }
			

}


private static void town() {
		
	int menuChoix;
	
	//menu ville
	while (true) {
		ui.cls();
		ui.println("------------------------------------------------------------------");
		ui.println("                    **  Welcome dans ta ville **                  ");
		ui.println("-- Informations sur ton score :");
		ui.println("     Stat Victimes : " + stats.tuer);
		ui.println("     Meilleur Score : " + stats.highScore);
		ui.println("-- Information joueur --");
		ui.println("     Santé : " + joueurs_sante.getStr());
		ui.println("     Golds : " + gold.get());
		ui.println("     Kit de 1er secours: " + equipement_premiersSecours.get());
        ui.println("     Potions: ");
        ui.println("          Survie: " + equipement_potion.get("Survie"));
        ui.println("          Restauration : " + equipement_potion.get("Restauration") );
		ui.println("     Armes actuelle : " + equipement_armes.get().getNom());
		ui.println("------------------------------------------------------------------");
		ui.println("1) Casino");
		ui.println("2) Maison !");
		ui.println("3) Banque");
		ui.println("4) Boutique");
		ui.println("5) Augmente ta sante");
		ui.println("6) Retour");
		ui.println("------------------------------------------------------------------");

		menuChoix = ui.getValidInt();

		switch (menuChoix) {
			case 1:
				casino.menuJeux();
				break;
			case 2:
				home();
				break;
			case 3:
				banque.menu();
				break;
			case 4:
				boutique.menu();
				break;
			case 5:
				joueurs_sante.upgrade();
				break;
			case 6:
				return;
				default:
					break;
			}//Switch menu town
		}//fin while
	}//fin town

private static void home() {

	int menuChoix;

	//Menu Maison
	while (true) {
		ui.cls();
		ui.println("------------------------------------------------------------------");
		ui.println("                      ** Bienvenue à la Casa **                           ");
		//ui.println("-- Informations sur ton score : ");
		//ui.println("    Ennemies tuer : " + stats.tuer);
		//ui.println("    Meilleurs score : " + stats.highScore);
		ui.println("-- Informations perso :");
		ui.println("     Ton nom  : " + joueurs.nom());
		ui.println("     Ta santé : " + joueurs_sante.getStr());
		ui.println("     Ta bourse : " + gold.get());
		//ui.println("     Kit de premier secours : " + equipement_premiersSecours.get());
		//ui.println("     Potions: " + (equipement_potion.get("Survie") + equipement_potion.get("Restauration")));
		//ui.println("     Armes portées: " + equipement_armes.get().getNom());
		ui.println("------------------------------------------------------------------");
		ui.println("1) Armes disponibles");
		ui.println("2) Armures disponibles");
		ui.println("3) Objets ");
		ui.println("4) Missions");
		ui.println("5) Stats de la partie");
		ui.println("                                                                  ");
		ui.println("6) A propos");
		ui.println("7) Réglages");
		ui.println("8) Aide");
		ui.println("9) Retour");
		ui.println("------------------------------------------------------------------");

		menuChoix = ui.getValidInt();

		switch (menuChoix) {
			case 1:
				equipement_armes.choix();
				break;
			case 2:
				equipement_armure.choix();
				break;
			case 3:
				equipement_coffre.affichage();
				break;
			case 4:
				joueurs_mission.affichageMissions();
				break;
			case 5:
				stats.view();
				break;
			case 6:
				joueurs_mission.affichageOption = true;
				break;
			case 7:
				setting.menu();
				break;
			case 8:
				aide.view();
			case 9:
				return;
			default:
				break;
			}//Switch
		} //fin while
	}//fin home

}
