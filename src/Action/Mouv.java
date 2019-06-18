package Action;

import javax.swing.Icon;

import Control.ActionController;
import Control.Orientation;

public class Mouv {

	
	private int dx,dy;
	private Orientation id;
	private ActionController actioncenter;
	
	public Mouv(Orientation dir,int dx, int dy, ActionController playcontrol) {
		super();
		this.id = dir;
		this.dx = dx;
		this.dy = dy;
		this.actioncenter = playcontrol;		
	}

	public Mouv(String arg0) {
		super();
	}

	public Mouv(String arg0, Icon arg1) {
		super();
	}

}
