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
	    
	    UI.out.println("Tu as �t� attaquer par");
	    
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
	      
	    	UI.out.println("Tu as" + bloquer + " d�gats " + nonbloquer + "malgr� les d�g�ts venant � ta rencontre");
	    	prendre = Perso.heal((new degat(bloquer, nonbloquer));
	      
	    	if(prendre == 1) {
	    		UI.out.println("Tu as presque bloqu� cela, mais en raison d'un manque de comp�tence, tu gagnes 1 points de d�gats !");
	    	} else if(prendre > 1) {
	    		UI.out.println("H�las! Tu ne peux pas tout bloquer et tu souffres " + prendre + " de d�gats");
	    	} else {
	    		UI.out.println("Tu n'as m�me pas une �gratignure !");
	    	}
	    } else {
	      
	    	if(ennemis.size() > 1) {
	    		UI.out.println("Tes ennemis sont encore plus qualifi�s que toi, car ils ne te causent pas 1 point de d�g�ts!");
	    	} else {
	    		UI.out.println("Ton ennemi est un adversaire redoutable, car il vient de t'infliger 0 en d�gats!");
	    	}
	    }
	    
	    int soins = Perso.heal();
	    
	    if(soins == 1) {
	      UI.out.println("!");
	    }
	    else if(soins > 1) {
	      UI.out.println("Tu n'a pas un dipl�me en m�decine ou une forte magie pour pouvoir gu�rir" + soins + "de d�gats!");
	    }
	    if(prendre > 0 || soins > 0) {
	      UI.out.println("Maintenant tu as " +  Perso.getHeal(0) + "sante");
	    }
	    UI.out.println("Tu as trouv� un pansement et regagn� 1 point de sant� perdue");
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
		    
		    UI.out.println("Tu as tirer " + ennemis.get(quelVilains) + " pour " + degats.getBloquer() + " d�gats et " + degats.getnonBloquer() + " blesse.");
		    
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
		      UI.out.print("Bien jou� ! tu as �limin� " + ennemis.get(quelVilains) + " et " + monsters.get(whichMonster).getMonsterRating() + "xp!");
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
		    		options.add("continuer � se battre � bout portant");
		      
		    } else {
		      
		    		options.add("Echapper au combat � distance");
		    		options.add("Continuer les combats rapporch�s");
		    }
		      
		    	switch(UI.menu("Quelle action tu voudrais faire ?", options)) {
		        
		    	case 0:
		        
		    		succes = initiative(monsters, Perso, aPortee, true);
		       
		    		if(succes.size() == 0) {
		    			UI.out.println("Bon travail! Tu as r�ussis � t'en sortir\n!");
		    			return true;
		        
		    		} else {
		        	
		    			UI.out.println("\nD�sol�, tu as attrap� par");
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
		            
		            	if(!attaque(Perso, suprise, UI.menu("\nTu obtiens une attaque de m�l�e surprise suppl�mentaire! Sur qui voudrais-tu effectuer l'attaque suppl�mentaire??", monsterMenu), false)) {
		            		return true;
		            	}
		            
		            UI.out.println("\nMaintenant, voici la phase de combat");
		          }
		          
		        } else {
		        
		          succes = initiative(monsters, Perso, aPortee, true);
		          
		          if(succes.size() == 0) {
		            
		        	  UI.out.println("Bon travail! Malgr� la distance!");
		        	  aPortee = true;
		        	  UI.out.println("\nMaintenant, voici la phase de combat");
		          
		          } else {
		          
		        	  UI.out.println("d�sol�e, tu as rat� ton attaque");
		        	  //UI.printMonsters(succes);
		        	  if(!joueursSoins(j, succes, false)) {
		        		  return false;
		        	  }
		            
		        	  UI.out.println("Te voici en m�lee");
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
