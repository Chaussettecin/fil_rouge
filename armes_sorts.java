package inventory;

import java.util.Arrays;
import java.util.ArrayList;

public class armes_sorts {

	public static ArrayList<armes_sorts> getAll(){
		
		return new ArrayList<armes_sorts> (
				
				Arrays.asList(new armes_sorts[]{
				
						frozen("magique"),
						missileMagique("magique"),
						BoulesDeFeu("magique"),
						tempete("magique"),
						canonArcane("magique"),
						tempetedesDieux("magique"),
						lance("magique")
				}
		));
	}
	
	public static armes_sorts frozen(String description) {
		return new armes_sorts();
	}
	
	public static armes_sorts missileMagique(String description) {
		return new armes_sorts();
	}
	
	public static armes_sorts BoulesDeFeu(String description) {
		return new armes_sorts();
	}
	
	public static armes_sorts tempete(String description) {
		return new armes_sorts();
	}
	
	public static armes_sorts canonArcane(String description) {
		return new armes_sorts();
	}
	
	public static armes_sorts tempetedesDieux(String description) {
		return new armes_sorts();
	}
	
	public static armes_sorts lance(String description) {
		return new armes_sorts ();
}

	public boolean aDeuxMains() {
		// TODO Auto-generated method stub
		return false;
	}
}