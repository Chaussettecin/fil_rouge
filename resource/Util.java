package resource;


import Battle.SpecialMove;
import perso.enemy;
import perso.perso;


public class Util {


//--- Non des effets d'attaque ? 
    public static  SpecialMove S_DISTRACT = new SpecialMove(DISTRACT,
            "Distract", "Next enemy attack\n-" + Util.P_DISTRACT + "% ACC", 1, null);
    public static  SpecialMove S_FOCUS = new SpecialMove(FOCUS,
            "Focus", "Next attack 100% ACC\nand +" + Util.P_FOCUS_CRIT + "% crit chance", 7, null);
    public static  SpecialMove S_INTIMIDATE = new SpecialMove(INTIMIDATE,
            "Intimidate", "Next attack is\namplified by " + Util.P_INTIMIDATE + "%", 3, null);
    public static  SpecialMove S_REFLECT = new SpecialMove(REFLECT,
            "Reflect", "Next enemy attack\nis reflected back", 23, null);
    public static  SpecialMove S_STUN = new SpecialMove(STUN,
            "Stun", Util.P_STUN + "% chance to\nstun enemy", 5, null);
    public static  SpecialMove S_INVERT = new SpecialMove(INVERT,
            "Invert", "Heal moves damage\nDamage moves heal", 13, null);
    public static  SpecialMove S_SACRIFICE = new SpecialMove(SACRIFICE,
            "Sacrifice", "Sacrifice all but 1 hp\nfor increased dmg", 10, null);
    public static  SpecialMove S_SHIELD = new SpecialMove(SHIELD,
            "Shield", "Summon a shield that\nabsorbs " + Util.P_SHIELD + "% max hp", 17, null);

    public static  SpecialMove[] SMOVES_ORDER_BY_LVL = {
        S_DISTRACT, S_INTIMIDATE, S_STUN, S_FOCUS, S_SACRIFICE, S_INVERT, S_SHIELD, S_REFLECT
    };
    
    public static  SpecialMove[] SMOVES_ORDER_BY_ID = {
        S_DISTRACT, S_FOCUS, S_INTIMIDATE, S_REFLECT, S_STUN, S_INVERT, S_SACRIFICE, S_SHIELD
    };


    // Probabilities, Percentages, and Multipliers
    public static  int RUN_FROM_BATTLE = 7;
    public static  int SAVED_FROM_BATTLE = 1;
    public static  int ELITE_CHANCE = 5;
    public static  int PLAYER_ACCURACY = 80;
    public static  int ENEMY_MIN_ACCURACY = 75;
    public static  int ENEMY_MAX_ACCURACY = 95;
    public static  int REVIVAL = 1;
    public static  int ENCHANT = 50;
    public static  int DESTROY_ITEM_IF_FAIL = 50;
    public static  int TILE_INTERATION = 70;
    public static  int DEATH_PENALTY = 1;

//-- Battle special moves percentages --
    public static  int P_DISTRACT = 50;
    public static  int P_INTIMIDATE = 40;
    public static  float INTIMIDATE_MULT = 1.4f;
    public static  int P_FOCUS_CRIT = 30;
    public static  int P_STUN = 60;
    public static  int P_SHIELD = 20;

    public static  int CRIT_MULTIPLIER = 3;
    public static  float MIN_ELITE_MULTIPLIER = 1.3f;
    public static  float MAX_ELITE_MULTIPLIER = 1.6f;

    public static  int NORMAL_ITEM_DROP = 30;
    public static  int ELITE_ITEM_DROP = 60;
    public static  int BOSS_ITEM_DROP = 80;
    public static  int COMMON_ITEM_RNG_INDEX = 60;
    public static  int RARE_ITEM_RNG_INDEX = 90;
    public static  int EPIC_ITEM_RNG_INDEX = 99;
    public static  int LEGENDARY_ITEM_RNG_INDEX = 100;

    public static  float COMMON_ENCHANT_MIN = 1.f;
    public static  float COMMON_ENCHANT_MAX = 1.2f;
    public static  float RARE_ENCHANT_MIN = 1.1f;
    public static  float RARE_ENCHANT_MAX = 1.3f;
    public static  float EPIC_ENCHANT_MIN = 1.2f;
    public static  float EPIC_ENCHANT_MAX = 1.4f;
    public static  float LEGENDARY_ENCHANT_MIN = 1.3f;
    public static  float LEGENDARY_ENCHANT_MAX = 1.6f;

    // Level up scaling
    public static  int PLAYER_INIT_MAX_HP = 75;
    public static  int PLAYER_INIT_MIN_DMG = 10;
    public static  int PLAYER_INIT_MAX_DMG = 16;
    public static  int PLAYER_MIN_HP_INCREASE = 9;
    public static  int PLAYER_MAX_HP_INCREASE = 17;
    public static  int PLAYER_MIN_DMG_INCREASE = 1;
    public static  int PLAYER_MAX_DMG_INCREASE = 3;

    public static  int ENEMY_INIT_MIN_MINDMG = 2;
    public static  int ENEMY_INIT_MAX_MINDMG = 4;
    public static  int ENEMY_INIT_MIN_MAXDMG = 5;
    public static  int ENEMY_INIT_MAX_MAXDMG = 7;

    public static  int ENEMY_MIN_DMG_INCREASE = 1;
    public static  int ENEMY_MAX_DMG_INCREASE = 4;

    // Experience


    public static int calculateMaxExp(int level, int offset) {
        return (int) (2 * level * (Math.pow(1.3, level / 3)) + offset) + 4;
    }

//-- Le exp donné au joueur après sa défaite
    //EXP = (ennemiLevel ^ 0.8) + offset
    public static int calculateExpEarned(int enemyLevel, int offset) {
        return (int) (Math.pow(enemyLevel, 0.95)) + offset;
    }

//**************** Random helper functions ********

//-- Renvoie si un événement a réussi avec une probabilité -
    public static boolean isSuccess(int p) {
        int k = MathUtils.random(99);
        return k < p;
    }

//--Retourne un nombre aléatoire dans une plage produite par une moyenne et un écart type
    public static int getDeviatedRandomValue(int mu, int sigma) {
        
    	int n0 = mu - sigma;
        int n1 = mu + sigma;
        return MathUtils.random(n0, n1);
    }

//-- Renvoie une instance d'une entité basée sur un identifiant d'entité numérique
     	//@param id
     	//@param position
     	//@param map
     	//@param rm
     	//@return
    public static enemy getVilain(int id, ResourceManager rm) {
        
    	switch (id) {
            
    		case 2: return new Normal("Tor Ibrion", rm, 1, 0, 2, 1 / 3f);
            case 3: return new Normal("cultiste nain",rm, 1, 2, 2, 1 / 3f);
            case 4: return new Normal("cultiste nain", rm, 1, 4, 2, 1 / 3f);
            case 5: return new Boss("ELLYRON ", 0, rm, 1, 6, 2, 1 / 3f);
            case 6: return new Normal("humain",  rm, 2, 0, 2, 1 / 3f);
            case 7: return new Normal("humain", rm, 2, 2, 2, 1 / 3f);
            case 8: return new Normal("orc", rm, 2, 4, 2, 1 / 3f);
            case 9: return new Normal("elfe",  rm, 2, 6, 2, 1 / 3f);
            case 10: return new Boss("KHAINE ", 1, rm, 2, 8, 2, 1 / 3f);
            case 11: return new Normal("orc", rm, 3, 0, 2, 1 / 3f);
            case 12: return new Normal("nain voleur", rm, 3, 2, 2, 1 / 3f);
            case 13: return new Normal("Dark Elfe", rm, 3, 4, 2, 1 / 3f);
            case 14: return new Normal("Cultiste ORC", rm, 3, 6, 2, 1 / 3f);
            case 15: return new Boss("NAAGGROTH ", 2, rm, 3, 8, 2, 1 / 3f);
        }
        return null;
    }

}
