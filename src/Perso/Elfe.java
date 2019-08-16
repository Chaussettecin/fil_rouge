package Perso;


public abstract class Elfe extends Perso {
	
	private String description;
	

    public Elfe(String nom, Race ClassesPerso) { 
    	super(nom,ClassesPerso);
		
	}
	
	public Elfe(String description  ) { 
		super (	nom, race); 
	}

	
	public String descriptionHatachar() {
		return "Un fameux personnage, il avait tout pour �tre heureux, m�decin r�put� dans le monde entier, \r\n" + 
			" une petite maison, une femme et un chien."+
				"Courte de dur�e car les Elfes noirs (Cultistes) ont tu� sa femme Nennae.";
	}
	

//--- Elle "stringuise" ttes les valeurs pr pouvoir les afficher --
	public String toString() {

		return 	" Nom: " + this.getNom() +
				" Point de vie :" + this.getPtv() +
				" Level :" + this.getLevel() +
				" Gold:" + this.getMoney() +
				" Description:" + this.descriptionHatachar();
	
	}

	public String getDescription() { return description;}

	public void setDescription(String description) { this.description = description; }	



}
