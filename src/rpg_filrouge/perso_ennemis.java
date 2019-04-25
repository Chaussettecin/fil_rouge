package rpg_filrouge;


public class perso_ennemis {

	
private int enemiesRating;
	
	public perso_ennemis (String tempNom, equipement_armes[] tempArmes, equipement_pouvoirs[] tempPouvoir, 
			equipement_armure[] tempArmure, int tempTaille, int tempConstitution, int tempDexterite, 
			int tempVitesse, int tempMagie, int tempIntelligence, int tempSoinC, int tempMonsterRating, 
			int tempGP) 
	{
		
		super(tempNom, tempArmes, tempPouvoir, tempArmure, tempTaille,
				tempConstitution, tempDexterite, tempVitesse, tempMagie, 
				tempIntelligence, tempSoinC, tempGP);
		    
		enemiesRating = tempMonsterRating;
		    
	}

	public int getEnemiesRating() {
		  return enemiesRating;
	}
}
