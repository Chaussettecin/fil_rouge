package Menu;

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

	public Adventure getAdventure() {
		return adventure;
	}

	public void setAdventure(Adventure adventure) {
		this.adventure = adventure;
	}
}
