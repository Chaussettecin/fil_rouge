package Mouvement;

import java.awt.Color;

import Maps.Map;
import Enemy.Cultiste;
import Utils.SingleTonRandom;
import asciiPanel.AsciiPanel;

public class CultMouv {

	Map map;
	char tile;
	
	Color color;
	Cultiste cult;
	
	AsciiPanel terminal; //Use la lib Ascii
	public Vector2d position;
	
	
/*
 * Constructor 
 */
	public CultMouv(AsciiPanel terminal, Map map, Vector2d v,char tile,
					Color color) {
			
			this.map = map;
			this.tile=tile;
			this.position=v;
			this.color=color;
			this.terminal=terminal;
		
	}

	
	public void afficher() { map.map[position.dy][position.dx]=tile; }

	
	public void deplacementAlea(){
		
		if(SingleTonRandom.getInstance().nextBoolean()) {
			int tmp = SingleTonRandom.getInstance().nextInt(3);
			deplacerX(tmp);
			
		} else {
			
			int tmp = SingleTonRandom.getInstance().nextInt(3);
			deplacerY(tmp);
		}
			
			
		//	System.out.println(SingleTonRandom.getInstance().nextInt(3)-1);
	
	}
	
	public void deplacerX(int p) {
		//System.out.println("largeur :");
		//System.out.println(map);
		//System.out.println(map.getLargeur());
		if (p >= 0 && p < map.largeur) {
		
		//-- Si position choix = vide il peut y aller.
			if (map.map[position.dy][position.dx+p]==' ') {
			position.dx+=p;
			map.map[position.dy][position.dx-p]=' '; 
			// Efface ligne precedente
			
			}	
		}
			
	}

	
	public void deplacerY(int p) {
		
		if (p >= 0 && p < map.hauteur) {
		
			if (map.map[position.dy+p][position.dx]==' ') {
			
				position.dy+=p;
				map.map[position.dy-p][position.dx]=' ';
		
			}
		}
		
	
	}
	

}
