package UI;

import java.awt.event.KeyEvent;

import Adventure.Adventure;
import Perso.Perso;
import Shop.Shop;
import asciiPanel.AsciiPanel;

public class TownMenu implements Screen{

    private boolean toExitTown = false;
    private Shop shopMenu = new Shop();

    TownMenu(){}
        
   
    public int runMenu() {
        Perso perso = Perso.getCurrentCharacter();

        while (!toExitTown) {
            
        	super.runMenu();
        	
            System.out.println("Gold: " + perso.getMoney() + "Gold");
            System.out.println("XP: " + perso.getXp() + "XP/" + perso.getExperienceForNextLevel());
            System.out.println("Level : " + perso.getLevel());
            System.out.println("Sante : " + perso.getStats().getCurrentHealth() 
            			+ "/" + perso.getStats().getMaxHealth());
            
            printMenu();
            int chosenMenu2 = getInput();
            goToMenu(chosenMenu2);
        
        }
        
        //Perso.saveToFile(false);

        return 0;
    }

    @Override
    public void printMenu() {
        System.out.println("1 Adventure");
        System.out.println("2 Shop");
        System.out.println("3 Rest");
        System.out.println("4 Retour au menu principal");
    }

    public boolean checkConditions(int a) {
        boolean isValid;
        
        if(a<6 && 0<a){
            isValid = true;
        
        } else {
            isValid=false;
            System.out.println("Choix  1, 2 ou 3");
        
        }
        return isValid;
    }

//-- Allez dans la boutique -- 
    private void goToShop() {
        shopMenu.runMenu();
    }

//-- Choisir et naviguer dans les mondes -- 

    public void goToMenu(int chosenMenu2) {
        Perso personnage = Perso.getCurrentCharacter();
        
        switch (chosenMenu2){
            
        case 1:
                Adventure adventureMenu = new Adventure();
                adventureMenu.runMenu();
                break;
         case 2:
                goToShop();
                shopMenu = new Shop();
                personnage.useMoney(1);
                break;
         
         case 3:
            	personnage.restauSante(10);
            	personnage.useMoney(10);
                break;
            
         case 4:
                toExitTown = true;
                break;
            
         default:
                toExitTown = false;
                break;
        }
    }



@Override
public Screen respondToUserInput(KeyEvent key) {
	// TODO Auto-generated method stub
	return null;
}



@Override
public void displayOutput(AsciiPanel terminal) {
	// TODO Auto-generated method stub
	
}
}
