package UI;

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;
import java.util.ArrayList;

import Perso.Perso;
import Inventory.Sort;
import Inventory.Item;
import Main.PlayScreen;
import Mouvement.Vector2d;



public class ReadSpellScreen implements Screen {

	Vector2d v;
	private Item item;
	protected Perso perso;
	private String letters;
	
	static PlayScreen screenBefore;
	

//--- Constructor -- 	
	public ReadSpellScreen(Perso perso, Vector2d v, Item item){
		
		this.perso = perso;
		this.letters = "abcdefghijklmnopqrstuvwxyz";
		this.item = item;
		this.v = v;
	
	}
	
	

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
		terminal.write("Que voudrais-tu faire?", 2, 23);
		
		terminal.repaint();
	
	}
	
	
//--- Liste des sorts  -- 
	private ArrayList<String> getList() {
			ArrayList<String> lines = new ArrayList<String>();
		
		for (int i = 0; i < item.writtenSpells().size(); i++){
			
			Sort sort = item.writtenSpells().get(i);
			
			String line = letters.charAt(i) + " - " + sort.getNom();
			lines.add(line);
		
		}
		
		return lines;
	}

	
	
	public Screen respondToUserInput(KeyEvent key) {
		
		char c = key.getKeyChar();

		Item[] items = perso.inventaire().getItems();
		
		if (letters.indexOf(c) > -1 
				&& items.length > letters.indexOf(c)
				&& items[letters.indexOf(c)] != null) {
			
			//return use(item.writtenSpells().get(letters.indexOf(c)));
		
		} else if (key.getKeyCode() == KeyEvent.VK_ESCAPE) {
			return null;
		
		} else {
			return this;
		}
		return null;
	
	}

	
//--- Utilisation du sort -- 
	/*protected CastSpellScreen use(Sort sort){
		
		if (sort.requiresTarget())
			return new CastSpellScreen(perso, "", v, sort);
		
		//perso.castSpell(sort);
		return null;
	}*/


}
