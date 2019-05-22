package Battle;

import java.util.ArrayList;

import Degat.degat;
import Player.Player;
import enemys.enemy;
import perso.perso;
import Utils.utilsGame;
import ui.UI;


public class battle {

//-- Modifie chaque enemis  --
	private static ArrayList<enemy> initiative ( ArrayList<enemy> ennemis, perso Perso, boolean aportee, boolean rapide) {
					  								
			int cible = 0;
	
			if(aportee) {
				cible = Perso.getJustesse() + Utils.utilsGame.random(0, 7);
			
			} else {
				cible = Perso.getJustesse() + Utils.utilsGame.random(-3, 4);
			
			}
		    
			ArrayList<Integer> vitesse = new ArrayList<Integer>();
			
			for(int i = 0; i < ennemis.size(); i++) {
				vitesse.add(ennemis.get(i).getVitesse() + Utils.utilsGame.random(-3, 4));
			}
		
			ArrayList<enemy> returnEnemy = new ArrayList<>();
		
			for(int i = 0; i < vitesse.size(); i++) {
		   
				if(vitesse.get(i) >= cible && rapide) {
					returnEnemy.add(ennemis.get(i));
				}
		   
				if(vitesse.get(i) < cible && !rapide) {
					returnEnemy.add(ennemis.get(i));
				}
			}
			
			return returnEnemy;
	}


//-- Retourne faux si le joueur et mort --
	private static boolean joueursSoins(perso Perso, boolean aportee, 
									ArrayList<enemys.enemy> ennemis, boolean portee) {
	    
			int bloquer = 0;
			int nonbloquer = 0;
			UI.out.println("Tu as �t� attaquer par");
	    
	//-- Mets les enem
			ArrayList<enemys.enemy> attaques = new ArrayList<enemys.enemy>();
			ArrayList<battleAttaque> attaquesArmes = new ArrayList<battleAttaque>();
	    
			for(int i = 0; i < ennemis.size(); i++) {
	    	
				attaques.add(ennemis.get(i));
				if(portee) {
					int armesNbre = utilsGame.random(0, ennemis.get(i).getutiliserArmesDistance().size());
					attaquesArmes.add(ennemis.get(i).infligeDegatDistance(armesNbre));
	    		
					degat temp = ennemis.get(i).attaqueBase(null);;
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
	      prendre = Perso.infligeDegats((new degat(bloquer, nonbloquer));
	      
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
	    
	    int soins = Perso.heal(prendre);
	    
	    if(soins == 1) {
	      UI.out.println("!");
	    }
	    else if(soins > 1) {
	      UI.out.println("Tu n'a pas un dipl�me en m�decine ou une forte magie pour pouvoir gu�rir" + soins + "de d�gats!");
	    }
	    if(prendre > 0 || soins > 0) {
	      UI.out.println("Maintenant tu as " + soins + "sante");
	    }
	    UI.out.println("Tu as trouv� un pansement et regagn� 1 point de sant� perdue");
	    return(Perso.heal(prendre) > 0);
	  }

		 
//-- retourne faux s'il n'y a pas de creature --		
	
	private static boolean vilainsSoins(perso Perso, ArrayList<enemy> ennemis, int quelVilains, boolean portee) {
							
			ArrayList<String> rAttaques = new ArrayList<String>();
				
			for (int i = 0; i < Perso.getArmure().size(); i++) {
					rAttaques.add(Perso.getutiliserArmesDistance().get(i).toString());
			}
		    
		    ArrayList<String> vAttaques = new ArrayList<String>();
		    	
		    for(int i = 0; i < Perso.getArmure().size(); i++) {
		    		vAttaques.add(Perso.getUtiliserArMelee().get(i).toString());
		    }

		    degat degats;
		    
		    if(portee) {
		      degats = Perso.infligeDegats(System.out.printf("S'il te plait Selectionne ton armes", rAttaques));
		    } else {
		      degats = Perso.infligeDegats(UI.menu("S'il te plait Selectionne ton armes", vAttaques));
		    }
		    
		    
		    UI.out.println("Tu as tirer " + ennemis.get(quelVilains) + " pour " + degats.getBloquer() + " d�gats et " + degats.getnonBloquer() + " blesse.");
		    
		  // int prendre = ennemis.get(quelVilains).attaqueBase(null);;
		    
		    if(quelVilains> 0) {
		    	System.out.print("Cette amure est un bouclier complet, mais tu peux prendre des degats");
		      
		    }else {
		    	System.out.print("Tes defences sont trop fortes");
	
		    }
		    
		    enemy soigner = ennemis.get(quelVilains);
		    
		    if(soigner > 0) {
		      UI.out.println("unfortunately, the " + ennemis.get(quelVilains) + " appears to have recovered a little");
		    }
		    
		    ennemis.get(quelVilains);
			if(enemys.enemy.getDefense()<= 0) {
		      UI.out.print("Bien jou� ! tu as �limin� " + ennemis.get(quelVilains) + " et " + enemys.enemy.getMonsterRating() + "xp!");
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
		    
		ArrayList<enemys.enemy> monsters = node.monsterList();
		ArrayList<enemys.enemy> succes = new ArrayList<enemys.enemy>();
		    
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
		          
		    			if(!joueursSoins(Perso, aPortee, succes, false)) {
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
		        		
		        		ArrayList<enemys.enemy> suprise = initiative(monsters, Perso, aPortee, false);
		         
		        		if(suprise.size() > 0) {
		        			
		        			UI.out.println("Bravo ! tu as Surpris");
		        			//UI.printMonsters(suprise);
		            
		        			ArrayList<String> monsterMenu = new ArrayList<String>();
		            
		        			for(int i = 0; i < suprise.size(); i++) {
		        				monsterMenu.add(suprise.get(i).toString());
		        			}
		            
		        			if(!attaqueBase(Perso, suprise, UI.menu("\nTu obtiens une attaque de m�l�e surprise suppl�mentaire! Sur qui voudrais-tu effectuer l'attaque suppl�mentaire??", monsterMenu), false)) {
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
		        				
		        				if(!joueursSoins(Perso, aPortee, succes, false)) {
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

		    if(!joueursSoins(Perso, aPortee, monsters, aPortee)) {
		        return true;
		    }

		    if(!joueursSoins(Perso, aPortee, monsters, aPortee)) {
		        return false;
		    }
		 }
		 return true;
		  
	}

		  
	public static boolean run(perso Perso, battleNode node, boolean aPortee){
		    
		boolean valRetourne = combatenCours(Perso, node, aPortee);
		return valRetourne;
	}
	

}
