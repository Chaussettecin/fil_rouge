package Perso;

import Perso.PersoStats;
import Util.JSON.Json;
import Util.JSON.JsonObject;

public class PersoStats extends Perso{
	
public static int totalGoldDepenser;
	/*
 * Class qui r�cup�re les stats du perso ou equipe -
 */
	 private int maxHealth;
	 private int currentHealth;
	 private int strength;
	 private int dexterity;

//--- Constructor  
	 // avec les valeurs par defaut 
	 public PersoStats() {
		 
		 super(nom, race);
	        
		 maxHealth = 100;
	     currentHealth = maxHealth;
	     strength = 1;
	     dexterity = 0;
	 }

	    
	 public static PersoStats loadFromJSON(JsonObject json) {
	        
		 PersoStats stats = new PersoStats();

	        if (json.contains("maxhealth"))
	            stats.maxHealth = json.get("maxhealth").asInt();

	        if (json.contains("currenthealth"))
	            stats.currentHealth = json.get("currenthealth").asInt();

	        if (json.contains("strength"))
	            stats.strength = json.get("strength").asInt();

	        if (json.contains("dexterity"))
	            stats.dexterity = json.get("dexterity").asInt();

	        return stats;
	 }

	    
	 public void saveToJSON(JsonObject json) {
	        
	    	JsonObject characterStats = Json.object();
	        json.add("stats", characterStats);
	        characterStats.add("maxhealth", maxHealth);
	        characterStats.add("currenthealth", currentHealth);
	        characterStats.add("strength", strength);
	        characterStats.add("dexterity", dexterity);
	 }

	    
	 public int getMaxHealth() {
	     return maxHealth;
	 }

	 public void setMaxHealth(int value) {
	        
		 if (value < 1)
	        value = 1;

	        maxHealth = value;
	 }

	 public int getCurrentHealth() {
	    return currentHealth;
	 }

	    
	 public void setCurrentHealth(int value) {
	        
		 if (value > maxHealth)
	         value = maxHealth;

	        currentHealth = value;
	 }

	    
	 public int getStrength() {
	        return strength;
	 }

	    
	 public void setStrength(int value) {
	        
		 if (value < 0)
	         value = 0;

	        strength = value;
	 }

	    
	 public int getDexterity() {
	        return dexterity;
	 }

	 public void setDexterity(int value) {
	        
		 if (value < 0)
	         value = 0;

	        dexterity = value;
	}
}
