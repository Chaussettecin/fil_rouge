package Battle;

import java.util.ArrayList;

import Enemy.Cultiste;
import Npc.Npc;
import Perso.Perso;
import Perso.PersoStats;

public class BattleFight {

	static Npc randNpc;
	static Perso equipePerso;
	static Cultiste randCultist;
	
	private static boolean isAdventureOver;
	
	public BattleFight(ArrayList<Perso> persoArray, Cultiste cult) {
		
	}

	public static void fight(){

		while (!isAdventureOver){
        
			equipePerso.recoitDegat(randCultist.getDegat());
			randCultist.receiveDamage(equipePerso.getStats().getStrength());

			System.out.println(equipePerso.getNom() + " deals " + PersoStats.getStats().getStrength() + " damage!");
			System.out.println(randCultist.getNom() + " deals " + randCultist.getDegat() + " damage back at you!");
			System.out.println("Health of " + equipePerso.getNom()  + PersoStats.getStats().getCurrentHealth() + ". "
                + randCultist.getNom() + " 's Health: " + randCultist.getDegat());
        
			try {
				Thread.sleep(500);
       
			} catch (InterruptedException e) {
				e.printStackTrace();
        
			}
        
			isAdventureOver = !randCultist.isAlive();
			
			}
		
		equipePerso.addXP(randCultist.getXpRecup(), "");
		equipePerso.addMoney(randCultist.getGoldRecup());
		
		//System.out.println("The Battle has ended. " + equipPerso.getNom() + " Wins!");
		//System.out.println("Gold Looted: " + randEnemy.getGoldRecup() + ", Earned XP: " + randEnemy.getXpRecup() );
	}
	
	public void doAdventure(){
		isAdventureOver = false;
		
	}
}
