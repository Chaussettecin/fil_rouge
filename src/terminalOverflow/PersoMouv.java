package terminalOverflow;

import java.awt.Color;
import asciiPanel.AsciiPanel;
import maps.Map;

public class PersoMouv {
	
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
	
	
	public PersoMouv(AsciiPanel terminal,Map map, int posX, int posY,char tile, Color color) {
		
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
	
	public PersoMouv(AsciiPanel terminal,Map map, int posX, int posY,char tile, Color color, String nom) {
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
		terminal.write((char)36,terminal.getWidthInCharacters()/2,0);
		terminal.write((char)37,terminal.getWidthInCharacters()-5,0);
		String vie="";
		Color color = Color.WHITE;
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
		
		if ((position.dx<terminal.getWidthInCharacters()/2)) {
			posMapX=position.dx;
			map.setiX(0);
		
		} else if(position.dx>map.largeur-terminal.getWidthInCharacters()/2){
			map.setiX(map.largeur-terminal.getWidthInCharacters());
			posMapX+=p;
			
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


	
