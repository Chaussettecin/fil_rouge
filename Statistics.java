package Utils;

//Stores data for game statistics
  //(battle, map, etc)
 
//--- Stat du joueur --- 
public class Statistics {

	 public MaxStat maxGold;

	 public static int totalGoldepenserprSante;
	 public static int totalGoldDepenser;
	 
	 public int XPgagne;
	 public int degatPris;
	 public int santeGagner;
	 public int nbreEnemyTuer;
	 public int nbreObjetAcheter;

// --- Stat Maps du joueur ---
    public int nbreDonjonFinis;
    public int nbreObjetGagner;
    public int goldGagnerMaps;
    public int nbreMondeFini;
    public int numTeleporte;


// --- Combat Stat --

    public int degat;
    public MaxStat maxDegatUneAttaque;
    public MaxStat maxDegatBattle;
    public MaxStat maxSanteSoin;
  
    public int combatPerdus;
    public int combatCultitePerdus;
    public int combatBossPerdus;
    
    public int cultiteRencontrer;
    public int bossRencontrer;

    public Statistics() {
    	
        maxGold = new MaxStat();
        maxDegatUneAttaque = new MaxStat();
        maxDegatBattle = new MaxStat();
        maxSanteSoin = new MaxStat();
        
    }

    public void updateMax(MaxStat maxStat, int candidate) {
        if (candidate > maxStat.stat) {
            maxStat.stat = candidate;
        }
    }

//-- Return : liste des description stat
    public String[] getDescList() {
        return new String[] {
            "Perso Statistique",
            "xp gagné: ",
            "Total Gold : ",
            "Degats pris: ",
            "Soin : ",
            "Nombre de morts : ",
           
            "Articles achetés dans la boutique: ",
            "Stat des maps :",

            "Nombre de Monde fini : ",
            "Nombre d'objet gagné après un combat : ",
            "Nombre d'objet abandonné : ",
            "Total gold gagné dans la maps : ",

            "Nombre de monde exploré : ",
            
            "Statistique Combat",
            "Nombre de défaite via les cultistes : ",
            "Nombre de Cultiste battu : ",
            "Nombre de defaite via les boss: ",
            "Nombre de Boss battu : "
        };
    }

//-- Return la liste des stat par num -- 
    public String[] getStatsList() {
        return new String[] {
            "",
            "" + maxGold,
            "" +totalGoldepenserprSante,
            "" +totalGoldDepenser, 
            "" +XPgagne,
            "" +degatPris, 
            "" +santeGagner,
            "" +nbreEnemyTuer,
            "" +nbreObjetAcheter, 
            "" +nbreDonjonFinis, 
            "" +nbreObjetGagner,
            "" +goldGagnerMaps,
            "" +nbreMondeFini,
            "" +numTeleporte,
           
            "",
          
            "" +degat,
            "" +maxDegatUneAttaque,  
            "" +maxDegatBattle,
           
            "",
            "" + combatPerdus, 
            "" + combatCultitePerdus,
            "" + combatBossPerdus,
            
            "" +cultiteRencontrer,
            "" +bossRencontrer
        };
    }

}
