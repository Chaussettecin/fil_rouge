package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;

import Inventory.Inventory;
import Menu.MainMenu;
import Menu.Menu;
import Perso.Perso;
import Save.SaveSlot;
import Main.Game;
import UI.StartScreen;
import UI.Screen;
import UI.UI;
import Utils.HelpGame;
import Utils.Setting;
import asciiPanel.AsciiPanel;

public class Game extends JFrame  implements KeyListener {

	  public static Scanner USERINPUT = new Scanner(System.in);
	  public static final Random RAND = new Random();
	  public static Perso currPlayer;
	  
	  private AsciiPanel terminal;
	  private Screen screen;
	  //Inventory inventory = new Inventory();
	  
	  //Map map = new Map();
	  //ItemMap itemMap = new ItemMap();

		
	public static void main(String[] args) throws IOException {
		
	      // Game.mainMenu(); // Lance le menu principal
		Game app = new Game();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
	 }
	 
	/* private static void displayPDF(String chemin) throws IOException {
	        Files.newDirectoryStream(Paths.get(chemin),
	                path -> path.toString().endsWith(".*"))
	                .forEach(System.out::println);
	    }*/
	
	public Game() {
		super();
		terminal = new AsciiPanel();
		add(terminal);
		pack();
		screen = new StartScreen();
		addKeyListener(this);
		repaint();
//		Screen sc = new StartScreen(); 
	}

	public void repaint() {
		terminal.clear();
		screen.displayOutput(terminal);
		super.repaint();
	}
	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		screen = screen.respondToUserInput(e);
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
	                 loadGame(); // d'apr�s la sauvegarde
	                 status = true;
	                 break;
	                
	            case "3":
	                 Settings(); // R�glage du jeux -- 
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


//--- D�marer la partie � partir d'une sauvegarde existente -- 	    
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

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
		

}
