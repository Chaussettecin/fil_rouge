package inventory;




//-- An Item is held by an inventory slot and can be one of:

	// potion (restores current hp)
	// equip (several categories of equips)
	// misc (some other useless thing)

	public class Item {

		public String name;
		public String labelName;
		public String desc;
    // type of item
    /**
     * 0 - potion
     * 1 - misc
     * 2 - helmet
     * 3 - armor
     * 4 - weapon
     * 5 - gloves
     * 6 - shoes
     * 7 - necklace
     * 8 - shield
     * 9 - ring
     * 10 - enchant scroll
     */
    public int type;
    public int prix;

    // the range of enemy levels that can drop this item
    public int minLevel;
    public int maxLevel;

    // item stats
    // if hp is negative then its absolute value is the percentage hp that the item gives
    // used to separate percentage hp from regular hp potions
    public int ptv = 0;
    public int minPtv = 0;
    public int dmg = 0;
    public int acc = 0;
    // potions can give exp (percentage)
    public int exp = 0;

    // an item's index in the inventory
    public int index;
    // whether or not this item is equipped
    public boolean equipped = false;
    // the number of successful enchants on the item
    public int enchants = 0;
    public int enchantCost;
    // percentage bonus enchant chance from scrolls
    public int bonusEnchantChance = 0;
    // for enchant scrolls representing the bonus enchant percentage that the scroll gives
    public int eChance = 0;


    
//  For potions // Only can be consumed for hp or sold for gold
    public Item(String name, String desc, int rarity, int imgIndex, int minLevel, 
    		int maxLevel, int hp, int exp, int prix, int ptv) {
       
    	this.name = name;
        this.desc = desc;
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
        this.ptv = ptv;
        this.exp = exp;
        this.prix = prix;
        type = 0;
        labelName = name;
    }

// -- For misc items  -- Only can be sold for gold
    public Item(String name, String desc, int rarity, int imgIndex, int minLevel,
    		int maxLevel, int prix, int exp2, int sell) {
    	
    		this.name = name;
    		this.desc = desc;
    		this.minLevel = minLevel;
    		this.maxLevel = maxLevel;
    		this.prix = prix;
    		type = 1;
    		labelName = name;
    
    }

 //-- For all types of equips
    //--Gives increased stats and can be sold for gold
    public Item(String name, String desc, int type, int rarity, int imgIndex, 
    			int minLevel, int maxLevel, int mPtv, int dmg, int acc, int prix) {
      
    	this.name = name;
        this.desc = desc;
        this.type = type;
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
        this.minPtv = mPtv;
        this.dmg = dmg;
        this.acc = acc;
        this.prix = prix;
        labelName = name;
    }

 //-- For enchant scrolls -
    public Item(String name, String desc, int rarity, int imgIndex, int minLevel, 
    		int maxLevel, int eChance, int prix) {
        
    	this.name = name;
        this.desc = desc;
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
        this.eChance = eChance;
        this.prix = prix;
        type = 10;
        labelName = name;
    }


    public Item(String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
	}

	

	//-- Returns the full description with all stats and descriptions
    //- concatenated into a single string
    public String getFullDesc() {
       
    	String ret = "";
        
    	if (type == 0) {
    		
            // percentage hp potions
            if (ptv < 0) ret = desc + "\n retrouve " + - ptv + "%  de vie ";
            // exp potions
            else if (exp > 0) ret = desc + "\nDonnes " + exp + "% XP";
            else ret = desc + "\nSoin pour" + ptv + " Points de vie";
            ret += "\n\ndouble tap to consume";
        
    	} else if (type == 1) {
            ret = desc;
        
    	} else if (type >= 2 && type <= 9) {
            ret = desc + "\n";
            if (ptv != 0) ret += "+" + ptv + " PV\n";
            if (dmg != 0) ret += "+" + dmg + " Degats\n";
            if (acc != 0) ret += "+" + acc + "% Precision de l'attaque "; // Accuracy
            if (bonusEnchantChance != 0) ret += "\n+" + bonusEnchantChance + "% BONUS ENCHANT CHANCE";
       
    	} else if (type == 10) {
            ret = desc + "\n+" + eChance + "% ENCHANT CHANCE";
            ret += "\n\ndrag onto an equip to use";
        }
        // remove newline from end of string if there is one
        ret = ret.trim();
        return ret;
    }


 //-- Returns the item's name as [TYPE] [name] for dialog box -- 
    public String getDialogName() {
        
    	String ret = "";
        
    	switch (type) {
            case 0:
                ret = "[COMMON] " + name;
                break;
            case 1:
                ret = "[RARE] " + name;
                break;
            case 2:
                ret = "[EPIC] " + name;
                break;
            case 3:
                ret = "[LEGENDARY] " + name;
                break;
        }
        return ret;
    }

}
