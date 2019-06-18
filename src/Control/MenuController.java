package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Save.DataBox;
import UI.MenuDisplay;
import UI.RootLayer;
import UI.SaveMenu;


public class MenuController implements ActionListener {
	
	private UI.RootLayer layer;
	private DataListener filecontrol;
	private UI.MenuDisplay menu;

	public MenuController(RootLayer layer) {
		this.layer = layer;
		this.menu = new MenuDisplay(this);
	}
	
	public void display() {
		System.out.println("menu");
		this.layer.addLayer(this.menu, this.layer.MENU);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}

	public DataListener getFilecontrol() {
		return filecontrol;
	}

	public void setFilecontrol(DataListener filecontrol) {
		this.filecontrol = filecontrol;
	}

}
