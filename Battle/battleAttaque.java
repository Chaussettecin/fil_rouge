package Battle;

import Degat.degat;
import perso.perso;
import resource.utilsGame;

public abstract class battleAttaque {

	private String nom, description;
	private boolean duo;
	private int des, add;
	private int prix;
	private boolean deuxMains;

		
	public battleAttaque(String tempNom, String tempDescription, boolean tempDuo, 
						int tempDes, int tempAdd, int tempPrix, boolean tempsdeuxMains) {
			
			  des = tempDes;
			  add = tempAdd;
			  nom = tempNom;
			  description = tempDescription;
			  duo = tempDuo;
			  prix = tempPrix;
			  deuxMains = tempsdeuxMains;
		}
			
	public String toString() {
			
		if(duo) {
			  return DuoString();
		}
		return " " + description + " " + nom;
	}
			
		
	public String DuoString() {
			  
		if(duo) {
			return description + " " + nom;
		}
			  
		return description + " " + nom + "s";
	}

		
	public String getNom() {
		return nom;
	}
	
		
	public String getDescription() {
		return description;
	}
		
		
	public boolean Duo() {
		return duo;
	}

		
	public abstract boolean peutUtiliser(perso Perso);
			
		public degat degats(perso Perso) {
			  
			if(peutUtiliser(Perso)) {
				  
			    int desTotal = 0;
			    int blesser = 0;
			    int temp = 0;
			    
			    for(int i = 0; i < des; i++) {
			    	desTotal += (temp = utilsGame.random(1, 7));
			    	
			    	if(temp == 6) {
			        blesser++;
			    	}
			    }
			    return new degat(desTotal + add, blesser);
			  }
			  return new degat(0, 0);
		}
			
	
	public int getDes() {
		return des;
	}
			
		
	public int getAdd() {
		return add;
	}
		
	public int getPrix(){
		return prix;
	}
		
	public boolean aDeuxMains() {
		return deuxMains;
	}
	
}
