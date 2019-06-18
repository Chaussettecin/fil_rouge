package Menu;

import Inventory.Item;
import Perso.Perso;
import Player.Player;
import Shop.Shop;

public class ShopBuyMenu extends Menu {
    
    private boolean toExitShopBuyMenu = false;
    
    public ShopBuyMenu() {
        setTitle("Shop Achat");
    }

    @Override
    public boolean checkConditions(int a) {
        
    	if(a >= 0){
            return true;
        }
    	
        return false;
    }

    @Override
    public void printMenu() {
        System.out.println("0 Quitter la boutique et revenir dans la ville");
        Shop.showItemList();
        System.out.println("Choisis un item dnas la lite.(Entre le numero)");
        System.out.println("Tu posséde " + Perso.getCurrentCharacter().getMoney() + " gold.");
    }

    @Override
    public void goToMenu(int chosenMenu) {
        
    	if(chosenMenu == 0){
            toExitShopBuyMenu = true;
        
    	}else{
            Item item = Shop.getItemById(chosenMenu);
             
            if(Perso.getCurrentCharacter().buyItem(item)){
                Shop.sellItem(item);
                System.out.println("Achat effectué.");
            
            }else{
                System.out.println("Achat impossible. La maison ne fait pas crédit!");
            } 
        }
    }
    
    @Override
    public int runMenu() {
        
    	Perso character = Perso.getCurrentCharacter();
        
    	while (!toExitShopBuyMenu) {
            
    		super.runMenu();
            printMenu();
            int chosenMenu4 = getInput();
           
            if(checkConditions(chosenMenu4)){
                goToMenu(chosenMenu4);
            } 
        }
    //        character.saveToFile(false);
        return 0;
    }
    
    
    
    
}
