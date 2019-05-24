package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;


import maps.Room;
import perso.perso;
import save.Save;
import Player.Player;
import Utils.Setting;
import ui.UI;

public class Game implements ActionListener {

	  public static final Scanner USERINPUT = new Scanner(System.in);
	  public static final Random RAND = new Random();
	 
	  public static Room[][] currDungeon;  
	  public static Player currPlayer;

	  
	  public static void main(String[] args) {
	        mainMenu();
	  }
	  

//-- Menu principal -- 
	  public static void mainMenu() {
	        
		  boolean status = false;
	        
		  do {
	            UI.Welcome();
	            String selection = USERINPUT.nextLine();
	            
	            switch (selection) {
	               
	            	case "1":
	                    newGame();
	                    status = true;
	                    break;
	                case "2":
	                    loadGame();
	                    status = true;
	                    break;
	                case "3":
	                    settings();
	                    status = true;
	                    break;
	                case "4":
	                    UI.credits();
	                    status = true;
	                    break;
	                case "5":
	                    System.exit(0);
	            }

	        } while (status == false);

	    }

	    
	  public static void newGame() {
		  perso.creaPerso();

	      //currDungeon = Dungeon.newRandomDungeon(currPlayer);
	        
	    

	    }

	    public static void loadGame() {
	    	//--- Démarer la partie à partir d'une sauvegarde -- 
	    	
	    	Save.read();
	    }

	    public static void settings() {
	    	Setting.menu();
	    }

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}

	
}
