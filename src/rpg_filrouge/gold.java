package rpg_filrouge;

public class gold {

	private static int gold;
	private static int banque;

   public static int get() {
        return gold;
    }

    public static void set(int montant, boolean add) {
        if (!add) {
            gold = montant;
        } else {
            gold += montant;
            if (montant < 0) stats.totalGoldDepenser += -montant;
            if (gold < 0) gold = 0;
        }
    }
}
