package perso;

import inventory.armes_distances;
import inventory.armes_melees;
import inventory.armes_sorts;
import inventory.armures;

public class creationPerso extends perso {

	private int creatureRating;
	
	public creationPerso(String tempNom, 
			
			armes_melees[] temparmeMelee,
			armes_distances[] temparmesDistance, 
			armes_sorts[] tempSorts, 
			armures[] tempArmure, 
			
			int tempTaille, int tempConstitution, 
			int tempDexterite, int tempVitesse, 
			int tempMagie, int tempIntelligence, int tempSoinC, 
			int tempcreatureRating, int tempGP)  {
	
	    
		super(tempNom, temparmeMelee, temparmesDistance, 
				tempSorts, tempArmure, tempTaille, tempConstitution, 
				tempDexterite, tempVitesse, tempMagie, tempIntelligence, 
				tempSoinC, tempGP);
		
		creatureRating = tempcreatureRating;	
	}
	
	 
	public int getCreatureRating() {
	  return creatureRating;
	 }	 
}
