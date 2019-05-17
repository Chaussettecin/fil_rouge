package inventory;

//-- La collection d'équipes que le joueur a équipée -


public class Equipment {

 //--- equipement :
     //0 - helmet
     //1 - armor
     //2 - weapon
     //3 - gloves
     //4 - shoes
     //5 - necklace
     //6 - shield
     
  
    public static final int NUM_SLOTS = 8;

    public Item[] equips;
    
    //public Vector2[] positions;

   /* public Equipment() {
    	//-- stock les positions des machines à sous par rapport aux stocks
        equips = new Item[NUM_SLOTS];
        positions = new Vector2[NUM_SLOTS];

        positions[0] = new Vector2(42, 42);
        positions[1] = new Vector2(42, 26);
        positions[2] = new Vector2(26, 26);
        positions[3] = new Vector2(58, 26);
        positions[4] = new Vector2(42, 10);
        positions[5] = new Vector2(10, 42);
        positions[6] = new Vector2(10, 26);
        positions[7] = new Vector2(10, 10);
    }*/

//-- Le joueur équipé d'un objet qui est placé dans le bon emplacement
    //--Retourne false si impossible
    public boolean addEquip(Item equip) {
        if (equips[equip.type - 2] == null) {
            equips[equip.type - 2] = equip;
            equip.equipped = true;
            return true;
        }
        return false;
    }

//-- Supprime une équipe à un index et renvoie l'élément
    public Item removeEquip(int index) {
        Item ret = null;
        if (equips[index] != null) {
            ret = equips[index];
            equips[index] = null;
            return ret;
        }
        return null;
    }

//--- Retourne l'équipement d'un index spécifique mais ne le supprime pas
    public Item getEquipAt(int index) {
        return equips[index];
    }

}
