package ui;

import Player.Player;
import enemys.enemy;
import inventory.Item;
import main.Game;
import maps.Dungeon;
import maps.Room;
import perso.perso;



import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//--- UI - 
public abstract class UI {

	 public static void playerCrit() {
	        System.out.println("Nice! You landed a critical hit! (x2 Damage)");
	    }

	    
	 public static void monsterCrit() {
	        
		 System.out.println("Ouch! The monster landed a critical hit! " + "(x2 Damage)");
	    }

// --- Affichage Statistique du joueur  --- 
	    public static boolean displayPlayerStats(String name, String description,int maxHitPoints, int minDamage, 
	    											int maxDamage, int defense, double critChance) {
	        
	    	System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
	                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
	                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	        System.out.println(name);
	        System.out.println("-------");
	        System.out.println(description);
	        System.out.println();
	        System.out.println("MAX HP: " + maxHitPoints);
	        System.out.println();
	        System.out.println(
	                "ATTACK: " + minDamage + "-" + maxDamage);
	        System.out.println();
	        System.out.println("DEFENSE(Scale:1-5): " + defense);
	        System.out.println();
	        System.out.println("CRIT CHANCE: " + critChance + "%");
	        System.out.println();
	        System.out.println("ARE YOU SURE YOU WANT TO PLAY AS A "
	                + name.toUpperCase() + "? "
	                + "(y/n)");
	        System.out.println();
	        System.out.println();
	        System.out.println();
	        if (Game.USERINPUT.nextLine().equals("y")) {
	            return true;
	        } else {
	            return false;
	        }
	    }

	    
	    public static void credits() {
	        
	    	System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
	                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	        System.out.println("--- Jeux réalisé par Fabrice, Muriel et cindy --- ");
	        System.out.println(".");
	        System.out.println("Veux tu retourner au menu principal ? (y/n)");
	        
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

	    

	
	    
//--- Introduction d'un combat 
	    public static void battleIntro(Player player, Room room) {
	        
	       // System.out.println("Tu arrives dans la salle [" + player.getCurrX() + "]["
	               // + player.getCurrY() + "]");
	        System.out.println("Tu rentres dans une salle et tu tombe sur...");
	        System.out.println(room.getDescription() + "\n\n");
	        System.out.println("Nombre de Cultiste: " + room.getNumOfMonsters());
	        System.out.println("Ton combat avec  " + room.getMonster().getNom()
	                + " commence.\n");
	    }

	    
	    public static void battle(perso Perso, enemy Enemy, Room room) {
	        
	    	List<Item> inventaire = Perso.getItem();
	    	
	        while (Perso.isKO() && Enemy.isKO()) {
	            
	        	System.out.println("\nEnemy points de vie : " + Enemy.getSante()
	                    + "    " + "Perso points de vie : " + Perso.getSante());
	            
	        	System.out.println("");
	        	System.out.println("----------------------------------");
	            System.out.print("\nAttaquer (a)   Soigner (h)");
	            
	            String action = Game.USERINPUT.nextLine();
	            
	            if (action.equals("a")) {
	                
	            	Enemy.defend(Perso);
	                
	            	if (Enemy.isKO()) {
	            		Perso.defend(Enemy);
	                }
	            
	            } else if (action.equals("h")) {
	                
	            	boolean potionExists = false;
	                
	            	if (!inventaire.isEmpty()) {
	                    
	            		for (int i = 0; i < inventaire.size(); i++) {
	                        potionExists = false;
	                        
	                        if (inventaire.get(i).getName().equals("Potion")) {
	                        	Perso.heal(inventaire.get(i));
	                            potionExists = true;
	                            break;
	                        }
	                    
	            		}
	                }
	            	
	                if (potionExists == false) {
	                    System.out.println("Tu est fatigué... une sieste ou une potion ? "
	                            + "potions!");
	                    battle(Perso, Enemy, room);
	                }
	                if (Enemy.isKO()) {
	                	Perso.defend(Enemy);
	                }
	            }
	        }
	        if (!perso.isKO()) {
	            System.out.println(" GAME OVER !!");
	        } else if (!Enemy.isKO()) {
	            System.out.println("L'ennemi à été vaincu!");
	            System.out.println("--------------------------------\n");
	        }

	    }

// --- Frappe - - 
	    public static void persoAttaqueMsg(int degat, enemy Enemy) {
	        System.out.println("Oupss... " +  Enemy.getNom() + " vient de te frapper en te faisant "
	                + degat + " dégats.");
	    }

	    
	    public static void enemyAttaqueMsg(enemy Enemy) {
	        System.out.println("Tu viens de toucher " + Enemy.getNom());
	    }
	    
//--- soin -- 
	    public static void heal(int hitPoints) {
	        System.out.println("Tu viens de boire une potion tu gagnes, 20 points!");
	        System.out.println("Point de vie : " + hitPoints);
	    }

}