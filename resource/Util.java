package resource;

import java.util.Vector;

import Battle.SpecialMove;

//-- Stocke des constantes et des fonctions utiles --

public class Util {

    // rates
    public static float TEXT_SPEED = 0.03f;
    public static float HP_BAR_DECAY_RATE = 25.f;
    public static float TRANSITION_SCREEN_SPEED = 110;

    public static int RAINDROP_X = 50;
    public static int RAINDROP_Y_DEVIATED = 20;
    public static int SNOWFLAKE_X = 30;
    public static int SNOWFLAKE_Y_DEVIATED = 30;

    public static Vector RAIN_VELOCITY = new Vector(Util.RAINDROP_X, -100);
    public static Vector HEAVY_RAIN_VELOCITY = new Vector(Util.RAINDROP_X, -120);
    public static Vector SNOW_VELOCITY = new Vector(Util.SNOWFLAKE_X, -60);
    public static Vector BLIZZARD_VELOCITY = new Vector(Util.SNOWFLAKE_X + 50, -80);

    // Animation indexes
    public static int PLAYER_WALKING = 0;

    // Animation delay
    public static float PLAYER_WALKING_DELAY = 1 / 6f;

    // Directional pad button positions
    public static int DIR_PAD_SIZE = 20;
    public static int DIR_PAD_OFFSET = 5;

    // Special move indexes
    public static int NUM_SPECIAL_MOVES = 8;
    public static int DISTRACT = 0;
    public static int FOCUS = 1;
    public static int INTIMIDATE = 2;
    public static int REFLECT = 3;
    public static int STUN = 4;
    public static int INVERT = 5;
    public static int SACRIFICE = 6;
    public static int SHIELD = 7;

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

    // Button dimensions
    public static  int MOVE_WIDTH = 72;
    public static  int MOVE_HEIGHT = 25;

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

    // Battle special moves percentages
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

    /**
     * Current max exp formula is:
     * EXP = 2 * level * (1.35 ^ (level / 3)) + offset
     * Slow exponential growth
     *
     * @param level the level of the player
     * @param offset the initial max exp at level 1 acting as an offset to the curve (random)
     * @return max experience at a given level
     */
    public static int calculateMaxExp(int level, int offset) {
        return (int) (2 * level * (Math.pow(1.3, level / 3)) + offset) + 4;
    }

//-- Le exp donn� au joueur apr�s sa d�faite
    //EXP = (ennemiLevel ^ 0.8) + offset
    public static int calculateExpEarned(int enemyLevel, int offset) {
        return (int) (Math.pow(enemyLevel, 0.95)) + offset;
    }

//**************** Random helper functions ********

//-- Renvoie si un �v�nement a r�ussi avec une probabilit� -
    public static boolean isSuccess(int p) {
        int k = MathUtils.random(99);
        return k < p;
    }

//--Retourne un nombre al�atoire dans une plage produite par une moyenne et un �cart type
    public static int getDeviatedRandomValue(int mu, int sigma) {
        
    	int n0 = mu - sigma;
        int n1 = mu + sigma;
        return MathUtils.random(n0, n1);
    }

    /*public static Label.LabelStyle getItemColor(int rarity, ResourceManager rm) {
        
    	switch (rarity) {
            case 0: return new Label.LabelStyle(rm.skin.getFont("default-font"), new Color(1, 1, 1, 1));
            case 1: return new Label.LabelStyle(rm.skin.getFont("default-font"), new Color(0, 200 / 255.f, 0, 1));
            case 2: return new Label.LabelStyle(rm.skin.getFont("default-font"), new Color(0, 180 / 255.f, 1, 1));
            case 3: return new Label.LabelStyle(rm.skin.getFont("default-font"), new Color(164 / 255.f, 80 / 255.f, 1, 1));
        }
        return null;
    }*/

    // Tout les titres bloqu�s --
    public static  int[] BLOCKED_TILE_IDS = {
        5, 6, 7, 9, 10, 11, 12, 13, 14, 15, 25, 26, 27, 28, 29, 30, 31, 36,
        38, 41, 42, 48, 49, 50, 51, 54, 55, 64, 65, 66, 67, 70, 84, 85, 86,
        87, 88, 91, 92, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 112,
        113, 114, 115, 116, 117, 118, 120, 121, 123, 128, 129, 130, 130, 131, 132,
        133, 134, 135, 136, 137, 138, 139, 144, 145, 146, 147, 156, 157, 165, 166,
        151, 152, 167, 168, 169, 170, 184, 185, 186, 197, 198, 199, 200, 201, 202,
        215, 216, 217, 218, 227, 228, 229, 230, 231, 232, 233, 234, 235, 243, 244,
        247, 249, 263, 264, 265, 266, 267, 268, 269
    };

    public static  int[] BLOCKED_ANIMATED_TILE_IDS = { 96, 109 };

    public static boolean isBlockedTile(int id) {
        for (int i = 0; i < BLOCKED_TILE_IDS.length; i++) {
            if (id == BLOCKED_TILE_IDS[i]) return true;
        }
        return false;
    }

    public static boolean isBlockedAnimatedTile(int id) {
        for (int i = 0; i < BLOCKED_ANIMATED_TILE_IDS.length; i++) {
            if (id == BLOCKED_ANIMATED_TILE_IDS[i]) return true;
        }
        return false;
    }

//-- Renvoie une instance d'une entit� bas�e sur un identifiant d'entit� num�rique
     	//@param id
     	//@param position
     	//@param map
     	//@param rm
     	//@return
    public static entity getEntity(int id, Vector position, TileMap map, ResourceManager rm) {
        
    	switch (id) {
            
    		case 2: return new Normal("slime", position, map, rm, 1, 0, 2, 1 / 3f);
            case 3: return new Normal("blue slime", position, map, rm, 1, 2, 2, 1 / 3f);
            case 4: return new Normal("blast slime", position, map, rm, 1, 4, 2, 1 / 3f);
            case 5: return new Boss("slime king", 0, position, map, rm, 1, 6, 2, 1 / 3f);
            case 6: return new Normal("ghost", position, map, rm, 2, 0, 2, 1 / 3f);
            case 7: return new Normal("zombie", position, map, rm, 2, 2, 2, 1 / 3f);
            case 8: return new Normal("skeleton", position, map, rm, 2, 4, 2, 1 / 3f);
            case 9: return new Normal("witch", position, map, rm, 2, 6, 2, 1 / 3f);
            case 10: return new Boss("red reaper", 1, position, map, rm, 2, 8, 2, 1 / 3f);
            case 11: return new Normal("snow puff", position, map, rm, 3, 0, 2, 1 / 3f);
            case 12: return new Normal("angry penguin", position, map, rm, 3, 2, 2, 1 / 3f);
            case 13: return new Normal("yeti", position, map, rm, 3, 4, 2, 1 / 3f);
            case 14: return new Normal("ice bat", position, map, rm, 3, 6, 2, 1 / 3f);
            case 15: return new Boss("ice golem", 2, position, map, rm, 3, 8, 2, 1 / 3f);
        }
        return null;
    }

}
