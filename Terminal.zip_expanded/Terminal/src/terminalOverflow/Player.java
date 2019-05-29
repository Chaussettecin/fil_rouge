package terminalOverflow;

import java.awt.Color;
import asciiPanel.AsciiPanel;
import map.Map;

public class Player {
	
	private static final long serialVersionUID = 1L;
	private String nom = "deglass";
	char tile;
	Color color;
	//int posX;
	//int posY;
	int posMapX,posMapY;
	AsciiPanel terminal;
	Map map;
	public Vector2d position;
	
	

	public Player(AsciiPanel terminal,Map map, int posX, int posY,char tile, Color color) {
		
		this.terminal=terminal;
	//	this.posX=posX;
		this.posMapX=posX;
	//	this.posY=posY;
		this.posMapY=posY;
		this.tile=tile;
		this.map=map;
		this.color=color;
		this.position= new Vector2d(posX,posY);
		
	}
	
	public Player(AsciiPanel terminal,Map map, int posX, int posY,char tile, Color color, String nom) {
		this.nom=nom;
		this.terminal=terminal;
		this.position= new Vector2d(posX,posY);
	//	this.posX=posX;
		this.posMapX=posX;
	//	this.posY=posY;
		this.posMapY=posY;
		this.tile=tile;
		this.map=map;
		this.color=color;
	}
	
	public void afficherPlayer() {
		terminal.write(tile, posMapX, posMapY, color);
	}
	
	
	
	public void DeplacerX(int p) {
		
		position.dx+=p;
		
		if ((position.dx<terminal.getWidthInCharacters()/2)) {
			posMapX=position.dx;
			map.setiX(0);
		}else if(position.dx>map.largeur-terminal.getWidthInCharacters()/2){
			map.setiX(map.largeur-terminal.getWidthInCharacters());
			posMapX+=p;
			
		}
		else {
			posMapX=terminal.getWidthInCharacters()/2-1;
			map.setiX(map.getiX()+p);
			
		}
		
		
		
	}
	
	public void DeplacerY(int p) {
		position.dy+=p;
		
		if ((position.dy<terminal.getHeightInCharacters()/2)) {
			posMapY=position.dy;
			map.setjY(0);
		}else if(position.dy>map.hauteur-terminal.getHeightInCharacters()/2){
			map.setjY(map.hauteur-terminal.getHeightInCharacters());
			posMapY+=p;
			
		}
		else {
			posMapY=terminal.getHeightInCharacters()/2-1;
			map.setjY(map.getjY()+p);
			
		}
	}

	
		public void dig() {
			if(map.map[position.dy][position.dx+1]== 'X')
				map.map[position.dy][position.dx+1]= ' ';
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public char getTile() {
			return tile;
		}

		public void setTile(char tile) {
			this.tile = tile;
		}

		public int getPosMapX() {
			return posMapX;
		}

		public void setPosMapX(int posMapX) {
			this.posMapX = posMapX;
		}

		public int getPosMapY() {
			return posMapY;
		}

		public void setPosMapY(int posMapY) {
			this.posMapY = posMapY;
		}

		public AsciiPanel getTerminal() {
			return terminal;
		}

		public void setTerminal(AsciiPanel terminal) {
			this.terminal = terminal;
		}

		public Map getMap() {
			return map;
		}

		public void setMap(Map map) {
			this.map = map;
		}

		public Vector2d getPosition() {
			return position;
		}

		public void setPosition(Vector2d position) {
			this.position = position;
		}
		
		
		
}


	