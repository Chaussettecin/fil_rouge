package Action;

import java.awt.event.ActionEvent;

import UI.RootLayer;

public class Navigation {
	
	private static RootLayer navigator; 

	public Navigation() {
		super();
	}
	
	public Navigation(String text) {
		super();
	}

	public static void setNavigator(RootLayer nav) {
		Navigation.navigator = nav;
	}

	public void actionPerformed(ActionEvent prev) {
		this.navigator.removeLayer(navigator.highestLayer());
	}


}
