package Battle;

import Enemy.Enemy;
import Perso.Perso;

public class Fight implements battleAction {

	int input;  
	String Text;
	String outcomeText;
	
	private Perso perso;
	private Enemy ennemi;
	private battleAction persoAction;
	
//-- Constructor -- 
	public Fight(int input, String Text, Perso perso, Enemy ennemi, 
				 battleAction persoAction) {
		
			this.perso = perso; 
			this.ennemi = ennemi; 
			this.setPersoAction(persoAction);
	}
	
//-- Methode de la methode Battle action -
	@Override
	public String baston() {
		
		//int degat = battleHelper.getRng(perso.getBonusDefense())+1;
        
		ennemi.getDegat(input);;
	    return Text = (perso.getNom() + " frappe pour : " + input + "\n" 
		+ ennemi.getNom(Text) + "a pour santé :" + Enemy.getActuelleSante()+ "\n\n");
	}
	
	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String parer() {
		 Text =   (perso.getNom() + "a paré l'attaque..." + msgBattle.noAction(null));
		return null;
	}
	
	@Override
	public String toString(){
		return Text;
		
	}

	public battleAction getPersoAction() {
		return persoAction;
	}

	public void setPersoAction(battleAction persoAction) {
		this.persoAction = persoAction;
	}
	
}
