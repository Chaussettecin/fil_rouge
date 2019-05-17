package perso;

import java.util.ArrayList;
import Battle.moveSet;
import inventory.liste_Armes;
import map.TileMap;
import resource.ResourceManager;


public abstract class perso {

    protected String id;
	private String nom ;
	private job metier ;
	protected int level;
	private Race race ;
  	private int ptv ;           // pts de vie de base
    protected boolean dead = false; // Verif s'il est est vivant ou pas
    
  	private int attaque ;     
  	private int bonusAttaque ; // addition des differents bonus d'equipement
    private int defense ;      
    private int bonusDefense ; // addition des differents bonus d'equipement
    
    protected ResourceManager rm;
    protected moveSet moveset;
  
    protected int XP;
    protected int maxXP;
    protected int previousXP;
    
    // for applying the hp change after the dialogue is finished
    int degat= 0;
    protected int soint = 0;
    // 0-100 in % points
    protected int accuracy;
    // damage range
    protected int minDamage;
    protected int maxDamage;

// position (x,y) in map coordinates (tile * tileSize)
    //protected static Vector2 position;
    
//-- Mouvement type utilise  -1
    protected int prevMoveUsed = -1;
    protected int moveUsed = -1;

//---- map ---
    // protected TileMap tileMap;

  //--- VAR Equipements ---- 
    // Defence
    protected boolean hasShield = false;
    protected int shield;
    protected int maxShield;
    protected int prevShield;
    
    private ArrayList<liste_Armes> dansLesMains = new ArrayList<>();  
    private boolean presenceArmure;           
    private int mains ;

//-- Constructor --- 
    public perso(String id, ResourceManager rm) {
        this.id = id;
        this.rm = rm;

        //position = new Vector2();
    }

    public perso(String id,  TileMap tileMap, ResourceManager rm) {
        this(id, rm);
        
    }

    public void update(float dt) {
       
        if (XP > maxXP) XP = maxXP;
        if (XP <= 0) {
            XP = 0;
        }

    }

 
//-- An entity's hp is decreased by damage taken -
    public void hit(int damage) {
        this.degat = damage;
    }

//--An entity's hp is increased by healing -
    public void heal(int healing) {
        this.healing = healing;
    }

// -- Add un bouclier dans l'entité santé bar -
    public void setShield(int mshield) {
        
    	hasShield = true;
        this.shield = this.maxShield = this.prevShield = mshield;
    }

//-- Reset le bouclier du joueur à 0
    public void resetShield() {
        hasShield = false;
        this.shield = this.maxShield = this.prevShield = 0;
    }

//--- Application des degats en fonction des attaques précédentes -
    public void applyDamage() {
    	
    	//-- Avec un bouclier (defene) les degats sont appliqués d'abord pour diminuer la def
        if (hasShield) {
            if (degat == 0) {
                hasShield = false;
                return;
            }
            prevShield = shield;
            moveUsed = prevMoveUsed;
            prevMoveUsed = -1;

            //-- Si les degats casse le shield (bouclier) le joueur connait des degats
            if (shield - degat < 0) {
                degat = Math.abs(shield - degat);
                shield = 0;
                damageHp();
            }
            // damage breaks through the entire shield but does not damage hp bar
            else if (shield - degat == 0) {
                shield = 0;
            }
            // damage damages the shield
            else {
                shield -= degat;
                degat = 0;
            }

        }
        else {
            moveUsed = prevMoveUsed;
            prevMoveUsed = -1;
            damageHp();
        }
    }

    private void damageHp() {
        
    	previousXP = XP;
        XP -= degat;
        degat = 0;
        if (XP <= 0) {
            XP = 0;
            dead = true;
        }
    }

// --- Application - Soin --- 
    public void applyHeal() {
        
    	previousXP = XP;
        moveUsed = prevMoveUsed;
        prevMoveUsed = -1;
        XP += healing;
        healing = 0;
        if (XP > maxXP) XP = maxXP;
    }

//--- Justesse de l'attaqye -- 
    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

   public TileMap getTileMap() {
        return getTileMap();
   }

    public String getId() {
        return id;
    }
    
    public moveSet getMoveset() { return moveset; }

    public int getHp() {
        return XP;
    }

    public void setHp(int hp) {
        this.XP = hp;
    }

    public void setMaxHp(int maxHp) {
        this.maxXP = maxHp;
    }

    public int getMaxHp() {
        return maxXP;
    }

    public int getPreviousHp() { return previousXP; }

    public void setPreviousHp(int previousHp) { this.previousXP = previousHp; }

    public void setLevel(int level) { this.level = level; }

    public int getLevel() {
        return level;
    }

    public int getMinDamage() { return minDamage; }

    public int getMaxDamage() { return maxDamage; }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public int getAccuracy() { return accuracy; }

    public boolean isDead() { return dead; }

    public void setDead(boolean dead) { this.dead = dead; }
   
// Equipement  --- 
    public boolean isHasShield() {
        return hasShield;
    }

    public void setHasShield(boolean hasShield) {
        this.hasShield = hasShield;
    }

    public int getShield() {
        return shield;
    }

    public int getMaxShield() {
        return maxShield;
    }

    public void setMaxShield(int maxShield) {
        this.maxShield = maxShield;
    }

    public int getPrevShield() {
        return prevShield;
    }

    public void setPrevShield(int prevShield) {
        this.prevShield = prevShield;
    }

    public boolean healthBelow(int percentage) {
        return XP <= (int) ((percentage / 100f) * (float) maxXP);
    }

	public job getMetier() {
		return metier;
	}

	public void setMetier(job metier) {
		this.metier = metier;
	}

	public boolean isPresenceArmure() {
		return presenceArmure;
	}

	public void setPresenceArmure(boolean presenceArmure) {
		this.presenceArmure = presenceArmure;
	}

	public int getMains() {
		return mains;
	}

	public void setMains(int mains) {
		this.mains = mains;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public int getPtv() {
		return ptv;
	}

	public void setPtv(int ptv) {
		this.ptv = ptv;
	}

	public int getAttaque() {
		return attaque;
	}

	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}

	public int getBonusAttaque() {
		return bonusAttaque;
	}

	public void setBonusAttaque(int bonusAttaque) {
		this.bonusAttaque = bonusAttaque;
	}

	public int getBonusDefense() {
		return bonusDefense;
	}

	public void setBonusDefense(int bonusDefense) {
		this.bonusDefense = bonusDefense;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

}
