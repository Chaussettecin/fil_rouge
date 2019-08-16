package UI;

import Inventory.Item;
import Perso.Perso;

/*
 * Affichage lacher un objet 
 */

public class DropScreen extends InventoryBasedScreen {

	public DropScreen(Perso perso) {
		super(perso);
	}

	
	
//---- Méhode InventoryBasedScreen  -- 
	
	@Override
	protected String getVerb() { 
		return "drop"; 
	}

	@Override
	protected boolean isAcceptable(Item item) { 
		return true; 
	}
	
	@Override
	protected Screen use(Item item) { 
		//perso.drop(item); 
		return null;
	}

}
