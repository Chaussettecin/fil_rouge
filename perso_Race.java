package rpg_filrouge;

public interface perso_Race {


	 // interface qui decrit les different attribut d'une race

    // retourne le bonus d'attaque de la race
    public int BonusAttaque( perso_ennemis  ennemis);

    // retourne si le personnage a possibilit� de parer
    public boolean parer(perso_ennemis ennemis);

    // methode d�crivant les effets, bonus , malus du pouvoir donn� par la race
    public boolean pouvoir(perso_ennemis ennemis);

    // String d�crivant le pouvoir
    public String descriptionPouvoir();

    public String toString();

    public boolean isUtilisationPouvoir();

    public void setUtilisationPouvoir(boolean utilisationPouvoir);

}
