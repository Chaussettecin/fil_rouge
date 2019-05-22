package perso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import Utils.utilsGame;
import inventory.armes_distances;
import inventory.armes_melees;
import inventory.armes_sorts;
import inventory.armures;
import ui.UI;


public class perso_test {

	public static perso_test joueurs() {
	   
		UI.out.println("Quel est votre nom Humain?");
	    String name = UI.in.nextLine();
	    
	    if (name.toLowerCase().equals("Monsieur Fitz")) {
	    	
	    	utilsGame.sleep(1000);
	    	UI.out.println("Qu'est qui vous aménes?");
	    	utilsGame.sleep(2000);
	    	UI.out.println("De trouver le Saint Graal!");
	    	utilsGame.sleep(2000);
	    	UI.out.println("Quoi...");
	    	utilsGame.sleep(1000);
	    	UI.out.print("est la Capital d'Assyria?");
	    	utilsGame.sleep(1000);
	    	UI.out.println("");
	    	UI.out.println("Je ne sais pas ce que c'est!");
	    	utilsGame.sleep(100);
	    	UI.out.println("AGGHHHHHHHHHHH");
	    	utilsGame.sleep(1000);
	    	System.exit(0);
	    }

	    ArrayList<Integer> stats = new ArrayList<Integer>();
	    
	    for (int i = 0; i < 8; i++){
	      stats.add(StatRandom());
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

	    ArrayList<armes_distances> ArmesDistances = new ArrayList<armes_distances>();
	    ArrayList<armes_melees> ArmesMelees = new ArrayList<armes_melees>();
	    ArrayList<armes_sorts> Sorts = new ArrayList<armes_sorts>();
	    ArrayList<armures> Armures = new ArrayList<armures>();
	    
	    ArrayList<String> classes = new ArrayList<String>(Arrays.asList(new String[]{"Rogue", "Guerrier", "Magie", "Bourrin"}));
	    	
	    int classeChoix = UI.menu("Choisis ta classe", classes);

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

	    UI.out.println("Tes Stats :");
	    UI.out.println("taille:\t" + Taille);
	    UI.out.println("const:\t" + Constitution);
	    UI.out.println("dext:\t" + Dexterite);
	    UI.out.println("vitesse:\t" + Vitesse);
	    UI.out.println("magie:\t" + Magie);
	    UI.out.println("intel:\t" + Intelligence);
	    UI.out.println("chance:\t" + Chance);
	    UI.out.println("char:\t" + Charisme);

	    perso j = 	new perso(classes.get(classeChoix), name, 
	    			new armes_melees[]{}, 
	    			new armes_distances[]{}, 
	    			new armes_sorts[]{}, 
	    			new armures[]{},Taille, Constitution, Dexterite, 
	    			Vitesse, Intelligence, Magie, Chance, Charisme, SoinC, 
	    			utilsGame.random(300,700));

	    ArrayList<armes_melees> tempMelee = armes_melees_creation.getAll();
	    for(int i = 0; i < tempMelee.size(); i++) {
	      if(tempMelee.get(i).peutUtiliser(j)) {
	        ArmesMelees.add(tempMelee.get(i));
	      }
	    }
	   ArrayList<armes_distances> tempRanged = armes_distances_creation.getAll();
	   for(int i = 0; i < tempRanged.size(); i++) {
	      if(tempRanged.get(i).peutUtiliser(j)) {
	    	  armes_distances_creation.add(tempRanged.get(i));
	      }
	    }
	    ArrayList<armes_sorts> tempSorts = armes_sorts.getAll();
	    for(int i = 0; i < tempSorts.size(); i++) {
	      if(tempSorts.get(i).canUse(j)) {
	        Sorts.add(tempSorts.get(i));
	      }
	    }
	    ArrayList<armures> tempArmures = armures_creation.getAll();
	    for(int i = 0; i < tempArmures.size(); i++) {
	      if(tempArmures.get(i).canUse(j)) {
	        Armures.add(tempArmures.get(i));
	      }
	    }

	    switch (classeChoix) {
	      case 0:
	        utilsGame.shop(j, ArmesMelees, ArmesDistances, Sorts, Armures);
	        break;
	      case 1:
	        utilsGame.shop(j, ArmesMelees, ArmesDistances, new ArrayList<armes_sorts>(), 
	        		Armures);
	        break;
	      case 2:
	        utilsGame.shop(j, new ArrayList<armes_melees>(Arrays.asList(new armes_melees[]{armes_melees_creation.staff("spark")})),
	        			new ArrayList<armes_distances>(), Sorts, Armures);
	        break;
	      case 3:
	        utilsGame.shop(j, ArmesMelees, new ArrayList<armes_distances>(), Sorts, Armures);
	        break;
	    }
	    return j;
	  }

	  public static int StatRandom() {
	    int de1, de2, de3;
	    int total = 0;
	   
	    do {
	      
	    	de1 = utilsGame.random(1, 7);
	    	de2 = utilsGame.random(1, 7);
	    	de3 = utilsGame.random(1, 7);
	    	total += (de1 + de2 + de3);

	    } while (de1 == de2 && de2 == de3);
	    	return total;
	  }
}
