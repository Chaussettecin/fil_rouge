package Battle;

import java.util.ArrayList;

import resource.ResourceManager;

public class statusSet<SpriteBatch> {

//-- status icons
    public ArrayList<statusEffect> effects;
    private boolean player;
    private ResourceManager rm;

    public statusSet(boolean player, ResourceManager rm) {
        
    	this.player = player;
        this.rm = rm;
        effects = new ArrayList<statusEffect>();
   
    }

 
// -- Adds an effect to the list if the effect is not already in it
    public void addEffect(int effect) {
        
    	if (findEffect(effect) == -1) {
            effects.add(new statusEffect(effect, rm));
        }
    }

    public void clear() {
        effects.clear();
    }


//-- Removes all multi turn status effects --
    public void clearAllButSingleTurnEffects() {
        
    	for (int i = 0; i < effects.size(); i++) {
           
    		if (effects.get(i).type == statusEffect.DMG_RED) {
                effects.remove(i);
            }
        
    	}
    }

    
// -- Removes all single turn status effects --
    public void clearAllButMultiTurnEffects() {
        for (int i = 0; i < effects.size(); i++) {
            if (effects.get(i).type != statusEffect.DMG_RED) {
                effects.remove(i);
            }
        }
    }

  
//--- Returns if the set contains a certain effect -
    public boolean contains(int effect) {
        return findEffect(effect) != -1;
    }

    
//--Returns the index of an effect
    // Returns -1 if not in set
    public int findEffect(int effect) {
       
    	for (int i = 0; i < effects.size(); i++) {
            
    		if (effects.get(i).type == effect)
                return effects.get(i).type;
        }
        return -1;
    }

  
//--- Player's status bar renders from left to right = return Batch
    public void render(SpriteBatch batch) {
       
    	for (int i = 0; i < effects.size(); i++) {
           
        	statusEffect s = effects.get(i);
            
        	if (player) {
                if (s != null) batch.draw(s.icon, 1 + (i * 11), 90);
            } else {
                if (s != null) batch.draw(s.icon, 189 - (i * 11), 90);
            }
        }
    }
}
