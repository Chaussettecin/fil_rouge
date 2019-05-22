package perso;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Effect.effect;
import Effect.statusEffect;
import Gold.gold;
import Player.Player;
import enemys.enemy;
import inventory.Equipment;
import inventory.Inventory;


import inventory.armes_bouclier;
import inventory.armes_melees;
import main.Game;



import ui.UI;


public abstract class perso  extends Player{
	
	public static final String getSort = null;

	private static String nom ;
	private String description;
	protected int level;
	
	private Race ClassesPerso ; // Liste des races des perso -- 
	
  	private int ptv ;// ------------------pts de vie de base
  	private int ptvMin; 
    protected static boolean dead = false; //----Verif s'il est est vivant ou pas
    // damage range
    protected int minDamage;
    protected int maxDamage;
    int degat= 0;
    protected int soin = 0;
    
    gold gold; // -------------Monnaie 
  	private int attaque ;     
  	private int bonusAttaque ; //---------addition des differents bonus d'equipement
    private int defense;
    protected int accuracy;
    private int bonusDefense ; //---------addition des differents bonus d'equipement

    protected Map<Character, Integer> capacites;
    
 //Liste des Skills
    protected List<perso_skill> skills;
    
//-- Inventaire - Sac à dos  - 
    public Inventory inventory;
    public static Equipment equips;
    
  //-- Si le joueur à une armure  
    private boolean presenceArmure;           
    private boolean  mainslivre; // savoir si le perso à les mains libres ou pas
    
    // Battle
    private enemy meetEnemy;

// Battle status effets 
    public statusEffect statusEffects;
    
//--- Dialogue avec un PNJ 
    private boolean tileInteraction = false;
    

  

//-- Constructor --- 
    public perso(String id, String nom, String description, int level, int ptv, int ptvMin, boolean dead, int minDamage, int maxDamage, int defense, int accuracy) {
		
    	super(id);
		
    		perso.nom = nom;
    		this.description = description;
    		this.setRace(ClassesPerso);
    		this.ptv = ptv; 
    		this.setPtvMin(ptvMin);
    		
    		this.dead = dead;
    		this.minDamage = minDamage;
    		this.maxDamage = maxDamage;
    		this.defense = defense;
    		this.accuracy = accuracy;
    		
    		//this.setBonusAttaque(bonusAttaque);
    		//this.setBonusDefense(bonusDefense); 
    		
    		//this.initCharacteristics();
 	        //this.initSkills();
 	     
 	        //this.armes = null;
 	        //this.armure = null;
 	   
    		//this.inventory = new ArrayList<>(10);
        	//Item.addPotion(3, this);
    	
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
 

 //-- Methode Attaque perso - 
    public int attack() {
    	return Game.RAND.nextInt(maxDamage - minDamage + 1);
    }


//-- Perso se prend une attaque
    public void attaquePerso(int damage) {
        this.degat = damage;
    }
    
//-- Perso defent --- 
    public int defend(enemy Enemy, Degat.degat degat) {
        
		Degat.degat incomingAttack = Enemy.attaqueBase(description);
		int random = Game.RAND.nextInt(99) + 1;
		
		if (random <= Enemy.getDefense()) {
			UI.monsterCrit(); 
		}
		
		UI.monsterHitPointsMessage(incomingAttack, Enemy);
		/*ptv = (ptv * defense > incomingAttack)
            ? ptv - incomingAttack : 0;*/
		return ptv;
    }
    
   
//-- Soin -- 
    public int heal(int soin) {
        return this.soin = soin;
    }

    public void addEffect(effect effets){
        //this.effets.add(effets);
    }
    
   //execute les effets
    public void lancerEffets(){
        
        
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


//--- Justesse de l'attaque -- 
    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }
    
    public int getJustesse() { return accuracy; }

 
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


//--  SET et GETTER qui verifie si le perso est encore en envie ou pas --
    public boolean isKO() { return dead; }

    public void setKO(boolean dead) { this.dead = dead; }
  
   
//--- SET et GETTER Soin 
    
    public boolean healthBelow(int percentage) {
        return degat <= (int) ((percentage / 100f) * (float) defense);
    }

	
	public Degat.degat infligeDegats(PrintStream printStream) {
		return null;
	}


//--  GETTER ET SETTER  Equipements - 
	public ArrayList<armes_melees> getArmure() {
		return null;
	}

	public ArrayList<enemy> getutiliserArmesDistance() {
		return null;
	}

	public ArrayList<enemy> getUtiliserArMelee() {
		return null;
	}

//-- GETTER ET SETTER  Gold - 	
	public int getGold() {
		return 0;
	}

	public void setGold(int i) {
		return ; 
	}
	

//-- GETTER ET SETTER  Point de vie - 
	public int getPtvMin() {
		return ptvMin;
	}

	
	public void setPtvMin(int ptvMin) {
		this.ptvMin = ptvMin;
	}
	
	
//-- GETTER ET SETTER  Race - 
	public Race getRace() {
		return ClassesPerso;
	}

	
	public void setRace(Race race) {
		this.ClassesPerso = race;
	}

	
//-- GETTER ET SETTER  Bonus - 
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


//-- GETTER & SETTER Rencontre avec un enemy
	public enemy getMeetEnemy() {
		return meetEnemy;
	}

	public void setMeetEnemy(enemy meetEnemy) {
		this.meetEnemy = meetEnemy;
	}

	
	
//--- GETTER ET SETTER interaction PNJ	
	public boolean isTileInteraction() {
		return tileInteraction;
	}


	public void setTileInteraction(boolean tileInteraction) {
		this.tileInteraction = tileInteraction;
	}



	public boolean isPresenceArmure() {
		return presenceArmure;
	}


	public void setPresenceArmure(boolean presenceArmure) {
		this.presenceArmure = presenceArmure;
	}


	public boolean isMainslivre() {
		return mainslivre;
	}


	public void setMainslivre(boolean mainslivre) {
		this.mainslivre = mainslivre;
	}


	public int getAttaque() {
		return attaque;
	}


	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}


}
