package Menu;

import Player.Player;
import Shop.Shop;

import java.util.ArrayList;

import Inventory.Item;
import Perso.Perso;

public class ShopSellMenu extends Menu {
    
    private boolean toExitShopSellMenu = false;
    
    public ShopSellMenu() {
        setTitle("Shop");
    }
     
    @Override
    public boolean checkConditions(int a) {
        //todo
        if(a >= 0){
            return true;
        }
        return false;
    }
    
    @Override
    public void printMenu() {
        
    	System.out.println("0 -  Sortir de la boutique et revenir dans la ville");
        System.out.println("#### ITEMS ####");
        
        ArrayList<Item> items = Perso.getItemData().getAllInventoryItems();
        
        for(int i = 0; i < items.size(); i++){
            System.out.println(items.get(i).toString());
        } 
        
        System.out.println("Choisis un article dans la liste ci-dessus.(Entrer le numero)");
        System.out.println("tu posséde " + Perso.getMoney() + " Gold.");
    }
    
    @Override
    public void goToMenu(int chosenMenu) {
        
    	if(chosenMenu == 0){
            toExitShopSellMenu = true;
        
    	}else{
            Item item = Shop.getItemById(chosenMenu);
            //Perso.sellItem(item);
            Shop.buyItem(item);
        }
    }
    
    @Override
    public int runMenu() {
        
    	Perso perso = Perso.getCurrentCharacter();;
        
    	while (!toExitShopSellMenu) {
            
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
