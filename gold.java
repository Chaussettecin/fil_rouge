package rpg_filrouge;

public class gold {
	
//--- golds est la monnaie de notre univers

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
            if (montant < 0) perso_stats.totalGoldDepenser += -montant;
            if (gold < 0) gold = 0;
        }
    }
}
