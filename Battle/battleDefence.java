package Battle;

import perso.perso;

//import rpg.perso_creature;

public class battleDefence {

	protected String nom;
	protected String description;
	protected int minDex;
	protected int minStr;
	protected int defenseValue;
	protected int prix;
	protected int DexteriteDebuff;
	protected int VitesseDebuff;
	protected int RestMagie;
	
	public battleDefence(String tempNom, String tempDescription, 
						int tempMinDex, int tempMinStr, int tempDefenseValue, 
						int tempPrix, int tempDexDebuff, int tempVitesseDebuff,
						int tempRestMagie) {
		 
			nom = tempNom;
			description = tempDescription;
			minDex = tempMinDex;
			minStr = tempMinStr;
			defenseValue = tempDefenseValue;
			prix = tempPrix;
			DexteriteDebuff = tempDexDebuff;
			VitesseDebuff = tempVitesseDebuff;
			RestMagie = tempRestMagie;
	}
		
	public String getNom() {
		 return nom;
	}
	
	public String getDescription() {
		 return description;
		
	}
		
	public String toString() {
		 return (" " + description + " " + nom);
	}
		
	public int getMinDex() {
		 return minDex;
	}
		
	public int getMinStr() {
		 return minStr;
	}
		
	public int getValDef() {
		 return defenseValue;
	}
		
	public int getPrix() {
		 return prix;
	}
		
	public int getMagicResistance() {
		 return RestMagie;
	}
	
	public int getDexteriteDebuff() {
		  return DexteriteDebuff;
	}
		
	public int getVitesseDebuff() {
		  return VitesseDebuff;
	}
		
	public boolean canUse(perso perso) {
		  return (perso.getTaille() >= minStr && perso.getDexterite() >= minDex);
	}
	
}
