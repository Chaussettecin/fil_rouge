package Serialization;

import Perso.Perso;
import Main.PlayScreen;
import Mouvement.Vector2d;

public class Donnees {
	
	private Perso nom;
	private Vector2d pos;
	private boolean isValide=true;

	public Donnees() {}
		
	public Donnees(PlayScreen screen) {
		this.pos=screen.persD.position;
		this.nom=screen.persD.getPerso();
	}
	
	public Vector2d getPos() {
		return pos;
	}
	
	public Perso getNom() {
		return this.nom;
	}

	public boolean isValide() {
		return isValide;
	}

	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}
	

}
