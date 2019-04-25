package rpg_filrouge;

import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JOptionPane;


public class perso_sante {

	public static int 	nbXKO;
	private static int 	sante;
	private static int 	outOf;
	
	private static int 	UPGRADE_PRIX;
	
	private perso_sante(){
	}
	
	public static String getStr() {
		return sante + "/" + outOf;
	}

	public static int get() {
		return sante;
	}

	public static int getOutOf() {
		return outOf;
	}

public static void set(int s) {
	sante = s;
}

public static void set(int s, int sOutOf) {
	sante = s;
	outOf = sOutOf;
}

public static void setAugmPrix(int prix) {
		UPGRADE_PRIX = prix;
		}

	public static void gains(int s) {
		sante += s;	
			if (sante > outOf) {
				sante = outOf;
			}
	}

	private static void lose(int s) {
		sante -= s;
		if (sante <= 0) {
			KO();
		}
	}

public static void KO() {
	float randomGoldPerdu = ThreadLocalRandom.current().nextInt(25, 51); //entre 25 % et 50%
	int goldPerdu = Math.round(gold.get() * (randomGoldPerdu / 100));		
	ui.popup("Oupss... Tu es mort, tu perds " + goldPerdu + " Gold(s).","Game Over !", JOptionPane.WARNING_MESSAGE);
	gold.set(-(goldPerdu), true);
	stats.tuer = 0;		
	joueurs_sante.set(joueurs_sante.getOutOf());			
	nbXKO++;
}//KO

public static void prendreDegats(int degat) {
	if (setting.getModeBourrin()) {
	degat = 0;
}
			
		double resistance = equipement_armure.getEquiper().getRestDegatst() / 100.0;
		degat = (int) (degat - (degat * resistance));

		ui.cls();
		ui.println("------------------------------------------------------------");
		ui.println("Tu as été touché par " + joueurs_ennemis.get().getNom() + "!");
		ui.println("Tu as perdu " + degat + " santé.");
		ui.println("------------------------------------------------------------");
		ui.println("Ta santé est de : " + (sante - degat));
		ui.println("La santé de ton énemi : " + joueurs_ennemis.get().getSanteStr());
		ui.println("----------------------------------------------------");
		ui.pause();
		joueurs_sante.lose(degat);
    
}//fin prendre egats

private static int getLevel() {
	//Mise à jiveau de l'état de santé
	switch (getOutOf()) {
        	case 100:
        		return 0;
        	case 110:
        		return 1;
        	case 120:
        		return 2;
        	case 130:
        		return 3;
        	case 140:
        		return 4;
        	case 150:
        		return 5;
        	case 160:
        		return 6;
        	case 170:
        		return 7;
        	case 180:
        		return 8;
        	case 190:
        		return 9;
        	case 200:
        		return 10;
        	default:
            support.error("Récupération du niveau de santé - IMPOSSIBLE !");
            return 0;
		}
	}

// Mise à niveau de la sante
	public static void upgrade() {
		while (true) {
			
			//verif si le joueur ne l'as pas deja fait
			if (joueurs_sante.getOutOf() == 200) {
				ui.msg("Tu es tout neuf");
				return;
			}
				
			//Calcul la possibilité de la remise en forme
			int sante = getOutOf() + 10;

			//Verifier si la sante max de 200 n'est pas toucher
			if (sante > 200) {
				sante = 200;
			}

		ui.cls();
		ui.println("------------------------------------------------------------|");
		ui.println("                        ** Remise en forme **              	|");
		ui.println("Tu peux te remettre en forme jusqu'à 200 max.\r\n" );
		ui.println("                       -----------------                    |");
		ui.println("Chaque réparation physique coûte : " + UPGRADE_PRIX + " Golds.");
		ui.println();
		ui.println("Ta santé actuelle : " + getStr());
		ui.println();
		ui.println("1) Te revoilà en forme avec " + sante + " santé.");
		ui.println("2) Retour");
		ui.println("-------------------------------------------------------------");

        if (ui.getValidInt() == 1) {
        	//niveau nécessaire pour upgrade
            int level = getLevel() + 1;
            
            if ((joueurs_xp.getLevel() >= level) && (gold.get() >= UPGRADE_PRIX)) {
                
            	//Santé max
                if (getLevel() == 10) {
                	ui.msg("Vous n'êtes pas un chat :) vous n'avez pas 7 vies");
                }//fin if
                	
                //Upgrade sante
                joueurs_sante.set(sante, sante);
                gold.set(-UPGRADE_PRIX, true);

            	ui.msg("Ta santé sera augmentée ! Youhou !!");
         
            } else {
                ui.cls();
                ui.println("Mise à jours du niveau, es tu au moins au");
                ui.println("level " + level + ", et tu as au moins" + UPGRADE_PRIX + " Golds.");
                ui.println();
                ui.println("Level: " + joueurs_xp.getLevel());
                ui.println("Golds : " + gold.get());
                ui.pause();
            }//fin if
            
        } else {
        	return;
        }
    
		}//fin while

	}//fin Upgrade

}
