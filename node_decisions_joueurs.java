package ui;

import java.util.Arrays;
import java.util.ArrayList;

import perso.perso;


public abstract class node_decisions_joueurs extends node_decisions{
	 private ArrayList<String> menu;
	 
	public node_decisions_joueurs(String[] tempMenu, node[] tempNextNodes){
		    
		super(tempNextNodes);
		  menu = new ArrayList<String>(Arrays.asList(tempMenu));
		 }

	public node process(perso Perso) {
		   return nextNodes.get(UI.menu("Que veux-tu faire ?", menu));
	}

		 
}
