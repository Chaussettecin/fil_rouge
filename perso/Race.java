package perso;

public interface Race {

	// retourne le bonus d'attaque de race
	    public int BonusAttaque(perso personnage,perso enemi);

	    public boolean parer(perso personnage,perso enemi);

	 // methode les effets, bonus ou malus du pouvoir définit par la race choisie
	    public boolean pouvoir(perso personnage);
	   
	    public String toString();

	    public boolean isUtilisationPouvoir();

	    public void setUtilisationPouvoir(boolean utilisationPouvoir);
}
