package fantasy_RPG;

//--- Combat 

public abstract class combat_attaque {
	
	private String nom, description;
	private boolean plural;
	private int des, add;
	private int prix;
	private boolean deuxMains;

	public combat_attaque(	String tempNom, String tempDescription, 
							boolean tempPlural, int tempDes, int tempAdd, int tempPrix, 
							boolean tempsdeuxMains) {
		
		  		des = tempDes;
		 	 	add = tempAdd;
		  		nom = tempNom;
		  		description = tempDescription;
		  		plural = tempPlural;
		 		prix = tempPrix;
		  		deuxMains = tempsdeuxMains;
	}
		
	public String toString() {
		 if(plural) {
		   return toPluralString();
		  }
		  return " " + description + " " + nom;
		}
		
	public String toPluralString() {
		  if(plural) {
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
	
	public boolean isPlural() {
		  return plural;
		}

	public abstract boolean peutUtiliser(perso_creatures c);
		
	public Degats degats(perso_creatures c) {
		  if(peutUtiliser(c)) {
		    int desTotal = 0;
		    int blesser = 0;
		    int temp = 0;
		    for(int i = 0; i < des; i++) {
		      desTotal += (temp = utils.random(1, 7));
		      if(temp == 6) {
		        blesser++;
		      }
		    }
		    return new Degats(desTotal + add, blesser);
		  }
		  return new Degats(0, 0);
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
