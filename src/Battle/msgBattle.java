package Battle;

import Perso.Perso;

public class msgBattle {
	
    public static String inputPrompt(Perso perso) {
        return (perso + "'s tour \n Choix de l'action : \n1. "
        				+ "Attaquer | 2. Ne rien faire");
    }

    public static String attackAction(Perso perso, int damage) {
        return (perso + " attaque, en faisant" + damage + "\n");
    }

    public static String noAction(Perso perso) {
        return perso + "ne fait rien...";
    }
}
