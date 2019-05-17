package perso;

import java.util.ArrayList;
import Battle.moveSet;
import Battle.statusSet;
import inventory.Equipment;
import inventory.Inventory;
import inventory.armes_bouclier;
import inventory.liste_Armes;
import map.TileMap;
import resource.ResourceManager;
import resource.Statistics;


public abstract class perso  extends Player{
	
    public perso(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	protected String id;
    
	private String nom ;
	private job metier ;
	protected int level;
	private Race race ;
  	private int ptv ;           // pts de vie de base
    protected boolean dead = false; // Verif s'il est est vivant ou pas
    
    private int gold = 0;
  	private int attaque ;     
  	private int bonusAttaque ; // addition des differents bonus d'equipement
    private int defense ;      
    private int bonusDefense ; // addition des differents bonus d'equipement
    
    // Battle
    private enemy opponent;
    private boolean battling = false;
    
    protected static ResourceManager rm;
    protected moveSet moveset;
  
    protected int XP;
    protected int maxXP;
    protected int previousXP;
    int degat= 0;
    protected int soin = 0;
    // 0-100 in % points
    protected int accuracy;
    // damage range
    protected int minDamage;
    protected int maxDamage;

//-- Inventaire - Sac à dos  - 
    public Inventory inventory;
    public static Equipment equips;
    
// Battle status effets 
    public statusSet statusEffects;
    
	//--- Mouvement a voir avec Fabrice 
    public int moving = -1;
    private float speed;

//--- Dialogue avec un PNJ 
    private boolean tileInteraction = false;
// -- Monde fini
    public boolean completedMap = false;
    // player's level progress stored as a (world, level) key
    public int maxWorld = 0;
    public int maxLevel = 0;


// special moveset
    public moveSet smoveset;
//-- Mouvement type utilise  -1
    protected int prevMoveUsed = -1;
    protected int moveUsed = -1;
  //--- VAR Equipements ---- 
  
   // Defence
    //protected boolean hasShield = false;
    //protected int shield;
    //protected int maxShield;
    //protected int prevShield;
    
    private ArrayList<liste_Armes> dansLesMains = new ArrayList<>();  
    private boolean presenceArmure;           
    private int mains ;

//-- Constructor --- 
  


    public void update(float dt) {
       
        if (XP > maxXP) XP = maxXP;
        if (XP <= 0) {
            XP = 0;
        }

    }


//-- Perso se prend une attaque
    public void hit(int damage) {
        this.degat = damage;
    }
    
    //-- Soin -- 
    public void heal(int Soin) {
        this.soin = Soin;
    }

//--- Paramètre bouclier -- 
    
    // -- Add un bouclier dans l'entité santé bar -
    public void isShield(armes_bouclier tempName, boolean hasShield) {
    	hasShield = true;
       
    }

    //-- Reset le bouclier du joueur à 0
    public void resetShield(armes_bouclier tempName, boolean hasShield) {
        hasShield = false;
  
    }

    //--Application des degats en fonction des attaques précédentes -
   /* public void applyDamage(armes_bouclier tempName, boolean hasShield) {
    	
    	//-- Avec un bouclier (defene) les degats sont appliqués d'abord pour diminuer la def
        if (hasShield) {
            if (degat == 0) {
                hasShield = false;
                return;
            }
  
            moveUsed = prevMoveUsed;
            prevMoveUsed = -1;

            //-- Si les degats casse le shield (bouclier) le joueur connait des degats
            if (hasShield = true) {
               degat - ptv = ;
                hasShield = true;
                damageHp();
            }
            // damage breaks through the entire shield but does not damage hp bar
            else if (hasShield - degat == 0) {
                hasShield = 0;
            }
            // damage damages the shield
            else {
                hasShield -= degat;
                degat = 0;
            }

        }
        else {
            moveUsed = prevMoveUsed;
            prevMoveUsed = -1;
            damageHp();
        }
    }*/

    private void degatsXP() {
        
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
        XP += soin;
        soin = 0;
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
