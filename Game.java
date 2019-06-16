package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

import Inventory.Inventory;
import Menu.MainMenu;
import Menu.Menu;
import Perso.Perso;
import Save.SaveSlot;
import UI.UI;
import Utils.HelpGame;
import Utils.Setting;

public class Game implements ActionListener {

	  public static Scanner USERINPUT = new Scanner(System.in);
	  public static final Random RAND = new Random();
	  public static Perso currPlayer;
	  
	  Inventory inventory = new Inventory();
	  
	  //Map map = new Map();
	  //ItemMap itemMap = new ItemMap();

	public Game() {  }
		
	public static void main(String[] args) {
		//Menu mMenu = new MainMenu();
        //mainMenu();
	       Game.mainMenu(); // Lance le menu principal
	 }
	 
	  
//-- Menu principal -- 
	public static void mainMenu() {
	     
		boolean status = false;
	        
		do {
			 UI.welcome();
	         String selection = USERINPUT.nextLine();
	            
	         switch (selection) {
	               
	         	
	         	case "1":
	                 newGame(selection); // Nouvelle partie
	                 status = true;
	                 break;
	                
	            case "2":
	                 loadGame(); // d'après la sauvegarde
	                 status = true;
	                 break;
	                
	            case "3":
	                 Settings(); // Réglage du jeux -- 
	                 status = true;
	                 break;
	                 
	            case "4":
	                 helpGame(); // -- Aide du jeux --
	                 status = true;
	                 break;
	                
	            case "5":
	                 UI.credits();
	                 status = true;
	                 break;
	                
	            case "6":
	                 System.exit(0);
	          }

	        } while (status == false);

	    }

	
//-- Nouvelle partie - 
	public static void newGame(String selection2) {
	
		  UI.newGameIntroduction();
	      
		  String selection = USERINPUT.nextLine();
	            
	      switch (selection) {
	                
	          case "1":
			break;
			
	         
	      }
	    
	}


//--- Démarer la partie à partir d'une sauvegarde existente -- 	    
	public static void loadGame() {
	   SaveSlot.load();
	   //-- A faire en fonction du system de sauvegarde SQL
	}

//-- Aide de jeu  --- 
	public static void helpGame() {
	   // HelpGame.menu();
	}

//-- Reglage ---
	public static void Settings() {
		Settings();
	}
	
	
	public Perso getPlayer() {
				
		if (Game.currPlayer != null) {
			return Game.currPlayer;
		}
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
		

}
