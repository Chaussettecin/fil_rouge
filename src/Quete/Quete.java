package Quete;

import java.util.ArrayList;

import Npc.Npc;

import Perso.Perso; 

import Inventory.Sort;
import Inventory.Potion;
import Inventory.ArmesDistance;
import Inventory.ArmesMelees;

//--- Classe Quetes -- 

public class Quete {
	
    Npc npc;

//-- arrayList des quêtes  --- 
	private static final ArrayList<Quete> QuetesList = new ArrayList<>();
   
//-- ArrayList  = Potion ---
    private final ArrayList<Potion> recompensesPotions = new ArrayList<>();
	
//-- ArrayList  = Armes et Armures ---
	private final ArrayList<Sort> recompensesSorts = new ArrayList<>();
    private final ArrayList<ArmesDistance> recompensesArmures = new ArrayList<>();
    private final ArrayList<ArmesMelees> recompensesArmes = new ArrayList<>();
       
//-- Prerequis
    private int minLevelReq;
    private boolean complete;
    private boolean disponible;
    
 //-- Recompenses --
    private int xpRecompenseMin;
    private int xpRecompenseMax;
    private int goldRecompenseMin;
    private int goldRecompenseMax;
    private int santeRecompenseMin;
    public static int santeRecompenseMax;
   
    public Quete (	Npc npc, int goldMin, int goldMax, 
    				int xpMin, int xpMax, int santeMin,
    				int santeMax, int minLevel, 
    				boolean complete, boolean dispo ) {
    				
               
        	this.npc = npc;
        	this.disponible = dispo;
        	this.complete = complete;
        	this.minLevelReq = minLevel;
        	this.setSanteRecompenseMax(santeMax);
        	this.setGoldRecompenseMin(goldMin);
        	this.setGoldRecompenseMax(goldMax);
        	this.setXpRecompenseMin(xpMin);
        	this.setXpRecompenseMax(xpMax);
        	this.setSanteRecompenseMin(santeMin);
        	
        	QuetesList.add(this);
    }
    
    
 /*
  * Check Quetes données par les NPC
  */    
    public static boolean checkQuetePrNPC(Npc npc, Perso level) {
        
    	boolean check = false;
        int i = 0;
        
        do {
            
        	if (QuetesList.get(i) != null) {
                
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
    
    public int getMinLevelReq() { return minLevelReq;}

    public boolean getComplete() { return complete; }

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

	public int getGoldRecompenseMin() { return goldRecompenseMin; }

	public void setGoldRecompenseMin(int goldRecompenseMin) {
		this.goldRecompenseMin = goldRecompenseMin;
	}

	public int getGoldRecompenseMax() {return goldRecompenseMax;}


	public void setGoldRecompenseMax(int goldRecompenseMax) {
		this.goldRecompenseMax = goldRecompenseMax;
	}


	public int getXpRecompenseMin() { return xpRecompenseMin; }


	public void setXpRecompenseMin(int xpRecompenseMin) {
		this.xpRecompenseMin = xpRecompenseMin;
	}


	public int getSanteRecompenseMin() { return santeRecompenseMin;}


	public void setSanteRecompenseMin(int santeRecompenseMin) {
		this.santeRecompenseMin = santeRecompenseMin;
	}


	public int getXpRecompenseMax() { return xpRecompenseMax;}


	public void setXpRecompenseMax(int xpRecompenseMax) {
		this.xpRecompenseMax = xpRecompenseMax;
	}


	public int getSanteRecompenseMax() { return santeRecompenseMax;}


	public void setSanteRecompenseMax(int santeRecompenseMax) {
		this.santeRecompenseMax = santeRecompenseMax;
	}
	
}
