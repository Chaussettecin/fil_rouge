package enemys;

import Effect.statusEffect;
import resource.Util;
import Utils.utilsGame;

// --- Cultiste --- 
public abstract class enemyNormal extends enemy {
	
	public boolean Boss = false; // Ce nest pas un bosse 

//-- Constructor -- 
	 public enemyNormal(boolean isElite) {
	        
		 super(nom, level,race, ptv, dead, attaque, bonusAttaque, defense,
				 getBonusDefense(), XP, maxXP, previousXP, degat, soin,
		    		accuracy, minDamage, maxDamage, statusEffects);

	        
		// -- Verifie si c'est un boss ou un simple cultiste - 
	        Boss = Util.isSuccess(Util.ELITE_CHANCE);
	        
	        if (Boss) enemy.nom = "[boss] " + nom;
	}


}
