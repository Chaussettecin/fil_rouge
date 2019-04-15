package fantasy_RPG;


				/// Classe joueurs

public class joueurs {
	  
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
		ui.println("Nom par défaut."); 
					//donne le nom "joueurs" par défaut si, le jours ne personalise pas
		nom = "Joueurs";
	}
	nomJoueur = nom;
	}//fin nomSelection()
}
