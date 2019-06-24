package UI;

import Enemy.Enemy;
import Perso.Perso;

public class BattleDisplay {

/*
 * BLA BLA de combat -- 
 * 
 */
	public static String choicePrompt(Perso perso) {
		return (perso + "tour \n Choix de l'action : \n1."
	        			+ "Attaquer | 2. Ne rien faire");
	}

 	public static String attackAction(Perso perso, int damage) {
	    return (perso + " attaque, en faisant" + damage + "\n");
	}

	
	public static String noAction(Perso perso) {
	    return perso + "ne fait rien...";
	}
	
//--- Introduction d'un combat --
	public static String battleIntro(Perso perso, Enemy enemy) {
		        
		return enemy.getNom() + "apparait" +  
				"J'espère que votre équipe est prête !" + 
				"Ton combat avec " + enemy.getNom() + 
				"commence.\n";

	}
		
//-- Coup critique perso
	public static void persoCrit() {
        System.out.println("Bravo ! Tu viens de faire un coup critique ! (x2 Degat)");
	}

//-- Coup critique ennemi 
	public static void monsterCrit() {
      	System.out.println("Ouch! L'enemi vient de te donner un coup critique " + "(x2 Ddegat)");
	}

//-- msg attaque -
	public static void persoAttaqueMsg(int degat, Enemy Enemy) {
        System.out.println("Oupss... " +  Enemy.getNom() + 
        " vient de te frapper en te faisant " + degat + " dégats.");       
	}

//-- msg ennemi attaque	
	public static void enemyAttaqueMsg(Enemy Enemy) {
        System.out.println("Tu viens de toucher" + Enemy.getNom());
	}
	
//-- msg Game Over -
	public static String gameOver(Perso perso, Enemy Enemy) {
	
		return 	perso.getNom() + "de ton équipe " + "a été abattu par" + 
				Enemy.getNom() + "Oupss.... pas de chance" + 
				"pour ce personnage"
		    	+ "il lui faudra consommer une potion de restauration";

	}
    
}
