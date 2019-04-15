
public class jeux_menu {
	
public static void menu(){}


		
	public static void load() {
		
		while(true){
			
			ui.cls();
			//Menu ecran
			ui.println(" ___________________________________________");
			ui.println("|         		 WELCOME          			|");
			ui.println("|        Un bon petit jeu avec du text      |");
			ui.println("|                                           |");
			ui.println("|*******************************************|");
			ui.println("|                                           |");
			ui.println("|   ***** Faites votre choix ****           |");
			ui.println("|          *** Appuyer sur Entree ***       |");
			ui.println("|                                           |");
			ui.println("| 1) Lancer le jeux                         |");
			ui.println("|                                           |");
			ui.println("| 2) Sortie                                 |");
			ui.println("|___________________________________________|");

            switch (ui.getValidInt()) {
                case 1:
                    ui.cls();
                    ui.uiDispo = false;
                    jeux.start();
                    break;
                case 2:
                    return;
                default:
                    break;
            }//fin switch Menu principal
        }// fin boucle
    }//fin load
}
