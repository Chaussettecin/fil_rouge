package rpg_filrouge;

import java.util.ArrayList;

public class perso_boss extends perso_ennemis {

	public String nom;
	
	// Monde ? 
	
	public perso_boss(String race, int dexterite, int level, int charisme, int xp,
				ArrayList<equipement_arme> arrayArmes, ArrayList<equipement_sort> arraySorts,
				ArrayList<equipement_armure> arrayArmures) {
		
		super(race, dexterite, level, charisme, xp, arrayArmes, arraySorts, arrayArmures);
		
	}

	@Override
	public int BonusAttaque(perso_ennemis ennemis) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean parer(perso_ennemis ennemis) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pouvoir(perso_ennemis ennemis) {
		// TODO Auto-generated method stub
		return false;
	}

}
