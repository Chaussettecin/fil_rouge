package UI;

import Inventory.Item;
import Perso.Perso;

public class ExamineScreen extends InventoryBasedScreen {

	public ExamineScreen(Perso perso) {
		super(perso);
	}

	@Override
	protected String getVerb() {
		return "examine";
	}

	@Override
	protected boolean isAcceptable(Item item) {
		return true;
	}

	@Override
	protected Screen use(Item item) {
		
		String obj = "aeiou".contains(perso.getNom().subSequence(0, 1)) ? "an " : "a ";
		//perso.notify("C'est" + obj + item.getNom() + "." + item.details());
		return null;
	
	}

}
