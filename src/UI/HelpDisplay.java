package UI;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public class HelpDisplay implements Screen {

	@Override
	public void displayOutput(AsciiPanel terminal) {
		
		terminal.clear();
		terminal.writeCenter("Bienvenue dansl'aide du jeu", 1);
		terminal.write("Avances dans le monde, retrouvez le boss", 1, 3);
		terminal.write("Fais combatre ton équipe pour ne pas mourir", 1, 4);
		
		int y = 6;
		terminal.write("[g] ou [,] pour ramasser", 2, y++);
		terminal.write("[d] pour drop un objet", 2, y++);
		terminal.write("[e] Consommer", 2, y++);
		terminal.write("[f] Equiper", 2, y++);
		terminal.write("[?] pour l'aide", 2, y++);
		terminal.write("[x] Regarder l'inventaire", 2, y++);
		terminal.write("[t] Jeter un objet", 2, y++);
		terminal.write("[q] Boire une potion", 2, y++);
		terminal.write("[l] Lire", 2, y++);
		
		terminal.writeCenter("-- Appuie sur une touche pour continuer--", 22);
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		return null;
	}

}
