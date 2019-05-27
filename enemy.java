package enemys;

import java.util.Random;

import Battle.FaintedAction;
import Battle.battleAction;
import Effect.statusEffect;
import inventory.armes_sorts;
import perso.Race;
import perso.perso;
import enemys.enemy;


public abstract class enemy {
	
    protected static String nom ;
    protected static String description; 
    
    protected static Race race ;
	protected static int ptv ;// ------------------pts de vie de base
    protected static boolean dead = false; //----Verif s'il est est vivant ou pas
	
//--- Degats
    protected static int minDamage;
    protected static int maxDamage;
	
    protected static int  level;
  
    protected static int accuracy;
    protected static int attaque ;     
  	protected static int bonusAttaque ; //---------addition des differents bonus d'equipement
    protected static int defense ;      
    private static int bonusDefense ; //---------addition des differents bonus d'equipement
//-- XP ---- 
    protected static int XP;
    protected static int maxXP;
    protected static int previousXP;
    protected static int degat= 0;
    protected static int soin = 0;
	
//---Battle / Status Effect -
	static statusEffect statusEffects;
	battleAction BattleAction;
   	
	private static final Random rand = new Random();

//-- Constructor -
    public enemy(String nom, int level,Race race,int ptv, boolean dead, int attaque, int bonusAttaque,int defense,
    			int bonusDefense, int XP, int maxXP, int previousXP, int degat, int soin,
    			int accuracy,  int minDamage,int maxDamage, statusEffect statusEffects) {
    	
    		this.nom = nom;
    		this.level = 1;
    		this.ptv = 10;
    	
    		statusEffects = new statusEffect(false);
    	
    
    }

// -- Verifie si c'est un boss ou pas --
    public abstract boolean isBoss();


//--- Battle  -- 
  	public void attaqueBase( String nom){
  		
  		int variance = ((int) (Math.random() * 10)) - 5;
  		int attaqueDegats = (attaque * 2) + (accuracy * 2);
  		
  		attaqueDegats+= variance;
  		
  		System.out.println(nom + " frappe " + nom + "pour "
  				+ attaqueDegats + " dégats.");
		return;
  	}
  	
  	
  	protected void takeTurn(battleAction chosenAction){
        
  		if(ptv > 0){
            setBattleAction(chosenAction);              
        }
        else{
            //setBattleAction(new FaintedAction);
        }
        performAction();
    }
  	
  	
  	public void setBattleAction(battleAction chosenAction){
        BattleAction = chosenAction;
    }

	private void performAction(){
         //battleAction.execute(enemyBoss());
     };

//-- Sante dans le combat
    public void santePerdu(int amount){
         if(ptv - amount < 0){
        	 ptv = 0;
         }
         else{ptv -= amount;
         }
    }

     
    protected void santeGagner(int amount){
         
    	if(ptv + amount> 0){
    		ptv = degat;
    		
    	} else{
    		ptv += amount;
    	
    	}
     }       


//--- Gere les sors utilisés par l'adversaire pendant le combat
  	public void utiliseSort(perso Perso, armes_sorts Sort){
  		
  		int sortDegats = 0;
  		
  		sortDegats += (attaque * 2);
  		enemy.setActuelleSante(sortDegats);
  	
  	}
  
//--- Méthode Ennemi randam. 
  	 public void newRandomEnemy() {
         int random = rand.nextInt(4) + 1;
         
         enemy Enemy = null;
        
         switch (random) {
             case 1:
            	 Enemy = enemyBoss();
                 break;
             case 2:
            	 Enemy = enemyNormal();
                 break;
         }
     }
  	
  	 
  	 protected enemy enemyNormal() {
  		 return enemyNormal();
  	 }

  	 protected static enemy enemyBoss() {
  		 return enemyBoss();
  	 }


//-- GETTERS & Setter  Santé --- 
  	 
//--Set : utilise pour changer la santé et les mana de l'enemis -- 
  	 public void setMaxSante(int SanteMax){ enemy.ptv = SanteMax; }
	
  	 public static void setActuelleSante(int santeActuelle){ enemy.ptv= santeActuelle; }
	

//--Définit et met à l'échelle les statistiques de l'ennemi en fonction de son type 
    //-- et de son niveau
    public abstract void setStats();
	
    
    public int getDefense() {
		return defense;
	}

	public static void setDefense(int defense) {
		enemy.defense = defense;
	}

	public int getVitesse() {
		return 0;
	}

	public static int getBonusDefense() {
		return bonusDefense;
	}

	public static void setBonusDefense(int bonusDefense) {
		enemy.bonusDefense = bonusDefense;
	}
   
	public String getNom() {
		return nom;
	}

	public Object getSante() {
		// TODO Auto-generated method stub
		return null;
	}



}
