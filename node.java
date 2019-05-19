package ui;

import perso.Player;

public abstract class node {
	 
	private static node lastMade = null;
	private node nextID;
	private static int count = 0;
	private int id;
	private static node first = null;

		public void Node() {
			count++;
			id = count;
    
			if(lastMade != null) {
				lastMade.setNextByID(this);
			}
			
			lastMade = this;
			
			if(first == null) {
				first = this;
			}
		}

  // returns the next node to go to
  public abstract node process(Player p);

  public int getID() {
  	return id;
  }

  	private void setNextByID(node tempNextID) {
  		nextID = tempNextID;
  	}

  	private node getNextByID() {
  		return nextID;
  	}

  	public static node getNodeByID(int id) {
    
	  node returnValue = first;
    
	  for(int i = 1; i < id; i++) {
		  returnValue = returnValue.getNextByID();
	  }
	  
	  return returnValue;
  	}

 
}
