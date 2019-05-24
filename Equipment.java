package inventory;

//-- La collection d'�quipes que le joueur a �quip�e -

public class Equipment {

    public static final int NUM_SLOTS = 4;
    public Item[] equips;
    
    //-- Arme dispo pour le joueur, 2 armes par joueurs
    //max 2 �aisn pour manier l'arme
    private int nbrMain = 2 ;
    
    public Equipment() {	
	}

	//-- Le joueur �quip� d'un objet qui est plac� dans le bon emplacement
    //--Retourne false si impossible
    public boolean addEquip(Item equip) {
        if (equips[equip.type - 2] == null) {
            equips[equip.type - 2] = equip;
            equip.equipped = true;
            return true;
        }
        return false;
    }

//-- Supprime une �quipe � un index et renvoie l'�l�ment
    public Item removeEquip(int index) {
        Item ret = null;
        if (equips[index] != null) {
            ret = equips[index];
            equips[index] = null;
            return ret;
        }
        return null;
    }

//--- Retourne l'�quipement d'un index sp�cifique mais ne le supprime pas
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
