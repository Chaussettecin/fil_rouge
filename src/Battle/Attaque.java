package Battle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Enemy.Enemy;
import Perso.Perso;


public class Attaque implements ActionListener {

	private Perso p;
	private Enemy e;
	
	public Attaque  (Perso p,Enemy e){
		this.p = p;
		this.e = e;			
	
	}
	
	public void actionPerformed(ActionEvent e){
		this.e.receiveDamage(this.p.getDegat());
	}

}
