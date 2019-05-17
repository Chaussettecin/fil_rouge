package perso;

import map.TileMap;
import resource.ResourceManager;
import resource.Util;

// --- Cultiste --- 

public class enemyNormal extends enemy {
	
	public boolean isElite = false; // Ce nest pas un bosse 

	//--- Constructor -
		// public enemyNormal(String id, Vector position, TileMap tileMap, ResourceManager rm) {
	        //super(id, position, tileMap, rm);
	 	//}

	 public enemyNormal(boolean isElite) {
	        
		 super(id, nom, taille, agilité, level, santeActuelle, SanteMax, manaActuel,
				maxMana, intelligence);

	        // determine si l'enemi est un boss ou pas
	        isElite = Util.isSuccess(Util.ELITE_CHANCE);
	        if (isElite) this.nom = "[ELITE] " + nom;
	}

	 @Override
	public boolean isElite() {
	      return isElite;
	}

	@Override
	public boolean isBoss() {
	   return false;
	}

	@Override
	public void setStats() {
	  //- if the enemy is an elite then its stats are multiplied by an elite multiplier
	  float eliteMultiplier = MathUtils.random(Util.MIN_ELITE_MULTIPLIER, Util.MAX_ELITE_MULTIPLIER);

	 // hp is scaled polynomially with curve MHP = level ^ 2.0 + 25 as a seed then a value is chosen from deviation
	   int mhpSeed = (int) (Math.pow(level, 2) + 25);
	   int mhp = Util.getDeviatedRandomValue(mhpSeed, 4);

	   int minDmg = MathUtils.random(Util.ENEMY_INIT_MIN_MINDMG, Util.ENEMY_INIT_MAX_MINDMG);
	   int maxDmg = MathUtils.random(Util.ENEMY_INIT_MIN_MAXDMG, Util.ENEMY_INIT_MAX_MAXDMG);

	    for (int i = 0; i < this.level - 1; i++) {
	            
	    	int dmgMean = MathUtils.random(Util.ENEMY_MIN_DMG_INCREASE, Util.ENEMY_MAX_DMG_INCREASE);
	        	int minDmgIncrease = (dmgMean - MathUtils.random(2));
	        	int maxDmgIncrease = (dmgMean + MathUtils.random(2));

	        	minDmg += minDmgIncrease;
	        	maxDmg += maxDmgIncrease;
	     }

	   //-- set s a random accuracy initially
	     this.setAccuracy(MathUtils.random(Util.ENEMY_MIN_ACCURACY, Util.ENEMY_MAX_ACCURACY));

	        // finalize stats
	       // this.setMaxHp(isElite ? (int) (eliteMultiplier * mhp) : mhp);
	        //this.setMinDamage(isElite ? (int) (eliteMultiplier * minDmg) : minDmg);
	        //this.setMaxDamage(isElite ? (int) (eliteMultiplier * maxDmg) : maxDmg);
	    }
}
