package terminalOverflow;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import asciiPanel.AsciiPanel;

public class Term extends JFrame implements KeyListener,Runnable{
	
	private static final long serialVersionUID = 1L;
	
	AsciiPanel terminal ;
	Map map;
	Player j;
	Ennemie
	bot;
	boolean jeux=true;
	
	
	public Term() throws IOException {
		super();
		terminal = new AsciiPanel(100,50);
		add(terminal);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(this);
		requestFocusInWindow();
		terminal.clear();
		map = new Map(terminal);
		j = new Player(terminal,map,15,15,'@',Color.BLUE);
		map.afficherMap();
		j.afficherPlayer();
		bot = new Ennemie(terminal, map, 31, 30, 'O', Color.YELLOW);
		Thread t= new Thread(this);
		t.start();
		
	}
	
	public void testDonnees() {
		System.out.println("JOUEUR X : " + j.posX+", JOUEUR Y : "+j.posY);
		System.out.println("perso: " +j.posMapX+", Y :"+j.posMapY);
		System.out.println("MAP iX: " +map.iX+", MAPY :"+map.jY);
		
		if ((j.posY+map.getjY()) < 292 && (j.posX+map.getiX() < 500)) {
			System.out.println("MAP iX :" + map.getiX() + ", MAP jY : "+map.getjY());
			//System.out.println("MAP XY :" + map.map[map.getjY()+j.posY][map.getiX()+j.posX]);
			//System.out.println("hauteur : "+map.hauteur +", largeur : "+map.largeur);
			//System.out.println("Terminal Width : "+terminal.getWidthInCharacters()+", Height : "+terminal.getHeightInCharacters());
			
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		switch (e.getKeyCode()) // Les valeurs sont contenue dans KeyEvent. Elles commencent par VK_ et finissent par le nom de la touche
        {
        case KeyEvent.VK_UP: // si la touche enfonc�e est celle du haut
        	if (map.map[j.posY-1][j.posX]== ' ')
        		j.DeplacerY(-1);
        	break;
        case KeyEvent.VK_LEFT: // si la touche enfonc�e est celle de gauche
        	if (map.map[j.posY][j.posX-1]== ' ')
        		j.DeplacerX(-1);
            break;
        case KeyEvent.VK_RIGHT: // si la touche enfonc�e est celle de droite
        	if (map.map[j.posY][j.posX+1]== ' ')
        		j.DeplacerX(1);
            break;
        case KeyEvent.VK_DOWN: // si la touche enfonc�e est celle du bas
        	if (map.map[j.posY+1][j.posX]== ' ')
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
		while (j.posX != x || j.posY != y) {
			if (j.posX > x) {
				j.DeplacerX(-1);
			} else if (j.posX < x) {
				j.DeplacerX(1);
			}
			if (j.posY>y) {
				j.DeplacerY(-1);
			}else if (j.posY<y) {
				j.DeplacerY(1);
			}
		}
	}
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void run() {
		while(jeux) {
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
			
			terminal.clear();
			bot.deplacementAlea();
			bot.afficher();
			map.afficherMap();
			j.afficherPlayer();
			
			
			testDonnees();
			repaint();
		}
	}
}