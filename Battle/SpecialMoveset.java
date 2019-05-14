package Battle;

import java.util.ArrayList;

import resource.Util;

public class SpecialMoveset {

//--Nbre de mouv max Pour un joueur par tour - 
	public static int MAX_MOVES = 5;
    public ArrayList<SpecialMove> smoveset;

    public SpecialMoveset() {
    	smoveset = new ArrayList<SpecialMove>();
    }

//--- Ajoute un coup spécial basé sur l'id à l'ensemble
   //--si les contraintes sont respectées
    public void addSMove(int id) {
        
    	if (canAdd(id)) {
            smoveset.add(getMove(id));
        }
    }

    public SpecialMove getMoveAt(int i) {
        return smoveset.get(i);
    }

    //--Clears the smoveset
    public void clear() {
        smoveset.clear();
    }

    public boolean isFull() {
        return smoveset.size() == MAX_MOVES;
    }

//-- Supprime un smove d'un index donné --
    public void remove(int index) {
        smoveset.remove(index);
    }

    public String toString() {
        
    	String ret = "[ ";
        
    	for (int i = 0; i < smoveset.size(); i++) {
            ret += smoveset.get(i).name + (i == smoveset.size() - 1 ? "" : ", ");
        }
        ret += " ]";
        return ret;
    }

//-- Retourne s'il est possible d'ajouter un certain smove à l'ensemble
    	//--Contrainte 1: doit être assez d'espace
    	//--Contrainte 2: le déplacement ne doit pas déjà apparaître deux fois
    public boolean canAdd(int id) {
    	
        if (smoveset.size() == MAX_MOVES) return false;
        int count = 0;
        
        for (int i = 0; i < smoveset.size(); i++) {
            if (smoveset.get(i).id == id) count++;
        }
        return count < 2;
    }

//--Renvoie le smove associé à un identifiant --
    private SpecialMove getMove(int id) {
        
    	switch (id) {
            case Util.DISTRACT: return Util.S_DISTRACT;
            case Util.FOCUS: return Util.S_FOCUS;
            case Util.INTIMIDATE: return Util.S_INTIMIDATE;
            case Util.REFLECT: return Util.S_REFLECT;
            case Util.STUN: return Util.S_STUN;
            case Util.INVERT: return Util.S_INVERT;
            case Util.SACRIFICE: return Util.S_SACRIFICE;
            case Util.SHIELD: return Util.S_SHIELD;
        }
        return null;
    }
}
