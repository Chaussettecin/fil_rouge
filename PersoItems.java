package Perso;

import Shop.Shop;

import Util.JSON.Json;
import Util.JSON.JsonArray;
import Util.JSON.JsonObject;
import Util.JSON.JsonValue;

import java.util.ArrayList;

import Inventory.ArmeItem;
import Inventory.ArmesDistance;
import Inventory.ArmesMelees;
import Inventory.Item;

public class PersoItems {

    // Peut-être null 
    ArmeItem Arme;

    public static final int MaxInventorySize = 8;
    
    Item[] Inventory;

    PersoItems() {
        Inventory = new Item[MaxInventorySize];
    }

// -- Peut recup les items du sauvegarde - 
    public static PersoItems loadFromJSON(JsonObject json) {
        
    	PersoItems items = new PersoItems();

        if (json.contains("arme") && json.get("arme").isNumber()) {

            int armeID = json.get("arme").asInt();

            ArmeItem armeItem = (ArmeItem) Shop.getItemById(armeID);

            items.Arme = armeItem;
        }

        JsonArray inventaire = json.get("inventaire").asArray();

        items.Inventory = new Item[MaxInventorySize];

        for (int i = 0; i < MaxInventorySize; ++i) {
            JsonValue currentValue = inventaire.get(i);

            if (currentValue.isNull()) {
                items.Inventory[i] = null;
                continue;
            }

            int currentItemID = currentValue.asInt();
            Item currentItem = Shop.getItemById(currentItemID);
            items.Inventory[i] = currentItem;
        }

        return items;
    }

//--- Sauvegarde l'inventaire du perso en Json -    
    public void saveToJSON(JsonObject json) {
        
    	JsonObject characterItems = Json.object();
        json.add("items", characterItems);

        if (Arme == null)
            characterItems.add("arme", Json.NULL);
        else
            characterItems.add("arme", Arme.getID());

        JsonArray inventory = new JsonArray();
        
        characterItems.add("inventaire", inventory);

        for (int i = 0; i < MaxInventorySize; ++i) {
        
            Item currentItem = Inventory[i];
            
            if (currentItem != null)
                inventory.add(currentItem.getID());
            
            else
                inventory.add(Json.NULL);
        }
    }

    
    public boolean storeNewItem(Item newItem) {
        
    	for (int i = 0; i < MaxInventorySize; ++i) {
            
    		if (Inventory[i] == null) {
                Inventory[i] = newItem;

                return true;
            }
        
    	}
    	return false;
    }

    
    public Item getInventoryItem(int index) {
        return Inventory[index];
    }

    public Item removeInventoryItem(int index) {
        
    	Item returnItem = Inventory[index];
        Inventory[index] = null;
        return returnItem;
    }

    
    public ArrayList<Item> getAllInventoryItems() {
        
    	ArrayList<Item> items = new ArrayList<>();

        for (int i = 0; i < MaxInventorySize; ++i) {
            if (Inventory[i] != null)
                items.add(Inventory[i]);
        }
        return items;
    }
}
