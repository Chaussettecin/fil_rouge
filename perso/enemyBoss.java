package perso;

import Effect.statusEffect;
import resource.Util;
import resource.utilsGame;

//--- Dans notre jeux 4/5 Boss
public class enemyBoss extends enemy {

	   public static int bossId;

//-- Constructor -- 
	   public enemyBoss(String id, String nom, int level, Race race, int ptv, boolean dead, int attaque, int bonusAttaque,
			int defense, int bonusDefense, int XP, int maxXP, int previousXP, int degat, int soin, int accuracy,
			int minDamage, int maxDamage, statusEffect statusEffects) {
		
		   super(id, nom, level, race, ptv, dead, attaque, bonusAttaque, defense, bonusDefense, XP, maxXP, previousXP, degat, soin,
				accuracy, minDamage, maxDamage, statusEffects);
		
	}


//-- Permet d'identifier le boss ---
	   public void boss(String id, int bossId) {
    		enemyBoss.bossId = bossId;

	   }
    

 //-- Verifie si l'enemi est un boss ou pas
    //-- True EnemyNormal  
    //-- False EnemyBoss
    public boolean isElite() {
        return true;
    }

    public boolean isBoss() {
        return true;
    }

//-- Définit les statistiques du boss en fonction du niveau et de l'index du boss - -
    public void setStats() {
        
    	int mhp = 0;
        int minDmg = 0;
        int maxDmg = 0;

        switch (bossId) {
        //-- Chaque boss dispo dans le jeu
        
            case 0: // Nain - Monde 1 - 
            			//- A moins de HP parce que son passif le compense -
                	int mhpSeed0 = (int) (Math.pow(level, 2.1) + 15);
                	
                	mhp = Util.getDeviatedRandomValue(mhpSeed0, 1);
                	minDmg = utilsGame.random(5, 9);
                	maxDmg = utilsGame.random(10, 15);
                
                	for (int i = 0; i < level - 1; i++) {
                		minDmg += utilsGame.random(2, 4) - 1;
                		maxDmg += utilsGame.random(2, 4) + 1;
                	}
                	break;
            
            case 1: //-- Ellyron - monde 2
                	int mhpSeed1 = (int) (Math.pow(level, 2) + 14);
                	
                	mhp = Util.getDeviatedRandomValue(mhpSeed1, 3);
                	minDmg = utilsGame.random(3, 8);
                	maxDmg = utilsGame.random(9, 15);
                
                	for (int i = 0; i < level - 1; i++) {
                		
                		minDmg += utilsGame.random(1, 2) - 2;
                		maxDmg += utilsGame.random(1, 2) + 2;
                	
                	}
                	break;
            
            case 2: // KHAINE - boss 3 - Boss Elfe
                	int mhpSeed2 = (int) (Math.pow(level, 2.3) + 25);
            		
                	mhp = Util.getDeviatedRandomValue(mhpSeed2, 150);
            		minDmg = utilsGame.random(1, 4);
            		maxDmg = utilsGame.random(5, 8);
                
            		for (int i = 0; i < level - 1; i++) {
            			minDmg += utilsGame.random(1, 2) - 1;
            			maxDmg += utilsGame.random(1, 2) + 1;
            		}
            		break;
            
            case 3: // NAAGGROTH - boss 4  - Boss ORC / BOSS final --
        			int mhpSeed3 = (int) (Math.pow(level, 3.4) + 50);
        			
        			mhp = Util.getDeviatedRandomValue(mhpSeed3, 150);
        			minDmg = utilsGame.random(1, 4);
        			maxDmg = utilsGame.random(5, 8);
            
        			for (int i = 0; i < level - 1; i++) {
        				minDmg += utilsGame.random(1, 2) - 1;
        				maxDmg += utilsGame.random(1, 2) + 1;
        			}
        			break;
        }

        this.setMaxSante(mhp);
        //this.setMinDamage(minDmg);
        //this.setMaxDamage(maxDmg);
       // this.setAccuracy(utilsGame.random(Util.ENEMY_MIN_ACCURACY, Util.ENEMY_MAX_ACCURACY));
    }

 //--Renvoie une description du passif d'un boss basé sur bossId.
    public String getPassiveDescription() {
        
    	switch (bossId) {
            // king slime
            case 0: return "Slime Revival (Respawns après la mort avec la moitié des points de santé jusqu'à 4 fois).";
            // red reaper
            case 1: return "Phantom Presence (Fait en sorte que la précision du joueur soit réduite de 40% pour toutes les attaques.).";
            // ice golem
            case 2: return "Lifesteal (Soigne 20% des dégâts de chaque attaque).";
        }
        return "";
    }


}
