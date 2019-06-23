package Utils;

import java.util.ArrayList;

import Inventory.ArmesDistance;
import Inventory.ArmesMelees;
import Inventory.Sort;
import Inventory.Armure;
import Perso.Perso;
import Player.Player;
import UI.UI;


//--- Utilitaire du jeu -- 
public class utilsGame {

//Thread -- 
	public static void sleep(int milliseconds) {
	    
		try {
	      Thread.sleep(milliseconds);
	    
		} catch(InterruptedException ex) {
	      Thread.currentThread().interrupt();
	    
		}
	}

//-- Methode random -- 
	public static int random(int min, int max){
	    return (int) (Math.random() * (max - min) + min);
	}

	
	public static String toCamelCase(String s){
	    
		String[] parts = s.split(" ");
	    String camelCaseString = "";
	    
	    for (String part : parts){
	      camelCaseString += part.substring(0, 1).toUpperCase() + part.substring(1).toLowerCase();
	    }
	    
	    return camelCaseString.substring(0, 1).toLowerCase() + camelCaseString.substring(1);
	}

	
	public static String monsterAdjective() {
	    
		String[] adjectives = {"dirty", "rusty", "old", "average looking", "cursed", "mighty", "misshapen", "shiny", "funny looking", "bloody", "acid bitten", "scary looking", "blasphemous"};
	    return adjectives[random(0,adjectives.length)];
	}

	public static String playerAdjectives() {
	    
		String[] adjectives = {"average looking", "epic", "ancient", "whispering", "bloodthirsty", "Legendary", "super duper", "mighty", "seal destroying", "bug murdering", "bugbear ending", "St. Geschwindigkeitsbegrenzung's, the patron saint of speed limits", "holy", "bad-ass", "LENGENDARALLY EPIC"};
	    return adjectives[utilsGame.random(0,adjectives.length)];
	}


	public static void shop(Perso j, ArrayList<ArmesMelees> armesMelees,
							ArrayList<ArmesDistance> arrayList,
							ArrayList<Sort> sorts, ArrayList<Armure> armures) {
		// TODO Auto-generated method stub
		
	}

	
	/*public static void shop(perso perso, ArrayList<armes_melees> armesMelees, 
		
		ArrayList<armes_distances> armesDistances, ArrayList<armes_sorts> sorts, 
		ArrayList<armures> armure) {
		
			ArrayList<String> mainMenu = new ArrayList<String>();
	    
			if(armes_melees.getAll() > 0) {
				mainMenu.add("Armes de Melées");
			}
	    
			if(armesDistances.size() > 0) {
				mainMenu.add("Armes de Distances");
			}
	    
			if(sorts.size() > 0) {
				mainMenu.add("Sorts");
			}
	    
			if (armure.size() > 0) {
				mainMenu.add("Armures");
			}
	    
			mainMenu.add("Rien, ceci est une arnaque!");
	    
			int choix = -1;
	   
			do {
	      
	    	choix = UI.menu("What would you like to purchase with your " + Integer.toString(p.getGP()) + "GP?", mainMenu);
	      
	    	if(mainMenu.get(choix).equals("Armes de Melée")) {
	        
	    		ArrayList<String> attaques = new ArrayList<String>();
	        
	    		for(int i = 0; i < armesMelees.size(); i++) {
	    			
	    			String next = armesMelees.get(i) + "\n\t" + Integer.toString(armesMelees.get(i).getPrix()) + "gp " + Integer.toString(armesMelees.get(i).getDice()) + "d6";
	          
	    			if(armesMelees.get(i).getAdd() > 0) {
	    				next += " + " + Integer.toString(armesMelees.get(i).getAdd());
	    			}
	    			else if(armesMelees.get(i).getAdd() < 0) {
	    				next += " - " + Integer.toString(Math.abs(armesMelees.get(i).getAdd()));
	    			}
	    			
	          attaques.add(next);
	        }
	    		
	        attaques.add("RIEN");
	        
	        int buying = UI.menu("what would you like to buy with your " + Integer.toString(p.getGP()) + "GP?", attaques);
	        
	        	if(buying == armesMelees.size()) {
	        		UI.out.println("Fine! be like that!");
	        	}
	        	
	        	else if(armesMelees.get(buying).getPrix() <= perso.getGold()) {
	        		
	        		perso.getArmure().add(armesMelees.get(buying));
	        		perso.setGold(perso.getGOld() - armesMelees.get(buying).getPrix());
	        	}
	        	else {
	          
	        		UI.out.println("Désolé ! Nous n'avez pas assez de gold!");
	        	}
	      }
	      else if(mainMenu.get(choix).equals("Armes à distance ")) {
	       
	    	  ArrayList<String> attacks = new ArrayList<String>();
	    	  
	    	  for(int i = 0; i < armesDistances.size(); i++) {
	    		  String next = armesDistances.get(i) + "\n\t" + Integer.toString(armesDistances.get(i).getPrix()) + "gp " + Integer.toString(armesDistances.get(i).getDice()) + "d6";
	    		  
	    		  if(armesDistances.get(i).getAdd() > 0) {
	    			  next += " + " + Integer.toString(armesDistances.get(i).getAdd());
	    		  } else if(armesDistances.get(i).getAdd() < 0) {
	    			  next += " - " + Integer.toString(Math.abs(armesDistances.get(i).getAdd()));
	    		  }
	         
	    		  if(armesDistances.get(i).aDeuxMains()) {
	    			  next += "Armes à deux mains !";
	    		  }
	    		  attacks.add(next);
	    	  }	
	    	  
	    	  attacks.add("Rien");
	    	  int buying = UI.menu("what would you like to buy with your " + Integer.toString(p.getGP()) + "GP?", attacks);
	    	 
	    	  if(buying == armesDistances.size()) {
	    		  UI.out.println("Fine! be like that!");
	       
	    	  } else if (armesDistances.get(buying).getPrix() <= perso.getGold()) {
	          //perso.getutiliserArmesDistance.add(armesDistances.get(buying));
	          perso.setGold(perso.getGold() - armesDistances.get(buying).getPrix());
	        }
	        else {
	          UI.out.println("Désolé ! Nous n'avez pas assez de gold!");
	        }
	      }
	      else if(mainMenu.get(choix).equals("Sorts")) {
	        ArrayList<String> attacks = new ArrayList<String>();
	        for(int i = 0; i < sorts.size(); i++) {
	          String next = sorts.get(i) + "\n\t" + Integer.toString(sorts.get(i).getPrix()) + "gp " + Integer.toString(sorts.get(i).getDice()) + "d6";
	          if(sorts.get(i).getAdd() > 0) {
	            next += " + " + Integer.toString(sorts.get(i).getAdd());
	          }
	          else if(sorts.get(i).getAdd() < 0) {
	            next += " - " + Integer.toString(Math.abs(sorts.get(i).getAdd()));
	          }
	          if(sorts.get(i).aDeuxMains()) {
	            next += " Deux mains";
	          }
	          attacks.add(next);
	        }
	        attacks.add("nothing");
	        int buying = UI.menu("what would you like to buy with your " + Integer.toString(p.getGP()) + "GP?", attacks);
	        if(buying == sorts.size()) {
	          UI.out.println("Fine! be like that!");
	        }
	        else if(sorts.get(buying).getPrix() <= perso.getGold()) {
	          perso.getSort.add(sorts.get(buying));
	          perso.setGold(perso.getGold() - sorts.get(buying).getPrix());
	        }
	        else {
	          UI.out.println("Sorry, you don't have enough GP to buy that!");
	        }
	      }
	      else if (mainMenu.get(choix).equals("Armure ")){
	        
	    	  ArrayList<String> defense = new ArrayList<String>();
	        
	    	  for (int i = 0; i < armure.size(); i++){
	    		  String next = armure.get(i) +"\n\t" + Integer.toString(armure.get(i).getPrix()) + "Gold " + Integer.toString(armure.get(i).getDefence) + "defense points";
	    		  
	    		  if(armure.get(i).descriptionArmures() > 0) {
	    			  next += " -" + Integer.toString(armure.get(i).descriptionArmures()) + "de Dextérité";
	    		  }}
	        }
	       
	        defense.add("Rien");
	       
	        int buying = UI.menu("Qu'est ce que vous voulez ? " + Integer.toString(perso.getGold()) + "Gold?", defense);
	        
	        if(buying == armure.size()) {
	        	UI.out.println("Ok! si tu veux !");
	        }
	        
	        else if(armure.get(buying).getPrix() <= perso.getGold()) {
	          
	        	perso.getArmure().add(armure.get(buying));
	        	perso.setGold(perso.getGold() - armure.get(buying).getPrix());
	        }
	        
	        else {
	          UI.out.println("Desolée ! La maison ne fait pas crédit. ");
	        }
	      
	      }
	    	
	    } while(!mainMenu.get(choix).equals("Rien, ceci est une anarque !"));*/
}

