package Battle;


public class StatusEffect extends Effect{
	
	
public StatusEffect(Effect other) {
		super(other);
		
	}

//--- Types des effets -- 
	
    public static int DMG_RED = 0;
    public static int DISTRACT = 1;
    public static int FOCUS = 2;
    public static int INTIMIDATE = 3;
    public static int REFLECT = 4;
    public static int STUN = 5;
    public static int INVERT = 6;
    public static int SHIELD = 7;
    public static int SACRIFICE = 8;

    public boolean type;


   
}
