package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JFrame;
import Save.SaveSlot;
import Main.ApplicationMain;
import UI.StartScreen;
import UI.Screen;

import asciiPanel.AsciiPanel;

public class ApplicationMain  extends JFrame  implements KeyListener {

/**
 * Classe Principale du jeu 
 * ** Qui contient le main et ses param�tres
 */
	private static final long serialVersionUID = 1L;
	
	private AsciiPanel terminal;
	private Screen screen;
	

//--- Main -- 	
	public static void main(String[] args) throws IOException {
		
		ApplicationMain app = new ApplicationMain();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
	 
	}
	 
//-- Constructor - 
	public ApplicationMain() {
	
		super();
		terminal = new AsciiPanel();
		add(terminal);
		pack();
		screen = new StartScreen();
		addKeyListener(this);
		repaint(); 
	}

	public void repaint() {
		terminal.clear();
		screen.displayOutput(terminal);
		super.repaint();
	
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		screen = screen.respondToUserInput(e);
		repaint();
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

	@Override
	public void keyReleased(KeyEvent e) { }
	
		
	@Override
	public void keyTyped(KeyEvent e) { }
		

}
