package Inventory;

import java.util.ArrayList;

//inventaire est une collection d'objets disposés dans une grille.
//agit comme 1 classe de collection et fonctionne pour implémenter la gestion des stocks

public class Inventory {

//-- Inventaire limitié à 24 objets
    public static final int NUM_SLOTS = 24;
    public Item[] items;

    public Inventory() {
        items = new Item[NUM_SLOTS];
    }


// --- Retourne si un emplacement à un index est vide ou non --
    public boolean isFreeSlot(int index) {
        return items[index] == null;
    }

    
 //-- Ramasse l'objet --  
    public Item takeItem(int index) {
        Item ret = null;
        if (items[index] != null) {
            ret = items[index];
            items[index] = null;
            return ret;
        }
        return null;
    }

// -- Verifie si le sac à dos / inventaire du Joueur est complet --
    public boolean isFull() {
        for (int i = 0; i < NUM_SLOTS; i++) {
            if (items[i] == null) return false;
        }
        return true;
    }

   
    public void bidon() {
    	ArrayList<Item> ar = new ArrayList<Item>();
    	
    	Item popo = Potion.generateRandomPotion();
    	
    	ar.add(popo);
    	Item usedItem = ar.remove(0);
    	
    	for(Item item:ar) {
    		System.out.println(item.toString());
    	}
    }

}
