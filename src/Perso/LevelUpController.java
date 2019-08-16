package Perso;

import java.util.ArrayList;
import java.util.List;

/* 
 *  Controller de level Up
 */

public class LevelUpController {
	
	private static LevelUpOption[] options = new LevelUpOption[] {
			
		new LevelUpOption("Augmentation des points de vie") {
				
			public void invoke(Perso perso) {
					perso.setPtv(10, name);
					perso.addXP(10, "KO bonus de niveau de Pt de vie augmenté?");
					//perso.doAction("Beaucoup plus en forme");
				}
			
		}, 
		
		new LevelUpOption("Augmentation du mana") {
				
				public void invoke(Perso perso) {
					perso.modifMana(5);
					perso.modifMana(5);
					//perso.doAction("avoir l'air encore plus magique");
				}
			
		}, 
		
		new LevelUpOption("Valeur d'attaque accrue") {
				
				public void invoke(Perso perso) {
					perso.modifAttaque(2);
					//perso.doAction("avoir l'air plus fort");
				}
			
		}, 
		
		new LevelUpOption("Valeur de défense accrue") {
				
			public void invoke(Perso perso) {
					perso.modifDefValeur(1);
					//perso.doAction("avoir l'air un peu plus difficile");
				}
			
		}, 
			 
		
		new LevelUpOption("Augmentation de la régénération du Mana") {
			
			public void invoke(Perso perso) {
					
				perso.modifMana(10);
				//perso.doAction("Avoir l'air un peu moins fatigué");
				
			}
		} 
			
	};

	public void autoLevelUp(Perso perso) {
		options[(int) (Math.random() * options.length)].invoke(perso);
	}

	
	public List<String> getLevelUpOptions() {
		   List<String> names = new ArrayList<String>();
		
		  for (LevelUpOption option : options) {
			  names.add(option.name());
		   }
		   
		return names;
	}

	
	public LevelUpOption getLevelUpOption(String name) {
		
			for (LevelUpOption option : options) {
			
				if (option.name().equals(name))
					return option;
			}
		
			return null;
	}


}
