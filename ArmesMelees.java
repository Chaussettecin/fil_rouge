package Inventory;

import java.util.HashMap;
import java.util.Map;

import Inventory.ItemType;


public class ArmesMelees extends ArmeItem{

	String descArmMel;
	
	public ArmesMelees(Integer id, String nom, Integer prix,
						String descArmMel) {
		
		super(id, ItemType.ARME_MELEE, nom, prix);
	}


	private static Map<String,ArmesMelees> possibleArmeMel = new HashMap<String,ArmesMelees>();
	
	 public void initPossibleArmeMel() {
		 possibleArmeMel.put("armMel", new ArmesMelees(0, "Lucile", 20,"Batte en bois naturel"
	                + "Arme de bourrin."));
			
		 possibleArmeMel.put("armMel", new ArmesMelees (0, "Epee simple", 50, "."
		                + ""
		                ));
		 
		 possibleArmeMel.put("armMel", new ArmesMelees (0, "Epee double", 100, ""
	                + "."
	                + "Attention aux reflex" ));
	 }

	@Override
	 public String toString() {
	     return id + "Nom de l'arme: " + nom + ", prix: " + prix + "Gold"
	    		 + descArmMel;
	 }
	
	
// Methode pour voir si le perso possede deja ou peut utiliser l'arme
	
	//public boolean peutUtiliser(perso Perso) {
		//return (Perso.equips  = Perso.setAccuracy(minDext);
	//}
	
}
