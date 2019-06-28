package TerminalOverflow;

import java.awt.Color;

import Adventure.Npc;
import Enemy.Enemy;
import Maps.Map;
import Utils.SingleTonRandom;
import asciiPanel.AsciiPanel;

public class MouvementOther {
	
/*
 	*Class qui contient les mouvements de nos PNJ & Cultiste
*/
	private static final long serialVersionUID = 1L;
	
	char tile;
	Npc npc;
	Map map;
	Color color;
	Enemy enemy;
	AsciiPanel terminal; //Use la lib Ascii

	public Vector2d position;
	
//-- Constructor ---
	public MouvementOther(AsciiPanel terminal,Map map, Vector2d v,
			char tile, Color color) {
					
		this.enemy = enemy;
		this.npc = npc;
		this.terminal=terminal;
		this.tile=tile;
		this.map=map;
		this.color=color;
		this.position=v;
	
	}
	
	public void afficher() {
		map.map[position.dy][position.dx]=tile;
	}
	
/*
 * Gére les deplacement aléatoire des autres gusses ds le jeux
 * *** NPC / Cultiste
 */
	public void deplacementAlea(){
		
		if(SingleTonRandom.getInstance().nextBoolean())
			deplacerX((SingleTonRandom.getInstance().nextInt(3))-1);
		
		else
			deplacerY((SingleTonRandom.getInstance().nextInt(3))-1);
		//	System.out.println(SingleTonRandom.getInstance().nextInt(3)-1);
	
	}
	
/*
 *  Deplacemet X et Deplacement Y
 */
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


	