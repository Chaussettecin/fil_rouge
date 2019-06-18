package Menu;

import Perso.Perso;
import Player.Player;
import Shop.Shop;


public class ShopMenu extends Menu {

    private boolean toExitShop = false;
    private Shop shop = new Shop();
    private ShopBuyMenu shopBuyMenu = new ShopBuyMenu();
    private ShopSellMenu shopSellMenu = new ShopSellMenu(); 
    
    //private Shop shop;
    
    public ShopMenu() {
        setTitle("Shop");
    }

    @Override
    public void printMenu() {
        System.out.println("1 Acheter les items");
        System.out.println("2 Vendre items");
        System.out.println("3 Quitter la boutique");
    }
    
    private void goToShopBuyMenu() {
        shopBuyMenu.runMenu();
    }
    
    private void goToShopSellMenu() {
        shopSellMenu.runMenu();
    }
    
    @Override
    public void goToMenu(int chosenMenu) {
        switch(chosenMenu) {
            case 1:
                
                goToShopBuyMenu();
                shopBuyMenu = new ShopBuyMenu();
                break;
            case 2:
                goToShopSellMenu();
                shopSellMenu = new ShopSellMenu();
                break;
            case 3:
                toExitShop = true;
                break;
            default:
                toExitShop = false;
                break;
        }
    }

    @Override
    public boolean checkConditions(int a) {
        
    	boolean isValid;
        
    	if(a > 0 && a < 4){
            isValid = true;
        
    	} else {
            System.out.println("Entrer 1, 2 ou 3");
            isValid = false;
        }
        
    	return isValid;
    }  
    
    
    @Override
    public int runMenu() {
        Perso character = Perso.getCurrentCharacter();
         
        while (!toExitShop) {
            
        	super.runMenu();
            printMenu();
            int chosenMenu3 = getInput();
            
            if(checkConditions(chosenMenu3)){
                goToMenu(chosenMenu3);
            }   
         
        }
//        character.saveToFile(false);
        return 0;
    }
       
}
