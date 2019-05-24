package inventory;

import java.util.ArrayList;
import java.util.Arrays;

import Battle.battleAttaque;
import perso.perso;
import resource.Util;


public abstract class armes_melees extends battleAttaque{
	
//-- Accuracie
	private int minDext;

//--Constructor - 
	public armes_melees(String tempNom, String tempDescription, boolean tempPlural, int tempDes, int tempAdd,
						int tempMinDext, int tempPrix, boolean tempTwoHands) {
						
		
			super(tempNom, tempDescription, tempPlural, tempDes, tempAdd, tempPrix, tempTwoHands);
		
		minDext = tempMinDext;
	}
	

//-- Liste armes melees  --
	public static ArrayList<armes_melees> getAll(){ 
		
		return new ArrayList<armes_melees>(
				
				Arrays.asList(new armes_melees[]{
						
						dirk(description), 
						epeeCourte(description),		
						grall(description),
						epeeMagique(description),
						baton((description)),
			
				}));
	}
		 
	
	public static armes_melees dirk(String description) {
		return new armes_melees();
	}
		 
	public static armes_melees grall(String description) {
		return new armes_melees();
	}
		 
	public static armes_melees epeeMagique(String description) {
		return new armes_melees("Epée Magique", description, 
		false, 6, 0, 21, 18, 240, true);
	}
		 
 
	public static armes_melees epeeCourte(String description) {
		return new armes_melees("épée courte", description, 
		false, 3, 0, 7, 3, 35, false);
	}
		 
	public static armes_melees axe(String description) {
		return new armes_melees("axe", description, 
		false, 4, 0, 17, 8, 100, false);
	}
		 
	public static armes_melees baton(String description) {
		return new armes_melees("baton", description, 
				false, 2, 0, 3, 2, 6, false);
	}
		 

	public int getMinDext() {
		return minDext;
	}
// Methode pour voir si le perso possede deja ou peut utiliser l'arme
	
	//public boolean peutUtiliser(perso Perso) {
		//return (Perso.equips  = Perso.setAccuracy(minDext);
	//}
	
}
