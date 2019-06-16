package Quete;

import java.util.ArrayList;

import Inventory.ArmesDistance;
import Inventory.ArmesMelees;
import Inventory.Sort;
import Inventory.Potion;
import Perso.Perso;


public class Quete {

//-- arrayList des quêtes  --- 
	private static final ArrayList<Quete> QuetesList = new ArrayList<>();
   
//-- ArrayList  = Armes et Armures ---
    private final ArrayList<ArmesDistance> recompensesArmures = new ArrayList<>();
    private final ArrayList<ArmesMelees> recompensesArmes = new ArrayList<>();
    private final ArrayList<Sort> recompensesSorts = new ArrayList<>();
    
  //-- ArrayList  = Potion ---
    private final ArrayList<Potion> recompensesPotions = new ArrayList<>();
    
    private String hote;
    //Recompenses
    private int goldRecompenseMin;
    private int goldRecompenseMax;
    private int xpRecompenseMin;
    private int xpRecompenseMax;
    private int santeRecompenseMin;
    private int santeRecompenseMax;
    //Prerequis
    private int minLevelReq;
    private boolean complete;
    private boolean disponible;

    public Quete(String hôte, int goldMin, int goldMax, int xpMin, int xpMax,
                 int santeMin, int santeMax, int minLevel, boolean complete, boolean dispo) {

        this.hote = hôte;
        this.setGoldRecompenseMin(goldMin);
        this.setGoldRecompenseMax(goldMax);
        this.setXpRecompenseMin(xpMin);
        this.setXpRecompenseMax(xpMax);
        this.setSanteRecompenseMin(santeMin);
        this.setSanteRecompenseMax(santeMax);
        this.minLevelReq = minLevel;
        this.complete = complete;
        this.disponible = dispo;
        QuetesList.add(this);
    }
    
    
//--- Quêtes des PNJ --     
    public static boolean checkQuetePrNPC(String npcNom, Perso level) {
        
    	boolean check = false;
        int i = 0;
        
        do {
            
        	if (QuetesList.get(i).hote.equalsIgnoreCase(npcNom)) {
                
        		if (QuetesList.get(i).getMinLevelReq() <= level.getLevel()) {
                    
        			if (QuetesList.get(i).getDisponible())
                        check = !QuetesList.get(i).getComplete();
                
        		}
            
        	}

            i++;

        } while ((i < QuetesList.size()) || (check));
        return check;
    }

    
//--- GETTER & SETTER - 
    public int getMinLevelReq() {
        return minLevelReq;
    }

    public boolean getComplete() {
        return complete;
    }

    public boolean getDisponible() {
        return disponible;
    }


	public ArrayList<Potion> getRecompensesPotions() {
		return recompensesPotions;
	}


	public ArrayList<Sort> getRecompensesSorts() {
		return recompensesSorts;
	}


	public ArrayList<ArmesMelees> getRecompensesArmes() {
		return recompensesArmes;
	}


	public ArrayList<ArmesDistance> getRecompensesArmures() {
		return recompensesArmures;
	}


	public int getGoldRecompenseMin() {
		return goldRecompenseMin;
	}


	public void setGoldRecompenseMin(int goldRecompenseMin) {
		this.goldRecompenseMin = goldRecompenseMin;
	}


	public int getGoldRecompenseMax() {
		return goldRecompenseMax;
	}


	public void setGoldRecompenseMax(int goldRecompenseMax) {
		this.goldRecompenseMax = goldRecompenseMax;
	}


	public int getXpRecompenseMin() {
		return xpRecompenseMin;
	}


	public void setXpRecompenseMin(int xpRecompenseMin) {
		this.xpRecompenseMin = xpRecompenseMin;
	}


	public int getSanteRecompenseMin() {
		return santeRecompenseMin;
	}


	public void setSanteRecompenseMin(int santeRecompenseMin) {
		this.santeRecompenseMin = santeRecompenseMin;
	}


	public int getXpRecompenseMax() {
		return xpRecompenseMax;
	}


	public void setXpRecompenseMax(int xpRecompenseMax) {
		this.xpRecompenseMax = xpRecompenseMax;
	}


	public int getSanteRecompenseMax() {
		return santeRecompenseMax;
	}


	public void setSanteRecompenseMax(int santeRecompenseMax) {
		this.santeRecompenseMax = santeRecompenseMax;
	}
}
