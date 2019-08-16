package UI;

import Perso.Perso;
import Inventory.Item;


public class EquipScreen extends InventoryBasedScreen {

	
	public EquipScreen(Perso perso) { super(perso); }

	
	protected String getVerb() { return "Porter"; }

	
// --- Méthode de de la classe InventoryBasedScreen -- 

	@Override
	protected boolean isAcceptable(Item item) {
		return item.valAttaque() > 0 || item.valDefence() > 0;
	
	}


	@Override
	protected Screen use(Item item) {
		
		//useItem.getInventoryItem((item);
		return null;
	}

}
