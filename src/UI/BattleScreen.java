package UI;

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;

import Enemy.Enemy;
import Perso.Perso;

import Enemy.Cultiste;
import Main.PlayScreen;

import Battle.BattleFight;
import Mouvement.PersoMouv;
import Mouvement.Vector2d;
import Serialization.Serialiser;


/*
 * Screen de combat survient aprés la screen 
 * Rencontre avec les cultistes
 */
public class BattleScreen implements Screen {
	
	Perso perso;
	Cultiste cult;
	BattleFight fight;
	
	public PersoMouv persD;
	PlayScreen screenBefore;
	
	
//--- Consructor  - 	
	public  BattleScreen(PlayScreen before,int enn, Vector2d v ) {	

		this.screenBefore=before;
		cult = PlayScreen.meetCultiste(); 
		
		this.fight=new BattleFight (screenBefore.getPersoArray(),cult);

		screenBefore.map.map
		[screenBefore.getPersoArray().get(enn).getXp()] // a voir avec fab
		[screenBefore.getPersoArray().get(enn).getXp()]=' ';
		screenBefore.getPersoArray().remove(enn);

	}
	
	
//--- Méthode Screen	
	
	@Override
	public Screen respondToUserInput(KeyEvent key) {
		
		if(key.getKeyCode()==KeyEvent.VK_ENTER) {
			return screenBefore;
		
		} else if (key.getKeyChar()=='s') {
			//-- S -- Sauvegarde 
			new Serialiser(screenBefore,"testSav.json");
		
		}
		
		return this;
	}
	
	
/*
 * Affichage du interface menu d'action pendant un combat - 
 */
	@Override
	public void displayOutput(AsciiPanel terminal) {
			
		terminal.write(" Un cultiste apparait"+ "J'espére que votre equipe et prete !");
		terminal.writeCenter("Combat avec "+ cult.getNom(), 1);
		terminal.writeCenter("Les point de vie du cultiste  : " + Enemy.getPtv(), 2);
		terminal.writeCenter("Choix d'action : ",3); 
		terminal.writeCenter("1. Lancer l'attaque ", 4); //Methode - Attack
		terminal.writeCenter("2. Lancer un sort ", 5); // Methode - Sort
		terminal.writeCenter("3. Soigner ", 6); // Methode - Soigner
		terminal.writeCenter("4. Ne rien faire", 7); // Methode - no action 
		BattleFight.fight(); //-- Lance le combat
	
		//-- Attaque 
		terminal.writeCenter(perso.getNom() + "attaque, en faisant" , 8);
		// -- No Action
		terminal.write(perso.getNom() + "ne fait rien... ");
		
		//-- Intro Combat
		
		
	}
	
	
//-- Coup critique perso
	/*public static void persoCrit() {
        System.out.println("Bravo ! Tu viens de faire un coup critique ! (x2 Degat)");
	}*/

//-- Coup critique ennemi 
	/*public static void monsterCrit() {
      	System.out.println("Ouch! L'enemi vient de te donner un coup critique " + "(x2 Ddegat)");
	}*/

//-- msg attaque -
	/*public static void persoAttaqueMsg(int degat, Enemy Enemy) {
        System.out.println("Oupss... " +  Enemy.getNom() + 
        " vient de te frapper en te faisant " + degat + " d�gats.");       
	}*/

//-- msg ennemi attaque	
	/*public static void enemyAttaqueMsg(Enemy Enemy) {
        System.out.println("Tu viens de toucher" + Enemy.getNom());
	}*/
	

//-- msg Game Over -
	public static String gameOver(Perso perso, Enemy Enemy) {
	
		return 	Perso.getNom() + "de ton équipe " + "a et abattu par" + 
				Enemy.getNom() + "Oupss.... pas de chance" + 
				"pour ce personnage"
		    	+ "il lui faudra consommer une potion de restauration";
	}


    
}
