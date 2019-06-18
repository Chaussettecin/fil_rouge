package Inventory;


import java.util.HashMap;
import java.util.Map;


public class Armure  extends Item {
	
	public String descriptionArmure;
	
	
//-- Constructor
	public Armure(Integer id, String nom, Integer prix, String descriptionArmure) {
		
		super(id, ItemType.ARMURE, nom, prix);
	}


	private static Map<String,Armure> possibleArmure = new HashMap<String,Armure>();
	
 	
	 public void initPossibleArmure() {
		 possibleArmure.put("armureCuire", new Armure(0, "Armure", 20,"Petite Armure en Cuire "
	                + "Comme une seconde peau. Protege les attaques."));
			
		 possibleArmure.put("armureFer", new Armure(0, "Armure", 100, "Armure tout en fer"
		                + " Elle tiens bien chaud Mais elle protege bien."
		                + "" ));
	 }

		
	public String toString(){
		return ("Equiper de " + descriptionArmure + " " + nom + " armure.");
	}

	
	}

