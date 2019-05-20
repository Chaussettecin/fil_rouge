package perso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


import Shop.Shop;
import inventory.Equipment;
import inventory.Inventory;
import inventory.Item;


import resource.Statistics;
import resource.Util;
import ui.UI;
import inventory.armes_distances;
import inventory.armes_distances_creation;
import inventory.armes_melees;
import inventory.armes_melees_creation;
import inventory.armes_sorts;
import inventory.armures;
import inventory.armures_creation;
import perso.Player;
import save.Settings;

public class Player  {

	public static final String Inventory = null;

	private int id; 
	
//-- Le reglage du joueur-
    public Settings settings = new Settings();

    public Player(String id) {
      
    	   System.out.println("Quel est votre nom Humain?");
    	    	String name = ui.UI.in.nextLine();
    	    
    	    if (name.toLowerCase().equals("Monsieur Fitz")) {
    	      
    	    	//Util.sleep(1000);
    	      UI.out.println("Qu'est qui vous aménes?");
    	     // utils.sleep(2000);
    	      UI.out.println("De trouver le Saint Graal!");
    	      //utils.sleep(2000);
    	      UI.out.println("Quoi...");
    	     // utils.sleep(1000);
    	      UI.out.print("est la Capital d'Assyria?");
    	      //utils.sleep(1000);
    	      UI.out.println("");
    	      UI.out.println("Je ne sais pas ce que c'est!");
    	      //utils.sleep(100);
    	      UI.out.println("AGGHHHHHHHHHHH");
    	      //utils.sleep(1000);
    	      System.exit(0);
    	    }

    	   ArrayList<Integer> stats = new ArrayList<Integer>();
    	    
    	    for (int i = 0; i < 8; i++){
    	      stats.add(random());
    	    }
    	    Collections.sort(stats);
    	    Collections.reverse(stats);

    	    int Taille = 0;
    	    int Constitution = 0;
    	    int Dexterite = 0;
    	    int Vitesse = 0;
    	    int Magie = 0;
    	    int Intelligence = 0;
    	    int Chance = 0;
    	    int Charisme = 0;
    	    int SoinC = 0;

    	    ArrayList<inventory.armes_distances> ArmesDistances = new ArrayList<inventory.armes_distances>();
    	    ArrayList<inventory.armes_melees> ArmesMelees = new ArrayList<inventory.armes_melees>();
    	    ArrayList<inventory.armes_sorts> Sorts = new ArrayList<inventory.armes_sorts>();
    	    ArrayList<inventory.armures> Armures = new ArrayList<inventory.armures>();
    	   
    	    ArrayList<String> classes = new ArrayList<String>(Arrays.asList(new String[]{"Rogue", "Guerrier", "Magie", "Bourrin"}));
    	    
    	    int classeChoix = ui.UI.menu("Choisis ta classe", classes);

    	    switch(classeChoix) {
    	     
    	    case 0:
    	        Dexterite = stats.remove(0);
    	        Taille = stats.remove(0);
    	        Intelligence = stats.remove(0);
    	        Chance = stats.remove(0);
    	        Collections.shuffle(stats);
    	        Charisme = stats.remove(0);
    	        Magie = stats.remove(0);
    	        Vitesse = stats.remove(0);
    	        Constitution = stats.remove(0);
    	        SoinC = 0;
    	        break;
    	     
    	      case 1:
    	    	Taille = stats.remove(0);
    	        Dexterite = stats.remove(0);
    	        Constitution = stats.remove(0);
    	        Vitesse = stats.remove(0);
    	        Intelligence = stats.remove(stats.size()-1);
    	        Collections.shuffle(stats);
    	        Charisme = stats.remove(0);
    	        Magie = stats.remove(0);
    	        Chance = stats.remove(0);
    	        SoinC = 0;
    	        break;
    	      
    	      case 2:
    	    	Magie= stats.remove(0);
    	        Intelligence = stats.remove(0);
    	        Chance = stats.remove(0);
    	        Collections.shuffle(stats);
    	        Constitution = stats.remove(0);
    	        Taille = stats.remove(0);
    	        Dexterite = stats.remove(0);
    	        Charisme = stats.remove(0);
    	        Vitesse = stats.remove(0);
    	        SoinC = 0;
    	        break;
    	      
    	      case 3:
    	        Constitution= stats.remove(0);
    	        Taille= stats.remove(0);
    	        Intelligence= stats.remove(0);
    	        Collections.shuffle(stats);
    	        Magie= stats.remove(0);
    	        Charisme = stats.remove(0);
    	        Chance = stats.remove(0);
    	        Vitesse = stats.remove(0);
    	        Dexterite= stats.remove(0);
    	        SoinC = 5;
    	        break;
    	    }

    	    ui.UI.out.println("Tes Stats :");
    	    ui.UI.out.println("taille:\t" + Taille);
    	    ui.UI.out.println("const:\t" + Constitution);
    	    ui.UI.out.println("dext:\t" + Dexterite);
    	    ui.UI.out.println("vitesse:\t" + Vitesse);
    	    ui.UI.out.println("magie:\t" + Magie);
    	    ui.UI.out.println("intel:\t" + Intelligence);
    	    ui.UI.out.println("chance:\t" + Chance);
    	    ui.UI.out.println("char:\t" + Charisme);
    }

    	  Player joueur = new Player(
    	    				
    		new inventory.armes_melees[]{}, 
    		new inventory.armes_distances[]{}, 
    		new inventory.armes_sorts[]{}, 
    	    new inventory.armures[]{},

    	    //ArrayList<inventory.armes_melees> tempMelee = armes_melees_creation.getAll();
    	    	
    	    	//for(int i = 0; i < tempMelee.size(); i++) {
    	    		//if(tempMelee.get(i).peutUtiliser(j)) {
    	    			//ArmesMelees.add(tempMelee.get(i));
    	    		//}
    	    	//}
    	    	
    	   ArrayList<inventory.armes_distances> tempRanged = armes_distances_creation.getAll();
    	   
    	   for(int i = 0; i < tempRanged.size(); i++) {
    	      if(tempRanged.get(i).peutUtiliser(j)) {
    	    	  arme.add(tempRanged.get(i));
    	      }
    	    }
    	    
    	   ArrayList<inventory.armes_sorts> tempSorts = armes_sorts.getAll();
    	    
    	   for(int i = 0; i < tempSorts.size(); i++) {
    	      if(tempSorts.get(i).canUse(j)) {
    	        tempSorts.add(tempSorts.get(i));
    	      }
    	    }
    	    ArrayList<inventory.armures> tempArmures = armures_creation.getAll();
    	    for(int i = 0; i < tempArmures.size(); i++) {
    	      if(tempArmures.get(i).canUse(j)) {
    	        tempArmures.add(tempArmures.get(i));
    	      }
    	    }
			

    	  /*  switch (classeChoix) {
    	      case 0:
    	        Shop.shop(j, ArmesMelees, ArmesDistances, tempSorts, Armures);
    	        break;
    	      case 1:
    	    	  Shop.shop((j, ArmesMelees, ArmesDistances, new ArrayList<armes_sorts>(), 
    	        		Armures);
    	        break;
    	      case 2:
    	    	  Shop.shop((j, new ArrayList<armes_melees>(Arrays.asList(new armes_melees[]{armes_melees_creation.staff("spark")})),
    	        			new ArrayList<armes_distances>(), tempSorts, Armures);
    	        break;
    	      case 3:
    	    	  Shop.shop(j, ArmesMelees, new ArrayList<armes_distances>(), tempSorts, Armures);
    	        break;
    	    }
    	    return j;*/
    }
    
  
}
