package Inventory;

import java.util.HashMap;
import java.util.Map;

import Battle.Effect;


/*
 * Classe Sorts --
 */
public class Sort extends Item{
	
	private static int id;
	private static String nom; 
	private Effect effet;
	private int mana;
	private static String description;

//-- Constructor -- 
	 public Sort(int id, String nom, String description, Effect effet,int mana) { 
	
		 super(id, ItemType.SORT, nom, prix, color, description); 
	 		
		 	this.setId(id);
		 	this.setNom(nom);
		 	this.mana = mana;
		 	this.effet = effet;
		 	this.description = description;
		 
	 }
			 
				
				 
	
	 private static Map<String,Sort> possibleSort = new HashMap<String,Sort>();
	
	 	public void initPossiblePotions() {
	 		possibleSort.put("SortFroz", new Sort(0, "frozen", 
	 				"Un petit sort de base Mais qui pourrait contre le rechauffement climatique (ou pas)", effect(), mana));
	 		
			
	 		possibleSort.put("SortMiss", new Sort(0, "missileMagique", "Petit missile magique."+ 
				 		"Qui fera tourner la t�te des enemis", effect(), mana));
			
	 		possibleSort.put("SortFeu", new Sort(0, "BoulesDeFeu", "Petites boules de feu - Parfaite pour un petit"
	                	+ "feu de camp ?", effect(), mana));
		 
	 		possibleSort.put("SortTemp", new Sort(0, "canonArcane", "Un canon et pas n'importe lequel"
				 		+ "Surprise.", effect(), mana));
		 
	 		possibleSort.put("SortArc", new Sort(0, "tempetedesDieux", "Tornado"+ ".", effect(), mana));
	 	
	 	}

	

	public Effect effect() { return new Effect(effet); }


//--- Prend pour cible un ennemi pour utiliser le sort en question -- 
	public boolean requiresTarget() { return true; }

	

//--- GETTER & SETTER  - 
	
	public String getDescription() { return description; }

	public void setDescription(String description) { this.description = description; }

	public String getNom() { return nom; }

	public void setNom(String nom) { this.nom = nom; }

	public int getId() { return id; }

	public void setId(int id) { this.id = id; }
	
	
}
