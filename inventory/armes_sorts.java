package inventory;

import java.util.Arrays;
import java.util.ArrayList;

public class armes_sorts {

	public static ArrayList<armes_sorts> getAll(){
		
		return new ArrayList<armes_sorts>
		
		(Arrays.asList(new armes_sorts[]{
				frozen("magique"),
				missileMagique("magique"),
				BoulesDeFeu("magique"),
				tempete("magique"),
				canonArcane("magique"),
				tempetedesDieux("magique"),
				lance("magique")
				}));
	}
	
	public static armes_sorts frozen(String description) {
		return new armes_sorts();
	}
	
	public static armes_sorts missileMagique(String description) {
		return new armes_sorts();
	}
	
	public static armes_sorts BoulesDeFeu(String description) {
		return new sorts("Boules de feu", description, false, 3, 2, 16, 1, 1000, false);
	}
	
	public static armes_sorts tempete(String description) {
		return new sorts("Tempetes", description, false, 4, 5, 18, 2, 1000, false);
	}
	
	public static armes_sorts canonArcane(String description) {
		return new sorts("Canon des Arcanes", description, false, 5, 3, 20, 2, 2000, true);
	}
	
	public static armes_sorts tempetedesDieux(String description) {
		return new sorts("Tempete des Dieux", description, false, 6, 4, 25, 2, 2000, true);
	}
	
	public static armes_sorts lance(String description) {
		return new sorts ("lance", description, false, 7, 0, 27);
}
}