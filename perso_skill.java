package perso;

public class perso_skill {

	
	
	//Ecran : Echec critique
    public void echecCritique() {
        System.out.println("\n----------------------------------------");
        System.out.println(" ECHEC CRITIQUE !");
        System.out.println("----------------------------------------");
    }

    //PErsonne fail 
    public void attaqueFail() {
        System.out.println("\n----------------------------------------");
        System.out.println("Le personnage est fatigu�, il ne peut pas attaquer !");
        System.out.println("----------------------------------------");
    }
    
     //r�ussite critique
    public void succesCritique() {
        System.out.println("\n----------------------------------------");
        System.out.println(" REUSSITE CRITIQUE !");
        System.out.println("----------------------------------------");
    }

    //enemis esquiv�
    public void enemisesquive() {
        System.out.println("\n----------------------------------------");
        System.out.println(" L'enemis a esquiv� !");
        System.out.println("----------------------------------------");
    }
}
