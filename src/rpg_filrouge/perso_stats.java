package rpg_filrouge;

import fantasy_RPG.casino;
import fantasy_RPG.soluces;

public class perso_stats {

	//Statistiques combats
		public static int highScore;
	    public static int tuer;
	    public static int totalDegats;
	    public static int totaltuer;
	    public static int bulletsFired;
	    public static int bulletsThatHit;

	 //Gold(s) gagné
	    public static int totalGoldDepenser;
	    public static  int totalGoldepenserprArmes;
	    public static int totalGoldepenserprSante;
	    public static int golddepenserInteret;
	    public static int xpAchetes;
	 
	 //Autres
	    public static int timesCheated;
	    public static int timesQuit;
	    public static int itemsCrafted;
	    public static int jeuxdedesJouer;
	    public static int jeuxSlotJouer;
	    
	    private static String  majPersotues;

	private stats() {
	}

	 public static void view() {
	    	
		 	majPersotues();
	    	
	        ui.cls();
	        ui.println("------------------------------------------------");
	        ui.println("              *** Statistiques Joueurs ***   	");
	        ui.println();
	        ui.println(" ********************************************** ");
	        ui.println(" ** Voici tes stats du combat ** ");
	        ui.println("   High Score =" + highScore);
	        ui.println("   Dernier ennemies tués  =" + majPersotues);
	        ui.println("   Total Pouvoirs utilisés = " + equipement_pouvoirs.aUtiliser);
	        ui.println("   Armes actuelles = " + equipement_armes.get().getNom());
	        ui.println("   Ennemis actuels = " + joueurs_ennemis.get().getNom());
	        ui.println("   Total des dégats s/ ennemies =" + totaltuer);
	        ui.println("   Total victimes =" + totaltuer);
	        ui.println("   Bullets Fired  =" + bulletsFired);
	        ui.println("   Bullets that hit - " + bulletsThatHit);
	        ui.println("   KO" + majPersotues);
	        ui.println();
	        ui.println("*************************************************");
	        ui.println(" $$ Golds $$ :");
	        ui.println("   Golds :" + gold.get());
	        ui.println("   Golds dans la Banque :" + banque.get());
	        ui.println("   Total Golds gagnés au Casino :" + casino.totalGoldrecup);
	        ui.println("   Total Jeux Jouer au Casino : " + casino.jeuxJouer);
	        ui.println("   Total Golds dépenser : " + totalGoldDepenser);
	        ui.println("   Golds dépensés en intérêts dans la banque : " + golddepenserInteret);
	        ui.println("   Golds dépensés pour t'armer :" + totalGoldepenserprArmes);
	        ui.println("   Golds dépensés pour te soigner :" + totalGoldepenserprSante);
	        ui.println("   XP achetés : " + xpAchetes);
	        ui.println();
	        ui.println(" ** Santé : ***");
	        ui.println("   Ton niveau de santé  : " + perso_sante.getStr());
	        ui.println("   Insta-Santé utilisés : " + equipement_instaSante.utiliser);
	        ui.println("   Kit de 1er soin utilisé : " + equipement_premiersSecours.utiliser);
	        ui.println("   Tu as pris  	: " + (equipement_potion.svUtiliser + equipement_potion.restoUtiliser) + "potions.");
	        ui.println("   Tu es morts  : " + perso_sante.nbXKO);
	        ui.println("   Tu as mangés : " +(equipement_food.totalAlimentsConso) + "d'aliments");
	        ui.println();
	        ui.println(" Autres : ");
	        ui.println("   Soluces :" + soluces.activer());
	        ui.println("   Level :" + perso_xp.getLevel());
	        ui.println("   Xp : " + perso_xp.getFull());
	        ui.println("   Total d'XP gagné : " + perso_xp.totale);
	        ui.println("   Temps triches : " + timesCheated);
	        ui.println("   Times quit : " + timesQuit);
	        ui.println("   Objets ramassés : " + itemsCrafted);
	        ui.println("   Jeux de dés : " + jeuxdedesJouer);
	        ui.println("   Jeux de Machines à sous : " + jeuxSlotJouer);
	        ui.println();
	        ui.println("-------------------------------------------------");
	        ui.pause();
	    }//fin vue

	    private static void majPersotues() {
	        int i, gcm = 1, first = totaltuer, second = perso_sante.nbXKO;
	        	i = (first >= second) ? first : second;

	        	while (i != 0) {
	        		if (first % i == 0 && second % i == 0) {
	        			gcm = i;
	        		break;
	        		}
	        	i--;
	        	}//finWhile

	        majPersotues = first / gcm + ":" + second / gcm;
	    }// fin majPersoTues
}
