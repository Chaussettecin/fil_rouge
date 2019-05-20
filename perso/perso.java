package perso;

import java.util.ArrayList;
import java.util.Scanner;

import Effect.statusEffect;
import inventory.Equipment;
import inventory.Inventory;
import inventory.armes_bouclier;
import inventory.armes_melees;
import resource.Statistics;


public abstract class perso  extends Player{
	
 
	protected String id;
	private String nom ;
	protected int level;
	private Race race ;
  	private int ptv ;// ------------------pts de vie de base
    protected boolean dead = false; //----Verif s'il est est vivant ou pas
    private int gold = 0; // -------------Monnaie 
  	private int attaque ;     
  	private int bonusAttaque ; //---------addition des differents bonus d'equipement
    private int defense ;      
    private int bonusDefense ; //---------addition des differents bonus d'equipement
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
    // Battle
    private enemy opponent;
    private boolean battling = false;
    
//-- Inventaire - Sac à dos  - 
    public Inventory inventory;
    public static Equipment equips;
    
// Battle status effets 
    public statusEffect statusEffects;
    
//--- Dialogue avec un PNJ 
    private boolean tileInteraction = false;
    
//-- Si le joueur à une armure 
    private boolean presenceArmure;           
    private int mains ;

    public perso(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
 
//-- Constructor --- 
  
    
//-- A personaliser en fonction du background du personnage -  
    public static perso creaPerso(){
    	Scanner sc = new Scanner(System.in);
    		
    		String nom;
    		int reponseRace;
    		int reponseMetier;
    		Race race;
    		perso personnage = null;

    		System.out.println("--- Création du personnage ---");
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
    		
    			}catch (Exception e){
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
        XP += soin;
        soin = 0;
        if (XP > maxXP) XP = maxXP;
    }

//--- Justesse de l'attaqye -- 
    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

 
    public String getId() {
        return id;
    }
    
   
//-- SET et GETTER XP --- 
    public int getXP() {
        return XP;
    }

    public void setXP(int xp) {
        this.XP = xp;
    }

    public void setMaxHp(int maxHp) {
        this.maxXP = maxHp;
    }

    public int getMaxHp() {
        return maxXP;
    }

    public int getPreviousXP() { return previousXP; }

    public void setPreviousXP(int previousXP) { this.previousXP = previousXP; }

//-- SET et GETTER Lvl 
    public void setLevel(int level) { this.level = level; }

    public int getLevel() {
        return level;
    }

 //-- SET et GETTER degats
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
	
	public Degat.degat infligeDegats(int armesNbre) {
		return null;
	}

	public ArrayList<armes_melees> getArmure() {
		return null;
	}

}
