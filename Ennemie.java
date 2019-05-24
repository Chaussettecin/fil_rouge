package terminalOverflow;

import java.awt.Color;

import asciiPanel.AsciiPanel;

public class Ennemie {
	
	private static final long serialVersionUID = 1L;
	String nom = "Ennemie";
	char tile;
	Color color;
	int posmapX;
	int posmapY;
	AsciiPanel terminal;
	Map map;
	
	

	public Ennemie(AsciiPanel terminal,Map map, int posmapX, int posmapY,char tile, Color color) {
		this.terminal=terminal;
		this.posmapX=posmapX;
		this.posmapY=posmapY;
		this.tile=tile;
		this.map=map;
		this.color=color;
	}
	
	public void afficher() {
	//	terminal.write(tile, posmapX, posmapY, color);
	
		map.map[posmapY][posmapX]=tile;
	}
	

	public void deplacementAlea(){
		if(SingleTonRandom.getInstance().nextBoolean())
			DeplacerX((SingleTonRandom.getInstance().nextInt(3))-1);
		else
			DeplacerY((SingleTonRandom.getInstance().nextInt(3))-1);
		//	System.out.println(SingleTonRandom.getInstance().nextInt(3)-1);
	}
	
	
	
	
	///////GETTER SETTER
	public void DeplacerX(int p) {
		if (map.map[posmapY][posmapX+p]==' ') {
			System.out.println(map.map[posmapY][posmapX+p]);
			posmapX+=p;
			map.map[posmapY][posmapX-p]=' ';
		}		
	}
	public void DeplacerY(int p) {
	//	System.out.println(map.map[posmapY+p][posmapX]);
		if (map.map[posmapY+p][posmapX]==' ') {
			posmapY+=p;
			map.map[posmapY-p][posmapX]=' ';
		}
	}
	
		
}


	