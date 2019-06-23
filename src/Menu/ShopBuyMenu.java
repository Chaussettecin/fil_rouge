package Menu;

import Inventory.Item;
import Perso.Perso;
import Shop.Shop;

// Menu achat objet

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
    	
        System.out.println("0 Quitter la boutique et revenir dans la map");
        Shop.showItemList();
        System.out.println("Choisis un objet dansla lite.(Entre le numero)");
        System.out.println("Tu posséde " + Perso.getMoney() + " gold.");
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
        
    	Perso perso;
        
    	while (!toExitShopBuyMenu) {
            
    		super.runMenu();
            printMenu();
            int chosenMenu4 = getInput();
           
            if(checkConditions(chosenMenu4)){
                goToMenu(chosenMenu4);
            } 
        }
    
        return 0;
    }
    
    
    
    
}
