package terminalOverflow;

import java.awt.Color;
import asciiPanel.AsciiPanel;

public class Player {
	
	private static final long serialVersionUID = 1L;
	String nom = "deglass";
	char tile;
	Color color;
	int posX;
	int posY;
	int posMapX,posMapY;
	AsciiPanel terminal;
	Map map;
	
	

	public Player(AsciiPanel terminal,Map map, int posX, int posY,char tile, Color color) {
		this.terminal=terminal;
		this.posX=posX;
		this.posMapX=posX;
		this.posY=posY;
		this.posMapY=posY;
		this.tile=tile;
		this.map=map;
		this.color=color;
	}
	
	public void afficherPlayer() {
		terminal.write(tile, posMapX, posMapY, color);
	}
	
	
	
	public void DeplacerX(int p) {
		
		posX+=p;
		
		if ((posX<terminal.getWidthInCharacters()/2)) {
			posMapX=posX;
			map.setiX(0);
		}else if(posX>map.largeur-terminal.getWidthInCharacters()/2){
			map.setiX(map.largeur-terminal.getWidthInCharacters());
			posMapX+=p;
			
		}
		else {
			posMapX=terminal.getWidthInCharacters()/2-1;
			map.setiX(map.getiX()+p);
			
		}
		
//		if ((posX>terminal.getWidthInCharacters()/2)) {
//			posMapX=terminal.getWidthInCharacters()/2-1;
//			map.setiX(map.getiX()+p);
//		}else {
//			posMapX=posX;
//			map.setiX(0);
//		}
//		

			
			
		
		
	}
	
	public void DeplacerY(int p) {
		posY+=p;
		
		if (!(posY<terminal.getHeightInCharacters()/2)) {
			posMapY=terminal.getHeightInCharacters()/2-1;
			map.setjY(map.getjY()+p);
		}else {
			posMapY=posY;
			map.setjY(0);
		}
		
		
		
//		posY+=p;
//		posMapY+=p;
//		if (posY>terminal.getHeightInCharacters()/2 && posY<map.hauteur-terminal.getHeightInCharacters()/2) {
//			posMapY=terminal.getHeightInCharacters()/2;
//			map.setjY(map.getjY()+p);
//		}else {
//			posMapY=posY;
//			map.setjY(0);
//		}
		
	}
//	public void DeplacerX(int p) {
//		
//		posX+=p;
//		if (posX<10) {
//			posX=10;
//			map.setiX(map.getiX()+p);
//		}
//		else if(posX > terminal.getWidthInCharacters()-10) {
//			posX=terminal.getWidthInCharacters()-10;
//			map.setiX(map.getiX()+p);
//		}
//		
//		
//	}

				
	
//		public void DeplacerY(int p) {
//			posY+=p;
//			if (posY<10) {
//				posY=10;
//				map.setjY(map.getjY()+p);
//			}
//			else if(posY>terminal.getHeightInCharacters()-10) {
//				posY=terminal.getHeightInCharacters()-10;
//				map.setjY(map.getjY()+p);			
//			}
//		}
	
		public void dig() {
			if(map.map[posY][posX+1]== 'X')
				map.map[posY][posX+1]= ' ';
		}
}


	