package Effect;

public class effect {
	
	protected String nom;
	protected int strMod, dextMode, mageMode, intelMode, construcMode, 
					vitesseMode, chanceMode, charisMode;
	
	public effect (String tempNom, int tempStrMod, int tempdextMode, 
					int tempmageMode, int tempintelMode, 
					int tempconstrucMode, int tempvitesseMode, 
					int tempcharisMode, int tempchanceMode) {
		  
			nom = tempNom;
			strMod = tempStrMod;
			dextMode = tempdextMode;
			mageMode = tempmageMode;
			intelMode = tempintelMode;
			construcMode = tempconstrucMode;
			vitesseMode = tempvitesseMode;
			charisMode = tempcharisMode;
			chanceMode = tempchanceMode;
	}
		 
	public String toString(){
		  return nom;
	}
	
	public int filtreTaille(int initialeTaille){
		 return (initialeTaille + strMod);
	}
		 
	public int filtreDext(int intialDext){
		 return (intialDext + dextMode);
	}
	
	public int filtreMage(int intialMage){
		 return (intialMage + mageMode);
	}
	
	public int filtreIntel(int intialeIntel){
		 return (intialeIntel + intelMode);
	}
		 
	public int filtreConstr(int intialConstr){
		 return (intialConstr + construcMode);
	}
	
	public int filtreVit(int intialeVitess){
		 return (intialeVitess + vitesseMode);
	}
	
	public int filtreChar(int intialChar){
		 return (intialChar + charisMode);
	}
		 
	public int filtreChance(int intialeChance){
		 return (intialeChance + chanceMode);
	}

}
