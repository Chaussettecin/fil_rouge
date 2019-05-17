package perso;

import map.TileMap;
import resource.ResourceManager;
import resource.Util;

//--- Dans notre jeux 4/5 Boss
public class enemyBoss extends enemy {

//-- Permet d'identifier le boss ---
    public int bossId;
    
//-- Constructor -- 
    public enemyBoss(String id, Vector2 position, TileMap tileMap, ResourceManager rm) {
       
    	super(id,position, nom,taille, agilité, level, santeActuelle,
    			SanteMax, manaActuel,maxMana, xpGagner, goldgagner,tileMap,rm);
    }

    
    public enemyBoss(String id, int bossId, Vector position, TileMap tileMap, ResourceManager rm,
                int worldIndex, int startIndex, int numFrames, float delay) {
        
    		this(id, position, tileMap, rm);
    		this.bossId = bossId;

        // create tilemap animation
        //am = new AnimationManager(rm.sprites16x16, worldIndex, startIndex, numFrames, delay);
        // create battle scene animation
        //bam = new AnimationManager(rm.battleSprites96x96, worldIndex, startIndex, 2, delay);
    }
    

    public boolean isElite() {
        return false;
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
                	minDmg = MathUtils.random(5, 9);
                	maxDmg = MathUtils.random(10, 15);
                
                	for (int i = 0; i < level - 1; i++) {
                		minDmg += MathUtils.random(2, 4) - MathUtils.random(1);
                		maxDmg += MathUtils.random(2, 4) + MathUtils.random(1);
                	}
                	break;
            case 1: //-- Ellyron - monde 2
            	
                	int mhpSeed1 = (int) (Math.pow(level, 2) + 14);
                	mhp = Util.getDeviatedRandomValue(mhpSeed1, 3);
                	minDmg = MathUtils.random(3, 8);
                	maxDmg = MathUtils.random(9, 15);
                
                	for (int i = 0; i < level - 1; i++) {
                		minDmg += MathUtils.random(1, 2) - MathUtils.random(2);
                		maxDmg += MathUtils.random(1, 2) + MathUtils.random(2);
                	}
                	break;
            
            case 2: // KHAINE - boss 3 - Boss Elfe
                
            		int mhpSeed2 = (int) (Math.pow(level, 2.3) + 25);
            		mhp = Util.getDeviatedRandomValue(mhpSeed2, 150);
            		minDmg = MathUtils.random(1, 4);
            		maxDmg = MathUtils.random(5, 8);
                
            		for (int i = 0; i < level - 1; i++) {
            			minDmg += MathUtils.random(1, 2) - 1;
            			maxDmg += MathUtils.random(1, 2) + 1;
            		}
            		break;
            case 3: // NAAGGROTH - boss 4  - Boss ORC / BOSS final
                
        			int mhpSeed2 = (int) (Math.pow(level, 2.3) + 25);
        			mhp = Util.getDeviatedRandomValue(mhpSeed2, 150);
        			minDmg = MathUtils.random(1, 4);
        			maxDmg = MathUtils.random(5, 8);
            
        			for (int i = 0; i < level - 1; i++) {
        				minDmg += MathUtils.random(1, 2) - 1;
        				maxDmg += MathUtils.random(1, 2) + 1;
        			}
        			break;
        }

        this.setMaxHp(mhp);
        this.setMinDamage(minDmg);
        this.setMaxDamage(maxDmg);
        this.setAccuracy(MathUtils.random(Util.ENEMY_MIN_ACCURACY, Util.ENEMY_MAX_ACCURACY));
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
