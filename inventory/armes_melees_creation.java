package inventory;

import java.util.Arrays;
import java.util.ArrayList;

public class armes_melees_creation {
	
	public static ArrayList<armes_melees> getAll(){ 
		
		return new ArrayList<armes_melees>(Arrays.asList(new armes_melees[]{
				
				dirk(utils.playerAdjectives()), 
				epeeCourte(utils.playerAdjectives()),		
				grall(utils.playerAdjectives()),
				epeeMagique(utils.playerAdjectives()),
				epeecassee(utils.playerAdjectives()),
				rapier(utils.playerAdjectives()),
				epeeCourte(utils.playerAdjectives()),
				axe(utils.playerAdjectives()),
				axeDeFolie(utils.playerAdjectives()),
				doubleBladedAxe(utils.playerAdjectives()),
				baton(utils.playerAdjectives()),
				club(utils.playerAdjectives()),
				flail(utils.playerAdjectives()),
				heavyFlail(utils.playerAdjectives()),
				warHammer(utils.playerAdjectives()),
				mace(utils.playerAdjectives()),
				morningstar(utils.playerAdjectives()),
				spear(utils.playerAdjectives()),
				footmansLance(utils.playerAdjectives()),
				longSpear(utils.playerAdjectives()),
				halfHalbard(utils.playerAdjectives()),
				halbard(utils.playerAdjectives()),
				poleaxe(utils.playerAdjectives()),
				brassKnuckles(utils.monsterAdjective()),
				talons(utils.monsterAdjective()),
				poings(utils.monsterAdjective()),
				rock(utils.monsterAdjective()),
				staff(utils.playerAdjectives())}));
	}
		 
	public static armes_melees dirk(String description) {
		return new armes_melees("dirk", description, 
		false, 2, 1, 1, 4, 18, false);
	}
		 
	public static armes_melees grall(String description) {
		return new armes_melees("Grall", description, 
		false, 3, 4, 15, 10, 140, false);
	}
		 
	public static armes_melees fitz(String description) {
		return new armes_melees("Fitz", description, 
		false, 4, 4, 12, 13, 150, false);
	}
		 
	public static armes_melees epeeMagique(String description) {
		return new armes_melees("Epée Magique", description, 
		false, 6, 0, 21, 18, 240, true);
	}
		 
	public static armes_melees epeecassee(String description) {
		return new armes_melees("Epée cassée", description, 
		false, 5, 0, 16, 12, 150, false);
	}
		 
	public static armes_melees rapier(String description) {
		return new armes_melees("rapier", description, 
		false, 3, 4, 10, 14, 160, false);
	}
		 
	public static armes_melees epeeCourte(String description) {
		return new armes_melees("épée courte", description, 
		false, 3, 0, 7, 3, 35, false);
	}
		 
	public static armes_melees axe(String description) {
		return new armes_melees("axe", description, 
		false, 4, 0, 17, 8, 100, false);
	}
		 
	public static armes_melees axeDeFolie(String description) {
		return new armes_melees("Axe de folie", description, 
		false, 5, 3, 20, 10, 110, true);
	}
		 
	public static armes_melees doubleBladedAxe(String description) {
		return new armes_melees("double bladed axe", description, 
		false, 6, 3, 21, 10, 140, true);
	}
		 
	public static armes_melees baton(String description) {
		return new armes_melees("baton", description, 
				false, 2, 0, 3, 2, 6, false);
	}
		 
	public static armes_melees club(String description) {
		  return new armes_melees("club", description, 
				  false, 3, 0, 5, 3, 15, false);
	}
		 
	public static armes_melees flail(String description) {
		  return new armes_melees("flail", description, 
				  false, 3, 4, 19, 13, 55, false);
	}
	
	public static armes_melees heavyFlail(String description) {
		  return new armes_melees("heavy flail", description, 
				  false, 4, 4, 20, 15, 100, false);
	}
	
	public static armes_melees warHammer(String description) {
		  return new armes_melees("war hammer", description, 
				  false, 5, 1, 16, 3, 85, false);
	}
		 
	public static armes_melees mace(String description) {
		  return new armes_melees("mace", description, 
				  false, 5, 2, 17, 3, 120, true);
	}
		 
	public static armes_melees morningstar(String description) {
		  return new armes_melees("morningstar", description, 
				  false, 5, 0, 17, 11, 140, false);
	}
	
	public static armes_melees spear(String description) {
		  return new armes_melees("spear", description, 
				  false, 3, 1, 8, 8, 15, false);
	}
		
	public static armes_melees footmansLance(String description) {
		  return new armes_melees("footman's lance", description, 
				  false, 4, 0, 10, 10, 40, true);
	}
	
	public static armes_melees longSpear(String description) {
		  return new armes_melees("long spear", description, 
				  false, 5, 0, 12, 10, 40, true);
	}
	
	public static armes_melees halfHalbard(String description) {
		  return new armes_melees("half halbard", description, 
				  false, 4, 1, 13, 9, 110, true);
	}
		 
	public static armes_melees halbard(String description) {
		  return new armes_melees("halbard", description, 
				  false, 6, 0, 16, 12, 200, true);
	}
	
	public static armes_melees poleaxe(String description) {
		  return new armes_melees("poleaxe", description, 
				  false, 7, 0, 14, 13, 210, true);
	}
		 
	public static armes_melees brassKnuckles(String description) {
		  return new armes_melees("brass knuckles", description, 
				  true, 1, 2, 2, 3, 20, true);
	}
		 
	public static armes_melees talons(String description) {
		  return new armes_melees("talons", description, 
				  true, 0, 10, 2, 10, 30, false);
	}
	
	public static armes_melees poings(String description) {
		 return new armes_melees("fists", description, 
				 true, 1, 0, 0, 0, 0, true);
	}
	
	public static armes_melees rock(String description) {
		  return new armes_melees("rock", description, 
				  false, 1, 0, 0, 0, 0, false);
	}
	
	public static armes_melees staff(String description) {
		  return new armes_melees_creation("staff", description, 
				  false, 2, 0, 10, 8, 10, true);
	}
}
