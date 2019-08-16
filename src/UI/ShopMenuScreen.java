package UI;

import java.awt.event.KeyEvent;

import Inventory.Item;
import Main.PlayScreen;
import Perso.Perso;
import Serialization.Serialiser;
import Shop.Shop;
import asciiPanel.AsciiPanel;

public class ShopMenuScreen implements Screen {
    
	Shop shop;
	Perso perso;
	PlayScreen screenBefore;
	
    private boolean toExitShopBuyMenu = false;
    
    public ShopMenuScreen() { }

 
    public void goToMenu(int chosenMenu) {
        
    	if(chosenMenu == 0){
            setToExitShopBuyMenu(true);
        
    	}else{
            Item item = Shop.getItemById(chosenMenu);
             
            /*if(Perso.getNom() ){
                Shop.sellItem(item);
                System.out.println("Achat effectu�.");
            
            }else{
                System.out.println("Achat impossible. La maison ne fait pas cr�dit!");
            } */
        }
    }
    
   
	@Override
	public Screen respondToUserInput(KeyEvent key) {
		
		if(key.getKeyCode()==KeyEvent.VK_ENTER) {
			return screenBefore;
		
		} else if (key.getKeyChar()=='s') {
			//-- S -- Sauvegarde 
			new Serialiser(screenBefore,"testSav.json");
		}
		
		return this;
	}

	
/*
 * Affichage du interface menu d'action dans la boutique - 
 */
	@Override
	public void displayOutput(AsciiPanel terminal) {
		
		terminal.writeCenter("Bienvenue dans la boutique !",1 );
		terminal.writeCenter("Choisis un objet dansla lite: ", 2);
		terminal.writeCenter( Shop.showItemList(), 3);
		terminal.writeCenter("Niveau d'argent : ",4); 
		terminal.writeCenter("Tu posséde " + Perso.getMoney() + " Gold.", 5);
		terminal.writeCenter("Quitter la boutique et revenir dans la map",6); 
		
	}

	/*
	 * if(chosenMenu == 0){
            setToExitShopBuyMenu(true);
        
    	}else{
            Item item = Shop.getItemById(chosenMenu);
             
            /*if(Perso.getNom() ){
                Shop.sellItem(item);
                System.out.println("Achat effectu�.");
            
            }else{
                System.out.println("Achat impossible. La maison ne fait pas cr�dit!");
            }*/ 
	 

	public boolean isToExitShopBuyMenu() { return toExitShopBuyMenu;}
	
	public void setToExitShopBuyMenu(boolean toExitShopBuyMenu) {
		this.toExitShopBuyMenu = toExitShopBuyMenu;
	}
    
     
}
