package UI;

import java.util.Arrays;
import java.util.ArrayList;


public abstract class node_decisions_joueurs extends node_decisions {
	 
	private ArrayList<String> menu;
	 
	public node_decisions_joueurs(String[] tempMenu, node[] tempNextNodes) {
		    
		super(tempNextNodes);
		 
		menu = new ArrayList<String>(Arrays.asList(tempMenu));
	
	}

	public ArrayList<String> getMenu() {
		return menu;
	}

	public void setMenu(ArrayList<String> menu) {
		this.menu = menu;
	}

	

		 
}
