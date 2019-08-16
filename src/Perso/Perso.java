package Perso;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Enemy.Enemy;

import Battle.BattleFight;
import Battle.Effect;
import Battle.StatusEffect;

import Inventory.Item;
import Inventory.Armure;
import Inventory.ItemType;
import Inventory.Potion;
import Mouvement.Vector2d;
import Inventory.ArmeItem;
import Inventory.Inventory;

import Perso.Perso;
import Perso.PersoItems;
import Perso.PersoStats;


public class Perso {

	protected static String nom;
	protected static Race race; // Liste des races des perso -- 
	protected static int level; 
	private char glyph;
	private String causeKO;
	protected static int xp;
	protected static int Gold;

// -----------------  Niveau de vie ------------	
	protected static int ptv;
	protected static int ptvMin; 
	protected static int ptvMax;
	
	protected static PersoStats Stats;
	
// -----------------  Item & Conso ------------
 	
	private int food;
	private int maxFood;
  	private Armure armure;
  	private ArmeItem weapon;
	private Inventory inventory;
	protected static PersoItems Items;
          
// -----------------  Battle ------------ 
	//-- Degats --- 
	private int mana;
	private int maxMana;
  	static int degat= 0;
    	private int soin = 0;
    private int regenManaCooldown;
    private int regenManaPer1000;
    
    BattleFight BattleAction;
   
    protected static int defence; 
    protected static int justesse; // Justesse de l'attaque
  	protected static int attaque ;
  	
    protected static int minDegat; 
    protected static int maxDegat;
  
    protected static int bonusAttaque; //addition des differents bonus d'equipement
    protected static int bonusDefense; 
    protected static boolean  mainlibre;
    
    protected static boolean dead = false;
    protected static boolean presenceArmure; 
    
    public static StatusEffect statusEffects;

       
//-- Constructor --- 
    public Perso (String nom, Race race) {
        
    	nom = nom;
    	race = race;
        level = 1; // niv de base
        xp = 5; // niv xp � modifier peut �tre
        Gold = 30; // pareil pour les golds
        ptv = 10;
        ptvMin = 5;
        minDegat = 5;
        maxDegat = 10; 
        degat = 0; 
        this.maxMana = 5;
        mainlibre = true;
        this.maxFood = 1000;
        this.attaque = attaque;
      	this.defence = defence;
        presenceArmure = false; //-- Pas d'armure au debut jeu ?
		this.food = maxFood / 3 * 2;
	
		Stats = new PersoStats();
	    Items = new PersoItems();
		this.inventory = new Inventory();
		//this.statusEffects = new ArrayList<Effect>();
      
    }
 	   
    
//--- Point de vie  --- 
    public int ptv() { return ptv; }
	
    public int maxPtv() { return ptvMax; }
	
    public void modifPtv(int valeur, String string) { ptvMax += valeur; }
	
    public static int getPtv() { return ptv; }
    
    public static int setPtv(int i, String string) { return ptv; }
   

//--- LEVEL --
   public static int getLevel() { return level; }
   
   //--- Exp pour passer au niveau suivant 10 * level^2
   public int getExperienceForNextLevel() { return 10 * level * level;}
   
   //--- Recup Xp pour voir s'il Level Up --
  	private void levelUpIfNeeded() {
     
	   int requiredXP;

      while (	xp >= (requiredXP = getExperienceForNextLevel())) {
   	   		xp -= requiredXP;
   	   		++level;
      }
  
  	}


//--- XP --
   public int getXp() { return xp; }

   public void addXP(int xp, String string) {
       
	   if (xp < 0)
           return;

       xp += xp;

       levelUpIfNeeded();
   }

   public void modifXp(int amount) { 
		
	   xp += amount;
		
		//notify("You %s %d xp.", amount < 0 ? "lose" : "gain", amount);
		
		while (xp > (int)(Math.pow(level, 1.75) * 25)) {
			level++;
			//doAction("advance to level %d", level);
			//ai.onGainLevel();
			modifPtv(level * 2, "Died from having a negative level?");
		}
	}



//---- Mana ---- 
    public int mana() { return mana; }
	
   	public void modifMana(int montant) { 
	   mana = Math.max(0, Math.min(mana+montant, maxMana)); 
	}
   	
   	
//---- Attaque  ---- 
   public void modifAttaque(int valeur) { attaque += valeur; }
	
   public int attaqueValeur() { 	
		return attaque + (weapon == null ? 0 : weapon.getNivBonusAttaque());
   	}	


//---- Défence  ---- 
	public void modifDefValeur(int valeur) { defence += valeur; }
	
	
	public int defValeur() { 
		
		return defence
			+ (weapon == null ? 0 : weapon.valDefence())
			+ (getArmure() == null ? 0 : getArmure().valDefence());
	}
	
  
	public void recoitDegat(int dmg) {
	       
		   if (dmg < 0)
	       return;

	       Stats.setCurrentHealth(Stats.getCurrentHealth() - dmg);
	       if (Stats.getCurrentHealth() <= 0);
	          
	}
	
	
	public String causeKO() { return causeKO; }
   
   
	public char glyph() { return glyph; } 
	
   
	
//--- Use potion de restau --
   public void restauSante(int ptv) {
       
	   if (ptv < 0)
           return;

       Stats.setCurrentHealth(Stats.getCurrentHealth() + ptv);
   }
   
   
//---  Soin -- 
   public int heal(Item item) { return soin; }
     
   public static PersoStats getStats() { return Stats; }

   public static PersoItems getItemData() { return Items; }
  
//--- Return vrai si les achats ont réussis, sinon Faux
   
   public Inventory inventaire() { return inventory; } 
   
   public Item arme() { return weapon; }
	
   public Item armure() { return armure; } 
   
   public boolean buyItem(Item newItem) {
      
   	
	   if (!verifSiMoney(newItem.getPrix()))
       return false;
  
	   // Armure // Armes Distances // Armes melees // Sorts --     
   		if (newItem.getType() == ItemType.ARME_DISTANCE || 
   			newItem.getType() == ItemType.ARME_MELEE ||
   			newItem.getType() == ItemType.ARMURE || 
   			newItem.getType() == ItemType.SORT) {
           
   			ArmeItem itemAsWeapon = (ArmeItem) newItem;
   		
   			if (itemAsWeapon.getNivDexterite() > getStats().getDexterity() ||
   					itemAsWeapon.getNivBonusAttaque() > getStats().getStrength())
               
   				return false;	
       }

       if (!Items.storeNewItem(newItem))
           return false;

       useMoney(newItem.getPrix());
       return true;
  
   }

   public void vendItem(Item item) {
       
   		for (int i = 0; i < PersoItems.MaxInventorySize; ++i) {
           
   			Item currentItem = Items.getInventoryItem(i);

   			if (currentItem == item) {
               
        	   Items.removeInventoryItem(i);
               addMoney(item.getPrix());
               return;
           }
       
   		}
   }
   
 
//--- Update  Santé / Mana / Effet   
   public void update(){
		
	   modifyFood(-1);
	   regenerationSante();
	   regenerationMana();
	   updateEffects();
	  
   }
	
	
   private void updateEffects(){
		
		List<Effect> udpateEff = new ArrayList<Effect>();
		
		//for (Effect effect == effect){
			
		statusEffects.update(this);
			if (statusEffects.isDone()) {
				
				statusEffects.end(this);
				udpateEff.add(statusEffects);
			}
	
			//statusEffects.removeAll(udpateEff);
   }
		
    	
   private void regenerationSante(){
		
		regenManaCooldown -= regenManaPer1000;
		
		if (regenManaCooldown < 0){
			
			if (xp < maxPtv()){
				modifPtv(1, "Tu es KO! Tu veux te refaire une santé ?");
				modifyFood(-1);
			}
			
			regenManaCooldown += 1000;
		}
	}
	
   
   private void regenerationMana(){
		
		regenManaCooldown -= regenManaPer1000;
		
		if (regenManaCooldown < 0){
		
			if (mana < maxMana) {
				modifMana(1);
				modifXp(-1);
			}
			
			regenManaCooldown += 1000;
		}
	} 

  

//--- Gestion des GOLDS --
	  
	public void addMoney(int montant) {
	       
		if (montant < 0)
	         return;

	     Gold += montant;
	   
	}

	public boolean verifSiMoney(int montant) { return Gold >= montant; }

	public boolean useMoney(int montant) {
	       
		 if (montant < 0)
	         return false;

	       if (!verifSiMoney(montant)) // verif si le perso des sousous
	           return false;

	       Gold -= montant;
	       return true;
	}
	   
	public static int getMoney() { return Gold; }


// ---- ITEMS  ------- 
	
   public void pickup(Vector2d v){
		
		Item item =1;
		
		if (inventory.isFull() || item == null){
			//doAction("grab at the ground");
		
		} else {
			//doAction("pickup a %s", item.getNom());
			//Map.remove(item);
			inventory.add(item);
		
		}
	}
	
	
   // Ramasser un objet --
   public void drop(Item item){
		
	//doAction("drop a " + item.getNom());
	   inventory.remove(item);
	   noEquip(item);
		
	}
    
	
   public void modifyFood(int montantFood) { 
		
	   food += montantFood;
		
		if (food > maxFood) {
			
			maxFood = (maxFood + food) / 2;
			food = maxFood;
			//notify("You can't belive your stomach can hold that much!", null);
			modifPtv(-1, "Killed by overeating.");
		
		} else if (food < 1) {
			modifPtv(-1000, "Starved to death.");
		
		}
	}
 
	
  
	
	
   public void consoPotionf(Potion potion){
		//doAction("Avaler:  " + item.getNom());
		consume(potion + potion.getNom());
	}
	
	
   private void consume(Item item){
		
	   if (item.valeurFood() < 0)
		//notify("Gross!");
		addEffect(item.quaffEffect());
		
		modifyFood(item.valeurFood());
		supObj(item);
	
   }
	
   public boolean siMainslivre() { return siMainslivre(); }

   private void addEffect(Effect effect){
		
	   if (effect == null)
			return;
		
		effect.start(this);
		
	}
	
   private void supObj(Item item){
		inventory.remove(item);
		noEquip(item);
	
   }
	
	public void equiper(Item item){
		
		if (!inventory.contains(item)) {
			
			if (inventory.isFull()) {
				//notify("Can't equip %s since you're holding too much stuff.", item.getNom());
				return;
			
			} else {
				//map.remove(item);s
				inventory.add(item);
			
			}
		}
		
		if (item.valAttaque() == 0 && item.rangedAttackValue() == 0 && item.valDefence() == 0)
			return;
		
		if (item.valAttaque() + item.rangedAttackValue() >= item.valDefence()){
			noEquip(weapon);
			doAction("wield a " + item.getNom());
			weapon = (ArmeItem) item;
		
		} else {
			noEquip(getArmure());
			doAction("put on a " + item.getNom());
			setArmure(item);
		}
	}
	
	
   public void noEquip (Item item){
		
	   if (item == null)
		return;
		
		if (item == getArmure()){
			
			if (ptv > 0)
				doAction("Supprimer l'objet:" + item.getNom());
				setArmure(null);
		
		} else if (item == weapon) {
			
			if (ptv > 0) 
				doAction("Ranger l'objet" + item.getNom());
				weapon = null;
		
		}
	}
	
	
   public void setPresenceArmure(boolean presenceArmure) {
		Perso.presenceArmure = presenceArmure;
	}
   
	/*private int detectCreatures;
	public void modifyDetectCreatures(int amount) { setDetectCreatures(getDetectCreatures() + amount); }
	public int getDetectCreatures() { return detectCreatures; }
	public void setDetectCreatures(int detectCreatures) {
		this.detectCreatures = detectCreatures;
	}*/
	

//-- GETTER & SETTER 
	
	public static String getNom() { return nom;}
	
	boolean siPresenceArmure() { return presenceArmure; }

	public void setMainslivre(boolean mainslivre) { Perso.mainlibre = mainslivre;}

	public Armure getArmure() { return armure; }

	public void setArmure(Armure armure) { this.armure = armure; }


}
