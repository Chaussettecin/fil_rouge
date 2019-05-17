package Battle;

import java.util.ArrayList;

import perso.Player;
import perso.perso;



public class battle {


	//modifie chaque Monst 
	private static ArrayList<perso> initiative
	(ArrayList<perso> monsters, Player player, 
	boolean aportee, boolean rapide) {
	    
	int cible = 0;
	    
	if(aportee) {
	    cible = player.getVitesse() + utils.random(0, 7);
	} else {
	    cible = player.getVitesse() + utils.random(-3, 4);
	}
	    
	ArrayList<Integer> vitesse = new ArrayList<Integer>();
		for(int i = 0; i < monsters.size(); i++) {
			vitesse.add(monsters.get(i).getVitesse() + utils.random(-3, 4));
		}
	
	
	ArrayList<perso> returnMonsters = new ArrayList<perso>();
		for(int i = 0; i < vitesse.size(); i++) {
			if(vitesse.get(i) >= cible && rapide) {
				returnMonsters.add(monsters.get(i));
			}
	   
			if(vitesse.get(i) < cible && !rapide) {
	        returnMonsters.add(monsters.get(i));
			}
		}
		return returnMonsters;
	}

	//Retourne faux si le joueur et mort
	private static boolean joueursSoins(perso perso, ArrayList<perso> vilains, boolean portee) {
	    
		int bloquer = 0;
	    int nonbloquer = 0;
	    UI.out.println("Tu as été attaquer par");
	    
	    ArrayList<perso> attaques = new ArrayList<perso>();
	    ArrayList<battleAttaque> attaquesArmes = new ArrayList<battleAttaque>();
	    
	    for(int i = 0; i < vilains.size(); i++) {
	    	attaques.add(vilains.get(i));
			
	    	if(portee) {
	    		int armesNbre = utils.random(0, vilains.get(i).getutiliserArmesDistance().size());
	    		attaquesArmes.add(vilains.get(i).infligeDegatDistance(armesNbre));
	    		Degats temp = vilains.get(i).infligeDegats(armesNbre);
	    		bloquer += temp.getBloquer();
	    		nonbloquer += temp.getnonBloquer();
	    	
			} else {
	    
				int armesNbre = utils.random(0, vilains.get(i).getArmesDistance().size());
				attaquesArmes.add(vilains.get(i).getUtiliserArMelee());
				Degats temp = vilains.get(i).infligeDegatDistance(armesNbre);
				bloquer += temp.getBloquer();
				nonbloquer += temp.getnonBloquer();
			}
	    }
	    UI.afficheCreatureetArme(attaques, attaquesArmes);
	    
	    int prendre = 0;
	    if(bloquer + nonbloquer > 0) {
	      UI.out.println("Tu as" + bloquer + " dégats " + nonbloquer + "malgré les dégâts venant à ta rencontre");
	      prendre = j.prendDegats(new Degats(bloquer, nonbloquer));
	      
	      if(prendre == 1) {
	        UI.out.println("Tu as presque bloqué cela, mais en raison d'un manque de compétence, tu gagnes 1 points de dégats !");
	      } else if(prendre > 1) {
	        UI.out.println("Hélas! Tu ne peux pas tout bloquer et tu souffres " + prendre + " de dégats");
	      } else {
	        UI.out.println("Tu n'as même pas une égratignure !");
	      }
	    } else {
	      
	    	if(vilains.size() > 1) {
	        UI.out.println("Tes ennemis sont encore plus qualifiés que toi, car ils ne te causent pas 1 point de dégâts!");
	      } else {
	        UI.out.println("Ton ennemi est un adversaire redoutable, car il vient de t'infliger 0 en dégats!");
	      }
	    }
	    
	    int soins = j.soin();
	    
	    if(soins == 1) {
	      UI.out.println("!");
	    }
	    else if(soins > 1) {
	      UI.out.println("Tu n'a pas un diplôme en médecine ou une forte magie pour pouvoir guérir" + soins + "de dégats!");
	    }
	    if(prendre > 0 || soins > 0) {
	      UI.out.println("Maintenant tu as " + j.getConstitution() + "sante");
	    }
	    UI.out.println("Tu as trouvé un pansement et regagné 1 point de santé perdue");
	    return(j.getConstitution() > 0);
	  }

	 //retourne faux s'il n'y a pas de creature
	private static boolean vilainsSoins(perso perso, ArrayList<perso> vilains, int quelVilains, boolean portee) {
	    
		ArrayList<String> rAttaques = new ArrayList<String>();
	    	for(int i = 0; i < perso.getArmesDistance().size(); i++) {
	    		rAttaques.add(perso.getutiliserArmesDistance().get(i).toString());
	    	}
	    
	    ArrayList<String> vAttaques = new ArrayList<String>();
	    	for (int i = 0; i < perso.getUtiliserArMelee().size(); i++) {
	    		vAttaques.add(perso.getUtiliserArMelee().get(i).toString());
	    	}

	    Degats degats;
	    if(portee) {
	      degats perso.infligeDegatDistance(UI.menu("S'il te plait Selectionne ton armes", rAttacks));
	    }
	    else {
	      degats = perso.infligeDegatMelee(UI.menu("S'il te plait Selectionne ton armes", mAttacks));
	    }
	    UI.out.println("Tu as tirer " + vilains.get(quelVilains) + " pour " + degats.getBloquer() + " dégats et " + degats.getnonBloquer() + " blesse.");
	    int prendre = vilains.get(quelVilains).prendDegats(degats);
	    if(prendre > 0) {
	      UI.out.println("their armour cannot completely shield them and they take damage");
	    }
	    else {
	      UI.out.println("alas, their defenses are too strong! you do not get through");
	    }
	    int soigner = vilains.get(quelVilains).soin();
	    if(soigner > 0) {
	      UI.out.println("unfortunately, the " + vilains.get(quelVilains) + " appears to have recovered a little");
	    }
	    if(vilains.get(quelVilains).getConstitution() <= 0) {
	      UI.out.print("Bien joué ! tu as éliminé " + vilains.get(quelVilains) + " et " + monsters.get(whichMonster).getMonsterRating() + "xp!");
	      perso.addXP(vilains.remove(quelVilains).getMonsterRating());
	      if(vilains.size() == 0) {
	        UI.out.println("\n");
	        return false;
	      }
	      else {
	        UI.out.println(" now all that remains are");
	        UI.printMonsters(vilains);
	        UI.out.println("");
	        return true;
	      }
	    }
	    UI.out.println("");
	    return true;
	  }

	  // Lance le combat
	  private static boolean combatenCours(perso perso, combat_node node, boolean aPortee){
	    node.startCombat();
	    
	    ArrayList<perso> monsters = node.monsterList();
	    ArrayList<perso> succes = new ArrayList<perso>();
	   
	    UI.out.println("Tu es courageux pour faire face");
	    //UI.printMonsters(monsters);
	    UI.out.println("");
	    
	    while(!node.combatOver()) {
	      
	    	ArrayList<String> options = new ArrayList<String>();
	    	options.add("flee");
	      
	    	if(aPortee) {
	    		options.add("en mode Charge");
	    		options.add("continuer à se battre à bout portant");
	    	}
	    	else {
	    		options.add("Echapper au combat à distance");
	    		options.add("Continuer les combats rapporchés");
	    	}
	      
	    	switch(UI.menu("Quelle action tu voudrais faire ?", options)) {
	        	case 0:
	        		succes = initiative(monsters, j, aPortee, true);
	        		
	        		if(succes.size() == 0) {
	        			UI.out.println("Bon travail! Tu as réussis à t'en sortir\n!");
	        			return true;
	        
	        		} else {
	        	
	        		UI.out.println("\nDésolé, tu as attrapé par");
	        		//UI.printMonsters(succes);
	          
	        		if(!joueursSoins(j, succes, false)) {
	        			return false;
	        		}
	          
	        		if(aPortee) {
	        			UI.out.println("Tu attaques au contact !");
	        			aPortee = false;
	        		} else {
	        			UI.out.println("Tu restes en contact");
	        		}
	        		UI.out.println("\nMaintenant tu dans la phase principale du combat.");
	        		}
	        		break;
	        
	        	case 1:
	        		if(aPortee) {
	        			aPortee = false;
	        			ArrayList<perso> suprise = initiative(monsters, j, aPortee, false);
	          
	        			if(suprise.size() > 0) {
	        				UI.out.println("Bravo ! tu as Surpris");
	        				//UI.printMonsters(suprise);
	        				ArrayList<String> monsterMenu = new ArrayList<String>();
	            
	        				for(int i = 0; i < suprise.size(); i++) {
	        					monsterMenu.add(suprise.get(i).toString());
	        				}
	            
	        				if(!hitHealMonster(j, suprise, UI.menu("\nTu obtiens une attaque de mêlée surprise supplémentaire! Sur qui voudrais-tu effectuer l'attaque supplémentaire??", monsterMenu), false)) {
	        				return true;
	        				}
	            
	        				UI.out.println("\nMaintenant, voici la phase de combat");
	        			}
	        		}
	        		else {
	          
	        			succes = initiative(monsters, j, aPortee, true);
	        			if(succes.size() == 0) {
	        				
	        				UI.out.println("Bon travail! Malgré la distance!");
	        				aPortee = true;
	        				UI.out.println("\nMaintenant, voici la phase de combat");
	        			}
	        			else {
	        				UI.out.println("désolée, tu as raté ton attaque");
	        				//UI.printMonsters(succes);
	        				if(!joueursSoins(j, succes, false)) {
	        					return false;
	        				}
	            
	        				UI.out.println("Te voici en mélee");
	        				UI.out.println("\nMaintenant, voici la phase de combat");
	        			}
	        		}
	        		break;
	        	case 2: 
	        		break;
	    	}

	      if(!joueursSoins(j, monsters, utils.random(0, monsters.size()), aPortee)) {
	        j.reset();
	        return true;
	      }

	      if(!joueursSoins(j, monsters, aPortee)) {
	        j.reset();
	        return false;
	      }
	    }
	    perso.reset();
	    return true;
	  }

	  public static boolean run(perso perso, combat_node node, boolean aPortee){
	    
		  boolean valRetourne = combatencourt(perso, node, aPortee);
		  perso.reset();
		  return valRetourne;
	  }
}
