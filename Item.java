package Inventory;

import Inventory.ItemType;

public abstract class Item {
	
	 protected String nom;
	 protected Integer prix;
	 protected final Integer id;
	 protected final ItemType type;
	 
// Constructor --    
	public Item(Integer id, ItemType type, String nom, Integer prix) {
	        
		 this.id = id;
	     this.type = type;
	     this.nom = nom;
	     this.prix = prix;
	    
	 }

	public String getNom() {
	        return nom;
	}

	public void setNom(String nom) {
	     this.nom = nom;
	}
  
	public Integer getPrix() {
	    return prix;
	 }

	public void setPrix(Integer prix) {
	    this.prix = prix;
	 }

	public ItemType getType() { return type; }

	public Integer getID() { return id; }
	    
	@Override
	public abstract String toString();

	public static void add(ArmeItem itemArme) {
		// TODO Auto-generated method stub
		
	}
	    

}
