package rpg_filrouge;

public class joueur {

	  
private static String nomJoueur = "Joueur";

public static String nom() {
	return nomJoueur;	   
}

public static void setNom(String nom) {
	nomJoueur = nom;
}
	  
public static void nomSelection() {

	ui.cls();
	ui.println("Ton nom : ");
	String nom = ui.getValidString();

	//Validation
	nom = nom.trim();
	if (nom.equals("")) {
		ui.println("Nom par d�faut."); 
		//donne le nom "joueurs" par d�faut si, le jours ne personalise pas
		nom = "Joueurs";
	}
	nomJoueur = nom;
	}//fin nomSelection()
}
