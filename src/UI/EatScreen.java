package UI;

import Inventory.Item;
import Perso.Perso;


/*
 *  Affichage conso item 
 */

public class EatScreen extends InventoryBasedScreen {

	
	public EatScreen(Perso perso) {
		super(perso);
	}

	@Override
	protected String getVerb() {
		return "conso";
	}

	@Override
	protected boolean isAcceptable(Item item) {
		return item.valeurFood() != 0;
	}

	@Override
	protected Screen use(Item item) {
		perso.inventaire();
		return null;
	}

}
