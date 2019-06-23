package terminalOverflow;

import java.awt.Color;

import Enemy.Enemy;
import Utils.SingleTonRandom;
import asciiPanel.AsciiPanel;
import maps.Map;

public class EnemyMouv {
	
	/*
	 * Class qui gére tout les mouv qui ne sont pas nos perso
	 * Mais à voir si on peut mettre directement dans la classe 
	 * Enemy ? 
	 */
	private static final long serialVersionUID = 1L;
	
	char tile;
	
	Enemy enemy;
	Color color;
	AsciiPanel terminal; //-- Use la lib Ascii
	Map map;
	
	public Vector2d position;
	
//-- Constructor ---
	public EnemyMouv(AsciiPanel terminal,Map map, Vector2d v,
					char tile, Color color) {
		
		this.terminal=terminal;
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
			deplacerX((SingleTonRandom.getInstance().nextInt(3))-1);
		
		else
			deplacerY((SingleTonRandom.getInstance().nextInt(3))-1);
		//	System.out.println(SingleTonRandom.getInstance().nextInt(3)-1);
	
	}
	

	public void deplacerX(int p) {
		
		if (map.map[position.dy][position.dx+p]==' ') {
			position.dx+=p;
			map.map[position.dy][position.dx-p]=' ';
		
		}		
	}
	
	
	public void deplacerY(int p) {
		
		if (map.map[position.dy+p][position.dx]==' ') {
			position.dy+=p;
			map.map[position.dy-p][position.dx]=' ';
		
		}
	
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
		
}


	
