package inventory;

//inventaire est une collection d'objets dispos�s dans une grille.
//agit comme 1 classe de collection et fonctionne pour impl�menter la gestion des stocks

public class Inventory {

//-- Inventaire limiti� � 24 objets
    public static final int NUM_SLOTS = 24;
    public Item[] items;

    public Inventory() {
        items = new Item[NUM_SLOTS];
    }

//Renvoie l'index du premier emplacement vide de l'inventaire.
    //Retourne -1s'il n'y a pas de slots libres
    public int getFirstFreeSlotIndex() {
        for (int i = 0; i < NUM_SLOTS; i++) {
            if (items[i] == null) return i;
        }
        return -1;
    }

//-- Renvoie l'�l�ment dans l'inventaire � un index donn�
   // mais ne supprime pas l'article de l'inventaire
    public Item getItem(int index) {
        return items[index];
    }

//Retourne si un emplacement � un index est vide ou non --
    public boolean isFreeSlot(int index) {
        return items[index] == null;
    }

//--- Ajoute un article � l'inventaire qui est plac� dans le premier emplacement disponible
    //Retourne false si l'article ne peut pas �tre ajout�
    public boolean addItem(Item item) {
        int i = getFirstFreeSlotIndex();
        if (i != -1) {
            items[i] = item;
            item.index = i;
            return true;
        }
        return false;
    }

    public boolean addItemAtIndex(Item item, int index) {
        if (isFreeSlot(index)) {
            items[index] = item;
            item.index = index;
            return true;
        }
        return false;
    }

//-- Supprime un article de l'inventaire � un index sp�cifique --
    public void removeItem(int index) {
        if (items[index] != null) items[index] = null;
    }

    public Item takeItem(int index) {
        Item ret = null;
        if (items[index] != null) {
            ret = items[index];
            items[index] = null;
            return ret;
        }
        return null;
    }

// -- Verifie si le sac � dos / inventaire du Joueur est complet --
    public boolean isFull() {
        for (int i = 0; i < NUM_SLOTS; i++) {
            if (items[i] == null) return false;
        }
        return true;
    }

    public void clear() {
        for (int i = 0; i < NUM_SLOTS; i++) {
            removeItem(i);
        }
    }

}
