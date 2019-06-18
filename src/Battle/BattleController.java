package Battle;

import java.util.Random;

import Enemy.Enemy;
import Perso.Perso;

public class BattleController implements InputProviderListener {

		private BattlePerso perso;
		private BattleEnnemy ennemy;
		private StateBasedGame game;
		private Random random = new Random();

///--- Constructor - 		
	public BattleController(BattlePerso perso, BattleEnnemy ennemy,
							StateBasedGame game) {
			
			this.perso = perso;
			this.ennemy = ennemy;
			this.game = game;
		}

		
	@Override
	public void controlPressed(Command command) {
			
		switch ((BattleCommand) command) {
			
		case ATTAQUE:
				attack();
				break;
			
		case DEFEND:
				defend();
				break;
			
		case FUIR:
				fuire();
				break;
				
		case SOIN:
				heal();
				break;

			default:
				break;
			}
		}

	
		@Override
		public void controlReleased(Command command) {
		}

/**
* Si le joueur attaque : Il inflige entre 7 et 10 points dégâts avec 10% de chance de faire un
* critique (+50% de dégât) L'ennemi contre attaque en infligeant entre 5 et 9 dégâts.
*/
	private void attack() {
			
		int persoAttack = 7 + random.nextInt(4);
			
		if (random.nextDouble() < .1) {
			persoAttack += persoAttack / 2;
		}
			
		Enemy.setPtv(Enemy.getPtv() - persoAttack);
			
		if (Enemy.getPtv() <= 0) {
				//game.enterState(MapGameState.ID);
			
		} else {
			
			int ennemyAttack = 5 + random.nextInt(5);
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
*/
	private void defend() {
			
		int ennemyAttack = (5 + random.nextInt(5)) / 2;
		Perso.setPtv(Perso.getPtv() - ennemyAttack);
			
		if (Perso.getPtv() <= 0) {
				//game.enterState(MainScreenGameState.ID);
			
		} else {
				int playerAttack = 7 + random.nextInt(4);
				Enemy.setPtv(Enemy.getPtv() - playerAttack);
				
				if (Enemy.getPtv() <= 0) {
					//game.enterState(MapGameState.ID);
				}
		}
	}

		
/**
 * Si le joueur fuit :
* L'ennemi attaque et inflige entre 5 et 9 dégâts.
* Le joueur quitte le combat.
*/
	private void fuire() {
			
		int ennemyAttack = 5 + random.nextInt(5);
			Perso.setPtv(Perso.getPtv() - ennemyAttack);
			
			if (Perso.getPtv() <= 0) {
				//game.enterState(MainScreenGameState.ID);
			
			} else {
				//game.enterState(MapGameState.ID);
			}
		}
	
	private void heal() {
		// TODO Auto-generated method stub
		
	}


}
