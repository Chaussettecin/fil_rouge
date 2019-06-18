package Gold;



public class Gold {

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
	         
	        //if (montant < 0) persostat.totalGoldDepenser += -montant;
	        if (gold < 0) gold = 0;
	    }
	}

	public static int getBanque() {
		return banque;
	}

	public static void setBanque(int banque) {
		banque = banque;
	}
}
