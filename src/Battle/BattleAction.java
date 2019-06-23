package Battle;
/**
 * Interface avec les actions (choix) dispo au joueur
 */
public interface BattleAction {
	
	String attack();
	String flee();
	String sort();
	String heal();
	
	String getResult(); 
	 
	public String toString();
}
