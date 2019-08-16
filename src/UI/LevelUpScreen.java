package UI;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import Mouvement.PersoMouv;
import Perso.LevelUpController;
import Perso.Perso;
import asciiPanel.AsciiPanel;

public class LevelUpScreen implements Screen {

	private LevelUpController controller;
	private Perso perso;
	private int choix;
	
	
// --- Constructor -- 	
	public LevelUpScreen(Perso perso, ArrayList<PersoMouv> persoArrayMouv, int picks){
		
		this.controller = new LevelUpController();
		this.perso = perso;
		this.choix = picks;
	
	}
	
	
// --- Méthode Screen --	
	@Override
	public void displayOutput(AsciiPanel terminal) {
		
		List<String> options = controller.getLevelUpOptions();
		
		int y = 5;
		
		terminal.clear(' ', 5, y, 30, options.size() + 2);
		terminal.write("   Choisis un bonus de level Up  ", 5, y++);
		terminal.write("------------------------------", 5, y++);
		
		for (int i = 0; i < options.size(); i++){
			terminal.write(String.format("[%d] %s", i+1, options.get(i)), 5, y++);
		
		}
	}


/*
 *  Reponses du joueur
 *  * Entrer = continuer 
 *  * S =  Sauvegarder ? 
 */
	@Override
	public Screen respondToUserInput(KeyEvent key) {
		
		List<String> options = controller.getLevelUpOptions();
		String chars = "";
		
		for (int i = 0; i < options.size(); i++){
			chars = chars + Integer.toString(i+1);
		}
		
		int i = chars.indexOf(key.getKeyChar());
		
		if (i < 0)
			return this;
		
		controller.getLevelUpOption(options.get(i)).invoke(perso);
		
		if (--choix < 1)
			return null;
		else
			return this;
	}


}
