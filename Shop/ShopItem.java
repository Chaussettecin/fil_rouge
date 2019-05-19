package Shop;

import inventory.Item;

public class ShopItem extends Item {

    // price of the item in the shop
    public int prix;

//-- Constructor - 
    public ShopItem ( String name, String desc, int rarity,
                    int imgIndex, int level, int hp, int exp, int sell, int prix) {
        
    			super(name, desc, rarity, imgIndex, level, level, hp, exp, sell);
        
    			this.prix = prix;
       
    }

    /**
     * For all types of equips
     * Gives increased stats and can be sold for gold
     *
     * @param name
     * @param desc
     * @param type
     * @param rarity
     * @param imgIndex
     * @param mhp
     * @param dmg
     * @param acc
     * @param sell
     */
    public ShopItem(String name, String desc, int type, int rarity,
                    int imgIndex, int level, int mhp, int dmg, int acc, int sell, int price) {
        super(name, desc, type, rarity, imgIndex, level, level, mhp, dmg, acc, sell);
        
        this.prix = prix;
     
    }

    /**
     * For enchant scrolls
     *
     * @param rm
     * @param name
     * @param desc
     * @param rarity
     * @param imgIndex
     * @param eChance
     * @param sell
     * @param price
     */
    public ShopItem(String name, String desc, int rarity, int imgIndex, int level,
                    int eChance, int sell, int price) {
        super(name, desc, rarity, imgIndex, level, level, eChance, sell);
        
        this.price = price;
       
    }

}
