package Enemy;


public abstract class TorIbrion extends Enemy{
	
	private String description;
	

    public TorIbrion(String nom, String description) {
		super(nom, ptv, Degat);
		
		nom = "TorIbrion"; 
	}
	

//-- A ajouter l'histoire du perso - 	
	public String descriptionTorIbrion() {
		return "" + ""+ "";
			
	}
	
//-- Elle "stringuise" ttes les valeurs pr pouvoir les afficher
	public String toString() {

		return " Nom :" + this.getNom() +
           " Point de vie :" + this.getPtv() +
           " Level :" + this.getLevel() +
           " Gold:" + this.getGoldRecup() +
           " Description:" + this.descriptionTorIbrion();
	
	}


	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}	

}
