package Perso;

import java.util.List;

import Effect.statusEffect;
import Gold.Gold;
import Inventory.Item;

public abstract class Orc extends Perso{
	
	private String description;
	
	public Orc(String nom, Race ClassesPerso, PersoStats Stats, PersoItems Items, 
			int Level, int XP, int Gold, int ptv, int ptvMin, int minDegat, 
			int maxDegat,int degat, int attaque, int bonusAttaque, int defense,
			int accuracy,int bonusDefense, boolean presenceArmure, 
			boolean mainslibre, statusEffect statusEffects, 
			String description) {
			
		
		super (nom, ClassesPerso, Stats, Items, Level, XP, Gold, ptv, ptvMin, 
				minDegat, maxDegat, degat, attaque, bonusAttaque, defense, 
				accuracy,bonusDefense, presenceArmure, mainslibre, statusEffects);
				  
				 
			
		
		//-- A faire en fonction de nos personnage 
	
	
	}

	

	public void descriptionFes(String dsc) {
		dsc= "Ex cultiste d’Azaroth, il fut banni de Archityran (terre des ORcs) \n parce que la rationalité lui ai tombé sur  la tête"
             + "Pour lui les Dieux n'existent plus." + "Il prefere la baston pour sauver l'humanité";
	}
	
//-- Elle "stringuise" ttes les valeurs pr pouvoir les afficher
	public String toString() {

		return " Nom :" + this.getNom() +
           " Point de vie :" + this.getPtv() +
           " Level :" + this.getLevel() +
           " Gold:" + this.getMoney();
		
		this.descriptionFes(description);
	}	

}
