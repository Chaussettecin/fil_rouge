package rpg_filrouge;

public class perso_coffre {

	//sac à dos du joueur
	private perso_coffre() {
	 }

	//--- Coffre ou sac à dos. Doit être équiper seulement de 4 objets
		public static void affichage() {
	        ui.cls();
	        ui.println("----------------------------------------------------------- |");
	        ui.println("          ** Objets dans ton coffre **         				|");
	        ui.println();
	        ui.println("Kits de 1er soin : " + equipement_premiersSecours.get());
	        ui.println("Boost :" + equipement_instaSante.get()	);
	        ui.println("Potions : ");
	        ui.println("   -> Survie : " + (equipement_potion.get("Survie"))		  );
	        ui.println("   -> Restauration : " + equipement_potion.get("Restauration"));
	        ui.println("Gold : " + gold.get() 										  );
	        ui.println("Pouvoir : " + equipement_pouvoirs.get()						  );
	        
	        for (int i = 0; i < equipement_armes.arrayArmes.size(); i++) {
	            if (equipement_armes.arrayArmes.get(i).possede()) {
	                ui.println(equipement_armes.arrayArmes.get(i).getNom());
	                if (!equipement_armes.arrayArmes.get(i).contact)
	                    ui.println("Munitions : " + equipement_armes.arrayArmes.get(i).getMunition() + ")");
	            }
	        }//fin for
	        
	        for (int i = 1; i < equipement_armure.getarmures().size(); i++) {
	           if (equipement_armure.getarmures().get(i).esPossede()) {
	                ui.println(equipement_armure.getarmures().get(i).toString());
	            }
	        }
	        	
	        for (int i = 0; i < equipement_food.arrayFood.size(); i++) {	
	        	if (equipement_food.arrayFood.get(i).getQuantite() > 0)
	                ui.println(equipement_food.arrayFood.get(i).getNom() + "(x" + equipement_food.arrayFood.get(i).getQuantite() + ")");
	        }//fin for
	        	
	       ui.println();
	       ui.println("-------------------------------------------");
	       ui.pause();
	    
		}//fin affichage
		
}
