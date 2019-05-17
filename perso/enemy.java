package perso;

import java.util.Vector;

import Battle.moveSet;
import Battle.statusEffect;
import inventory.armes_sorts;
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
		protected static int intelligence;
		protected static int level;
		protected static int santeActuelle;
		protected static int SanteMax;
		protected static int manaActuel;
		protected static int maxMana;
		protected static int xpGagner;
		protected static int goldgagner;

//-- Constructor -
    public enemy(String id, String nom,int taille, int agilité, int level, 
    			int santeActuelle, int SanteMax, int manaActuel,int maxMana, int xpGagner,
    			int goldgagner, TileMap tileMap, resource.ResourceManager rm, int intelligence) {
    	
    			super();
    
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
    	
    
    }
  
    public abstract boolean isElite();

// -- Verifie si c'est un boss iy oas
    public abstract boolean isBoss();

//--Définit et met à l'échelle les statistiques de l'ennemi en fonction de son type 
    //et de son niveau
    public abstract void setStats();

  //attaque mélee basique
  	public void attaque(perso perso, String nom){
  		
  		int variance = ((int) (Math.random() * 10)) - 5;
  		int attaqueDegats = (taille * 2) + (agilité * 2);
  		attaqueDegats+= variance;
  		(perso).setsanteActuelle(perso.getsanteActuelle() - attaqueDegats);
  		
  		System.out.println(perso.id + " frappe " + nom + "pour "
  				+ attaqueDegats + " dégats.");
  	}
  	
  	//Gere les sors utilisés par l'adversaire pendant le combat
  	public void utiliseSort(Player j, armes_sorts Sort){
  		
  		//int sortDegats = Sort.getDegats();
  		//this.manaActuel -= Sort.getManaCost();
  		
  		//sortDegats += (intelligence * 2);
  		//j.setsanteActuelle(j.getsanteActuelle() - sortDegats);
  	}
    
    
//--Set : utilise pour changer la santé et les mana de l'enemis -- 
	public void setMaxSante(int SanteMax){ this.SanteMax = SanteMax; }
	public void setActuelleSante(int santeActuelle){ this.santeActuelle= santeActuelle; }
	public void setMaxMana(Object object){ this.maxMana = (int) object; }
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
