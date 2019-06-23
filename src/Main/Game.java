package Main;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JFrame;
import Save.SaveSlot;
import Main.Game;
import UI.StartScreen;
import UI.Screen;

import asciiPanel.AsciiPanel;

public class Game extends JFrame  implements KeyListener {

	private AsciiPanel terminal;
	private Screen screen;
	
//--- Main -- 	
	public static void main(String[] args) throws IOException {
		
		Game app = new Game();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
	 
	}
	 
//-- Méthode Game -- 
	public Game() {
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
	 
	
//--- Démarer la partie à partir d'une sauvegarde existente -- 	    
	public static void loadGame() {
	   SaveSlot.load();
	   //-- A faire en fonction du system de sauvegarde SQL
	}

//-- Aide de jeu  --- 
	public static void helpGame() {
	   // HelpGame.menu(); /// Faire une partie aide pour le joueur ?
	}

	public void actionPerformed(ActionEvent e) {}
		

}
