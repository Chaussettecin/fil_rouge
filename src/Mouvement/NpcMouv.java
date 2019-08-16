package Mouvement;

import java.awt.Color;
import java.util.ArrayList;

import Maps.Map;
import Npc.Npc;
import Utils.SingleTonRandom;
import asciiPanel.AsciiPanel;

public class NpcMouv {
	
/*
 * Class qui gére tout les mouv qui ne sont pas nos perso
 * Mais à voir si on peut mettre directement dans la classe 
 * Enemy ? 
 */
	private static final long serialVersionUID = 1L;
	
	char tile;
	
	Npc npc;
	Color color;
	Map map;
	AsciiPanel terminal; //-- Use la lib Ascii

	public Vector2d position;
	private ArrayList<String> npcList;
	
//-- Constructor ---
	public NpcMouv(AsciiPanel terminal, Map map, Vector2d position,
					char tile, Color color) {
		
		
		this.terminal= terminal;
		this.tile=tile;
		this.map= map;
		this.color=color;
		this.position= position;
	
	}
	
	
	public void afficher() { map.map[position.dy][position.dx]=tile; }
	
	public void deplacementAlea(){
		
		if(SingleTonRandom.getInstance().nextBoolean())
			deplacerX((SingleTonRandom.getInstance().nextInt(3))-1);
		
		else
			deplacerY((SingleTonRandom.getInstance().nextInt(3))-1);
		//	System.out.println(SingleTonRandom.getInstance().nextInt(3)-1);
	
	}
	

	public void deplacerX(int pc) {
		
		if (map.map[position.dy][position.dx+pc]==' ') {
			position.dx+=pc;
			map.map[position.dy][position.dx-pc]=' ';
		
		}		
	}
	
	
	public void deplacerY(int pc) {
		
		if (map.map[position.dy+pc][position.dx]==' ') {
			position.dy+=pc;
			map.map[position.dy-pc][position.dx]=' ';
		
		}
	
	}


// ----- GETTER  & SETTER -- 
	
	public static long getSerialversionuid() { return serialVersionUID; }

	public ArrayList<String> getNpcList() { return npcList; }

	public void setNpcList(ArrayList<String> npcList) { this.npcList = npcList;}
	
		
}
