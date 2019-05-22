package perso;

import java.util.Scanner;

import Effect.statusEffect;
import enemys.enemy;
import enemys.enemyNormal;
import inventory.armes_distances;
import inventory.armes_melees;
import inventory.armes_sorts;
import inventory.armures;
import resource.Skill;

public class creature_races  extends enemy{
	
		protected int lifeMax;
		protected int manaMax;
		protected int powerMax;	
		protected int lifeActual;
		protected int manaActual;
		protected int powerActual;
		
	// skills
		protected Skill fireball;
		protected Skill knockOut;
		protected Skill healing;
		protected Skill poisoning;
		
	// state values
		protected boolean alive;
		protected boolean isKnockedOut;
		protected int[] isPoisoned;

		
//-- Constructor - 
		public creature_races(String id, String name, int level, Race race, int ptv, 
				boolean dead, int attaque, int bonusAttaque, int defense, int bonusDefense, 
				int XP, int maxXP, int previousXP, int degat, int soin,
				int accuracy, int minDamage, int maxDamage, statusEffect statusEffects, int manaMax, int powerMax, int lifeMax) {
		
			
			super(id, level, race, ptv, dead, attaque, bonusAttaque, defense, 
					bonusDefense, XP, maxXP, previousXP, degat, soin,
					accuracy, minDamage, maxDamage, statusEffects);
	
	        this.nom = name;
	        this.lifeMax = lifeMax;
	        this.manaMax = manaMax;
	        this.powerMax = powerMax;

	        this.lifeActual = lifeMax;
	        this.manaActual = manaMax;
	        this.powerActual = powerMax;

	 }
	 

	
// Liste des races ennemis --
	// a voir avec les autres
	/*public static enemyNormal humainDark() {
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
	 */
 

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
