package inventory;

//-- La collection d'équipes que le joueur a équipée -

public class Equipment {

    public static final int NUM_SLOTS = 4;
    public Item[] equips;
    
    //-- Arme dispo pour le joueur, 2 armes par joueurs
    //max 2 ùaisn pour manier l'arme
    private int nbrMain = 2 ;
    
    public Equipment() {	
	}

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

    // Getter -----------------------------
    public int getNbrMain() {
        return nbrMain;
    }

    // Setter -----------------------------
    public void setNbrMain(int nbrMain) {
        this.nbrMain = nbrMain;
    }
}
