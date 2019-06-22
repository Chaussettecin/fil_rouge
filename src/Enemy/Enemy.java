package Enemy;

import java.util.Random;

import Battle.battleAction;
import Effect.statusEffect;
import Enemy.Enemy;


public class Enemy  {
	
	protected static String Nom;
    protected static int ptv;
    private int Level;
    protected static int Degat;
    private int XpRecup;
    private int GoldRecup;
    public static boolean dead = false; //----Verif s'il est est vivant ou pas
	
//---Battle / Status Effect -
	static statusEffect statusEffects;
	battleAction BattleAction;
   	
	private static final Random rand = new Random();

//-- Constructor -
	public Enemy  (String Nom, int ptv, int Degat){

	        this.Nom = Nom;
	        Enemy.ptv = ptv;
	        this.Degat = Degat;
	        this.XpRecup = (Degat + ptv)*2;
	        this.GoldRecup = XpRecup * 2;
	    
	        statusEffects = new statusEffect(false);
    	
    }
// a faire 

// -- Verifie si c'est un boss ou pas --
    public boolean isBoss() {
	return false;
}

    public void receiveDamage(int amount){
        ptv -= amount;
    }

    public boolean isAlive(){
        return ptv > 0;
    }

    public String getNom(){
        return Nom;
    }

    public int getDegat(int input){
        return Degat;
    }

    public int getXpRecup(){
        return XpRecup;
    }

    public static int getPtv(){
        return ptv;
    }
    
    public static int setPtv(int i){
        return ptv;
    }

    public int getGoldRecup(){
        return GoldRecup;
    }

 
    public String toString(){
        return "Ennemi : " + getNom() + ", Niveau de vie : "+ getPtv()+ ", Degats: "+ getDegat(Degat);
    }

	public int getLevel() {
		return Level;
	}

	public void setLevel(int level) {
		Level = level;
	}

	public static Random getRand() {
		return rand;
	}

 }
