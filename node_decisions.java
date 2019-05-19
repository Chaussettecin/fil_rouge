package ui;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class node_decisions extends node{
	
		protected ArrayList<node> nextNodes;

		public node_decisions(node[] tempNextNodes) {
	    
			super();
			
			nextNodes = new ArrayList<node>(Arrays.asList(tempNextNodes));
	  
		}
	 

}
