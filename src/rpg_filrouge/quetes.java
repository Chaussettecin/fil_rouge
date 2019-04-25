package rpg_filrouge;


import java.util.ArrayList;

public class quetes {

	private static final ArrayList<quetes> QuetesList = new ArrayList<>();
    
    private final ArrayList<equipement_armure> recompensesArmures = new ArrayList<>();
    private final ArrayList<equipement_armes> recompensesArmes = new ArrayList<>();
    
    private String hote;
    //Recompenses
    private int goldRecompenseMin;
    private int goldRecompenseMax;
    private int xpRecompenseMin;
    private int xpRecompenseMax;
    private int santeRecompenseMin;
    private int santeRecompenseMax;
    //Prerequis
    private int minLevelReq;
    private boolean complete;
    private boolean disponible;

    public quetes(String hôte, int goldMin, int goldMax, int xpMin, int xpMax,
                 int santeMin, int santeMax, int minLevel, boolean complete, boolean dispo) {

        this.hote = hôte;
        this.goldRecompenseMin = goldMin;
        this.goldRecompenseMax = goldMax;
        this.xpRecompenseMin = xpMin;
        this.xpRecompenseMax = xpMax;
        this.santeRecompenseMin = santeMin;
        this.santeRecompenseMax = santeMax;
        this.minLevelReq = minLevel;
        this.complete = complete;
        this.disponible = dispo;
        QuetesList.add(this);
    }

    public static boolean checkQuetePrNPC(String npcNom) {
        boolean check = false;
        int i = 0;
        do {
            if (QuetesList.get(i).hote.equalsIgnoreCase(npcNom)) {
                if (QuetesList.get(i).getMinLevelReq() <= joueurs_xp.getLevel()) {
                    if (QuetesList.get(i).getDisponible())
                        check = !QuetesList.get(i).getComplete();
                }
            }

            i++;

        } while ((i < QuetesList.size()) || (check));
        return check;
    }

    public int getMinLevelReq() {
        return minLevelReq;
    }

    public boolean getComplete() {
        return complete;
    }

    public boolean getDisponible() {
        return disponible;
    }
}
