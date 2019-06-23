package UI;



import Enemy.Enemy;

//--- UI - 
public abstract class UI {
	

	public static void playerCrit() {
	        System.out.println("Bravo ! Tu viens de fiare un coup critique ! (x2 Degat)");
	}

	public static void monsterCrit() {
	      	System.out.println("Ouch! L'enemi vient de te donner un coup critique " + "(x2 Ddegat)");
	}

	
	

	    

	

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