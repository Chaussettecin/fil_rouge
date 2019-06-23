package UI;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import Perso.Perso;
import Perso.Race;
import asciiPanel.AsciiPanel;
import maps.Map;
import maps.MapPosition;

import Serialization.Donnees;
import terminalOverflow.EnemyMouv;
import terminalOverflow.PersoMouv;
import terminalOverflow.Vector2d;

public class PlayScreen implements Screen {
	
	public String nom;
	public boolean persDeux=true;
	private Donnees d ;
	public Map map;
	public PersoMouv persD;
	public AsciiPanel terminal;
	
	private ArrayList<Perso> persoArray = new ArrayList<Perso>();
	public ArrayList<EnemyMouv> bot;
	
	public PlayScreen(String nomJ) {
		this.nom=nomJ;
	}
	
	public PlayScreen(Donnees donnees) {
		this.d=donnees;
	}
	
	@Override
	public Screen respondToUserInput(KeyEvent key) {
		
		int check;	
		
		switch (key.getKeyCode()) { // Les valeurs sont contenue dans KeyEvent. Elles commencent par VK_ et finissent par le nom de la touche
        
        	case KeyEvent.VK_UP: // si la touche enfoncée est celle du haut
        	
        		if (map.map[persD.position.dy-1][persD.position.dx]== ' '||map.map[persD.position.dy-1][persD.position.dx]== 'w'||map.map[persD.position.dy-1][persD.position.dx]== '#')
        			persD.DeplacerY(-1);
        			check=checkCollision();
        	
    		if(check<100) {
    			return new rencontreScreen(this,check);
    		}
        	break;
        
        	case KeyEvent.VK_LEFT: // si la touche enfoncée est celle de gauche
        	
        		if (map.map[persD.position.dy][persD.position.dx-1]== ' '||
        			map.map[persD.position.dy][persD.position.dx-1]== 'w'||
        			map.map[persD.position.dy][persD.position.dx-1]== '#')
        			persD.DeplacerX(-1);
            
        			check=checkCollision();
    		
        			if(check<100) {
        				return new rencontreScreen(this,check);
        			}
        	
        		break;
        		
        	case KeyEvent.VK_RIGHT: // si la touche enfoncée est celle de droite
        	
        		if (map.map[persD.position.dy][persD.position.dx+1]== ' '||map.map[persD.position.dy][persD.position.dx+1]== 'w'||map.map[persD.position.dy][persD.position.dx+1]== '#')
        			persD.DeplacerX(1);
        			check=checkCollision();
    		
        			if(check<100) {
        				return new rencontreScreen(this,check);
        			}
    		
        		break;
        
        	case KeyEvent.VK_DOWN: // si la touche enfoncée est celle du bas
        	
        		if (map.map[persD.position.dy+1][persD.position.dx]== ' '||map.map[persD.position.dy+1][persD.position.dx]== 'w'||map.map[persD.position.dy+1][persD.position.dx]== '#')
        			persD.DeplacerY(1);
        			check=checkCollision();
    		
        			if(check<100) {
        				return new rencontreScreen(this,check);
        			}
        		
        		break;
        
        	case KeyEvent.VK_D :
        			persD.dig();
        			break;
        
        	case KeyEvent.VK_E :
        			seDeplacerA(155,78);
        			break;	
        
        } // En Switch 
		
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
				e.printStackTrace();
			
			}
			
			persD = new PersoMouv(terminal,map,15,10,'@',Color.BLUE);
	        createBot(terminal);
	}
        
			if(d!=null) {
				seDeplacerA(d.getPos());
				persD.setPerso(d.getNom());
				d=null;
			}
			terminal.clear();
			for(int i=0;i<bot.size();i++) {
				((EnemyMouv) bot.get(i)).deplacementAlea();
				((EnemyMouv) bot.get(i)).afficher();
			}
			map.afficherMap();
			
			persD.afficherPlayer();
			
			
			testDonnees();
			terminal.repaint();
		}
	
	public void testDonnees() {
		System.out.println("Perso X : " + persD.position.dx+", Perso Y : "+persD.position.dy);
		System.out.println("Bot X "+bot.get(0).position.dx+" Y"+bot.get(3).position.dy);
	}

	
//--- Creation d'un tableau de personnages - 
	public void fillPersoArray () {
		
		persoArray.add(new Perso("Sidney Fox", Race.HUMAIN));
		persoArray.add(new Perso("Hatachar Godeth", Race.ELFE));
		persoArray.add(new Perso("Fes Forelash", Race.ORC));
		persoArray.add(new Perso("Jissi LightCat", Race.NAIN));
		
	}
	

//--- Creation de perso PNJ ou Ennemie - 
	public void createBot(AsciiPanel terminal) {
		
		MapPosition ennemie = new MapPosition();
		bot = new ArrayList<EnemyMouv>();
		
		for(int i=0;i<9;i++) {
			bot.add(new EnemyMouv(terminal, map, (Vector2d) ennemie.getEnnemiesMonde1().get(i), '#', Color.YELLOW ));
	    }
	}
	
	
//--- Verifie si notre equipe de personnage touche un "bot"
	public int checkCollision() {
		
		for(int i=0;i<bot.size();i++) {
			
			if(persD.position.Compare(bot.get(i).position)) {
				persDeux=!persDeux;
				return i;	
			}
			
		}
		return 100;
	}
	
//---  Interaction avec les "bot" enemy ou pnj
	public void interAction() {
		
		terminal.clear();
		terminal.repaint();
		persDeux=!persDeux;
			
	}
	
	private void seDeplacerA(int x, int y) {
		
		while (persD.position.dx != x || persD.position.dy != y) {
			
			if (persD.position.dx > x) {
				persD.DeplacerX(-1);
			
			} else if (persD.position.dx < x) {
				persD.DeplacerX(1);
			}
			
			if (persD.position.dy>y) {
				
				persD.DeplacerY(-1);
			
			} else if (persD.position.dy<y) {
				persD.DeplacerY(1);
			
			}
		}
	}
	
	private void seDeplacerA(Vector2d deplacement) {
		
		while (	persD.position.dx != deplacement.dx || 
				persD.position.dy != deplacement.dy) {
			
			if (persD.position.dx > deplacement.dx) {
				persD.DeplacerX(-1);
			
			} else if (persD.position.dx < deplacement.dx) {
				persD.DeplacerX(1);
			
			}
			if (persD.position.dy>deplacement.dy) {
				persD.DeplacerY(-1);
			
			} else if (persD.position.dy<deplacement.dy) {
				persD.DeplacerY(1);
			
			}
		}
	}

	public ArrayList<Perso> getPersoArray() {
		return persoArray;
	}
	
	public void setPersoArray(ArrayList<Perso> persoArray) {
		this.persoArray = persoArray;
	}
	
}
