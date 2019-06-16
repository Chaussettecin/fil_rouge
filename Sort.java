package Inventory;

import java.util.HashMap;
import java.util.Map;


public class Sort extends Item {
	
	
//-- Constructor -- 
	 public Sort(Integer id, String nom, Integer prix, String description) {
	 		
		 super(id, ItemType.SORT, nom, prix);
	 }
	 
	 private static Map<String,Sort> possibleSort = new HashMap<String,Sort>();
	
	 public void initPossiblePotions() {
		 possibleSort.put("SortFroz", new Sort(0, "frozen", 15,
				 		"Un petit sort de base"
				 				+ "Mais qui pourrait contré le rechauffement climatique (ou pas)"));
			
		 possibleSort.put("SortMiss", new Sort(0, "missileMagique", 30, 
		                "Petit missile magique."+ 
				 		"Qui fera tourner la tête des enemis"));
			
		 possibleSort.put("SortFeu", new Sort(0, "BoulesDeFeu", 50, 
				 		"Petites boules de feu - Parfaite pour un petit"
	                	+ "feu de camp ?"));
		 
		 possibleSort.put("SortTemp", new Sort(0, "canonArcane", 60, 
				 		"Un canon et pas n'importe lequel"
				 		+ "Surprise."));
		 
		 possibleSort.put("SortArc", new Sort(0, "tempetedesDieux", 100, 
				 			"Tornado"+ "."));
	 }

	
	@Override
	public String toString() {
		 return id + "Nom du sort: " + nom + ", prix: " + prix + ", ";
	}
}