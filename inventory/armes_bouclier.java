package inventory;

import Battle.battleDefence;

public class armes_bouclier extends battleDefence {
	
	public armes_bouclier (String tempName, String tempDescriptor, int tempMinDex, int tempMinStr, int tempDefenseValue, int tempPrice, int tempDexDebuff, int tempSpeedDebuff, int tempMagicResistance) {
		  super( tempName,tempDescriptor, tempMinDex, tempMinStr, tempDefenseValue, tempPrice, tempDexDebuff,  tempSpeedDebuff,  tempMagicResistance);
	}
}
