package perso;

import java.util.concurrent.ThreadLocalRandom;

import ui.UI;

//--- Classe concernant les PNJ dans le jeux - 

	public class NPC extends perso {
	    
		
		public NPC(String name, int lifeMax, int manaMax, int powerMax) {
	        
			super(name, lifeMax, manaMax, powerMax);
	    }

		public void chooseSkill(perso enemy) {
	        if(isKnockedOut()) {
	            return;
	        }

	        if (manaActual == 0) {
	            lifeActual = 0;
	            UI.println(getName() + " gives up because he has no mana.", 1000);
	            return;
	        }

	//-- Choix des skills --
	        int decision;
	       
	        while(true) {
	            
	        	decision = ThreadLocalRandom.current().nextInt(0, 4);

	            // i hope this is an accepted style, but i suspect it isnt
	            if((decision == 1 && healing.getManaRequirement() > manaActual)
	            || (decision == 1 && lifeMax == lifeActual)
	            || (decision == 2 && knockOut.getManaRequirement() > manaActual)
	            || (decision == 3 && poisoning.getManaRequirement() > manaActual)) {
	                continue;
	            } else {
	                break;
	           
	            }
	        }
	        
	        // cast the skill
	        if(decision == 0) {
	            castFireball(enemy);
	        } else if (decision == 1) {
	            castHealing();
	        } else if (decision == 2) {
	            castKnockOut(enemy);
	        } else if (decision == 3) {
	            castPoisoning(enemy);
	        }
	    }

	    

	    public void getStronger(double factor) {
	       
	    	lifeMax *= factor;
	        manaMax *= factor;
	        manaMax += 3;
	        powerMax += factor;

	        lifeActual = lifeMax;
	        manaActual = manaMax;
	        powerActual = powerMax;

	        isKnockedOut = false;
	        isPoisoned[0] = 0;
	        isPoisoned[1] = 0;
	    }
	    
	}
	    