package inventory;

import Battle.battleAttaque;
import perso.perso;

public abstract class armes_melees extends battleAttaque{
	
private int minDext, minTaille;

	public armes_melees(String tempNom, String tempDescription, boolean tempPlural, int tempDes, 
		int tempAdd, int tempMinTaille, int tempMinDext, int tempPrix, boolean tempTwoHands) {
		super(tempNom, tempDescription, tempPlural, tempDes, tempAdd, tempPrix, tempTwoHands);
		minTaille = tempMinTaille;
		minDext = tempMinDext;
	}
	
	public int getMinTaille() {
		return minTaille;
	}
	
	public int getMinDext() {
		return minDext;
	}
	
	public boolean peutUtiliser(perso Perso) {
		return (Perso.getTaille() >= minTaille && Perso.getDexterite() >= minDext);
	}
	
}
