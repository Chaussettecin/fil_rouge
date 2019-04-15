
import javax.swing.*;

public class support {

	public static void error(String e) {
	    System.err.println(e);
	    ui.popup(e, "Non non ceci n'est pas possible ! Erreur ^=^", JOptionPane.WARNING_MESSAGE);
	}
}
