package inventory;

import java.util.Arrays;
import resource.Util;
import java.util.ArrayList;

public class armes_distances_creation {
	
	public static ArrayList<armes_distances> getAll() {
		
		return new ArrayList<armes_distances>(
			
		Arrays.asList(new armes_distances[]{lightCrossbow(Util.playerAdjectives()),
				
				crossbow(Util.playerAdjectives()), heavyCrossbow(Util.playerAdjectives()),
				lightBow(Util.playerAdjectives()),bow(Util.playerAdjectives()),
				heavyBow(Util.playerAdjectives()),enchantedBow(Util.playerAdjectives()),
				sling(Util.playerAdjectives()),boomerang (Util.playerAdjectives()),
				throwingAxe(Util.playerAdjectives()), rock(Util.playerAdjectives())}));
	
	}
	

	public static armes_distances lightCrossbow(String description) {
		return new armes_distances("light crossbow", description, false, 3, -1, 8, 12, 20, 150, false);
	}
		 
	
	public static armes_distances crossbow(String description) {
		return new armes_distances("crossbow", description, false, 4, 0, 12, 10, 20, 170, true);
	}
	
	
	public static armes_distances heavyCrossbow(String description) {
		return new armes_distances("heavy crossbow", description, false, 5, 0, 15, 10, 20, 250, true);
	}
	
	
	public static armes_distances lightBow(String description) {
		return new armes_distances("light bow", description, false, 4, 3, 15, 15, 20, 100, true);
	}

	public static armes_distances bow(String description) {
		return new armes_distances("bow", description, false, 5, 3, 20, 16, 20, 175, true);
	}
	
	public static armes_distances heavyBow(String description) {
		return new armes_distances("heavy bow", description, false, 6, 3, 25, 17, 20, 250, true);
	}
	
	public static armes_distances enchantedBow(String description) {
		return new armes_distances("enchanted bow", description, false, 6, 5, 15, 18, 20, 500, true);
	}
	
	public static armes_distances sling(String description) {
		return new armes_distances("sling", description, false, 2, 0, 5, 10, 0, 5, false);
	}
		 
	public static armes_distances boomerang(String description) {
		return new armes_distances("boomerang", description, false, 2, 3, 11, 11, 0, 50, false);
	}
		 
	public static armes_distances throwingAxe(String description) {
		return new armes_distances("throwing axe", description, false, 3, 2, 9, 12, 1, 70, false);
	}
	
	public static armes_distances rock(String description) {
		return new armes_distances("rock", description, false, 1, 0, 0, 0, 0, 0, false);
	}
}
