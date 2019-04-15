package fantasy_RPG;


//// -- Attaque à distance 
///--- Car cetaines armes ou pouvoir peut fonctionner à distance

	public abstract class attaque_distance extends combat_attaque {

	 	public attaque_distance(	String tempNom, String tempDescription, boolean tempPlural, int tempDes, 
			 						int tempAdd, int tempPrix, boolean tempsdeuxMains) {
		  		
			 super(tempNom, tempDescription, tempPlural, tempDes, tempAdd, tempPrix, tempsdeuxMains);
	
	}
}
