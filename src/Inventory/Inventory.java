package Inventory;

import java.util.ArrayList;

//inventaire est une collection d'objets dispos�s dans une grille.
//agit comme 1 classe de collection et fonctionne pour impl�menter la gestion des stocks

public class Inventory {

	public Item[] items;
	public Item[] getItems() { return items; }
	public Item get(int i) { return items[i]; }

//-- Inventaire limiti� � 24 objets pour l'équipe
    public static final int NUM_SLOTS = 24;
    

    public Inventory() {
        items = new Item[NUM_SLOTS];
    }

    public void add(Item item){
		for (int i = 0; i < items.length; i++){
			if (items[i] == null){
				items[i] = item;
				break;
			}
		}
	}
    
	public void remove(Item item){
		for (int i = 0; i < items.length; i++){
			if (items[i] == item){
				items[i] = null;
				return;
			}
		}
	}

// -- Check si l'inventaire de l'�quipe est complet --
    public boolean isFull(){
		int size = 0;
		for (int i = 0; i < items.length; i++){
			if (items[i] != null)
				size++;
		}
		return size == items.length;
	}
    
	
	public boolean contains(Item item) {
		for (Item i : items){
			if (i == item)
				return true;
		}
		return false;
	}
   
    
	
	public void arrayRandomPotion() {
    	ArrayList<Item> ar = new ArrayList<Item>();
    	
    	Item popo = Potion.generateRandomPotion();
    	
    	ar.add(popo);
    	Item usedItem = ar.remove(0);
    	
    	for(Item item:ar) {
    		System.out.println(item.toString());
    	}
    }

}
