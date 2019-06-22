package Perso;


public abstract class Humain extends Perso{
	
	
	private String description;

	public Humain ( String description) {
					
		super (Nom, ClassesPerso, Stats, Items, Level, XP, 
				Gold, ptv, ptvMin, minDegat, maxDegat, degat, 
				attaque, bonusAttaque, defense, accuracy, 
				bonusDefense, presenceArmure, mainlibre , 
				statusEffects);
		
		// A adapter en fonction de notre Sidney
	}

	
//-- Elle "stringuise" ttes les valeurs pr pouvoir les afficher
	public String toString() {

        return " Nom :" + this.getNom() +
               " Point de vie :" + this.getPtv() +
               " Level :" + this.getLevel() +
               " Gold:" + this.getMoney() +
               " Description:" + this.descriptionSid();
        
        		
	}

	public String descriptionSid() {
		
		return "Fille d’un riche propriétaire, elle est férue d’histoire et connaît le monde comme sa proche.\n" + 
			"Elle a étudié l’ethnologies des races du disque monde. \r\n" + 
			"Mais son passé d’adolescence lui met des battons dans les roues "
			+ "(les PNG ne lui feront pas confiance facilement).";
	}
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	

}
