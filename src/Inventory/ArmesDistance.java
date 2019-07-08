package Inventory;

import java.awt.Color;
import Inventory.ItemType;


public class ArmesDistance extends ArmeItem{
	
	String descArmDist;
	   
//-- Constructor -- 
	public ArmesDistance(Integer id, String nom, Integer prix, 
							String descArmDist, Color color) {
	        
		super(id, ItemType.ARME_DISTANCE, nom, prix, nivDexterite, 
				nivBonusAttaque);
		
	}
	
	 
	public  Item newLance(String description){
			Item item = new Item(1, ItemType.ARME_DISTANCE, "Lance",20, "Petite arme en Cuire " );
			
			item.modifyAttackValue(5);
			item.modifyThrownAttackValue(5);
			
			//world.addAtEmptyLocation(item, depth);
			return item;
	}
	
	
	public 	Item newSarbacane(String descArmDist){
			Item item = new Item(2, ItemType.ARME_DISTANCE,"Sarbacane",50, "Attaque � distance. Et on peut mettre ce que l'on veut dedans.");
			
			item.modifyAttackValue(10);
			item.modifyThrownAttackValue(3);
			
			//world.addAtEmptyLocation(item, depth);
			return item;
	}
		
	public Item newBoomrang(String descArmDist){
		   Item item = new Item(3, ItemType.ARME_DISTANCE,  "Boomrang", 100," En bois, il assome l'ennemi et revient vers toi.");
			
		   item.modifyAttackValue(5);
		   item.modifyDefenseValue(3);
		   item.modifyThrownAttackValue(3);
			
		   //world.addAtEmptyLocation(item, depth);
		   return item;
		
	}
	
	public Item RandomArme(){
			
		switch ((int)(Math.random() * 3)){
			
			case 0: return newLance(descArmDist);
			case 1: return newSarbacane(descArmDist);
			case 2: return newBoomrang(descArmDist);
			default: return newLance(descArmDist);
		}
		
	}
	
	
	
	@Override
	 public String toString() {
	     return id + "Nom de l'arme: " + nom + ", prix: " + prix + "Gold"
	    		 + descArmDist;
	 }
	   
	
}
