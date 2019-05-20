package perso;

import Effect.statusEffect;
import inventory.armes_distances;
import inventory.armes_melees;
import inventory.armes_sorts;
import inventory.armures;

public class creature_races  extends enemy{
	
	
	
//-- Constructor - 
	public creature_races(String id, String nom, int level, Race race, int ptv, boolean dead, int attaque,
			int bonusAttaque, int defense, int bonusDefense, int XP, int maxXP, int previousXP, int degat, int soin,
			int accuracy, int minDamage, int maxDamage, statusEffect statusEffects) {
		super(id, nom, level, race, ptv, dead, attaque, bonusAttaque, defense, bonusDefense, XP, maxXP, previousXP, degat, soin,
				accuracy, minDamage, maxDamage, statusEffects);
		
	}

	
// Liste des races enemy --
	// a voir avec les autres
	public static enemyNormal humainDark() {
		return new enemyNormal("Humain Dark", new armes_melees[]{
				armes_melees_creation.epeeCourte(utils.monsterAdjective())
		}, 
		
		new armes_distances[]{armes_distances_creation.rock(utils.monsterAdjective())}, 
		new armes_sorts[]{}, 
		new armures[]{armures_creation.cuire("normale")},  14, 15, 14, 13, 2, 12, 0, 15, 10);
	}

	public static enemyNormal elfeDark() {
	    return new enemyNormal("Elfe Dark", new armes_melees[] {
	    	armes_melees_creation.brassKnuckles(utils.monsterAdjective())
	    }, 
	    	
	    new armes_distances[]{armes_distances_creation.lightBow(utils.monsterAdjective())}, 
	    new armes_sorts[]{}, 
	    new armures[]{armures_creation.cuire("normale")},  15, 12, 16, 11, 2, 14, 0, 15, 10);
	}

	public static enemyNormal orcDark() {
	    return new enemyNormal("Orc Dark", new armes_melees[] {
	    	armes_melees_creation.talons(utils.monsterAdjective())
	    }, 
	    	
	    new armes_distances[]{armes_distances_creation.rock(utils.monsterAdjective())}, 
	    new armes_sorts[]{},
	    new armures[]{armures_creation.cuire("normale")}, 16, 30, 16, 15, 3, 10, 0, 30, 5);
	}
	  
	public static enemyNormal voleur() {
	    return new enemyNormal("Nain Cultiste", new armes_melees[] {
	    	armes_melees_creation.axe(utils.monsterAdjective())
	    }, 
	    	
	    new armes_distances[]{armes_distances_creation.rock(utils.monsterAdjective())}, 
	    new armes_sorts[]{},  
	    new armures[]{armures_creation.cuire("normale")}, 14, 15, 14, 13, 2, 12, 0, 20, 12);
	}
	 
 

	@Override
	public boolean isElite() {
	
		return false;
	}

	@Override
	public boolean isBoss() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setStats() {
	// TODO Auto-generated method stub
	
	}

}
