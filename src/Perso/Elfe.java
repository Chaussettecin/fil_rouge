package Perso;

import Effect.statusEffect;

public abstract class Elfe extends Perso {
	
	private String description;
	

    public Elfe(String nom, Race ClassesPerso) {
		super(nom,ClassesPerso);
		
		//-- A faire en fonction de nos personnage 
	}
	
	public Elfe(String description  ) {
		
		super (	Nom, ClassesPerso, Stats, Items, Level, XP, 
				Gold, ptv, ptvMin, minDegat, maxDegat, degat, 
				attaque, bonusAttaque, defense, accuracy, 
				bonusDefense, presenceArmure, mainlibre , 
				statusEffects);
		
		//-- A faire en fonction de nos personnage 
	}

	
	public String descriptionHatachar() {
		return "Un fameux personnage, il avait tout pour être heureux, médecin réputé dans le monde entier, \r\n" + 
			" une petite maison, une femme et un chien."+
				"Courte de durée car les Elfes noirs (Cultistes) ont tué sa femme Nennae.";
	}
	
//-- Elle "stringuise" ttes les valeurs pr pouvoir les afficher
	public String toString() {

		return " Nom :" + this.getNom() +
           " Point de vie :" + this.getPtv() +
           " Level :" + this.getLevel() +
           " Gold:" + this.getMoney() +
           " Description:" + this.descriptionHatachar();
		
		
	}	
}
