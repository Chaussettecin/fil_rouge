package terminalOverflow;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import asciiPanel.AsciiPanel;
import maps.Map;
import maps.MapPosition;

public class Term implements Runnable{
	
	private static final long serialVersionUID = 1L;
	
	AsciiPanel terminal ;
	Map map;
	PersoMouv j;
	boolean jeux=true;
	ArrayList<EnemyMouv> bot;
	

	
	public Term(AsciiPanel terminal) throws IOException {
		
		this.terminal=terminal;
		map = new Map(terminal);
		j = new PersoMouv(terminal,map,15,10,'@',Color.BLUE);
        createBot();
		
		Thread t= new Thread(this);
		t.start();
		
	}
	
//	public void repaint(){
//        terminal.clear();
//        screen.displayOutput(terminal);
//        super.repaint();
//    }

	public void createBot() {
		MapPosition ennemie = new MapPosition();
		bot=new ArrayList();
		for(int i=0;i<9;i++) {
	    bot.add(new EnemyMouv(terminal, map, (Vector2d) ennemie.getEnnemiesMonde1().get(i), '#', Color.YELLOW  ));
	    }
	}
	
	public void checkCollision() {
		for(int i=0;i<bot.size();i++) {
			if(j.position.Compare(bot.get(i).position)) {
				System.out.println("collision");
				jeux=!jeux;
				interAction();
			}
		}
	}
	
	public void interAction() {
		terminal.clear();
		terminal.writeCenter("Vous avez rencontrer un Elf, Que voulez vous faire", 5);
		
		jeux=!jeux;
	}
	
	public void testDonnees() {
		System.out.println("JOUEUR X : " + j.position.dx+", JOUEUR Y : "+j.position.dy);
		System.out.println("Bot X "+bot.get(0).position.dx+" Y"+bot.get(3).position.dy);
		
//		System.out.println("MAP iX: " +map.iX+", MAPY :"+map.jY);
//		
//		if ((j.posY+map.getjY()) < 292 && (j.posX+map.getiX() < 500)) {
//			System.out.println("MAP iX :" + map.getiX() + ", MAP jY : "+map.getjY());
//			//System.out.println("MAP XY :" + map.map[map.getjY()+j.posY][map.getiX()+j.posX]);
//			System.out.println("hauteur : "+map.hauteur +", largeur : "+map.largeur);
//			System.out.println("Terminal Width : "+terminal.getWidthInCharacters()+", Height : "+terminal.getHeightInCharacters());
			
//		}
		
		//System.out.println("X"+bot.position.dx+" Y " +bot.position.dy);
	}

	
	public void keyPressed(KeyEvent e) {
//		screen.respondToUserInput(e);
//		repaint();
		switch (e.getKeyCode()) // Les valeurs sont contenue dans KeyEvent. Elles commencent par VK_ et finissent par le nom de la touche
        {
        case KeyEvent.VK_UP: // si la touche enfoncée est celle du haut
        	
        	if (map.map[j.position.dy-1][j.position.dx]== ' ')
        		j.DeplacerY(-1);
        	break;
        case KeyEvent.VK_LEFT: // si la touche enfoncée est celle de gauche
        	if (map.map[j.position.dy][j.position.dx-1]== ' ')
        		j.DeplacerX(-1);
            break;
        case KeyEvent.VK_RIGHT: // si la touche enfoncée est celle de droite
        	if (map.map[j.position.dy][j.position.dx+1]== ' ')
        		j.DeplacerX(1);
            break;
        case KeyEvent.VK_DOWN: // si la touche enfoncée est celle du bas
        	if (map.map[j.position.dy+1][j.position.dx]== ' ')
        		j.DeplacerY(1);
            break;
        case KeyEvent.VK_D :
        	j.dig();
        	break;
        case KeyEvent.VK_E :
           	seDeplacerA(155,78);
        	break;	
        	
        }
	}
	
	private void seDeplacerA(int x, int y) {
		while (j.position.dx != x || j.position.dy != y) {
			if (j.position.dx > x) {
				j.DeplacerX(-1);
			} else if (j.position.dx < x) {
				j.DeplacerX(1);
			}
			if (j.position.dy>y) {
				j.DeplacerY(-1);
			}else if (j.position.dy<y) {
				j.DeplacerY(1);
			}
		}
	}
	

	



	@Override
	public void run() {
		while(jeux) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
			
			terminal.clear();
			for(int i=0;i<bot.size();i++) {
				((EnemyMouv) bot.get(i)).deplacementAlea();
				((EnemyMouv) bot.get(i)).afficher();
			}
			map.afficherMap();
			j.afficherPlayer();
			testDonnees();
			checkCollision();
			
			testDonnees();
			terminal.repaint();
		}
	}
}
