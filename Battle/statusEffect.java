package Battle;

import resource.ResourceManager;

public class statusEffect {

//Types des effets
	    public static int DMG_RED = 0;
	    public static int DISTRACT = 1;
	    public static int FOCUS = 2;
	    public static int INTIMIDATE = 3;
	    public static int REFLECT = 4;
	    public static int STUN = 5;
	    public static int INVERT = 6;
	    public static int SHIELD = 7;
	    public static int SACRIFICE = 8;

	    public int type;
	    
	   
	    //public TextureRegion icon;

	    public statusEffect(int type, ResourceManager rm) {
	        this.type = type;
	        //icon = rm.statuseffects20x20[type];
	    }


		public void add(int dISTRACT2) {
			// TODO Auto-generated method stub
			
		}



}
