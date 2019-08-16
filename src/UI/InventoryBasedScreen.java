package UI;

import java.awt.event.KeyEvent;
import java.util.ArrayList;


import Inventory.Item;
import Perso.Perso;

import asciiPanel.AsciiPanel;

/*
 * Class affichage de l'inventaire
 */
public abstract class InventoryBasedScreen implements Screen {
	
	protected Perso perso;
	private String letters;
	
	protected abstract String getVerb();
	protected abstract Screen use(Item item);
	protected abstract boolean isAcceptable(Item item);
	
	
//--- Constructor -- 
	public InventoryBasedScreen(Perso perso){
		
		this.perso = perso;
		this.letters = "abcdefghijklmnopqrstuvwxyz";
	
	}
	
	
//--- Méthode Screen --
	public void displayOutput(AsciiPanel terminal) {
		ArrayList<String> lines = getList();
		
		int y = 23 - lines.size();
		int x = 4;

		if (lines.size() > 0)
			terminal.clear(' ', x, y, 20, lines.size());
		
		for (String line : lines){
			terminal.write(line, x, y++);
		}
		
		terminal.clear(' ', 0, 23, 80, 1);
		terminal.write("Quel est ton choix? " + getVerb() + "?", 2, 23);
		terminal.repaint();
	}
	
	
	
	private ArrayList<String> getList() {
			ArrayList<String> lines = new ArrayList<String>();
			Item[] inventaire = perso.inventaire().getItems();
		
		for (int i = 0; i < inventaire.length; i++){
			
			Item item = inventaire[i];
			
			if (item == null || !isAcceptable(item))
				continue;
			
			String line = letters.charAt(i) + " - "  + perso.getNom();
			
			if(item == perso.arme() || item == perso.armure())
				line += " (Equiper)";
			
			lines.add(line);
		}
		return lines;
	}

	
	public Screen respondToUserInput(KeyEvent key) {
		
		char c = key.getKeyChar();

		Item[] items = perso.inventaire().getItems();
		
		if (letters.indexOf(c) > -1 
				
				&& items.length > letters.indexOf(c)
				&& items[letters.indexOf(c)] != null
				&& isAcceptable(items[letters.indexOf(c)])) {
			
			return use(items[letters.indexOf(c)]);
		
		} else if (key.getKeyCode() == KeyEvent.VK_ESCAPE) {
			return null;
		
		} else {
			return this;
		
		}
	}
	
	

}
