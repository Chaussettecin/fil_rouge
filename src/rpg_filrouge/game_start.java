package rpg_filrouge;

import fantasy_RPG.jeux_menu;

public class game_start {

	public static void main(String args[]) {

		if (args.length != 0 && args[0].equalsIgnoreCase("Hello")) ui.uiDispo = false;
		ui.println("Chargement...");
	  
		//Lancer le jeu   
		jeux_menu.load();

		//Clear
		ui.cls();
	}	
}
