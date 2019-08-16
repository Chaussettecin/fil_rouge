package Battle;

import java.awt.event.InputMethodListener;
import asciiPanel.AsciiPanel;

import Maps.Map;
import Perso.Perso;
import Enemy.Enemy;

import Mouvement.Vector2d;
import Utils.SingleTonRandom;


public abstract class BattleController implements InputMethodListener {

	Map map;
	private Object e;
	Vector2d position;
	
	private Perso perso;
	private Enemy ennemy;
	
	BattleCommand Command;
	SingleTonRandom  Instance;
		

///--- Constructor - 		
	public BattleController(Perso perso, Enemy ennemy) {
		
		this.setPerso(perso);
		this.setEnnemy(ennemy);
			
	}

		
	public void controlPressed(AsciiPanel terminal) {
		
		//--- Rappel des battleCommand - 
		switch ((Command)) {
			
			case ATTACK:
					attack();
					break;
			
			case DEFEND:
					defend();
					break;
		
			case SORT:
					sort();
					break;
				
			case FLEE:
					flee();
					break;
				
			case HEAL:
					heal();
					break;

			default:
					break;
			}
		
	}

	
	public void controlReleased(AsciiPanel terminal) {
	}

/**
 * Perso attaque =  inflige entre 7 et0 points dégats avec 10% 
 * de chance de faire un critique (+50% de dégât) L'ennemi 
 * contre attaque en infligeant entre 5 et 9 dégâts.
 * 
*/
	private void attack () {
			
		int persoAttack = 7 + Instance.nextInt(4);
			
		if (Instance.nextDouble() < .1) {
			persoAttack += persoAttack / 2;
		}	
			
		Enemy.setPtv(Enemy.getPtv() - persoAttack);
			
		if (Enemy.getPtv() <= 0) {
	
			
		} else {
			
			int ennemyAttack = 5 + Instance.nextInt(5);
			Perso.setPtv(Perso.getPtv() - ennemyAttack, "Bobo");
				
			if (Perso.getPtv() <= 0) {}
			
		}
	}


/**
 * Si le joueur d�fend :
 * L'ennemi attaque et inflige entre 5 et 9 d�g�ts. Mais la moiti� des d�g�ts sont pr�venu.</li>
 * Le joueur contre attaque en infligeant entre 7 et 10 points de d�g�ts sans possibilit� de
 * faire des critiques.
*/
	private void defend() {
			
	int ennemyAttack = (5 + Instance.nextInt(5)) / 2;
	Perso.getPtv();
			
	if (Perso.getPtv() <= 0) {
		//game.enterState(MainScreenGameState.ID);
			
	} else {
				
		int playerAttack = 7 + Instance.nextInt(4);
		Enemy.setPtv(Enemy.getPtv() - playerAttack);
				
		if (Enemy.getPtv() <= 0) {
			//game.enterState(MapGameState.ID);
		}
		
	}
}

		
/**
* Le joueur quitte le combat.
*/
	private void flee() {
			
		int ennemyAttack = 5 + Instance.nextInt(5);
			//Perso.getPtv() - ennemyAttack;
			
			if (Perso.getPtv() <= 0) {}
	}
	
	
	private void sort() {
		
	}
	
	
/**
 * Soin
 */
	
	private void heal() {
			
	}


 
 
 
//-- GETTER & SETTER - 	
 	public Perso getPerso() { return perso;}


	public void setPerso(Perso perso) { this.perso = perso;}


	public Enemy getEnnemy() { return ennemy; }


	public void setEnnemy(Enemy ennemy) { this.ennemy = ennemy; }


	public Object getE() { return e; }


	public void setE(Object e) { this.e = e; }


}
