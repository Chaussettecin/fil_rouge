package UI;

import java.io.File;

public class SaveSlot {
	
	private String gamestate = "Emplacement vide";
	private File data;
	
	public SaveSlot() {
		
	}
	
	public String toString() {
		return gamestate;
	}

	public void overwrite() {
		this.gamestate = "Emplacement vide";
		
	}

	public boolean isEmpty() {
		return (gamestate=="Emplacement vide");
	}
	
	

}
