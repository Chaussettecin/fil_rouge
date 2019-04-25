package terminalOverflow;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import asciiPanel.AsciiPanel;

public class Map {
	
	char[][] map; 
	private int iX,jY=0;
	
	AsciiPanel terminal;
	int hauteur,largeur;
	
	public Map(AsciiPanel terminal) throws IOException {
		this.terminal=terminal;
		lireMap();
	}
	
	public void afficherMap() {
		for (int i = 0 ; i<terminal.getWidthInCharacters()  ; i++) {
			for (int j = 0 ; j<terminal.getHeightInCharacters() ; j++) {
				if ((j+jY) < hauteur && (i+iX) < largeur) {
					if((j+jY)<1 || (j+jY)> hauteur-1 ||(i+iX)<1 || (i+iX)>largeur-1) {
						terminal.write(map[j+jY][i+iX], i, j,Color.RED);
					}
					else {
						terminal.write(map[j+jY][i+iX], i, j);
					}
				}
			}
		}
	}
	
	public void lireMap() throws IOException {
		//Première lecture du fichier pour déterminer la hauteur et la largeur de la MAP
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("./src/terminalOverflow/map2.txt"));
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
			br = new BufferedReader(new FileReader("./src/terminalOverflow/map2.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			while ((line = br.readLine()) != null) {
			
				for (int j = 0 ; j< largeur ; j++) {
				    a=line.charAt(j);
				   	map[i][j] = a;
				}
				i++;
				System.out.println(i);
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
	
}
