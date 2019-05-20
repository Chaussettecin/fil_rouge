package perso;

import Effect.statusEffect;
import inventory.armes_sorts;
import perso.enemy;


public abstract class enemy {
	
	protected static String id;
    protected static String nom ;
    
	protected static int  level;
	protected static Race race ;
  	protected static int ptv ;// ------------------pts de vie de base
    protected static boolean dead = false; //----Verif s'il est est vivant ou pas
    
  	protected static int attaque ;     
  	protected static int bonusAttaque ; //---------addition des differents bonus d'equipement
    protected static int defense ;      
    private static int bonusDefense ; //---------addition des differents bonus d'equipement
    
    protected static int XP;
    protected static int maxXP;
    protected static int previousXP;
    protected static int degat= 0;
    protected static int soin = 0;
    // 0-100 in % points
    protected static int accuracy;
    // damage range 
    protected static int minDamage;
    protected static int maxDamage;

//---Battle / Status Effect -
	public static statusEffect statusEffects;
   	

//-- Constructor -
    public enemy(String id, String nom, int level,Race race,int ptv, 
    		boolean dead, int attaque,int bonusAttaque,int defense,
    		int bonusDefense, int XP, int maxXP, int previousXP, int degat, int soin,
    		int accuracy,  int minDamage,int maxDamage, statusEffect statusEffects) {
    	
    		this.nom = nom;
    		this.level = 1;
    		this.ptv = 10;
    	
    		statusEffects = new statusEffect(false);
    	
    
    }
  
    public abstract boolean isElite();

// -- Verifie si c'est un boss ou pas
    public abstract boolean isBoss();



//-- attaque mélee basique
  	public void attaqueBase( String nom){
  		
  		int variance = ((int) (Math.random() * 10)) - 5;
  		int attaqueDegats = (attaque * 2) + (accuracy * 2);
  		
  		attaqueDegats+= variance;
  		
  		System.out.println(nom + " frappe " + nom + "pour "
  				+ attaqueDegats + " dégats.");
  	}
  	
  	//Gere les sors utilisés par l'adversaire pendant le combat
  	public void utiliseSort(perso Perso, armes_sorts Sort, Degat.degat Degats){
  		
  		//int sortDegats = Sort.getDegats();
  		
  		//sortDegats += (attaque * 2);
  		//enemy.setActuelleSante(sortDegats);
  	
  	}
  
//-- GETTERS Et Setter --- 
  	
//--Set : utilise pour changer la santé et les mana de l'enemis -- 
	public void setMaxSante(int SanteMax){ this.ptv = SanteMax; }
	public void setActuelleSante(int santeActuelle){ this.ptv= santeActuelle; }
	

//--Définit et met à l'échelle les statistiques de l'ennemi en fonction de son type 
    //et de son niveau
    public abstract void setStats();
	
    
    public static int getDefense() {
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
   
  

}
