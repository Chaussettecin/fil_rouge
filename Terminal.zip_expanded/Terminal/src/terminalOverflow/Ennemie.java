package terminalOverflow;

import java.awt.Color;

import Random.SingleTonRandom;
import asciiPanel.AsciiPanel;
import map.Map;

public class Ennemie {
	
	private static final long serialVersionUID = 1L;
	String nom = "Ennemie";
	char tile;
	Color color;
//	int posmapX;
//	int posmapY;
	AsciiPanel terminal;
	Map map;
	public Vector2d position;
	

//	public Ennemie(AsciiPanel terminal,Map map, int posmapX, int posmapY,char tile, Color color) {
//		this.terminal=terminal;
//		this.posmapX=posmapX;
//		this.posmapY=posmapY;
//		this.tile=tile;
//		this.map=map;
//		this.color=color;
//	}
	public Ennemie(AsciiPanel terminal,Map map, Vector2d v,char tile, Color color) {
		this.terminal=terminal;
//		this.posmapX=posmapX;
//		this.posmapY=posmapY;
		this.tile=tile;
		this.map=map;
		this.color=color;
		this.position=v;
	}
	
	public void afficher() {
		map.map[position.dy][position.dx]=tile;
		
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
		if (map.map[position.dy][position.dx+p]==' ') {
			position.dx+=p;
			map.map[position.dy][position.dx-p]=' ';
		}		
	}
	public void DeplacerY(int p) {
		if (map.map[position.dy+p][position.dx]==' ') {
			position.dy+=p;
			map.map[position.dy-p][position.dx]=' ';
		}
	}
	
		
}


	