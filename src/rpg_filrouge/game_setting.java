package rpg_filrouge;

import fantasy_RPG.equipement_armes;
import fantasy_RPG.joueurs_ennemis;
import fantasy_RPG.soluces;

public class game_setting {


public static boolean diffverouillee = false;
private static String difficultes;
private static boolean modeBourrin = false;
private setting() {
}

public static void menu() {
	  while (true) {
	    	 
	       ui.cls();
	       ui.println("--------------------------------------------------------------------------------");
	       ui.println("                  ** Réglages **                                                ");
	       ui.println();
	       ui.println("1) Choisir sa difficulté (Actuellement " + difficultes + ".)");
	       ui.println("2) Difficulé verouillée " + difficultes);
	       ui.println("3) Soluces Verouillées ( Si vérouilées, tu ne pourras plus utiliser les astuces)");
	       ui.println("4) Fenêtre Pop'Up");
	       ui.println("5) Retour");
	       ui.println("--------------------------------------------------------------------------------");

	       switch (ui.getValidInt()) {
	          case 1:
	             switchDif();
	             break;
	          case 2:
	             diffBloquer();
	             break;
	          case 3:
	        	  solucebloquee();
	             break;
	          case 4:
	               if (ui.uiDispo) {
	                   ui.uiDispo = false;
	                   ui.msg("Popup disponible");
	               } else {
	                   ui.uiDispo = true;
	                   ui.msg("Popup non dispo");
	               }
	          break;
	          case 5:
	          return;
	       }//fin Switch
	   } // fin while
}//fin menu

public static void setDif(Object difficultes, boolean firstInit, boolean switchDif) {
	    
	    setConstants(difficultes, firstInit, switchDif);
	    
}

private static void switchDif() {
	       
	    if (diffverouillee) {
	        ui.msg("Difficultés validée. Vous ne pouvez plus revenir en arrière.");
	        return;
	    }

	    if (difficultes.equals("Facile")) {
	         setDif("Chaud Patate !", false, true);
	    } else {
	        setDif("Facile !", false, true);
	        }
	}//switchdif

private static void diffBloquer() {
	       
	    if (diffverouillee) {
	            ui.msg("Difficultés bloquées.");
	        return;
	    }

	    while (true) {
	         ui.cls();
	         ui.println("Est- tu sûr de vouloir confirmer cette " + difficultes + " ?\n"
	                    + "!");
	         ui.println("1) Continue");
	         ui.println("2) Annuler");
	        switch (ui.getValidInt()) {
	           case 1:
	                ui.msg("Diffuclté validée " + difficultes);
	                diffverouillee = true;
	           return;
	           case 2:
	           return;
	        }//fin Switch
	    }//fin while
	} //diffbloquer

private static void solucebloquee() {
	       
	    if (soluces.bloquer()) {
	        ui.msg("La soluce est verouillée ! ");
	        return;
	    }
	        
	    if (soluces.activer()) {
	        ui.msg("Les astuces sont déjà activée.");
	        return;
	    }

	    while (true) {
	        ui.cls();
	        ui.println("Etes tu sûr de verouiller petit tricheur ?");
	        ui.println("Tu ne pourras plus utiliser le mode Soluce après validation !");
	        ui.println("1) Continue");
	        ui.println("2) Annule");
	            
	        switch (ui.getValidInt()) {
	            case 1:
	                 ui.msg("Bloquée");
	                 soluces.bloquer();
	                 return;
	            case 2:
	                 return;
	        }
	     }//fin While
	  }// fin soluce bloquées


public static String getDif(boolean b, boolean c) {
	   return difficultes;
	}
	    
private static void setConstants(Object object, boolean firstInit, boolean changeDif) {
	if (object.equals("Facile")) {
	
//Var mode Facile
	//Enemies (nom, santé, goldrecolt, coindropmax, damagemin, damagemax, xp, firstinit)
	    jeux.darkElf = new joueurs_ennemis("Dark Elf", 45, 10, 15, 10, 15, 15, firstInit, changeDif);
	    jeux.ninja = new joueurs_ennemis("Ninja", 75, 5, 15, 5, 15, 15, firstInit, changeDif);
	    jeux.humain = new joueurs_ennemis("Humain", 35, 5, 10, 5, 10, 10, firstInit, changeDif);
	    jeux.Voleur = new joueurs_ennemis("Voleur", 20, 5, 15, 5, 15, 15, firstInit, changeDif);
	    jeux.goblin = new joueurs_ennemis("Goblin", 60, 10, 20, 10, 20, 20, firstInit, changeDif);
	  

	//Armes
	   //nom, utilise muni, muni incluse, achetable, prix, muni prix, level, chance lost, firstInit, changeDif)
	    jeux.poing = new equipement_armes("Poings", true, false, 0, 0, 5, 10, firstInit, changeDif);
	    jeux.epee = new equipement_armes("Epée", false, true, 170, 1, 10, 15, firstInit, changeDif);
	    jeux.lame = new equipement_armes("Couteau", false, true, 175, 2, 10, 20, firstInit, changeDif);
	    jeux.masse = new equipement_armes("masse", true, false, 0, 0, 5, 10, firstInit, changeDif);
	            
	//Prix
	    equipement_pouvoirs.prix = 25;
	    equipement_armes.JOURNAL_DEGATS = 10;
	    equipement_premiersSecours.prix = 5;
	    equipement_potion.svPrix = 10;
	    equipement_potion.restPrix = 20;
	    equipement_instaSante.prix = 30;
	    banque.setInteret(0.05);
	    joueurs_sante.setAugmPrix(100);

	//Régles des Niv requis
	    equipement_premiersSecours.level = 1;
	    equipement_potion.svPrix = 2;
	    equipement_potion.restPrix = 2;
	    equipement_instaSante.level = 3;
	    equipement_pouvoirs.level = 4;

	} else {
	
//Var mode chaud Patates
		  
	//Ennemis (Nom, sante, gold gagner, Golddropmax, degatmini, degatmax, xp, firstinit, changeDif)
	    jeux.darkElf = new joueurs_ennemis("Dark Elf", 55, 15, 20, 15, 20, 15, firstInit, changeDif);
	    jeux.ninja = new joueurs_ennemis("Ninja", 85, 10, 20, 10, 20, 15, firstInit, changeDif);
	    jeux.humain = new joueurs_ennemis("humain", 45, 10, 15, 10, 15, 10, firstInit, changeDif);
	    jeux.Voleur = new joueurs_ennemis("Voleur", 30, 10, 20, 10, 20, 15, firstInit, changeDif);
	    jeux.goblin = new joueurs_ennemis("Goblin", 70, 15, 25, 15, 25, 20, firstInit, changeDif);
	   
	 //Armes
	    jeux.poing = new equipement_armes("Poings", true, false, 0, 0, 5, 10, firstInit, changeDif);
	    jeux.epee = new equipement_armes("Epée", false, true, 170, 1, 10, 15, firstInit, changeDif);
	    jeux.lame = new equipement_armes("Couteau", false, true, 175, 2, 10, 20, firstInit, changeDif);
	    //jeux.pistolet = new equipement_armes("Epee magique", false, false, 0, 0, 5, 20, firstInit, changeDif);
	          
	 //Prix
	    equipement_pouvoirs.prix = 75;
	    equipement_armes.JOURNAL_DEGATS = 5;
	    equipement_premiersSecours.prix = 15;
	    equipement_potion.svPrix = 25;
	    equipement_potion.restPrix = 35;
	    equipement_instaSante.prix = 45;
	    banque.setInteret(0.10);
	    joueurs_sante.setAugmPrix(100);

	 //niveau minimum requis 
	    equipement_premiersSecours.level = 1;
	    equipement_potion.svNiveau = 2;
	    equipement_potion.svNiveau = 2;	
	    equipement_instaSante.level = 3;
	    equipement_pouvoirs.level = 4;

	} //fin if 
	
	if (firstInit) nouvPartieReg();
 }

//nouv partie reg
 private static void nouvPartieReg() {

	gold.set(50, false);
	equipement_premiersSecours.set(3, false);
	equipement_potion.set("Survie", 2, false);
	equipement_potion.set("Restauration", 2, false);
	joueurs_xp.setAll(0, 500, 1);
	jeux.sans.setPossede(true);
	jeux.sans.equipSilent();
 }// fin reglage nouvelle partie 


 //Méthode Mode Bourrin
 public static boolean getModeBourrin() {
	return modeBourrin;
 }

 
//Retourne le message que si le mode Dieu est activé
 public static String msgModeBourrin() {
	if (modeBourrin) {
			return "Mode bourrin activé\n";
	}	
	return "";
 } // fin msg ModeBourrin

	
 public static void toggleModeBourrin() {
	if (modeBourrin) {
		modeBourrin = false;
		ui.msg("Le Monde Dingo de Dieu est disponible !");
	} else {
		modeBourrin = true;
		ui.msg("Le Monde Dingo de Dieu est indisponible !");
	}

  }//Fin mode Bourrin

}
