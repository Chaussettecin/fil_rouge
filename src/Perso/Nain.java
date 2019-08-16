package Perso;


public abstract class Nain extends Perso {
	
	private String description;

	public Nain( String description) {
		super(nom, race);
	
	}


	public String descriptionJissi() {
		return "Il faut toujours se méfier des petites tailles" +
			"Suffit de voir son cahier de chasse, elle est la plus grande Assassin du monde."
			+ "Son nom est sur toute les lévres dans les tavernes.";
	}


//-- Elle "stringuise" ttes les valeurs pr pouvoir les afficher
	public String toString() {

		return " Nom :" + this.getNom() +
           " Point de vie :" + this.getPtv() +
           " Level :" + this.getLevel() +
           " Gold:" + this.getMoney() +
           " Description:" + this.descriptionJissi();
		
	}


	public String getDescription() { return description; }


	public void setDescription(String description) {
		this.description = description;
	}	


}
