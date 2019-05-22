package perso;

import java.util.concurrent.ThreadLocalRandom;

import ui.UI;

//--- Classe concernant les PNJ dans le jeux - 
	    		
	public class NPC extends perso {
	    
		
		public NPC(String name, int lifeMax, int manaMax, int powerMax) {
	        
			super(name, name, name, lifeMax, manaMax, powerMax, dead, powerMax, powerMax, powerMax, powerMax);
	    }

	}
	    
