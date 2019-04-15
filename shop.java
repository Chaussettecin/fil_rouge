package fantasy_RPG;

import java.util.ArrayList;

public class boutique {
	 
private boutique() {

			/// --- Boutique 

				/// Permet au joueur d'acheter ou de vendre de l'equipements ou potions
}
	
	  public static void menu() {
	     while (true) {
	        ui.cls();
	        ui.println("  ------------------------------------------------------------------");
	        ui.println("                     *** la boutique ! ***                    		");
	        ui.println();
	        ui.println("Gold: " + gold.get());
	        ui.println("Kit de 1er soin : " + equipement_premiersSecours.get());
	        ui.println("Potions: " + (equipement_potion.get("survie") + equipement_potion.get("Récupération")));
	        ui.println();
	        ui.println("  -------------------------------------------------------------------");
	        ui.println("1) Sante");
	        ui.println("2) Armes");
	        ui.println("3) Armures");
	        ui.println("4) Propriétés");
	        ui.println("5) XP");
	        ui.println("6) Retour");
	     ui.println("  -------------------------------------------------------------------");
	            
	     switch (ui.getValidInt()) {
	        case 1:
	             sante();
	             break;
	        case 2:
	             armes();
	             break;
	        case 3:
	             armures();
	             break;
	        case 4:
	             proprietes();
	             break;
	        case 5:
	            xp();
	            break;
	        case 6:
	            return;
	        default:
	        	break;
	     } //fin Switch
	  } //fin while
	}//fin menu

	private static void sante() {
	     
		while (true) {
		 ui.cls();
	     ui.println("-------------------------------------------------------------------");
	     ui.println("                            *** Santé ***                          ");
	     ui.println();
	     npc.welcome("Santé");
	     ui.println();
	     ui.println("Golds : " + gold.get());
	     ui.println("Kit de 1er soins: " + equipement_premiersSecours.get());
	     ui.println(" - Potions: " + (equipement_potion.get("Survie") + equipement_potion.get("Restauration")));
	     ui.println(" - Santé totale: " + equipement_premiersSecours.get());
	     ui.println();
	     ui.println("-------------------------------------------------------------------");
	     ui.println("1) Kit de 1er soin  : ");
	     ui.println(" - Prix  :" + equipement_premiersSecours.prix + " Golds");
	     ui.println(" - Level :" + equipement_premiersSecours.level);
	     ui.println();
	     ui.println("2) Potion de survie : ");
	     ui.println(" - Prix - " + equipement_potion.restPrix + " Golds");
	     ui.println(" - Level - " + equipement_potion.restNiveau);
	     ui.println();
	     ui.println("3) Potion Restauration : ");
	     ui.println(" - Prix - " + equipement_potion.svPrix + " Golds");
	     ui.println(" - Level - " + equipement_potion.svNiveau);
	     ui.println();
	     ui.println("4) Santé totale : ");
	     ui.println(" - Prix - " + equipement_instaSante.prix + " Golds");
	     ui.println(" - Level - " + equipement_instaSante.level);
	     ui.println();
	     ui.println("5) Retour");
	     ui.println("------------------------------------------------");
	     switch (ui.getValidInt()) {
	       case 1:
	    	   ui.cls();
	         	equipement_premiersSecours.achat();
	            npc.gratitude("Santé", "Acheter");
	            break;
	       case 2:
	    	   ui.cls();
	           	equipement_potion.achat("Potion de Survie");
	            npc.gratitude("Santé", "Acheter");
	            break;
	       case 3:
	    	  	ui.cls();
	        	equipement_potion.achat("Restauration");
	            npc.gratitude("Santé", "Acheter");
	            break;
	      	case 4:
	    	  	ui.cls();
	      		equipement_instaSante.achatBoost();
	      		npc.gratitude("Santé", "Acheter");
	      		break;
	      	case 5:
	    	  	return;
	      	default:
	    		break;
	    
	    }//fin switch
	  }//fin while
	}//fin sante
	
//Categories armes	
	private static void armes() {
	  while (true) {
	    ui.cls();
	  	ui.println("-------------------------------------------------------------------");
	    ui.println("                           *** Armes  ***                           ");
	    ui.println();
	    npc.welcome("Armes");
	    ui.println();
	    ui.println("Gold: " + gold.get());
	    ui.println("Level: " + joueurs_xp.getLevel());
	    ui.println();
	    ui.println("-------------------------------------------------------------------");
	    
	    int j = 0;
	    int[] offset = new int[equipement_armes.arrayArmes.size()];
	    for (int i = 0; i < equipement_armes.arrayArmes.size(); i++) {
	      equipement_armes.arrayArmes.get(i);
		if (equipement_armes.arrayArmes.get(i).estAchetable()) {
	       ui.println((j + 1) + ") " + equipement_armes.arrayArmes.get(i).getNom());
	       ui.println(" $$ Prix : " + equipement_armes.arrayArmes.get(i).prix);
	       ui.println(" ** Level : " + equipement_armes.arrayArmes.get(i).level);
	       offset[j] = i - j;
	       j++;
	       ui.println();
	       
		
		}//fin if
	   }//fin for
	    
	   ui.println((j + 1) + ") Pouvoirs : ");
	   ui.println(" $$ Prix  : " + equipement_pouvoirs.prix);
	   ui.println(" ** Level  : " + equipement_pouvoirs.level);
	   ui.println();
	   ui.println((j + 2) + ") Munitions");
	   ui.println();
	   ui.println((j + 3) + ") Retour");

	   while (true) {
	      
		 int menuObjets = ui.getValidInt();
	            
	     try { 
	    	 //choix d'autres options dnas un tab
	        if (menuObjets == (j + 1))
	        	equipement_pouvoirs.achats();
	        if (menuObjets == (j + 2))
	             acheterMuni();
	        if (menuObjets == (j + 3) || menuObjets > j)
	        	return;

	     menuObjets--;
	     menuObjets = menuObjets + offset[menuObjets];

	     //resultats
	     equipement_armes.arrayArmes.get(menuObjets);
	     return;

	     } catch (Exception e) {
	         ui.println();
	         ui.println(menuObjets + "Ceci n'est pas une option.");
	     }
	   }//fin while
	  }
	}//fin armes

	private static void xp() {
	    
		boolean valid;
	       
	    while (true) {
	       if (joueurs_xp.getLevel() == 100) {
	         ui.msg("Tu ne peux pas touché les étoiles ! Doucement - Doucement.");
	         return;
	    }

	    ui.cls();
	    ui.println("-------------------------------------------------------------------");
	    ui.println("                                *** XP ***                               ");
	    ui.println();
        npc.welcome("XP");
	    ui.println();
	    ui.println("Level : " + joueurs_xp.getLevel());
	    ui.println("XP : " + joueurs_xp.getFull());
        ui.println("Golds : " + gold.get());
        ui.println();
	    ui.println("Tu peux acheter de l'XP pour 1 Gold. Tu en voudrais combien ?");
	    ui.println("**(0) pour retourner en arrière**");
	    ui.println("-------------------------------------------------------------------");

	    int achat = ui.getValidInt();
	    valid = true;
	      
	  //Tests les situations     
	     if (achat > gold.get()) {
	    	 //Si pas assez d'argent
	         ui.msg("Tu n'as pas assez d'argent !");
	         valid = false;
	       }
	            
	     if (joueurs_xp.getLevel() == 100) {
	         ui.msg("GOURMAND ! Tu as déjà le niveau maximum du jeu.");
	         valid = false;
	     }
	            
	     if (achat < 0) {
	        ui.msg("Pourquoi acheter un montant négatif d'XP.. Essayes encore ! ;)");
	         valid = false;
	     }
	            
	     if (achat == 0) {
	        return;
	     }

	     if (valid) {
	       ui.msg("Tu viens d'investir " + achat + " xp.");
	       
	       //resultats
	       joueurs_xp.set(achat, true);
	       gold.set(-achat, true);
	       stats.xpAchetes += achat;
	       npc.gratitude("XP", "Acheter");
	    
	     }//fin if
	 }// fin while
}//fin XP

//munitions
private static <armes> void acheterMuni() {
	while (true) {
	   ui.cls();
	   ui.println("-------------------------------------------------------------------");
	   ui.println("                            *** Munitions ***                       ");
	   ui.println();
	   ui.println("Gold : " + gold.get());
	   ui.println("Level : " + joueurs_xp.getLevel());
	   ui.println();
	   ui.println("-------------------------------------------------------------------");
	           
	   ArrayList<armes> armesValidees = new ArrayList<armes>();
	   for (int i = 0; i <equipement_armes.arrayArmes.size(); i++) {
	      if (equipement_armes.arrayArmes.get(i).estAchetable() && !equipement_armes.arrayArmes.get(i).contact && equipement_armes.arrayArmes.get(i).possede()) {
	        ui.println((armesValidees.size() + 1) + ") " + equipement_armes.arrayArmes.get(i).getNom());
	        ui.println("Prix : " + equipement_armes.arrayArmes.get(i).getMunitionsprix());
	        ui.println("Level: " + equipement_armes.arrayArmes.get(i).level);
	        armesValidees.add( (armes) equipement_armes.arrayArmes.get(i));
	      }//fin if
	  }//fin for
	  
	 ui.println((armesValidees.size() + 1) + ") Retour");
	         	
	  while (true) {
	   
	     int menuObjets = ui.getValidInt();
	    	 
	     try {
	       ((equipement_armes) armesValidees.get(menuObjets - 1)).acheterMunitions();
	       npc.gratitude("Armes", "Acheter");
	       break;
	          
	     } catch (Exception e) {
	        	   
	       if (menuObjets == (armesValidees.size() + 1)) {
	          return;
	       } //fin if
	        	   
	       ui.println();
	       ui.println(menuObjets + "Oupss ! Ceci n'est pas une option !");
	       ui.pause();
	       ui.cls();
	      
	     }//fin catch
	    }//fin while
	  } //fin while 1
	}//fin achat munitions
	 
	private static void proprietes(){
	  while (true){
		  ui.cls();
	      ui.println("________________________________________________");
	      ui.println("                --- Propriétés ---              ");
	      npc.welcome("*** Propriétés : ");
	      ui.println("Level: " + joueurs_xp.getLevel());
	      ui.println("Argent: " + gold.get());
	      ui.println("________________________________________________");
	         
	      ui.pause();
            
	      return;
	   }
	}
	
	
//Partie Armures	
	private static void armures() {
	 while (true) {
	     ui.cls();
	     ui.println("-------------------------------------------------------------------");
	     ui.println("                         *** Armures ***                           ");
	     ui.println();
	     npc.welcome("Armures");
	     ui.println();
	     ui.println("Golds : " + gold.get());
	     ui.println("Level : " + joueurs_xp.getLevel());
	     ui.println();
	     ui.println("-------------------------------------------------------------------");
	            
         int j = 0;
         int[] armuresBoutique = new int[equipement_armure.getarmures().size()];
	     for (int i = 0; i < equipement_armure.getarmures().size(); i++) {
	         if (equipement_armure.getarmures().get(i).getPrix() != 0) {
	              ui.println((j + 1) + ") " + equipement_armure.getarmures().get(i).getNom());
	              ui.println("   Prix : " + equipement_armure.getarmures().get(i).getPrix());
	              ui.println("   Level : " + equipement_armure.getarmures().get(i).getLevel());
	              armuresBoutique[j] = i - j;
	              j++;
	              ui.println();
	        }//fin if
	     }//fin for
	     ui.println((j + 1) + ") Retour");

	     while (true) {
	          
	    	 int menuObjets = ui.getValidInt();
	          
	         try {

	       //Choix des options differentes:
	          if (menuObjets == j + 1 || menuObjets> j)
	                 return;

	          //retour en arrière amures 
	           menuObjets--;
	           menuObjets = menuObjets + armuresBoutique[menuObjets];

	         //Resultats
	           equipement_armure.getarmures().get(menuObjets).achat();
	           return;

	         } catch (Exception e) {
	             ui.println();
	             ui.println(menuObjets + "Oupss! Ceci n'est pas une option !");
	         }
	     }
	   } //fin while
	}// fin classearmures
}