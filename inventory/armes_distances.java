package inventory;

import Battle.battleAttaqueDistance;
import perso.perso;

public class armes_distances extends battleAttaqueDistance {
	 private int minDext, minTaille;
	 private int utilises, utiliser;
	
	
	public armes_distances (String tempNom, String tempDescription, boolean tempDuo, int tempDes,
		int tempAdd, int tempMinTaille, int tempMinDex, int tempUses, int tempPrix, boolean tempTwoHands) 
		{
			
		super(tempNom, tempDescription, tempDuo, tempDes, tempAdd, tempPrix, tempTwoHands);
			
			minTaille = tempMinTaille;
			minDext = tempMinDex;
			utilises = tempUses;
			utiliser = 0;
	}
		
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
		
	public void replenish() {
		utiliser = 0;
	}
		
	public Degats degats(perso Perso) {
		if(peutUtiliser(Perso) && utilises > 0) {
			utiliser++;
		}
		return super.degats(Perso);
	}
		
	public boolean peutUtiliser(perso Perso) {
		return (Perso.getTaille() >= minTaille && Perso.getDexterite() >= minDext && (utiliser < utilises || utilises <= 0));
	}

}
