package perso;

import java.util.ArrayList;
import java.util.Scanner;

import Effect.statusEffect;
import Player.Player;
import enemys.enemy;
import inventory.Equipment;
import inventory.Inventory;
import inventory.Item;
import inventory.armes_bouclier;
import inventory.armes_melees;
import main.Game;
import maps.Room;
import resource.Statistics;
import ui.UI;


public abstract class perso  extends Player{
	
	public static final String getSort = null;

	private static String nom ;
	private String description;
	protected int level;
	private Race race ;
	
  	private int ptv ;// ------------------pts de vie de base
  	private int ptvMin; 
    protected boolean dead = false; //----Verif s'il est est vivant ou pas
    // damage range
    protected int minDamage;
    protected int maxDamage;
    int degat= 0;
    protected int soin = 0;
    
    private int gold = 0; // -------------Monnaie 
  	private int attaque ;     
  	private int bonusAttaque ; //---------addition des differents bonus d'equipement
    private int defense;
    protected int accuracy;
    private int bonusDefense ; //---------addition des differents bonus d'equipement

    
//-- Inventaire - Sac à dos  - 
    public Inventory inventory;
    public static Equipment equips;
    
  //-- Si le joueur à une armure  
    private boolean presenceArmure;           
    private boolean  mainslivre; // savoir si le perso à les mains libres ou pas
    
    // Battle
    private enemy opponent;
    private boolean battling = false;
// Battle status effets 
    public statusEffect statusEffects;
    
//--- Dialogue avec un PNJ 
    private boolean tileInteraction = false;
    
// -- Deplacement - et salle
    private int currX;
    private int currY;
    private Room currRoom;


//-- Constructor --- 
    public perso(String id, int level, int ptv, int ptvMin) {
		
    	super(id);
		
    		this.nom = nom;
    		this.description = description;
    		this.setRace(race);
    		this.ptv = ptv; 
    		this.setPtvMin(ptvMin);
    		this.dead = dead;
    		this.minDamage = minDamage;
    		this.maxDamage = maxDamage;
    		this.defense = defense;
    		this.accuracy = accuracy;
    		this.setBonusAttaque(bonusAttaque);
    		this.setBonusDefense(bonusDefense); 
   
    		this.currX = 14;
    		this.currY = 14;
    		//this.inventory = new ArrayList<>(10);
        	//Item.addPotion(3, this);
    	
	}
    
    public int attack() {
    		return Game.RAND.nextInt(maxDamage - minDamage + 1);
    }

    	
    public int defend(enemy Enemy) {
        
    		Degat.degat incomingAttack = Enemy.attaqueBase(description);
    		int random = Game.RAND.nextInt(99) + 1;
    		
    		if (random <= Enemy.getDefense()) {
    			incomingAttack = incomingAttack * 2;
    			UI.monsterCrit(); 
    		}
    		
    		UI.playerHitPointsMessage(incomingAttack, Enemy);
    		ptv = (ptv * defense > incomingAttack)
                ? ptv - incomingAttack : 0;
    		return ptv;
    }
    
    
//-- A personaliser en fonction du background du personnage -  
    public static perso creaPerso(){
    	
    	Scanner sc = new Scanner(System.in);
    		
    	int reponseRace;
    	perso personnage = null;

    		System.out.println("--- Création du personnage ---");
    		System.out.println("                              ");
    		System.out.println("                              ");
    		System.out.println("\nChoix du nom de personnage :");
    		
    		nom = sc.nextLine();
    
    		System.out.println("\nChoix de ta race :");

    			do {
    				System.out.println("1 Humain");
    				System.out.println("2 Elfe");
    				System.out.println("3 Orc");
    				System.out.println("4-Nain");
        
    				try {
    					reponseRace = sc.nextInt();
    		
    			} catch (Exception e){
    				reponseRace = 0;
    				sc.nextLine();
    			}	
    		
    		} while (reponseRace != 1 && reponseRace != 2 && reponseRace != 3);

    		switch (reponseRace){
        
    		case 1 :
    			//race = new humain();
    			break;
    		
    		case 2 :
    			//race = new elfe();
    			break;
    		
    		case 3 :
    			//race = new orc();
    			break;
    		
    		default :
            //race = new humain();
    	}
    	

    	//personnage = new perso(nom,race);
    
    	System.out.println("\n Voici une synthése de Ton personnage :");
    	System.out.println(personnage);
    	
    	return personnage;

    }


//-- Perso se prend une attaque
    public void attaquePerso(int damage) {
        this.degat = damage;
    }
    
//-- Soin -- 
    public int heal(int soin) {
        return this.soin = soin;
    }

  // --- Application - Soin --- 
    public void applyHeal() {
        
    	previousXP = XP;
        XP += soin;
        soin = 0;
        if (XP > maxXP) XP = maxXP;
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


 //--- Justesse de l'attaqye -- 
    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

 
    public int getId() {
        return id;
    }
    
   

//-- SET et GETTER Lvl ----
    public void setLevel(int level) { this.level = level; }

    public int getLevel() {
        return level;
    }


 //-- SET et GETTER degats ---
    public int getMinDamage() { return minDamage; }

    public int getMaxDamage() { return maxDamage; }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

//-- SET et GETTER justesse des coups
    public int getJustesse() { return accuracy; }

//--  SET et GETTER qui verifie si le perso est encore en envie ou pas --
    public boolean isKO() { return dead; }

    public void setKO(boolean dead) { this.dead = dead; }
  
   
//--- SET et GETTER Soin 
    
    public boolean healthBelow(int percentage) {
        return XP <= (int) ((percentage / 100f) * (float) maxXP);
    }

//--- SET et GETTER metier 
	
	public Degat.degat infligeDegats(int i) {
		return null;
	}

	public ArrayList<armes_melees> getArmure() {
		return null;
	}

	public ArrayList<enemy> getutiliserArmesDistance() {
	
		return null;
	}

	public ArrayList<enemy> getUtiliserArMelee() {
	
		return null;
	}

	public int getGold() {
		return 0;
	}

	public void setGold(int i) {
		
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public int getPtvMin() {
		return ptvMin;
	}

	public void setPtvMin(int ptvMin) {
		this.ptvMin = ptvMin;
	}

	public int getBonusDefense() {
		return bonusDefense;
	}

	public void setBonusDefense(int bonusDefense) {
		this.bonusDefense = bonusDefense;
	}

	public int getBonusAttaque() {
		return bonusAttaque;
	}

	public void setBonusAttaque(int bonusAttaque) {
		this.bonusAttaque = bonusAttaque;
	}




}
