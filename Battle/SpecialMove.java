package Battle;

import java.awt.Image;


//-- Mouvements ou attaques sp�ciales
public class SpecialMove {

	public int id;
	public String name;
	public String desc;
//--- level that the player has to be to unlock this smove
	public int levelUnlocked;

//--- the icon of this smove
	public Image icon;

	public SpecialMove(int id, String name, String desc, int levelUnlocked, Image icon) {
	        
		this.id = id;
	    this.name = name;
	    this.desc = desc;
	    this.levelUnlocked = levelUnlocked; /// Voit le niveau deloqu� ?
	    this.icon = icon;
	}
	

}
