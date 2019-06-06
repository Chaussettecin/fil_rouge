package enemys;

import Effect.statusEffect;
import Utils.utilsGame;
import perso.Race;

//--- Dans notre jeux 4/5 Boss
public abstract class enemyBoss extends enemy {

	   public static int bossId;

//-- Constructor -- 
	   public enemyBoss(String id, String nom, int level, Race race, int ptv, boolean dead, int attaque, int bonusAttaque,
			int defense, int bonusDefense, int XP, int maxXP, int previousXP, int degat, int soin, int accuracy,
			int minDamage, int maxDamage, statusEffect statusEffects) {
		
		   super(id, level, race, ptv, dead, attaque, bonusAttaque, defense, bonusDefense, XP, maxXP, previousXP, degat, soin,
				accuracy, minDamage, maxDamage, statusEffects);
		
	}


//-- Permet d'identifier le boss ---
	   public void boss(String id, int bossId) {
    		enemyBoss.bossId = bossId;
	   }
    


}
