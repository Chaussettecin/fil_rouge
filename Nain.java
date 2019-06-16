package Perso;

import Effect.statusEffect;

public abstract class Nain extends Perso {
	
	private String description;

	public Nain(String nom, Race ClassesPerso, PersoStats Stats, PersoItems Items, 
			int Level, int XP, int Gold, int ptv, int ptvMin, int minDegat, 
			int maxDegat,int degat, int attaque, int bonusAttaque, int defense,
			int accuracy,int bonusDefense, boolean presenceArmure, 
			boolean mainslibre, statusEffect statusEffects, 
			String description) {
		
		
		super(nom, ClassesPerso, Stats, Items, Level, XP, Gold, ptv, ptvMin, minDegat, maxDegat, degat, attaque, bonusAttaque,
			defense, accuracy, bonusDefense, presenceArmure, mainslibre, statusEffects);
		
		
		
	
	
	}


	public void descriptionJissi(String dsc) {
		dsc = "Il faut toujours se méfier des petites tailles" +
			"Suffit de voir son cahier de chasse, elle est la plus grande Assassin du monde."
			+ "Son nom est sur toute les lèvres dans les tavernes.";
	}


//-- Elle "stringuise" ttes les valeurs pr pouvoir les afficher
	public String toString() {

		return " Nom :" + this.getNom() +
           " Point de vie :" + this.getPtv() +
           " Level :" + this.getLevel() +
           " Gold:" + this.getMoney();
		
		this.descriptionJissi(description);
	}	

}
