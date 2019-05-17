package Battle;


public class battleAttaque {

	private String nom, description;
	private boolean duo;
	private int des, add;
	private int prix;
	private boolean deuxMains;

		
		public battleAttaque(	String tempNom, String tempDescription, 
								boolean tempDuo, int tempDes, 
								int tempAdd, int tempPrix, 
								boolean tempsdeuxMains) {
			
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

		public abstract boolean peutUtiliser(perso_creature c);
			
		public Degats degats(perso_creature c) {
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
