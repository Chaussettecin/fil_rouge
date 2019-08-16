package Inventory;



public class Armure  extends Item {
	
	public static int nivBonusAttaque;
	
//-- Constructor
	public Armure(Integer id, String nom, Integer prix, 
			int nivDext, int nivBonusAttaque) {
	
		super(id, ItemType.ARMURE, nom, prix, color, desc);
			
	}
	

	public 	Item newLightArmor(){
			Item item = new Item(1, ItemType.ARMURE,"Cuire",50, null, "Armure de base et artisanale.");
				 item.modifValDef(2);
	
			//world.addAtEmptyLocation(item);
			return item;
	}

	public  Item newMediumArmor(){
			Item item = new Item(2, ItemType.ARMURE,"Cuivre",100, null, "Armure Protectrice. Attention à la chaleur.");
				 item.modifValDef(4);
					
			//world.addAtEmptyLocation(item);
			return item;
	}

	public 	Item newStrongArmor(){
		 	Item item = new Item(2, ItemType.ARMURE,"Metal",150, null, "Armure en métal. Tout feu tout flamme.");
				 item.modifValDef(6);
				
				//world.addAtEmptyLocation(item);
				return item;
}
	

	public Item randomArmor(){
	
		switch ((int)(Math.random() * 3)){
	
			case 0: return newLightArmor();
			case 1: return newMediumArmor();
			default: return newStrongArmor();
		}
	}
	
	/*private static Map<String,Armure> possibleArmure = new HashMap<String,Armure>();
	
 	
	 public void initPossibleArmure() {
		 possibleArmure.put("armureCuire", new Armure(0, "Armure", 20,"Petite Armure en Cuire "
	                + "Comme une seconde peau. Protege les attaques."));
			
		 possibleArmure.put("armureFer", new Armure(0, "Armure", 100, "Armure tout en fer"
		                + " Elle tiens bien chaud Mais elle protege bien."
		                + "" ));
	 }*/
	
	
	/*public String toString(){
	return ("Equiper de " + descriptionArmure + " " + nom + " armure.");
}*/

}

