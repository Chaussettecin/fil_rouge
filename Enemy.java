package Enemy;

import java.util.Random;

import Battle.battleAction;
import Effect.statusEffect;
import Enemy.Enemy;
import Inventory.Sort;
import Perso.Perso;
import Perso.Race;

public abstract class Enemy {
	
	private String Nom;
    private static int ptv;
    private int Level;
    private int Degat;
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
	        this.ptv = ptv;
	        this.Degat = Degat;
	        this.XpRecup = (Degat + ptv)*2;
	        this.GoldRecup = XpRecup * 2;
	    
	        statusEffects = new statusEffect(false);
    	
    }


// -- Verifie si c'est un boss ou pas --
    public abstract boolean isBoss();

    public void receiveDamage(int amount){
        ptv -= amount;
    }

    public boolean isAlive(){
        return ptv > 0;
    }

    public String getNom(){
        return Nom;
    }

    public int getDegat(){
        return Degat;
    }

    public int getXpRecup(){
        return XpRecup;
    }

    public int getPtv(){
        return ptv;
    }

    public int getGoldRecup(){
        return GoldRecup;
    }

    @Override
    public String toString(){
        return "Ennemi : " + getNom() + ", Niveau de vie : "+ getPtv()+ ", Degats: "+ getDegat();
    }
		
 }
