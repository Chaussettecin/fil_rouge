package inventory;

import java.util.ArrayList;
import java.util.Arrays;

import Battle.battleAttaqueDistance;
import Degat.degat;
import perso.perso;
import Utils.utilsGame;

public class armes_distances extends battleAttaqueDistance {
	
	private int minDext, minTaille;
	private int utilises, utiliser;
	
//--- Constructor --
	public armes_distances (String tempNom, String tempDescription, boolean tempDuo, 
							int tempDes, int tempAdd, int tempMinTaille, int tempMinDex, 
							int tempUses, int tempPrix, boolean tempTwoHands)  {
			
				super(tempNom, tempDescription, tempDuo, tempDes, tempAdd, tempPrix, 
				tempTwoHands);
			
					minTaille = tempMinTaille;
					minDext = tempMinDex;
					utilises = tempUses;
					utiliser = 0;
	}
	
//-- Liste des armes à distances / 
	public static ArrayList<armes_distances> getAll() {
		
		return new ArrayList<armes_distances>(
				
			Arrays.asList(new armes_distances[]{lightCrossbow(utilsGame.playerAdjectives()),
				
					crossbow(utilsGame.playerAdjectives()), heavyCrossbow(utilsGame.playerAdjectives()),
					lightBow(utilsGame.playerAdjectives()),bow(utilsGame.playerAdjectives()),
					heavyBow(utilsGame.playerAdjectives()),enchantedBow(utilsGame.playerAdjectives()),
					sling(utilsGame.playerAdjectives()),boomerang (utilsGame.playerAdjectives()),
					throwingAxe(utilsGame.playerAdjectives()), rock(utilsGame.playerAdjectives())}));
	}
	
	
	public static armes_distances lightCrossbow(String description) {
		return new armes_distances("light crossbow", description, false, 3, -1, 8, 12, 20, 150, false);
	}
		 
	
	public static armes_distances crossbow(String description) {
		return new armes_distances("crossbow", description, false, 4, 0, 12, 10, 20, 170, true);
	}
	
	
	public static armes_distances heavyCrossbow(String description) {
		return new armes_distances("heavy crossbow", description, false, 5, 0, 15, 10, 20, 250, true);
	}
	
	
	public static armes_distances lightBow(String description) {
		return new armes_distances("light bow", description, false, 4, 3, 15, 15, 20, 100, true);
	}

	public static armes_distances bow(String description) {
		return new armes_distances("bow", description, false, 5, 3, 20, 16, 20, 175, true);
	}
	
	public static armes_distances heavyBow(String description) {
		return new armes_distances("heavy bow", description, false, 6, 3, 25, 17, 20, 250, true);
	}
	
	public static armes_distances enchantedBow(String description) {
		return new armes_distances("enchanted bow", description, false, 6, 5, 15, 18, 20, 500, true);
	}
	
	public static armes_distances sling(String description) {
		return new armes_distances("sling", description, false, 2, 0, 5, 10, 0, 5, false);
	}
		 
	public static armes_distances boomerang(String description) {
		return new armes_distances("boomerang", description, false, 2, 3, 11, 11, 0, 50, false);
	}
		 
	public static armes_distances throwingAxe(String description) {
		return new armes_distances("throwing axe", description, false, 3, 2, 9, 12, 1, 70, false);
	}
	
	public static armes_distances rock(String description) {
		return new armes_distances("rock", description, false, 1, 0, 0, 0, 0, 0, false);
	}
	
	
//-- GETTER ET SETTER --
	public int getMinTaille() {
		return minTaille;
	}
		
	public int getMinDext() {
		return minDext;
	}
		
	public int getMaxUses() {
		return utilises;
	}
		
	public int getUsesLeft() {
		return utilises - utiliser;
	}
		
	
	public degat degats(perso Perso) {
		if(peutUtiliser(Perso) && utilises > 0) {
			utiliser++;
		}
		return super.degats(Perso);
	}

	@Override
	public boolean peutUtiliser(perso Perso) {
		// TODO Auto-generated method stub
		return false;
	}
		
	//public boolean peutUtiliser(perso Perso) {
		//return (Perso.getTaille() >= minTaille && Perso.getDexterite() >= minDext && (utiliser < utilises || utilises <= 0));
	//}

}
