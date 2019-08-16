package Inventory;

import Inventory.Item;
import Inventory.ItemType;

public class ArmeItem extends Item {

	 protected static Integer nivDexterite; // Precision 
	 protected static Integer nivBonusAttaque; // Bonnus attaque
	    
	 
	 public ArmeItem(Integer id, ItemType type, String nom, 
			 		Integer prix, Integer nivDexterite, Integer nivBonusAttaque) {
		 
	        super(nivBonusAttaque, type, nom, nivBonusAttaque, color, desc);
	        
	        this.nivBonusAttaque = nivBonusAttaque;
	        this.nivDexterite = nivDexterite;
	 }    
	    
	    
	 public Integer getNivBonusAttaque() {
	        return nivBonusAttaque;
	 }

	 public void setNivBonusAttaque(Integer nivBonusAttaque) {
	        this.nivBonusAttaque = nivBonusAttaque;
	 }

	 public Integer getNivDexterite() { return nivDexterite; }

	 public void setnivDexterite(Integer nivDexterite) {
	        this.nivDexterite = nivDexterite;
	 }

	@Override
	public String toString() {
		return null;
	}

	public static void remove(ArmeItem item) {
		// a voir 
		
	}


	public static void add(ArmeItem item) {
		// TODO Auto-generated method stub
		
	}
}
