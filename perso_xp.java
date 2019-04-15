package fantasy_RPG;
import javax.swing.*;

							/////classe gestion de l' XP du personnage 

public class joueurs_xp {
	
//Variables
private static int xp;
private static int combatXP;
private static int xpManquant;
private static int level;
public static int totale;

   
private static void levelUp() {
    if (level == 9) {
        ui.popup("Vous avez gagné un niveau !\n Tu as gagné 250 Golds!", "Level Up !",JOptionPane.INFORMATION_MESSAGE);
        level = 10;
        gold.set(250, true);

	} else if(level > 100){
		support.error("Erreur- Les niveau de ce jeu ne dépasse pas 100");
        level = 100;
        
	} else if(level == 99){
        level = 100;
        xp = 49000;
        
	}else {
		ui.popup("Level Up ! Maintenant tu es" + (level + 1) + "!\n Tu remportes 100 Golds!","Level Up !" ,JOptionPane.INFORMATION_MESSAGE);
		xp = 0;
		xpManquant += 500;
		level++;
		gold.set(100, true);
	}//Fin if
        
	joueurs_mission.check();
 }//fin levelUp()

	
 public static void set(int montant, boolean add) {
     if((level == 100) || soluces.activer()){
    	 return;
     }
        
     if (add){
         xp += montant;
         totale += montant;
     } else {
         xp = montant;
     }
        
	if ((xp >= xpManquant) && (xpManquant != 0)){
		int xpRestant = xp - xpManquant;
        levelUp();
        set(xpRestant, true);
	}
 }//fin set
	
public static int getCombatXp() {
	return combatXP;
}
	
public static void setCombatXp(int montant, boolean add) {
		
	if(add) {
		combatXP += montant;
	} else {
		combatXP = montant;
	}
} //fin setCombatXP

public static void setLevel(int lvl){
	level = lvl;
}
	
public static void setOutOf(int outOf){
	xpManquant = outOf;
}
	
public static void setAll(int actuel, int outOf, int lvl){
    xp = actuel;
    xpManquant = outOf;
    level = lvl;
}

public static int get(){
	return xp;
}

public static int getOutOf(){
	return xpManquant;
}

public static int getLevel(){
	return level;
}

public static String getFull(){
	return xp + "/" + xpManquant + " xp";
}

}//fin classe

