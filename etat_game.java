package ui;

import perso.perso;

public class etat_game {
	
	private int nodeID;
	private perso Perso;

	
	public etat_game(int tempNodeID,  perso tempPerso) {
			
			nodeID = tempNodeID;
			Perso = tempPerso;
	}
	
	
	public int getNodeID() {
			return nodeID;
	}
	
	
	public perso getJoueur() {
		return Perso;
	}
	
}
