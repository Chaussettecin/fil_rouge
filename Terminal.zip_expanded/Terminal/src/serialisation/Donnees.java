package serialisation;

import java.util.ArrayList;

import Screen.PlayScreen;
import terminalOverflow.Vector2d;

public class Donnees {
	private String nom;
	private boolean isValide=true;
	private Vector2d pos;
//	private ArrayList ennemie;
//	private int imap,jmap;
	
	
	public Donnees() {
		
	}
	
	public Donnees(PlayScreen screen) {
		this.pos=screen.j.position;
		this.nom=screen.j.getNom();
//		
//		this.imap=screen.map.iX;
//		this.jmap=screen.map.jY;
		
	}
	public Vector2d getPos() {
		return pos;
	}
	
	public String getNom() {
		return this.nom;
	}
	
//	public ArrayList getEnnemie() {
//		return ennemie;
//	}
//	public int getImap() {
//		return imap;
//	}
//	public int getJmap() {
//		return jmap;
//	}

}
