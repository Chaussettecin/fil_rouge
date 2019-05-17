package Battle;

import java.util.ArrayList;

import resource.ResourceManager;

public class moveSet {

	private ResourceManager rm;

//-- Index : 
	// 0 - acccurate
	// 1  -  wide
	// 2 - critique
	// 3 - soin

	public move[] moveset;
	public String[] names;
	public String[] descriptions;

	public moveSet(ResourceManager rm) {
	        
		 	this.rm = rm;
	        moveset = new move[4];
	        names = new String[4];
	        descriptions = new String[4];
	 }

//-- Reset a Moveset avec 4 nouvelles action random 
	 public void reset(int min, int max, int hp) {
	       
	 		moveset = getRandomMoves();
	        int dmg;

	        for (int i = 0; i < 4; i++) {
	            // reset damage seed for a new value between player's dmg range each iteration
	            dmg = MathUtils.random(min, max);
	            if (moveset[i].type == 3) moveset[i].setHeal(hp);
	            else moveset[i].setDamage(dmg);

	            names[i] = moveset[i].name;
	            // Concatenates move info into a full description
	            if (moveset[i].type < 2) {
	                descriptions[i] = "dmg: " + Math.round(moveset[i].minDamage)
	                        + "-" + Math.round(moveset[i].maxDamage);
	            } else if (moveset[i].type == 2) {
	                descriptions[i] = "dmg: " + Math.round(moveset[i].minDamage) + " + "
	                        + moveset[i].crit + "% to crit";
	            } else {
	                descriptions[i] = "HP: " + Math.round(moveset[i].minHeal)
	                        + "-" + Math.round(moveset[i].maxHeal) + ", -" + moveset[i].dmgReduction
	                        + "% DMG";
	            }
	        }
	    }

	//-- Resets Moveset pour les boss -- 
	public void reset(int min, int max, int hp, int bossId) {
	        
			moveset = getBossMoves(bossId);
	        
			int dmg;// Damage
	        for (int i = 0; i < 4; i++) {
	            
	        	dmg = MathUtils.random(min, max);
	            if (moveset[i].type == 3) moveset[i].setHeal(hp);
	            else moveset[i].setDamage(dmg);
	        }
		}

// -- Returns the first damage move from a moveset
	//-- If there are no damage moves then it returns a random heal move
	public move getDamagePriority() {
	        
			for (int i = 0; i < moveset.length; i++) {
	            
				if (moveset[i].type != 3) {
					return moveset[i];
				}
			}
			return moveset[MathUtils.random(3)];
		}

//-- Returns the first heal move from a moveset
	//--If there are no heal moves, then it returns a random move
	public move getHealPriority() {
	        
			for (int i = 0; i < moveset.length; i++) {
	            
				if (moveset[i].type == 3) {
					return moveset[i];
				}
			}
	        return moveset[MathUtils.random(3)];
		}

//-- Returns a Move array with 4 unique moves chosen from all possible Moves
	private move[] getRandomMoves() {
	        
			ArrayList<move> all = new ArrayList<move>();
	        	all.addAll(rm.accuratemoves);
	        	all.addAll(rm.widemoves);
	        	all.addAll(rm.critmoves);
	        	all.addAll(rm.healmoves);

	        move[] ret = new move[4];
	        int index;
	        
	        for (int i = 0; i < ret.length; i++) {
	           
	        	index = MathUtils.random(all.size() - 1);
	        	move randMove = all.get(index);
	        	move temp = null;

	        	if (randMove.type < 2)
	        		temp = new move(randMove.type, randMove.name, randMove.minDamage, randMove.maxDamage);
	        	else if (randMove.type == 2)
	        		temp = new move(randMove.name, randMove.minDamage, randMove.crit);
	        	else if (randMove.type == 3)
	        		temp = new move(randMove.name, randMove.minHeal, randMove.maxHeal, randMove.dmgReduction);

	        	ret[i] = temp;
	        	all.remove(index);
	        	}

	        return ret;
	    }

	//-- Returns a Move array with 4 unique moves from a boss's movepool
	private move[] getBossMoves(int bossId) {
	       
		ArrayList<move> pool = rm.bossmoves.get(bossId);
	        move[] ret = new move[4];
	        
	        int index;
	        for (int i = 0; i < ret.length; i++) {
	           
	        	index = MathUtils.random(pool.size() - 1);
	            move randMove = pool.get(index);
	            move temp = null;

	            if (randMove.type < 2)
	                temp = new move(randMove.type, randMove.name, randMove.minDamage, randMove.maxDamage);
	            else if (randMove.type == 2)
	                temp = new move(randMove.name, randMove.minDamage, randMove.crit);
	            else if (randMove.type == 3)
	                temp = new move(randMove.name, randMove.minHeal, randMove.maxHeal, randMove.dmgReduction);

	            ret[i] = temp;
	            pool.remove(index);
	        }

	        return ret;
	    }

}
