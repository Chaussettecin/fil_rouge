package Battle;

import Perso.Perso;


/*
 * Class Effect
 */

public class Effect {
	
	protected int duree;
	
	public boolean isDone() { return duree < 1; }

	public Effect(int b){ this.duree = b; }
	
	public Effect(Effect other){ this.duree = other.duree; }
	
	public void update(Perso perso){ duree--; }
	
	public void start(Perso perso){ }
	
	public void end(Perso perso){}

}
