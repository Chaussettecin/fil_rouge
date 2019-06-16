package Action;

import Controle.ActionController;

public class Choix {
	
	private boolean accept;
	private ActionController actioncenter;
	
	public Choix(boolean state, ActionController playcontrol) {
		
		this.setAccept(state);
		this.setActioncenter(playcontrol);
	
	}

	public ActionController getActioncenter() {
		return actioncenter;
	}

	public void setActioncenter(ActionController actioncenter) {
		this.actioncenter = actioncenter;
	}

	public boolean isAccept() {
		return accept;
	}

	public void setAccept(boolean accept) {
		this.accept = accept;
	}

}
