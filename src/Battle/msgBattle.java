package Battle;

public class msgBattle {
	

    public static String inputPrompt(String userName) {
        return (userName + "'s tour \n Choix de l'action : \n1. Attaquer | 2. Ne rien faire");
    }

    public static String attackAction(String userName, int damage) {
        return (userName + " attaque, en faisant" + damage + "\n");
    }

    public static String noAction(String userName) {
        return (userName + "ne fait rien...");
    }

}
