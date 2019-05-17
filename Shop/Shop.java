package Shop;

import java.util.ArrayList;

import inventory.ShopItem;
import inventory.Item;
import resource.ResourceManager;
import save.ShopItemAccessor;


public class Shop {

    //-- articles vendus séparés par type --
    public ArrayList<ArrayList<Item>> items;
    
    public Shop(ResourceManager rm) {
   
    	items = new ArrayList<ArrayList<Item>>();
        
    	for (int i = 0; i < 3; i++) items.add(new ArrayList<Item>());

        // fill shop items with items
        for (int rarity = 0; rarity < rm.items.size(); rarity++) {
            
        	for (int i = 0; i < rm.items.get(rarity).size(); i++) {
                
        		Item item = rm.items.get(rarity).get(i);
                Item shopItem;
                
             //--- potions  
                if (item.type == 0) {
                    item = new Item(rm, item.name, item.desc, item.rarity,
                        item.imgIndex, item.minLevel, item.hp, item.exp, item.sell, item.price);
                    items.get(0).add(shopItem);
                }
                // equip
                else if (item.type >= 2 && item.type <= 6) {
                		item = new Item(rm, item.name, item.desc, item.type, item.rarity, item.imgIndex,
                        item.minLevel, item.mhp, item.dmg, item.acc, item.sell, item.price);
                    
                		items.get(1).add(shopItem);
                }
                // accs
                else if (item.type >= 7 && item.type <= 9) {
                    item = new Item(rm, item.name, item.desc, item.type, item.rarity, item.imgIndex,
                        item.minLevel, item.mhp, item.dmg, item.acc, item.sell, item.price);
                    items.get(2).add(shopItem);
                }
               

                else if (item.type == 10) {
                    item = new Item(rm, item.name, item.desc, item.rarity, item.imgIndex, item.minLevel,
                        item.eChance, item.sell, item.price);
                    items.get(0).add(shopItem);
                }
            }
        }
    }

}
