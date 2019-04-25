package terminalOverflow;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import asciiPanel.AsciiPanel;

public class Player extends JFrame {
	
	private static final long serialVersionUID = 1L;
	String nom = "deglass";
	char tile = '@';
	Color color;
	int posX;
	int posY;
	AsciiPanel terminal;
	Map map;
	
	
//	public Player(AsciiPanel terminal,Map map,char til,Color color) {
//		this.terminal=terminal;
//		this.posX=15;
//		this.posY=15;
//		this.map=map;
//		this.color=color;
//		
//	
//	}
	public Player(AsciiPanel terminal,Map map, int posX, int posY,char tile, Color color) {
		this.terminal=terminal;
		this.posX=posX;
		this.posY=posY;
		this.tile=tile;
		this.map=map;
		this.color=color;
	}
	
	public void afficherPlayer() {
		terminal.write(tile, posX, posY, color);
	}
	
	
	
	public void DeplacerX(int p) {
		
		posX+=p;
		if (posX<10) {
			posX=10;
			map.setiX(map.getiX()+p);
		}
		else if(posX > terminal.getWidthInCharacters()-10) {
			posX=terminal.getWidthInCharacters()-10;
			map.setiX(map.getiX()+p);
		}
		
				
	}
		public void DeplacerY(int p) {
			posY+=p;
			if (posY<10) {
				posY=10;
				map.setjY(map.getjY()+p);
			}
			else if(posY>terminal.getHeightInCharacters()-10) {
				posY=terminal.getHeightInCharacters()-10;
				map.setjY(map.getjY()+p);			
			}
		}
	
		public void dig() {
			if(map.map[map.getjY()+posY][map.getiX()+posX+1]== 'X' || map.map[map.getjY()+posY][map.getiX()+posX+1]=='Q')
				map.map[map.getjY()+posY][map.getiX()+posX+1]= ' ';
		}
}


	