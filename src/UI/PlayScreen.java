package UI;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import asciiPanel.AsciiPanel;
import maps.Map;
import maps.MapPosition;
import Serialization.Donnees;
import terminalOverflow.EnemyMouv;
import terminalOverflow.PersoMouv;
import terminalOverflow.Term;
import terminalOverflow.Vector2d;



public class PlayScreen implements Screen {
	
	public String nom;
	private Donnees d ;
	public Map map;
	public PersoMouv j;
	public boolean jeux=true;
	public ArrayList<EnemyMouv> bot;
	public Term term;
	public AsciiPanel terminal;
	
	
	public PlayScreen(String nom) {
		this.nom=nom;
	}
	public PlayScreen(Donnees donnees) {
		this.d=donnees;
	}
	@Override
	public Screen respondToUserInput(KeyEvent key) {
		
		int check;	
		switch (key.getKeyCode()) // Les valeurs sont contenue dans KeyEvent. Elles commencent par VK_ et finissent par le nom de la touche
        {
        case KeyEvent.VK_UP: // si la touche enfoncée est celle du haut
        	
        	if (map.map[j.position.dy-1][j.position.dx]== ' '||map.map[j.position.dy-1][j.position.dx]== 'w'||map.map[j.position.dy-1][j.position.dx]== '#')
        		j.DeplacerY(-1);
        	check=checkCollision();
    		if(check<100) {
    			return new rencontreScreen(this,check);
    		}
        	break;
        case KeyEvent.VK_LEFT: // si la touche enfoncée est celle de gauche
        	if (map.map[j.position.dy][j.position.dx-1]== ' '||map.map[j.position.dy][j.position.dx-1]== 'w'||map.map[j.position.dy][j.position.dx-1]== '#')
        		j.DeplacerX(-1);
            check=checkCollision();
    		if(check<100) {
    			return new rencontreScreen(this,check);
    		}
        	break;
        case KeyEvent.VK_RIGHT: // si la touche enfoncée est celle de droite
        	if (map.map[j.position.dy][j.position.dx+1]== ' '||map.map[j.position.dy][j.position.dx+1]== 'w'||map.map[j.position.dy][j.position.dx+1]== '#')
        		j.DeplacerX(1);
        	check=checkCollision();
    		if(check<100) {
    			return new rencontreScreen(this,check);
    		}
        	break;
        case KeyEvent.VK_DOWN: // si la touche enfoncée est celle du bas
        	if (map.map[j.position.dy+1][j.position.dx]== ' '||map.map[j.position.dy+1][j.position.dx]== 'w'||map.map[j.position.dy+1][j.position.dx]== '#')
        		j.DeplacerY(1);
        	check=checkCollision();
    		if(check<100) {
    			return new rencontreScreen(this,check);
    		}
        	break;
        case KeyEvent.VK_D :
        	j.dig();
        	break;
        case KeyEvent.VK_E :
           	seDeplacerA(155,78);
        	break;	
        
        	
        }
		if(key.getKeyChar()=='p')
			return new pauseScreen(this);
		return this;
	}

	@Override
	public void displayOutput(AsciiPanel terminal) {
		
		if (map == null) {
			try {
				map = new Map(terminal);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			j = new PersoMouv(terminal,map,15,10,'@',Color.BLUE,nom);
	        createBot(terminal);
	}
        
			if(d!=null) {
				seDeplacerA(d.getPos());
				j.setNom(d.getNom());
				d=null;
			}
			terminal.clear();
			for(int i=0;i<bot.size();i++) {
				((EnemyMouv) bot.get(i)).deplacementAlea();
				((EnemyMouv) bot.get(i)).afficher();
			}
			map.afficherMap();
			
			j.afficherPlayer();
			
			
			testDonnees();
			terminal.repaint();
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

	public void createBot(AsciiPanel terminal) {
		MapPosition ennemie = new MapPosition();
		bot=new ArrayList();
		for(int i=0;i<9;i++) {
	    bot.add(new EnemyMouv(terminal, map, (Vector2d) ennemie.getEnnemiesMonde1().get(i), '#', Color.YELLOW  ));
	    }
	}
	
	public int checkCollision() {
		for(int i=0;i<bot.size();i++) {
			if(j.position.Compare(bot.get(i).position)) {
				jeux=!jeux;
				return i;
				
				
			}
			
		}
		return 100;
	}
	
	public void interAction() {
//		terminal.clear();
//		terminal.writeCenter("Vous avez rencontrer un Elf, Que voulez vous faire", 5);
//		terminal.repaint();
		//jeux=!jeux;
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
	private void seDeplacerA(Vector2d deplacement) {
		while (j.position.dx != deplacement.dx || j.position.dy != deplacement.dy) {
			if (j.position.dx > deplacement.dx) {
				j.DeplacerX(-1);
			} else if (j.position.dx < deplacement.dx) {
				j.DeplacerX(1);
			}
			if (j.position.dy>deplacement.dy) {
				j.DeplacerY(-1);
			}else if (j.position.dy<deplacement.dy) {
				j.DeplacerY(1);
			}
		}
	}
	
}