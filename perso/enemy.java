package perso;
import java.util.Vector;

import Battle.moveSet;
import Battle.statusEffect;
///import perso.enemy.entity;
//import perso.enemy.Moveset;
///import perso.ResourceManager;
//import perso.TileMap;
//import perso.Vector2;
import map.TileMap;


public abstract class enemy extends perso {

//---Battle / Status Effect -
		public statusEffect statusEffects;
   		
		protected static String nom;
		protected static int taille;
		protected static int agilité;
		private int intelligence;
		protected static int level;
		protected static int santeActuelle;
		protected static int SanteMax;
		protected static int manaActuel;
		protected static int maxMana;
		protected static int xpGagner;
		protected static int goldgagner;

    // battle sprite size
    // (used for making sprites bigger or smaller for effect)
    public int battleSize;
    // num of times the enemy respawned
    // (used for enemies that have special respawn capabilities)
    public int numRespawn;

//-- Constructor -
    public enemy(String id, Vector2 position, String nom,int taille, int agilité, int level, 
    			int santeActuelle, int SanteMax, int manaActuel,int maxMana, int xpGagner,
    			int goldgagner, TileMap tileMap, resource.ResourceManager rm) {
    	
    			super(id, position, tileMap, rm);
    
    		this.nom = nom;
    		this.setTaille(taille);
    		this.setAgilité(agilité);
    		this.intelligence = intelligence;
    		this.level = 1;
    		this.setXpGagner(xpGagner);
    		this.setGoldgagner(goldgagner);
    		this.setSanteMax(this.setSanteActuelle(this.setMaxMana(this.setManaActuel(intelligence * 15))));
    	
    		moveset = new moveSet(rm);
    		statusEffects = new statusEffect(false, rm);
    		battleSize = 48;
    		numRespawn = 0;
    
    }
  
    public abstract boolean isElite();

// -- Verifie si c'est un boss iy oas
    public abstract boolean isBoss();

//--Définit et met à l'échelle les statistiques de l'ennemi en fonction de son type 
    //et de son niveau
    public abstract void setStats();

  //attaque mélee basique
  	public void attaque(Player j){
  		
  		int variance = ((int) (Math.random() * 10)) - 5;
  		int attaqueDegats = (taille * 2) + (agilité * 2);
  		attaqueDegats+= variance;
  		(j).setsanteActuelle(j.getsanteActuelle() - attaqueDegats);
  		
  		System.out.println(nom + " frappe " + j.getNom() + "pour "
  				+ attaqueDegats + " dégats.");
  	}
  	
  	//Gere les sors utilisés par l'adversaire pendant le combat
  	public void utiliseSort(Player j, sorts s){
  		
  		int sortDegats = s.getDegats();
  		this.manaActuel -= s.getManaCost();
  		
  		sortDegats += (intelligence * 2);
  		j.setsanteActuelle(j.getsanteActuelle() - sortDegats);
  	}
    
    
//--Set : utilise pour changer la santé et les mana de l'enemis -- 
	public void setMaxSante(int SanteMax){ this.SanteMax = SanteMax; }
	public void setActuelleSante(int santeActuelle){ this.santeActuelle= santeActuelle; }
	public void setMaxMana(int maxMana){ this.maxMana = maxMana; }
	public void setManaActuel(int manaActuel){ this.manaActuel = manaActuel; }
   
  
//-- GETTERS Et Setter --- 
    public String getNom() {
		return nom;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public int getAgilité() {
		return agilité;
	}

	public void setAgilité(int agilité) {
		this.agilité = agilité;
	}

	public int getSanteActuelle() {
		return santeActuelle;
	}

	public int setSanteActuelle(int santeActuelle) {
		this.santeActuelle = santeActuelle;
		return santeActuelle;
	}

	public int getSanteMax() {
		return SanteMax;
	}

	public void setSanteMax(int santeMax) {
		SanteMax = santeMax;
	}

	public int getManaActuel() {
		return manaActuel;
	}

	public int getXpGagner() {
		return xpGagner;
	}

	public void setXpGagner(int xpGagner) {
		this.xpGagner = xpGagner;
	}

	public int getMaxMana() {
		return maxMana;
	}

	public int getGoldgagner() {
		return goldgagner;
	}

	public void setGoldgagner(int goldgagner) {
		this.goldgagner = goldgagner;
	}

}
