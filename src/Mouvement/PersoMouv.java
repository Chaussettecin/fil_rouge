package Mouvement;

import java.awt.Color;

import Maps.Map;
import Perso.Perso;
import Perso.Race;
import asciiPanel.AsciiPanel;

/**
 * Classe de gestion des mouvements de l'�quipe de personnages
 */
public class PersoMouv {
	
	Map map;
	char tile;
	Color color;
	Perso equipPerso;
	AsciiPanel terminal;
	
	int posMapX,posMapY;
	public Vector2d position;
	
	private static final long serialVersionUID = 1L;
	
/*
 * Constructor -
 */
	public PersoMouv(AsciiPanel terminal,Map map, int posX, 
						int posY,char tile, Color color) {
		
		this.terminal=terminal;
		this.posMapX=posX;
		this.posMapY=posY;
		this.tile=tile;
		this.map=map;
		this.color=color;
		this.position= new Vector2d(posX,posY);
		
	}
	
/*
 * Constructor qui recup le nom et humain -
 */
	public PersoMouv(AsciiPanel terminal,Map map, int posX, 
					int posY,char tile, Color color, Perso perso) {
		
		this.tile=tile;
		this.map=map;
		this.color=color;
		this.posMapX=posX;
		this.posMapY=posY;
		this.terminal=terminal;
		this.equipPerso = perso;
		this.position= new Vector2d(posX,posY);
	
	}
	
/*
 * Constructor qui recup le nom et humain -
 */
	public PersoMouv(String nom, Race humain) {}
	
//-- Affiche sur la map l'etat de l'equipe... PTV / Gold / Level
	

/*
 * Methode affiche sur en haut de la map 
 * l'etat de notre �quipe
 * ---  PTV
 * --- Gold
 * --- Level
 */
	public void afficherPlayer() {
		
		terminal.write(tile, posMapX, posMapY, color);
		terminal.write((char)36,terminal.getWidthInCharacters()/2,0);
		terminal.write((char)37,terminal.getWidthInCharacters()-5,0);
		
		String vie="";
		Color color = Color.WHITE;
		
		//Affiche les infos en haut de l'ecran
		int ptVie = Perso.getPtv();
		
		if(ptVie>90) {
			vie="||||||||||";
			color=Color.green;
		
		}else if(ptVie>=80 && ptVie<90) {
			vie="|||||||||";
			color=Color.green;
		}else if(ptVie>=70 && ptVie<80) {
			vie="||||||||";
			color=Color.green;
		}else if(ptVie>=60 && ptVie<70) {
			vie="|||||||";
			color=Color.green;
		}else if(ptVie>=50 && ptVie<60) {
			vie="||||||";
			color=Color.green;
		}else if(ptVie>=40 && ptVie<50) {
			vie="|||||";
			color=Color.green;
		}else if(ptVie>=30 && ptVie<40) {
			color=Color.yellow;
			vie="||||";
		}else if(ptVie>=20 && ptVie<30) {
			vie="|||";
		    color=Color.yellow;
		}else if(ptVie>=10 && ptVie<20) {
			vie="||";
			color=Color.red;
		}else if(ptVie>=0 && ptVie<10) {
			vie="|";
			color=Color.red;
		}
		
		terminal.write((char) 03,5,0,color);
		terminal.write(vie,1,1);
	}
	
	public void DeplacerX(int p) {
		
		position.dx+=p;
		
	// Camera = Jeu lancer
	//----Tant qu'il n'a pas atteind demi ecran la cam ne bouge pas.
	//------posMapX = Camera
		if ((position.dx<terminal.getWidthInCharacters()/2)) {
				posMapX=position.dx;
				map.setiX(0);
		
		} else if(position.dx>map.largeur-terminal.getWidthInCharacters()/2){
				map.setiX(map.largeur-terminal.getWidthInCharacters());
				posMapX+=p;
				//La carte bouge et le perso centrer
			
		} else {
			posMapX=terminal.getWidthInCharacters()/2-1;
			map.setiX(map.getiX()+p);
	
		}
		
	}
	
	public void DeplacerY(int p) {
		
		position.dy+=p;
		
		if ((position.dy<terminal.getHeightInCharacters()/2)) {
			posMapY=position.dy;
			map.setjY(0);
		
		} else if(position.dy>map.hauteur-terminal.getHeightInCharacters()/2){
			
			map.setjY(map.hauteur-terminal.getHeightInCharacters());
			posMapY+=p;
			
		} else {
			
			posMapY=terminal.getHeightInCharacters()/2-1;
			map.setjY(map.getjY()+p);
			
		}
	
	}

	
	public void dig() {
			
		if(map.map[position.dy][position.dx+1]== 'X')
				map.map[position.dy][position.dx+1]= ' ';
		}
		
/*
 * GETTER & SETTER - 	
 */
	public Perso getPerso() {return equipPerso; }
		
	public void setPerso(Perso per) { this.equipPerso = per; }
		
	public char getTile() { return tile; }
		
	public void setTile(char tile) { this.tile = tile; }
		 
	public int getPosMapX() { return posMapX; }
		
	public void setPosMapX(int posMapX) { this.posMapX = posMapX; }
		
	public int getPosMapY() { return posMapY; }
		
	public void setPosMapY(int posMapY) { this.posMapY = posMapY;}

	public AsciiPanel getTerminal() { return terminal; }

	public void setTerminal(AsciiPanel terminal) { this.terminal = terminal;}

	public Map getMap() { return map; }

	public void setMap(Map map) {this.map = map; }
		
	public Vector2d getPosition() { return position; }

	public void setPosition(Vector2d position) { this.position = position; }

	public static long getSerialversionuid() { return serialVersionUID; }

	public void setMap(int z) {
		// TODO Auto-generated method stub
		
	}
		
		
}


	