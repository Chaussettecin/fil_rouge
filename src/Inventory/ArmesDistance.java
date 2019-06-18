package Inventory;

import java.util.HashMap;
import java.util.Map;

import Inventory.ItemType;


public class ArmesDistance extends ArmeItem{
	
	String descArmDist;
	   
//-- Constructor -- 
	public ArmesDistance(Integer id, String nom, Integer prix, 
							String descArmDist) {
	        
		super(id, ItemType.ARME_DISTANCE, nom, prix);
		
	}
	
	private static Map<String,ArmesDistance> possibleArmeDist = new HashMap<String,ArmesDistance>();
	
	 public void initPossibleArmeDist() {
		 possibleArmeDist.put("armDist", new ArmesDistance(0, "Lance", 20,"Petite arme en Cuire "
	                + "Permet d'attraper ses enemis."));
			
		 possibleArmeDist.put("armDist", new ArmesDistance (0, "Sarbacane", 50, "Objet traditionnel."
		                + " Attaque à distance. Et on peut mettre ce que l'on veut dedans."
		                ));
		 
		 possibleArmeDist.put("armDist", new ArmesDistance (0, "Boomrang", 100, "Arme fidéle"
	                + " En bois, il assome l'ennemi et revient vers toi."
	                + "Attention aux reflex" ));
	 }

	@Override
	 public String toString() {
	     return id + "Nom de l'arme: " + nom + ", prix: " + prix + "Gold"
	    		 + descArmDist;
	 }
	   
	
}
