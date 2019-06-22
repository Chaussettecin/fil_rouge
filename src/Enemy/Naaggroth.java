package Enemy;


public abstract class Naaggroth extends Enemy{
	
	public static int bossId; 
	private String description;
	

    public Naaggroth(String nom, String description) {
		super(nom, ptv, Degat);
		
		nom = "NAAGGROTH"; 
	}
	

//-- A ajouter l'histoire du perso - 	
	public String descriptionNAAGGROTH() {
		return "" + ""+ "";
			
	}
	
//-- Elle "stringuise" ttes les valeurs pr pouvoir les afficher
	public String toString() {

		return " Nom :" + this.getNom() +
           " Point de vie :" + this.getPtv() +
           " Level :" + this.getLevel() +
           " Gold:" + this.getGoldRecup() +
           " Description:" + this.descriptionNAAGGROTH();
	
	}


	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}	

}
