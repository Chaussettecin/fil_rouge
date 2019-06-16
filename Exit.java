package Action;

import java.awt.Window;
import java.awt.event.ActionEvent;

public class Exit {

	public static Window window;

	public Exit() {}
	
	public Exit(String name) {
		super();
	}

	public static void setWindow(Window w) {
		Exit.window = w;
	}

	
}
