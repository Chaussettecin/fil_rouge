package rpg_filrouge;

import java.util.ArrayList;
import java.util.Arrays;


public class race {
	//---  Classe qui concerne l'ensemble des personnages du jeux. 
	
	   protected String nom;
	   protected ArrayList<equipement_armes> arrayArmes;
	   protected ArrayList<equipement_pouvoirs> arrayPowers;
	   protected ArrayList<equipement_armure> arrayArmures;
	   protected int soinsC;
	   protected int slogan;
	   protected int taille, constitution, dexterite, vitesse, magie, intelligence;
	   protected int modifieTaille, modifieConstitution, modifieDexterite, modifieVitesse, modifieMagie, modifieIntelligence;
	   protected int gp;

	public race (String tempNom, equipement_armes[] tempArmes, 
			equipement_pouvoirs[] tempPower, equipement_armure[] tempArmure, 
			int tempTaille, int tempConstitution, int tempDexterite, int tempVitesse, 
			int tempMagie, int tempIntelligence,  int tempSoinC, int tempGP, 
			int modifieIntelligence) {
		 
		nom = tempNom;
		arrayArmes = new ArrayList<equipement_armes>(Arrays.asList(tempArmes));
		arrayPowers = new ArrayList<equipement_pouvoirs>(Arrays.asList(tempPower));
		arrayArmures = new ArrayList<equipement_armure>(Arrays.asList(tempArmure));
		taille = tempTaille;
		constitution = tempConstitution;
		dexterite = tempDexterite;
		vitesse = tempVitesse;
		magie = tempMagie;
		intelligence = tempIntelligence;
		modifieTaille = tempTaille;
		modifieConstitution = constitution;
		modifieDexterite = dexterite;
		modifieVitesse = vitesse;
		modifieMagie = magie;
		modifieIntelligence = intelligence;
		soinsC = tempSoinC;
		gp = tempGP;
		}

	public Degats infligeDegats(int armesNbre) {
		  
			if(armesNbre >= 0 && armesNbre < getUtiliseContactAttaques().size()) {  
				return getUtiliseContactAttaques().get(armesNbre).degats(this);
			}
			return new Degats(0, 0);
	}
	
		
	public Degats infligeDegatsDistance(int armesNbr) {
		  if(armesNbr >= 0 && armesNbr < getUtiliseAttaqueDist().size()) {
		   return getUtiliseAttaqueDist().get(armesNbr).degats(this);
		  }
		 return new Degats(0, 0);
		}

	public ArrayList<ArmeMelee> getArmeMelee() {
		  return armeMelee;
	}
		
	public ArrayList<ArmesDistance> getArmesDistance() {
		return armesDistance;
	}
		
	public ArrayList<Sorts> getSorts() {
			return sorts;
	}
		
	public ArrayList<Armures> getArmures() {
			return armures;
		}
		
		
	public ArrayList<ArmeMelee> getUtiliserArMelee() {
		  
		ArrayList<ArmeMelee> returnList = new ArrayList<ArmeMelee>();
		  
		for(int i = 0; i < armeMelee.size(); i++) {
		    if(armeMelee.get(i).canUse(this)) {
		      returnList.add(armeMelee.get(i));
		    }
		  }
		  if(returnList.size() == 0) {
		    returnList.add(MakeMeleeWeapon.rock("normal"));
		  }
		  return returnList;
		}
		
		
	public ArrayList<AttaqueDistance> getutiliserArmesDistance() {
		  ArrayList<AttaqueDistance> attaqueDistance = new ArrayList<AttaqueDistance>();
		  
		  attaqueDistance.addAll(armesDistance);
		  attaqueDistance.addAll(sorts);
		  ArrayList<AttaqueDistance> returnList = new ArrayList<AttaqueDistance>();
		  for(int i = 0; i < attaqueDistance.size(); i++) {
		    if(attaqueDistance.get(i).canUse(this)) {
		      returnList.add(attaqueDistance.get(i));
		    }
		  }
		  if(returnList.size() == 0) {
		    returnList.add(MakeRangedWeapon.rock("normal"));
		  }
		  return returnList;
		}


	public int getTaille() {
		  return modifieTaille;
	}
		
	public int getConstitution() {
		 return modifieConstitution;
	}
		
	public int getDexterite() {
		 return modifieDexterite;
	}
		
	public int getVitesse() {
		  if (armures.size() > 0){
		    return (modifieVitesse - armures.get(0).getSpeedDebuff());
		  }
		  	return vitesse;
		}
			
	public int getMagie() {
			return modifieMagie;
	}
		
	public int getIntelligence() {
			return modifieIntelligence;
	}
		
	public int getDefenseVal() {
		if (armures.size() > 0){
			return (armures.get(0).getDefenseVal());
		}
		return 0;
	}
			
	public int getSoinContact() {
			return soinsC;
	}
		
	public void reset(){
		 modifieTaille = taille;
		 modifieConstitution = constitution;
		 modifieDexterite = dexterite;
		 modifieVitesse = vitesse;
		 modifieMagie = magie;
		 modifieIntelligence = intelligence;
	}

	public int prendDegats(Degats degats){
			
		if (equipement_armure.size() > 0){
				
			int toucher = degats.getBloquer() - equipement_armure.get(0).getDefenseVal();
				toucher = toucher > 0 ? toucher : 0;
				toucher += degats.getnonBloquer();
				modifieConstitution -= toucher;
				return toucher;
			} else {
	    
				int toucher = (degats.getBloquer() + degats.getnonBloquer());
				modifieConstitution -= toucher;
				return toucher;
			}
	}
 
			
	public Degats infligeDegatMelee(int armesNum) {
			  
		if(armesNum >= 0 && armesNum < getUtiliserArMelee().size()) {
			return getUtiliserArMelee().get(armesNum).degats(this);
		}
		return new Degats(0, 0);
	}
	
	public Degats infligeDegatDistance(int armesNum) {
	  
		if(armesNum >= 0 && armesNum < getutiliserArmesDistance().size()) {
			return getutiliserArmesDistance().get(armesNum).degats(this);
		}
		return new Degats(0, 0);
	}
    
	public int castSort(int magCost) {
		return (modifieMagie -= magCost);
	}
    
	public int soin(){
		constitution += soinsC;
		return soinsC;
	}
   
}
