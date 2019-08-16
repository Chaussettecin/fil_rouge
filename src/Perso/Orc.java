package Perso;


public abstract class Orc extends Perso{
	
	private String description;
	
// Fes Forelash -- 
	
	public Orc(String nom, Race ClassesPerso) {
			
		super(nom,ClassesPerso);
			
			//-- A faire en fonction de nos personnage 
	}
		
		public Orc(String description  ) {
			super (	nom, race);
			
			//-- A faire en fonction de nos personnage 
		}

		

	public String descriptionFes()  {
		return "Ex cultiste d'Azaroth, il fut banni de Archityran (terre des Orcs) \n parce que la rationalité lui ai tombée sur  la tête"
             + "Pour lui les Dieux n'existent plus." + 
				"Il prefere la baston pour sauver l'humanité";
		
	}
	
//-- Elle "stringuise" ttes les valeurs pr pouvoir les afficher
	public String toString() {

		return " Nom :" + this.getNom() +
           " Point de vie :" + this.getPtv() +
           " Level :" + this.getLevel() +
           " Gold:" + this.getMoney() +
           " Description:" + this.descriptionFes();
			
	}

	public String getDescription() { return description;}

	public void setDescription(String description) {
		this.description = description;
	}	

}
