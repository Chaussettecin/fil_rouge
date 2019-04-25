package rpg_filrouge;

import fantasy_RPG.Armor;
import fantasy_RPG.MeleeWeapon;
import fantasy_RPG.RangedWeapon;
import fantasy_RPG.Spell;

public class perso_cultiste {

	private int chance, charisme;
	private int xp;
	private int level;
	private String classeNom;
	private String metierPerso;
	
	public perso_joueurs (String tempclassName, String tempName, MeleeWeapon[] tempMeleeWeapons, RangedWeapon[] tempRangedWeapons, Spell[] tempSpells, Armor[] tempArmor, int tempStrength, int tempConstitution, int tempDexterity, int tempSpeed, int tempIntelligence, int tempWizardry, int tempLuck, int tempCharisma, int tempHealRate, int tempGP) {
		    super(tempName, tempMeleeWeapons, tempRangedWeapons, tempSpells, tempArmor, tempStrength, tempConstitution, tempDexterity, tempSpeed, tempWizardry, tempIntelligence, tempHealRate, tempGP);
		    
		    
		    nomClasse = tempClasseName;
		    chance = tempChance;
		    charisme = tempCharisme;
		    xp = 0;
		    level = 1;
	}
	 
	public perso_joueurs(String tempclassName, String tempName, MeleeWeapon[] tempMeleeWeapons, RangedWeapon[] tempRangedWeapons, Spell[] tempSpells, Armor[] tempArmor, int tempStrength, int tempConstitution, int tempDexterity, int tempSpeed, int tempIntelligence, int tempWizardry, int tempLuck, int tempCharisma, int tempHealRate, int tempGP, int tempXP, int tempLevel) {
		    super(tempName, tempMeleeWeapons, tempRangedWeapons, tempSpells, tempArmor, tempStrength, tempConstitution, tempDexterity, tempSpeed, tempWizardry, tempIntelligence, tempHealRate, tempGP);
		    
		    nomClasse = tempClasseName;
		    chance = tempChance;
		    charisme = tempCharisme;
		    xp = 0;
		    level = 1;
	}
	 
	public String toString() {
		    return nom;
	}
	
	public void addXP(int EnemisXP){
		xp += monsterXP;
	}
	
	public int getXP(){
		return xp;
	}
	
	public int getLevel() {
		return level;
	}
		  
	public String getClassName() {
		 return className;
	}
	
	public int getIntelligence() {
		 return intelligence;
	}
	
	public int getLuck() {
		 return luck;
	}
		  
	public int getCharisme() {
		 return charisme;
	}
}
