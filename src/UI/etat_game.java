package UI;

import Perso.Perso;

public class etat_game {
	
	private int nodeID;
	private Perso Perso;

	
	public etat_game(int tempNodeID,  Perso tempPerso) {
			
			nodeID = tempNodeID;
			Perso = tempPerso;
	}
	
	
	public int getNodeID() {
			return nodeID;
	}
	
	
	public Perso getJoueur() {
		return Perso;
	}
	
}
