package Enemy;


public abstract class Khaine extends Enemy{
	
	public static int bossId; 
	private String description;
	

    public Khaine(String nom, String description) {
		super(nom, ptv, Degat);
		
		nom = "KHAINE"; 
	}
	

//-- A ajouter l'histoire du perso - 	
	public String descriptionKHAINE() {
		return "" + ""+ "";
			
	}
	
//-- Elle "stringuise" ttes les valeurs pr pouvoir les afficher
	public String toString() {

		return " Nom :" + this.getNom() +
           " Point de vie :" + this.getPtv() +
           " Level :" + this.getLevel() +
           " Gold:" + this.getGoldRecup() +
           " Description:" + this.descriptionKHAINE();
	
	}


	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}	

}
