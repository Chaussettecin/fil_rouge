package Battle;

import java.util.ArrayList;

import Degat.degat;
import perso.Player;
import perso.enemy;
import perso.perso;
import resource.utilsGame;
import rpg.Degats;
import rpg.combat_attaque;
import rpg.perso_Mons;
import rpg.perso_joueurs;
import rpg.utils;
import ui.UI;


public class battle {

//-- Modifie chaque enemis  --
	private static ArrayList<enemy> initiative ( ArrayList<enemy> ennemis, 
					perso Perso, boolean aportee, boolean rapide) {
	    
			int cible = 0;
	
			if(aportee) {
				cible = Perso.getJustesse() + utilsGame.random(0, 7);
			
			} else {
				cible = Perso.getJustesse() + utilsGame.random(-3, 4);
			
			}
		    
			ArrayList<Integer> vitesse = new ArrayList<Integer>();
			
			for(int i = 0; i < ennemis.size(); i++) {
				vitesse.add(ennemis.get(i).getVitesse() + utilsGame.random(-3, 4));
			}
		
			ArrayList<enemy> returnMonsters = new ArrayList<enemy>();
		
			for(int i = 0; i < vitesse.size(); i++) {
		   
				if(vitesse.get(i) >= cible && rapide) {
					returnMonsters.add(ennemis.get(i));
				}
		   
				if(vitesse.get(i) < cible && !rapide) {
					returnMonsters.add(ennemis.get(i));
				}
			}
			return returnMonsters;
	}


//-- Retourne faux si le joueur et mort --
	private static boolean joueursSoins(perso  Perso, ArrayList<enemy> ennemis, 
										boolean portee) {
	    
		int bloquer = 0;
	    int nonbloquer = 0;
	    
	    UI.out.println("Tu as été attaquer par");
	    
	    ArrayList<enemy> attaques = new ArrayList<enemy>();
	    ArrayList<battleAttaque> attaquesArmes = new ArrayList<battleAttaque>();
	    
	    for(int i = 0; i < ennemis.size(); i++) {
	    	attaques.add(ennemis.get(i));
			if(portee) {
	    		int armesNbre = utilsGame.random(0, ennemis.get(i).getutiliserArmesDistance().size());
	    		attaquesArmes.add(ennemis.get(i).infligeDegatDistance(armesNbre));
	    		
	    		degat temp = ennemis.get(i).infligeDegats(armesNbre);
	    		bloquer += temp.getBloquer();
	    		nonbloquer += temp.getnonBloquer();
	    	
			} else {
	    
				int armesNbre = utilsGame.random(0, ennemis.get(i).getArmesDistance().size());
				attaquesArmes.add(ennemis.get(i).getUtiliserArMelee());
				
				degat temp = ennemis.get(i).infligeDegatDistance(armesNbre);
				bloquer += temp.getBloquer();
				nonbloquer += temp.getnonBloquer();
			}
	    }
	    UI.afficheCreatureetArme(attaques, attaquesArmes);
	    
	    int prendre = 0;
	    if(bloquer + nonbloquer > 0) {
	      
	    	UI.out.println("Tu as" + bloquer + " dégats " + nonbloquer + "malgré les dégâts venant à ta rencontre");
	    	prendre = Perso.heal((new degat(bloquer, nonbloquer));
	      
	    	if(prendre == 1) {
	    		UI.out.println("Tu as presque bloqué cela, mais en raison d'un manque de compétence, tu gagnes 1 points de dégats !");
	    	} else if(prendre > 1) {
	    		UI.out.println("Hélas! Tu ne peux pas tout bloquer et tu souffres " + prendre + " de dégats");
	    	} else {
	    		UI.out.println("Tu n'as même pas une égratignure !");
	    	}
	    } else {
	      
	    	if(ennemis.size() > 1) {
	    		UI.out.println("Tes ennemis sont encore plus qualifiés que toi, car ils ne te causent pas 1 point de dégâts!");
	    	} else {
	    		UI.out.println("Ton ennemi est un adversaire redoutable, car il vient de t'infliger 0 en dégats!");
	    	}
	    }
	    
	    int soins = Perso.heal();
	    
	    if(soins == 1) {
	      UI.out.println("!");
	    }
	    else if(soins > 1) {
	      UI.out.println("Tu n'a pas un diplôme en médecine ou une forte magie pour pouvoir guérir" + soins + "de dégats!");
	    }
	    if(prendre > 0 || soins > 0) {
	      UI.out.println("Maintenant tu as " +  Perso.getHeal(0) + "sante");
	    }
	    UI.out.println("Tu as trouvé un pansement et regagné 1 point de santé perdue");
	    return(Perso.getHeal() > 0);
	  }


		 
//-- retourne faux s'il n'y a pas de creature --		
	private static boolean vilainsSoins(perso Perso, ArrayList<enemy> ennemis, 
							int quelVilains, boolean portee) {
		    
			ArrayList<String> rAttaques = new ArrayList<String>();
				
			for(int i = 0; i < Perso.getArmure().size(); i++) {
					rAttaques.add(Perso.getutiliserArmesDistance().get(i).toString());
			}
		    
		    ArrayList<String> vAttaques = new ArrayList<String>();
		    	
		    for(int i = 0; i < Perso.getArmure().size(); i++) {
		    		vAttaques.add(Perso.getUtiliserArMelee().get(i).toString());
		    }

		    degat degats;
		    
		    if(portee) {
		      degats = Perso.infligeDegatDistance(UI.menu("S'il te plait Selectionne ton armes", rAttacks));
		    } else {
		      degats = Perso.infligeDegatMelee(UI.menu("S'il te plait Selectionne ton armes", mAttacks));
		    }
		    
		    UI.out.println("Tu as tirer " + ennemis.get(quelVilains) + " pour " + degats.getBloquer() + " dégats et " + degats.getnonBloquer() + " blesse.");
		    
		    //int prendre = ennemis.get(quelVilains).prendDegats(degats);
		    
		    if(prendre > 0) {
		      UI.out.println("their armour cannot completely shield them and they take damage");
		    }else {
		      UI.out.println("alas, their defenses are too strong! you do not get through");
		    }
		    
		    int soigner = ennemis.get(quelVilains).soin();
		    
		    if(soigner > 0) {
		      UI.out.println("unfortunately, the " + ennemis.get(quelVilains) + " appears to have recovered a little");
		    }
		    
		    if(ennemis.get(quelVilains).getDefense()<= 0) {
		      UI.out.print("Bien joué ! tu as éliminé " + ennemis.get(quelVilains) + " et " + monsters.get(whichMonster).getMonsterRating() + "xp!");
		      perso.equips(ennemis.remove(quelVilains).isElite());
		      
		      	if(ennemis.size() == 0) {
		      		UI.out.println("\n");
		        return false;
		      	} else {
		      
		      		UI.out.println(" now all that remains are");
		      		//UI.printMonsters(ennemis);
		      		UI.out.println("");
		      		return true;
		      	}
		    }
		    
		    UI.out.println("");
		    return true;
		  }


	private static boolean combatenCours(perso Perso, battleNode node, boolean aPortee){
		    
		node.startCombat();
		    
		ArrayList<enemy> monsters = node.monsterList();
		ArrayList<enemy> succes = new ArrayList<enemy>();
		    
		UI.out.println("Tu es courageux pour faire face");
		//UI.printMonsters(monsters);
		UI.out.println("");
		    
		while(!node.combatOver()) {
		      
		    ArrayList<String> options = new ArrayList<String>();
		    options.add("flee");
		      
		    if(aPortee) {
		    		options.add("en mode Charge");
		    		options.add("continuer à se battre à bout portant");
		      
		    } else {
		      
		    		options.add("Echapper au combat à distance");
		    		options.add("Continuer les combats rapporchés");
		    }
		      
		    	switch(UI.menu("Quelle action tu voudrais faire ?", options)) {
		        
		    	case 0:
		        
		    		succes = initiative(monsters, Perso, aPortee, true);
		       
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
		        		
		        		ArrayList<enemy> suprise = initiative(monsters, Perso, aPortee, false);
		          if(suprise.size() > 0) {
		            UI.out.println("Bravo ! tu as Surpris");
		            //UI.printMonsters(suprise);
		            
		            ArrayList<String> monsterMenu = new ArrayList<String>();
		            
		            	for(int i = 0; i < suprise.size(); i++) {
		            		monsterMenu.add(suprise.get(i).toString());
		            	}
		            
		            	if(!attaque(Perso, suprise, UI.menu("\nTu obtiens une attaque de mêlée surprise supplémentaire! Sur qui voudrais-tu effectuer l'attaque supplémentaire??", monsterMenu), false)) {
		            		return true;
		            	}
		            
		            UI.out.println("\nMaintenant, voici la phase de combat");
		          }
		          
		        } else {
		        
		          succes = initiative(monsters, Perso, aPortee, true);
		          
		          if(succes.size() == 0) {
		            
		        	  UI.out.println("Bon travail! Malgré la distance!");
		        	  aPortee = true;
		        	  UI.out.println("\nMaintenant, voici la phase de combat");
		          
		          } else {
		          
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

		      if(!joueursSoins(Perso, monsters, utilsGame.random(0, monsters.size()), aPortee)) {
		        Perso.reset();
		        return true;
		      }

		      if(!joueursSoins(Perso, monsters, aPortee)) {
		        Perso.reset();
		        return false;
		      }
		    }
		    Perso.reset();
		    return true;
		  }

		  
	public static boolean run(perso Perso, battleNode node, boolean aPortee){
		    
		boolean valRetourne = combatenCours(Perso, node, aPortee);
		Perso.reset();
		return valRetourne;
	}
	

}
