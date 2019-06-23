package Menu;

public class MainMenu extends Menu {

    public TownMenu townMenu = new TownMenu();


    public MainMenu(){
        setTitle("Menu principal");
    }

    public boolean toExit=false;

    @Override
    public int runMenu() {
        
    	while (!toExit) {
            
    		super.runMenu();
            printMenu();
            int chosenMenu = getInput();
            goToMenu(chosenMenu);
        
    	}
        return 0;
    }
    
    @Override
    public void printMenu() {
       
        System.out.println("2 Load Character");
        System.out.println("3 Exit Game");
    }


    @Override
    public boolean checkConditions(int a) {
        boolean isValid;
        
        if(a<4 && 0<a){
            isValid = true;
        
        } else {
            isValid=false;
            System.out.println("Choix du type est 1, 2 ou 3");
        
        }
        return isValid;
    }

    @Override
    public void goToMenu(int chosenMenu) {
        
    	switch (chosenMenu){
            
        	case 1:
               

                goToTown();
                townMenu = new TownMenu();
                break;
            
        	case 2:
                //if (!loadCharacter())
                    break;

                //goToTown();
                //townMenu = new TownMenu();
                //break;
            
        	case 3:
                toExit = true;
                break;
            default:
                break;
        }
    }

      
    private void goToTown() { townMenu.runMenu(); }
       
    
}
