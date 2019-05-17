package inventory;

import Battle.battleDefence;

public class armures  extends battleDefence{
	 
	public armures(String tempNom, String tempDescription, int tempMinDex, int tempMinStr, 
			int tempDefenseValue, int tempPrix, int tempDexDebuff, int tempSpeedDebuff, 
			int tempMagicResistance) {
		
			super(tempNom, tempDescription, tempMinDex, tempMinStr,  tempDefenseValue, 
			tempPrix, tempDexDebuff,  tempSpeedDebuff, tempMagicResistance);
	}

	public String toString(){
		return ("Equiper de " + description + " " + nom + " armures.");
	}
}
