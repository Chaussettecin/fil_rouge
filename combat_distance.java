package rpg_filrouge;


public class combat_distance extends combat_attaque {

	 public combat_distance(String tempNom, String tempDescription, boolean tempPlural, int tempDes, 
			 				int tempAdd, int tempPrix, boolean tempsdeuxMains) {
		
		 super(tempNom, tempDescription, tempPlural, tempDes, tempAdd, tempPrix, tempsdeuxMains);
	
	}

	@Override
	public boolean peutUtiliser(perso_ennemis e) {
	
		return false;
	}


}
