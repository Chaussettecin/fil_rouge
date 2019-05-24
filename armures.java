package inventory;

import java.util.ArrayList;
import java.util.Arrays;


import Battle.battleNode;

public class armures  extends Equipment{
	
	public String descriptionArmures;
	public String nomArmure;
	 
	public armures(String tempNom, String tempDescription, int tempMinDex, int tempMinStr, 
			int tempDefenseValue, int tempPrix, int tempDexDebuff, int tempSpeedDebuff, 
			int tempMagicResistance) {
		
			super();
	}

	//-- Liste Artmures -- 
		public static ArrayList<armures> getAll() {
			return (new ArrayList<armures>(Arrays.asList(new armures[]{cuire("normale")})));
		}
    
		public static armures cuire(String discription) {
			return new armures("cuire", discription, 5, 5, 10, 50, 1, 1, 0);
		}
		
	public String toString(){
		return ("Equiper de " + descriptionArmures + " " + nomArmure + " armure.");
	}

	public int descriptionArmures() {
		// TODO Auto-generated method stub
		return 0;
	}
}
