package UI;

import Player.Player;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Enemy.Enemy;
import Inventory.Item;
import Main.Game;
import Perso.Perso;


//--- UI - 
public abstract class UI {
	
	   
	public static void welcome() {
	        
		   System.out.println("");
	       System.out.println("        ****              ");
	       System.out.println();
	       System.out.println("     Bienvenue Joueur...  ");
	       System.out.println(" ");
	       System.out.println("   --------------------   ");
	       System.out.println();
	       System.out.println("        ** MENU **        ");
	       System.out.println("          ******          ");
	       System.out.println();
	       System.out.println();
	       System.out.println(" 1.    Nouveau Joueur     ");
	       System.out.println();
	       System.out.println(" 2.      Sauvegarde       ");
	       System.out.println();
	       System.out.println(" 3.    	  Aide           ");
	       System.out.println();
	       System.out.println(" 4.      Settings         ");
	       System.out.println();
	       System.out.println(" 5.      Credits          ");
	       System.out.println();
	       System.out.println(" 6.    Quitter le jeu     ");
	       System.out.println();
	       System.out.print(" Fais ton choix : ");
	       System.out.println();
	    }


	public static void newGameIntroduction() {
	        
		   	System.out.println("");
	        System.out.println(             "*****"                     );
	        System.out.println("");
	        System.out.println(        "------------------"             );
	        System.out.println();
	        System.out.println("        Voici la fine équipe"       	);
	        System.out.println();
	        System.out.println();
	        System.out.println("             ******                	"	);
	        System.out.println("   Sidney Fox - Humaine - Voleuse"  	);
	        System.out.println();
	        System.out.println("    1 - Plus d'information sur Sid "    );
	        System.out.println();
	        System.out.println("             ******                "	);
	        System.out.println("   Fes Forelash - Orc - Guerrier"   	);
	        System.out.println();
	        System.out.println("    2 - Plus d'information sur Fes "    );
	        System.out.println();
	        System.out.println("             ******                "	);
	        System.out.println("   Hatachar Godeth - Elfe - Sorcier" 	);
	        System.out.println(); 
	        System.out.println("    2 - Plus d'information sur Hatachar ");
	        System.out.println();
	        System.out.println("             ******                	"	);
	        System.out.println("   Jissi LightCat - Naine - Assassin" 	);
	        System.out.println(); 
	        System.out.println("    3 - Plus d'information sur Jiss "   );
	        System.out.println();
	        System.out.println();
	        System.out.print(   "Les présentation sont presques faites" );
	        System.out.println();
	        System.out.print(		"Prêt(e) pour l'aventure ?"         );
	        System.out.println();
	        System.out.println(					"(y/n)"                 );
	        
	        if (Game.USERINPUT.nextLine().equals("y")) {
	        	//Lancement du jeu
	        	//Maps and co
	        	//-- Voir avec Fabrice
	        }
	        
	}
	   
	
	public static void playerCrit() {
	        System.out.println("Bravo ! Tu viens de fiare un coup critique ! (x2 Degat)");
	}

	public static void monsterCrit() {
	      	System.out.println("Ouch! L'enemi vient de te donner un coup critique " + "(x2 Ddegat)");
	}

	
	public static void credits() {
	        
	    	System.out.println("");
	        System.out.println("--- Jeux réalisé par Fabrice, Muriel et Cindy --- ");
	        System.out.println(".");
	        System.out.println("Retour au menu principal ? (y/n)");
	        
	        if (Game.USERINPUT.nextLine().equals("y")) {
	        	Game.mainMenu();
	        }
	}
	    

	/*public static void movePlayer(Player player) {

	        if (Dungeon.isNorthDirection() == true) {
	            System.out.println("North (n)\n");
	        }
	        if (Dungeon.isSouthDirection() == true) {
	            System.out.println("South (s)\n");
	        }
	        if (Dungeon.isEastDirection() == true) {
	            System.out.println("East (e)\n");
	        }
	        if (Dungeon.isWestDirection() == true) {
	            System.out.println("West (w)\n");
	        }

	        System.out.print("Where would you like to travel?: ");
	        String selection = Game.USERINPUT.nextLine();
	       
	       /* if (selection.equals("n") && Dungeon.isNorthDirection()) {
	            player.setCurrY(player.getCurrY() + 1);
	        } else if (selection.equals("s") && Dungeon.isSouthDirection()) {
	            player.setCurrY(player.getCurrY() - 1);
	        } else if (selection.equals("e") && Dungeon.isEastDirection()) {
	            player.setCurrX(player.getCurrX() + 1);
	        } else if (selection.equals("w") && Dungeon.isWestDirection()) {
	            player.setCurrX(player.getCurrX() - 1);
	        }*/


//--- Introduction d'un combat --
	   /* public static void battleIntro(Player player) {
	        
	       // System.out.println("Tu arrives dans la salle [" + player.getCurrX() + "]["
	               // + player.getCurrY() + "]");
	        System.out.println("Tu rentres dans une salle et tu tombe sur...");
	        System.out.println(room.getDescription() + "\n\n");
	        System.out.println("Nombre de Cultiste: " + room.getNumOfMonsters());
	        System.out.println("Ton combat avec  " + room.getMonster().getNom(null)
	                + " commence.\n");
	    }*/

	    
	/* 
	public static void battle(Perso Perso, Enemy Enemy) {
	        
	    List<Item> inventaire = Perso.getInventaire(null);
	    	
	    while (Perso.isKO() && Enemy.dead) {
	            
	        	System.out.println("\nEnnemi points de vie : " + Enemy.getPtv()
	        				+ "    " + "Perso points de vie : " + Perso.getPtv());
	        	System.out.println("");
	        	System.out.println("----------------------------------");
	        	System.out.println("");
	            System.out.print("\nAttaquer (a)   Soigner (h)");
	            
	            String action = Game.USERINPUT.nextLine();
	            
	            if (action.equals("a")) {
	                
	            	Enemy.attaqueBase(Perso);
	                
	            	if (Enemy.dead) {
	            		Perso.defend(Enemy);
	                }
	            
	            } else if (action.equals("h")) {
	                
	            	boolean potionExists = false;
	                
	            	if (!inventaire.isEmpty()) {
	                    
	            		for (int i = 0; i < inventaire.size(); i++) {
	                        potionExists = false;
	                        
	                        if (inventaire.get(i).getNom().equals("Potion")) {
	                        	Perso.setPtv(inventaire.get(i));
	                            potionExists = true;
	                            break;
	                        }
	                    
	            		}
	                }
	            	
	                if (potionExists == false) {
	                    System.out.println("Tu est fatigué... une sieste ou une potion ? "
	                            + "potions!");
	                    battle(Perso, Enemy);
	                
	                }
	                
	                if (Enemy.dead) {
	                	Perso.getAttaque(Enemy);
	                }
	            }
	        }
	    
	        if (!Perso.isKO()) {
	            System.out.println(" GAME OVER !!");
	        
	        } else if (!Enemy.dead) {
	            System.out.println("L'ennemi à été vaincu!");
	            System.out.println("");
	            System.out.println("-------------------------\n");
	        }

	    }*/

	 public static void persoAttaqueMsg(int degat, Enemy Enemy) {
	        System.out.println("Oupss... " +  Enemy.getNom() + 
	        		" vient de te frapper en te faisant " + degat + " dégats.");       
	 }

	 public static void enemyAttaqueMsg(Enemy Enemy) {
	        System.out.println("Tu viens de toucher " + Enemy.getNom());
	 }
	    
	 public static void msgSoin(int hitPoints) {
	        System.out.println("Tu viens de boire une potion tu gagnes, 20 points!");
	        System.out.println("Point de vie : " + hitPoints);
	 }

}