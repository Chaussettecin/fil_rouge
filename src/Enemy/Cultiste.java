package Enemy;

import java.util.Random;

// --- Cultiste --- 
public class Cultiste extends Enemy {

	public boolean Boss = false; // Ce nest pas un BOSS

	
//-- Constructor -- 
	public Cultiste(boolean Boss) {		
		super(nom, ptv, degat, race);  
		
		this.nom = nom;
		this.ptv = ptv;
		this.degat = degat;
		
		this.Boss = false;
		
			
	}
	
//--- Reste à personnalisé les Cultiste	
	public void setRandCultiste() {
        
		Random rand = new Random();
        int randNum = rand.nextInt(7);

        Cultiste randEnemy;
        
		switch (randNum){
        
            case 0:
                randEnemy = new Cultiste(false);
            case 1:
                randEnemy = new Cultiste(false);
                break;
            case 2:
                randEnemy = new Cultiste(false);
                break;
            case 3:
                randEnemy = new Cultiste(false);
                break;
            case 4:
                randEnemy = new Cultiste(false);
                break;
         
        }
    }


	
}
