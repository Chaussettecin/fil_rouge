package Perso;

import Perso.Perso;

public class Skill {

	  private Perso casterPerso;
	  private String name;
	  private int level;
	  private double value;
	  private int manaRequirement;

	  
//-- Constructor - 
	  public Skill (Perso casterPerso, String name, int level, double value, 
			  		int manaRequirement) {
		  
	        this.casterPerso = casterPerso;
	        this.name = name;
	        this.level = level;
	        // means strength of the skill
	        // multiplicated with level
	        this.value = value;
	        // also multiplicated with level
	        this.manaRequirement = manaRequirement;
	   
	  }

	    public String getName() {
	        return name;
	    }

	    public int getValue() {
	        return (int)(casterPerso.getAttaque(null) * value * level);
	    }

	   
	    public int getLevel() {
	        return level;
	    }

	    public int getManaRequirement() {
	        return manaRequirement * level;
	    }
}
