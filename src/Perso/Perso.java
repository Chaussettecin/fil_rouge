package Perso;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import Battle.battleAction;
import Effect.effect;
import Effect.statusEffect;
import Enemy.Enemy;
import Inventory.ArmeItem;
import Inventory.ArmesMelees;
import Inventory.Item;
import Inventory.ItemType;
import Main.Game;
import Perso.Perso;
import Perso.PersoItems;
import Perso.PersoStats;
import Player.Player;
import UI.UI;

public class Perso {
	
	//private static Player CurrentCharacter = null;
	protected static Race ClassesPerso; // Liste des races des perso -- 
	private PersoStats Stats;
    private static PersoItems Items;
    private Enemy meetEnemy;
    private static File deleteFile; // Sauvegarde
    
	private final String Nom;
	private int Level; 
	private int XP;
	private static int Gold;
  	private static int ptv;// ------pts de vie de base
  	private int ptvMin; 
  	
  	protected static boolean dead = false; //----Verif s'il est est vivant ou pas

//-- Degats --- 
    protected static int minDegat; 
    protected static int maxDegat;
    static int degat= 0;
    protected int soin = 0;
   
  	protected static int attaque ;     
  	protected static int bonusAttaque ; //addition des differents bonus d'equipement
    private int defense; 
    protected int accuracy; // Justesse de l'attaque
    protected static int bonusDefense; //addition des differents bonus d'equipement

    protected Map<Character, Integer> capacites;
   
//-- Si le joueur à une armure --
    protected boolean presenceArmure;          
    protected static boolean  mainslivre; // savoir si le perso à les mains libres ou pas

//-- Battle status effets --
    public static statusEffect statusEffects;
	private static Object CurrentCharacter;
    battleAction BattleAction;

    
//--- Dialogue avec un PNJ --
    private boolean tileInteraction = false;
    

//-- Constructor --- 
    public Perso (String nom, Race ClassesPerso, PersoStats Stats,
    		PersoItems Items,int Level, int XP, int Gold,int ptv, int ptvMin,
    		int minDegat,int maxDegat,int degat,int attaque, int bonusAttaque,
    		int defense, int accuracy, int bonusDefense,boolean presenceArmure, 
    		boolean  mainslibre,statusEffect statusEffects) {
        
    	Nom = nom;
    	Perso.ClassesPerso = ClassesPerso;
        Level = 1; // niv de base
        XP = 5; // niv xp à modifier peut être
        Gold = 30; // pareil pour les golds
        ptv = 10;
        ptvMin = 5;
        minDegat = 5;
        maxDegat = 10; 
        degat = 0; 
        presenceArmure = false; //-- Pas d'armure au debut jeu ?
        mainslibre = true;

        Stats = new PersoStats();
        Items = new PersoItems();
    
    }
 	   

   public void attaquePerso(int degat) {
        Perso.degat = degat;
   }
    
   public static Perso getCurrentCharacter() {
       return getCurrentCharacter();
   }

   public static Perso setCurrentCharacter(Object character) {
       CurrentCharacter = character;
   }

   public String getNom() {
       return Nom;
   }

   public static int getMoney() {
       return Gold;
   }

   public void addMoney(int montant) {
       if (montant < 0)
           return;

       Gold += montant;
   }

   public boolean verifSiMoney(int montant) {
       return Gold >= montant;
   }

   public boolean UseMoney(int montant) {
       
	   if (montant < 0)
           return false;

       if (!verifSiMoney(montant)) // verif si le perso à des sousous
           return false;

       Gold -= montant;
       return true;
   }

   public int getLevel() {
       return Level;
   }

   public int getXp() {
       return XP;
   }

   public void addXP(int xp) {
       
	   if (xp < 0)
           return;

       XP += xp;

       levelUpIfNeeded();
   }

// Exp pour passer au niveau suivant 10 * level^2
   public int getExperienceForNextLevel() {
       return 10 * Level * Level;
   }

   private void levelUpIfNeeded() {
      
	   int requiredXP;

       while (XP >= (requiredXP = getExperienceForNextLevel())) {
          
    	   XP -= requiredXP;
           ++Level;
           
       }
   }

   private void die() {
       
	   deleteFile.delete();
       
       System.out.println("Le personnage " + Nom + "est mort.");
       System.out.println("Oupss.... pas de chance");
       System.out.println("Game Over...");
       System.out.print("Presse sur une touche pour revenir");
       Scanner scan = new Scanner(System.in);
       scan.nextLine();
       System.exit(0);
   }

   public void recoitDegat(int dmg) {
       
	   if (dmg < 0)
           return;

       Stats.setCurrentHealth(Stats.getCurrentHealth() - dmg);

       if (Stats.getCurrentHealth() <= 0)
           die();
   }

   public void restauSante(int ptv) {
       
	   if (ptv < 0)
           return;

       Stats.setCurrentHealth(Stats.getCurrentHealth() + ptv);
   }

   public PersoStats getStats() {
       return Stats;
   }

   public static PersoItems getItemData() { 
       return Items; 
   }

//-- Return vrai si les achats ont réussis, sinon Faux
   public boolean buyItem(Item newItem) {
      
   	if (!verifSiMoney(newItem.getPrix()))
           return false;
  // Armure // Armes Distances // Armes melees // Sorts --     
   	if (newItem.getType() == ItemType.ARME_DISTANCE || newItem.getType() == ItemType.ARME_MELEE
   		|| newItem.getType() == ItemType.ARMURE || newItem.getType() == ItemType.SORT) {
           
   		ArmeItem itemAsWeapon = (ArmeItem) newItem;
   		
        if (itemAsWeapon.getRequiredDexterity() > getStats().getDexterity() ||
            itemAsWeapon.getRequiredStrength() > getStats().getStrength())
               
        	return false;
       }

       if (!Items.storeNewItem(newItem))
           return false;

       UseMoney(newItem.getPrix());
       return true;
   }

   public void VendItem(Item item) {
       
   	for (int i = 0; i < PersoItems.MaxInventorySize; ++i) {
           
   		Item currentItem = Items.getInventoryItem(i);

           if (currentItem == item) {
               
        	   Items.removeInventoryItem(i);
               addMoney(item.getPrix());
               return;
           }
       }
   }

//-- Perso defent --- 
    /*public int defend(enemy ennemi) {
        
    	int incomingAttack = ennemi.attaque();
        int random = Game.RAND.nextInt(99) + 1;
        
        if (random <= ennemi.attaque()) {
            
        	incomingAttack = incomingAttack * 2;
            UI.monsterCrit(); 
        }
        
        UI.persoAttaqueMsg(incomingAttack, ennemi);
        
        attaque = (attaque * defense > incomingAttack)
                ? attaque - incomingAttack : 0;
        return attaque;
    }*/
    
   
//-- Soin -- 
   /* public int heal(Item item) {
        return soin = item;
    }*/

    public void addEffect(effect effets){
        //this.effets.add(effets);
    }
    
   //execute les effets
    public void lancerEffets(int i){
        
    }
    

//--- Paramètre bouclier -- 
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
    
//--  GETTER ET SETTER  Equipements - 
	public ArrayList<ArmesMelees> getArmure() {
		return null;
	}

	public ArrayList<Enemy> getutiliserArmesDistance() {
		return null;
	}

	public ArrayList<Enemy> getUtiliserArMelee() {
		return null;
	}


//-- GETTER ET SETTER  Point de vie - 
	public void setKO(boolean dead) { Perso.dead = dead; }
	
	public static boolean isKO() { return dead; }
	
	public static int getPtv() {
		return ptv;
	}

	public static void setPtv(int ptv) {
		Perso.ptv = ptv;
	}
	
	public int getPtvMin() {
		return ptvMin;
	}

	public void setPtvMin(int item) {
		this.ptvMin = item;
	}
	
//-- GETTER ET SETTER  Race - 
	public Race getRace() {
		return ClassesPerso;
	}

	public void setRace(Race race) {
		Perso.ClassesPerso = race;
	}

	
//-- GETTER ET SETTER  Attaque --- 
	public int getAttaque(Enemy enemy) {
		return attaque;
	}

	public void setAttaque(int attaque) {
		Perso.attaque = attaque;
	}
	
	public int getBonusDefense() {
		return bonusDefense;
	}

	public void setBonusDefense(int bonusDefense) {
		Perso.bonusDefense = bonusDefense;
	}

	public int getBonusAttaque() {
		return bonusAttaque;
	}

	public void setBonusAttaque(int bonusAttaque) {
		Perso.bonusAttaque = bonusAttaque;
	}
	

//--- Justesse de l'attaque -- 
    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }
    
    public int getJustesse() { return accuracy; }
    

//-- GETTER ET SETTER  Degat--- 
    public int getDegat() {
    	return degat;
    }
    
    public int setDegat() {
    	return degat;
    }
	
    public int getMinDegat() { return minDegat; }

    public int getMaxDegat() { return maxDegat; }

    public void setMinDegat(int minDegat) {
        Perso.minDegat = minDegat;
    }

    public void setMaxDamage(int maxDegat) {
        Perso.maxDegat = maxDegat;
    }

//-- GETTER & SETTER Rencontre avec un ennemi
	public Enemy getMeetEnnemi() {
		return meetEnemy;
	}

	public void setMeetEnemy(Enemy meetEnemy) {
		this.meetEnemy = meetEnemy;
	}

	public abstract void takeTurn(battleAction playerAction, Enemy enemie);
	
	
//--- GETTER ET SETTER interaction PNJ	
	public boolean isTileInteraction() {
		return tileInteraction;
	}

	public void setTileInteraction(boolean tileInteraction) {
		this.tileInteraction = tileInteraction;
	}

//-- GETTER & SETTER Rencontre avec un ennemi 
	boolean siPresenceArmure() {
		return presenceArmure;
	}

	public void setPresenceArmure(boolean presenceArmure) {
		this.presenceArmure = presenceArmure;
	}

	public boolean siMainslivre() {
		return mainslivre;
	}

	public void setMainslivre(boolean mainslivre) {
		this.mainslivre = mainslivre;
	}

	
}
