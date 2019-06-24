package Battle;


import java.awt.event.InputMethodListener;

import Enemy.Enemy;
import Perso.Perso;
import Utils.SingleTonRandom;
import asciiPanel.AsciiPanel;
import maps.Map;
import terminalOverflow.Vector2d;

public abstract class BattleController implements InputMethodListener {
//implements ActionListeners
	private Perso perso;
	private Enemy ennemy;
	//private StateBasedGame game;
	SingleTonRandom  Instance;
		
	BattleCommand Command;
	Map map;
	Vector2d position;
	private Object e;

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
					//sort();
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
 * Perso attaque =  inflige entre 7 et0 points dégâts avec 10% 
 * de chance de faire un critique (+50% de dégât) L'ennemi 
 * contre attaque en infligeant entre 5 et 9 dégâts.
 * 
*/private void attack () {
			
	int persoAttack = 7 + Instance.nextInt(4);
			
	if (Instance.nextDouble() < .1) {
		persoAttack += persoAttack / 2;
	}
			
	Enemy.setPtv(Enemy.getPtv() - persoAttack);
			
	if (Enemy.getPtv() <= 0) {
		//game.enterState(MapGameState.ID);
			
	} else {
			
		int ennemyAttack = 5 + Instance.nextInt(5);
		Perso.setPtv(Perso.getPtv() - ennemyAttack);
				
		if (Perso.getPtv() <= 0) {
			//game.enterState(MainScreenGameState.ID);
		}
			
	}
}


/**
 * Si le joueur défend :
 * L'ennemi attaque et inflige entre 5 et 9 dégâts. Mais la moitié des dégâts sont prévenu.</li>
 * Le joueur contre attaque en infligeant entre 7 et 10 points de dégâts sans possibilité de
 * faire des critiques.
*/private void defend() {
			
	int ennemyAttack = (5 + Instance.nextInt(5)) / 2;
	Perso.setPtv(Perso.getPtv() - ennemyAttack);
			
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
*/private void flee() {
			
		int ennemyAttack = 5 + Instance.nextInt(5);
			Perso.setPtv(Perso.getPtv() - ennemyAttack);
			
			if (Perso.getPtv() <= 0) {
				//game.enterState(MainScreenGameState.ID);
			
			} else {
				//game.enterState(MapGameState.ID);
			}
		}
	
	
/**
 * Soin
 */private void heal() {
			
	}


//-- GETTER & SETTER - 	
 	public Perso getPerso() {
		return perso;
	}


	public void setPerso(Perso perso) {
		this.perso = perso;
	}


	public Enemy getEnnemy() {
		return ennemy;
	}


	public void setEnnemy(Enemy ennemy) {
		this.ennemy = ennemy;
	}


}
