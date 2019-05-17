package perso;

import java.util.ArrayList;
import Battle.moveSet;
import map.TileMap;
import resource.ResourceManager;


public abstract class perso {

    protected String id;
	private String nom ;
	
	private Job metier ;    
  	
	private Race race ;
  	private int ptv ;           // pts de vie de base
    protected boolean dead = false; // Verif s'il est est vivant ou pas
    
  	private int attaque ;     
  	private int bonusAttaque ; // addition des differents bonus d'equipement
    private int defense ;      
    private int bonusDefense ; // addition des differents bonus d'equipement
    
    protected ResourceManager rm;
    // level up information
    protected int level;
    protected moveSet moveset;
  
    protected int hp;
    protected int maxHp;
    // for animation to keep track of hp difference between attacks
    protected int previousHp;

// position (x,y) in map coordinates (tile * tileSize)
    //protected static Vector2 position;
    
    // move type used default -1
    protected int prevMoveUsed = -1;
    protected int moveUsed = -1;

//---- map ---
    	// protected TileMap tileMap;

    // for applying the hp change after the dialogue is finished
    protected int damage = 0;
    protected int healing = 0;
    // 0-100 in % points
    protected int accuracy;
    // damage range
    protected int minDamage;
    protected int maxDamage;

    // Defence
    protected boolean hasShield = false;
    protected int shield;
    protected int maxShield;
    protected int prevShield;

//--- VAR Equipements ---- 
    	//-- armes portée par le perso
    		//private ArrayList<Arme> dansLesMains = new ArrayList<>();  
    private int mains ;                  //si mains dispo
    	//--- private Armure corps ;               // armure portee                                           
    private boolean presenceArmure;           
                                       
//-- Constructor --- 
    public perso(String id, ResourceManager rm) {
        this.id = id;
        this.rm = rm;

        //position = new Vector2();
    }

    public perso(String id, Vector2 position, TileMap tileMap, ResourceManager rm) {
        this(id, rm);
        //this.position = position;
        //this.tileMap = tileMap;
    }

    public void update(float dt) {
        // handle RPG elements
        if (hp > maxHp) hp = maxHp;
        if (hp <= 0) {
            hp = 0;
        }

        // animation
        //if (!pauseAnim) am.update(dt);
    }

    /*public void render(SpriteBatch batch, boolean looping) {
        // draw shadow
        batch.draw(rm.shadow11x6, position.x + 3, position.y - 3);
        batch.draw(am.getKeyFrame(looping), position.x, position.y);
    }*/

//-- An entity's hp is decreased by damage taken -
    public void hit(int damage) {
        this.damage = damage;
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
            if (damage == 0) {
                hasShield = false;
                return;
            }
            prevShield = shield;
            moveUsed = prevMoveUsed;
            prevMoveUsed = -1;

            //-- Si les degats casse le shield (bouclier) le joueur connait des degats
            if (shield - damage < 0) {
                damage = Math.abs(shield - damage);
                shield = 0;
                damageHp();
            }
            // damage breaks through the entire shield but does not damage hp bar
            else if (shield - damage == 0) {
                shield = 0;
            }
            // damage damages the shield
            else {
                shield -= damage;
                damage = 0;
            }

        }
        else {
            moveUsed = prevMoveUsed;
            prevMoveUsed = -1;
            damageHp();
        }
    }

    private void damageHp() {
        previousHp = hp;
        hp -= damage;
        damage = 0;
        if (hp <= 0) {
            hp = 0;
            dead = true;
        }
    }

// --- Application - Soin --- 
    public void applyHeal() {
        previousHp = hp;
        moveUsed = prevMoveUsed;
        prevMoveUsed = -1;
        hp += healing;
        healing = 0;
        if (hp > maxHp) hp = maxHp;
    }

   public void setMap(TileMap map) {
        //this.tileMap = map;
        //this.position.set(map.toMapCoords(map.playerSpawn));
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

   public TileMap getTileMap() {
        return getTileMap();
   }

   //public void setPosition(Vector2 position) {
       // this.position = position;
    //}

    public String getId() {
        return id;
    }

   // public Vector2 getPosition() {
      //  return position;
    //}

    public moveSet getMoveset() { return moveset; }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getPreviousHp() { return previousHp; }

    public void setPreviousHp(int previousHp) { this.previousHp = previousHp; }

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

    public int getMoveUsed() { return moveUsed; }

    public void useMove(int move) {
        this.prevMoveUsed = move;
    }

    public int getPrevMoveUsed() { return prevMoveUsed; }

    public void setMoveUsed(int moveUsed) {
        this.moveUsed = moveUsed;
    }

    public void setPrevMoveUsed(int prevMoveUsed) { this.prevMoveUsed = prevMoveUsed; }


//--- Returns the tile the Entity is currently standing on -- 
    //public Tile getCurrentTile() {
        //return tileMap.getTile(tileMap.toTileCoords(position));
    //}

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

//-- Returns if the entity's hp is below or equal to a certain threshold -
    public boolean healthBelow(int percentage) {
        return hp <= (int) ((percentage / 100f) * (float) maxHp);
    }

}
