package Menu;

import Player.Player;

import java.util.Scanner;

import Perso.Perso;

public class CharacterCreationMenu extends Menu {

    public String characterName = "";

    CharacterCreationMenu(){
        setTitle("Creation perso");
    }

   /* @Override
    public int runMenu() {
        
    	super.runMenu();
        boolean characterIsOk;
        
        do {
            printMenu();

            if (characterName.isEmpty())
                return 1;

            Perso character = new Perso(characterName, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, characterIsOk, characterIsOk, null);
            String errorString = character.saveToFile(true);

            if (errorString == null) {
                Player.setCurrentCharacter(character);
                characterIsOk = true;
            } else {
                System.out.println("Cannot create character: " + errorString);
                characterIsOk = false;
            }

        } while (!characterIsOk);

        return 0;
    }*/

    @Override
    public void printMenu() {
        System.out.print("Your character's name (leave empty to cancel): ");
        Scanner in = new Scanner(System.in);
        characterName = in.nextLine();
    }
}
