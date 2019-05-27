package ui;

import Player.Player;

public abstract class node {
	
	private node nextID;
	private static node first = null;
	private static node lastMade = null;
	
	private int id;
	private static int count = 0;
	

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
