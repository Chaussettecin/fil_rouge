package Menu;

import Perso.Perso;
import Adventure.Adventure;


public class AdventureMenu extends Menu {
   
	AdventureMenu(){
        setTitle("Adventure");
   }

    private boolean adventureIsOver = false;
    private Adventure adventure;

    @Override
    public int runMenu() {
        
    	while (!adventureIsOver) {
            
    		super.runMenu();
            printMenu();
            int chosenMenu = getInput();
            goToMenu(chosenMenu);
        
    	}
        return 0;
    }

    @Override
    public void printMenu() {

        this.adventure = new Adventure();
        
        //System.out.println(adventure.getEnemy());
        System.out.println("1 Baston (Combat les cultistes)");
        System.out.println("2 Parer (et perds 20 points de vie");
    }

    /*@Override
    public void goToMenu(int chosenMenu) {
        
    	switch (chosenMenu){
           
    	case 1:
                adventure.doAdventure();
                adventureIsOver = true;
                break;
            
    	case 2:
                PersoMouv player = PersoMouv.getCurrentCharacter();
                player.getStats().setCurrentHealth(player.getStats().getCurrentHealth()-20);
                adventureIsOver = true;
                break;
            
    	default:
                adventureIsOver = false;
                break;
        }
    }*/

    @Override
    public boolean checkConditions(int a) {
        boolean isValid;
        
        if(a<4 && 0<a){
            isValid = true;
        
        } else {
            isValid=false;
            System.out.println("rentre un chiffre 1, 2 ou 3");
        
        }
        return isValid;
    }
}
