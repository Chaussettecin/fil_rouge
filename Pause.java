package Action;

import java.awt.event.ActionEvent;

import Controle.ActionController;

public class Pause {
	
	private boolean skipsave;
	private ActionController actioncenter;
	
	public Pause(boolean menu, ActionController ac) {
					super();
		
		this.skipsave = !menu;		
		this.actioncenter = ac;
	}

	/*public void actionPerformed(ActionEvent e) {
		this.actioncenter.skipsave;
	}*/


}
