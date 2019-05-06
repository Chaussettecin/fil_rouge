package rpg_filrouge;

public interface perso_Race {


	 // interface qui decrit les different attribut d'une race

    // retourne le bonus d'attaque de la race
    public int BonusAttaque( perso_ennemis  ennemis);

    // retourne si le personnage a possibilité de parer
    public boolean parer(perso_ennemis ennemis);

    // methode décrivant les effets, bonus , malus du pouvoir donné par la race
    public boolean pouvoir(perso_ennemis ennemis);

    // String décrivant le pouvoir
    public String descriptionPouvoir();

    public String toString();

    public boolean isUtilisationPouvoir();

    public void setUtilisationPouvoir(boolean utilisationPouvoir);

}
