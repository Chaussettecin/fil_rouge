package Battle;

import Enemy.Enemy;
import Perso.Perso;

/*
 * Classe principale des Battle
 */
public class BattleFight implements BattleAction {

	int input;  
	String Text;
	Enemy enemy;
	
	private ArrayList<Perso> persoArray;
	private BattleAction persoAction;

// -- Constructor - 
	public BattleFight(int input, ArrayList<Perso> persoArray, Enemy enemy, 
			 BattleAction persoAction) {
	
		this.persoArray = persoArray; 
		this.enemy = enemy; 
		this.setPersoAction(persoAction);
	}

/*
 * Methode de la BattleAction
 */
	@Override
	public String attack() {
		
		enemy.getDegat();
		return Text = (persoArray + " frappe pour : " + input + "\n" 
					+ enemy.getNom() + " a pour santé :" + 
					Enemy.getPtv()+ "\n");
	}

	@Override
	public String flee() {
		 Text = (persoArray + " ont parés l'attaque..." + msgBattle.noAction(null));
			return null;
	}

	@Override
	public String sort() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String heal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	public BattleAction getPersoAction() {
		return persoAction;
	}

	
	public void setPersoAction(BattleAction persoAction) {
		this.persoAction = persoAction;
	}
	
	
}
