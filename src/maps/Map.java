package maps;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import asciiPanel.AsciiPanel;

public class Map {
	
	public char[][] map; 
    public int iX,jY=0;
	
	AsciiPanel terminal;
	public int hauteur;
	public int largeur;
	
	public Map(AsciiPanel terminal) throws IOException {
		
		this.terminal=terminal;
		lireMap();
	
	}
	
	public void afficherMap() {
		
		for (int i = 0 ; i<terminal.getWidthInCharacters()  ; i++) {
			
			for (int j = 0 ; j<terminal.getHeightInCharacters() ; j++) {
				
				if ((j+jY) < hauteur && (i+iX) < largeur) {
					
					if((j+jY)<2 || (j+jY)> hauteur-2 ||(i+iX)<2 || (i+iX)>largeur-2) {
						terminal.write(map[j+jY][i+iX], i, j,Color.RED);
					}
					
					else {
						
						if(map[j+jY][i+iX]=='D') {
							terminal.write(map[j+jY][i+iX], i, j,Color.GRAY);
						}else if(map[j+jY][i+iX]=='w'){
							terminal.write(map[j+jY][i+iX], i, j,Color.BLUE);
						}else if(map[j+jY][i+iX]=='#') {
							terminal.write(map[j+jY][i+iX], i, j,Color.YELLOW);
					    }else {
							terminal.write(map[j+jY][i+iX], i, j,Color.GREEN);
						}
					}
				}
			}
		}
	}
	
	public void lireMap() throws IOException {
		//Première lecture du fichier pour déterminer la hauteur et la largeur de la MAP
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("./src/maps/map2.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line;
		char a=' ';
		int i=0;
		while ((line=br.readLine()) !=null) {
			largeur=line.length();
			hauteur++;
			
		}
		br.close();
		
		//Seconde lecture pour copier le fichier dans un tableau
		map = new char[hauteur][largeur];
		try {
			br = new BufferedReader(new FileReader("./src/maps/map2.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			while ((line = br.readLine()) != null) {
			
				for (int j = 0 ; j< largeur ; j++) {
				    a=line.charAt(j);
				   	map[i][j] = a;
				}
				i++;
				
			}
		br.close();
		}
	
	
	
	
	
	
	//GETTER ET SETTER
	public void setiX(int iX) {
		this.iX=iX;
	}
	
	public int getiX() {
		return this.iX;
	}

	
	public int getjY() {
		return jY;
	}

	
	public void setjY(int jY) {
		this.jY=jY;
	}
	
	public void test() {
		terminal.write("HELLO WORLD",10,10);
	}
	
}
