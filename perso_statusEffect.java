package rpg_filrouge;

public class perso_statusEffect {

	 public enum type {
	       
		 SANTE, 
	     TAILLE, 
	     CHANCE, 
	     type;

	     @Override
	     public String toString() {
	            
	    	 String effect = super.toString();
	        return effect.substring(0, 1) + effect.substring(1).toLowerCase();
	     }
	    
	 }
	
}
