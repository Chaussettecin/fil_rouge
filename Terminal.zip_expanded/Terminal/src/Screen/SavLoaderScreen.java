package Screen;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import asciiPanel.AsciiPanel;
import serialisation.Deserialiser;
import serialisation.Donnees;

public class SavLoaderScreen implements Screen {
	
	ArrayList<Donnees> list;
	int i;
	
	public Screen respondToUserInput(KeyEvent key) {
		if(key.getKeyCode()==KeyEvent.VK_ESCAPE)
			return new StartScreen();
		if(list!=null) {	
			switch(key.getKeyCode()) {
			
			case KeyEvent.VK_0:
				if(i<2) {
				System.out.println("hello");
					return new PlayScreen(list.get(0));
					
				}	
				break;
			case KeyEvent.VK_1:
				if(i<3)
					return new PlayScreen(list.get(1));
				break;
			case KeyEvent.VK_2:
				if (i<4) 
					
					return new PlayScreen(list.get(2));
				
				break;
			case KeyEvent.VK_3:
				if(i<5)
					return new PlayScreen(list.get(3));
				break;
				
			
			}
		}	
		return this;
		
		
	}

	@Override
	public void displayOutput(AsciiPanel terminal) {
		
	    	
	    	list = new Deserialiser("sav.json").getListe();
	    	
	    	if(list.size()==0)
	    		terminal.writeCenter("Aucune sauvegarde pour le moment", 4,Color.RED);
	  
		terminal.writeCenter("Choississer votre sauvegarde : ", 2);
		for(i=0;i<list.size();i++) {
			terminal.writeCenter(i +". "+ list.get(i).getNom(), 5+i);
		}

	}

}
