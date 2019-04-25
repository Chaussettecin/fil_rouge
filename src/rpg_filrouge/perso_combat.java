package rpg_filrouge;

import java.util.ArrayList;



public class perso_combat {

	 // modifies each Creature's agility by a range from -3 to 3, then returns the list of monsters as fast or faster than the player if faster is true, otherwise returns slower monsters
	  private static ArrayList<Monster> initiative(ArrayList<Monster> monsters, Player p, boolean atRange, boolean faster) {
	    
		  int target = 0;
		  
		  if(atRange) {
			  target = p.getSpeed() + utils.random(0, 7);
		  }else {  
			  target = p.getSpeed() + utils.random(-3, 4);
		  }
		  
		  ArrayList<Integer> speeds = new ArrayList<Integer>();
		  for(int i = 0; i < monsters.size(); i++) {
			  speeds.add(monsters.get(i).getSpeed() + utils.random(-3, 4));
		  }
		  
		  ArrayList<Monster> returnMonsters = new ArrayList<Monster>();
		  for(int i = 0; i < speeds.size(); i++) {
			  if(speeds.get(i) >= target && faster) {
				  returnMonsters.add(monsters.get(i));
			  }
			  if(speeds.get(i) < target && !faster) {
				  returnMonsters.add(monsters.get(i));
			  }
		  }
		  return returnMonsters;
	  	}

//--- Retourne faux si le joueux est mort
	  private static boolean hitHealPlayer(Joueurs j, ArrayList<Monster> monsters, boolean atRange) {
	    
		  int bloque = 0;
		  int nonBloquer = 0;
		  
		  ui.out.println("Tu es attaqué par :");
	    
		  ArrayList<Monster> attaquer = new ArrayList<Monster>();
		  ArrayList<Attaques> armeAttaque = new ArrayList<Attaques>();
		  
		  for(int i = 0; i < monsters.size(); i++) {
			  attaquer.add(monsters.get(i));
			  	if(atRange) {
	        
				  int armesNbre = utils.random(0, monsters.get(i).getUsableRangedAttacks().size());
				  armeAttaque.add(monsters.get(i).getUsableRangedAttacks().get(armesNbre));
				  Degats temp = monsters.get(i).dealRangedDamage(armesNbre);
				  bloque += temp.getBloquer();
				  nonBloquer += temp.getnonBloquer();
			  	
			  	} else {
			  		
			  	int armesNbre = utils.random(0, monsters.get(i).getUsableMeleeAttacks().size());
			  	armeAttaque.add(monsters.get(i).getUsableMeleeAttacks().get(armesNbre));
			  	Degats temp = monsters.get(i).dealMeleeDamage(armesNbre);
			    bloque += temp.getBloquer();
			  	nonBloquer += temp.getnonBloquer();
			  	}
	    }//fin for
		  
	    ui.printMonstersAndWeapons(attaquer, armeAttaque);
	    
	    int prend = 0;
	    if(bloque + nonBloquer > 0) {
	      ui.out.println("tu as" + bloque + " de dégats" + nonBloquer + " spite damage coming your way");
	      prend = j.prendDegats(new Degats(bloque, nonBloquer));
	      if(prend == 1) {
	        ui.out.println("you almost blocked that, but due to lack of skill you recieve 1 point of damage");
	      }
	      else if(prend > 1) {
	        ui.out.println("alas, you are not able to block it all, and you suffer " + prend + " points de dégats");
	      }
	      else {
	        ui.out.println("you didn't take even a scratch!");
	      }
	    }
	    else {
	      if(monsters.size() > 1) {
	        ui.out.println("you enemies are even more skilled than you, for they deal you not 1 point of damage!");
	      }
	      else {
	        ui.out.println("your foe is a worthy opponent, for he just dealt you a whopping 0 damage!");
	      }
	    }
	    int soigner = j.heal();
	    if(soigner == 1) {
	      ui.out.println("you found a bandaid and regain 1 point of lost health!");
	    }
	    else if(soigner > 1) {
	      ui.out.println("you must have a medical degree or strong magic indeed to be able to heal " + healed + " points of damage!");
	    }
	    if(prend > 0 || soigner > 0) {
	      ui.out.println("Tu as maintenant :" + j.getConstitution() + "sante.");
	    }
	    ui.out.println("");
	    return(j.getConstitution() > 0);
	  }

	  //retourne faux s'il n'y a pas d'ennemis
	  private static boolean hitHealMonster(Joueurs j, ArrayList<Monster> monsters, int whichMonster, boolean atRange) {
	    ArrayList<String> rAttacks = new ArrayList<String>();
	    for(int i = 0; i < j.getUsableRangedAttacks().size(); i++) {
	      rAttacks.add(j.getUsableRangedAttacks().get(i).toString());
	    }
	    ArrayList<String> mAttacks = new ArrayList<String>();
	    for(int i = 0; i < j.getUsableMeleeAttacks().size(); i++) {
	      mAttacks.add(j.getUsableMeleeAttacks().get(i).toString());
	    }

	    Damage damage;
	    if(atRange) {
	      damage = p.dealRangedDamage(UI.menu("please select your weapon", rAttacks));
	    }
	    else {
	      damage = p.dealMeleeDamage(UI.menu("please select your weapon", mAttacks));
	    }
	    UI.out.println("you hit a " + monsters.get(whichMonster) + " for " + damage.getBlockable() + " damage and " + damage.getUnblockable() + " spite damage");
	    int taken = monsters.get(whichMonster).takeDamage(damage);
	    if(taken > 0) {
	      UI.out.println("their armour cannot completely shield them and they take damage");
	    }
	    else {
	      UI.out.println("alas, their defenses are too strong! you do not get through");
	    }
	    int healed = monsters.get(whichMonster).heal();
	    if(healed > 0) {
	      UI.out.println("unfortunately, the " + monsters.get(whichMonster) + " appears to have recovered a little");
	    }
	    if(monsters.get(whichMonster).getConstitution() <= 0) {
	      UI.out.print("good job! you killed a " + monsters.get(whichMonster) + " and got " + monsters.get(whichMonster).getMonsterRating() + "xp!");
	      p.addXP(monsters.remove(whichMonster).getMonsterRating());
	      if(monsters.size() == 0) {
	        UI.out.println("\n");
	        return false;
	      }
	      else {
	        UI.out.println(" now all that remains are");
	        UI.printMonsters(monsters);
	        UI.out.println("");
	        return true;
	      }
	    }
	    UI.out.println("");
	    return true;
	  }

	  // lancer le combat
	  private static boolean actualCombat(Joueurs j, CombatNode node, boolean atRange){
	    
		  node.startCombat();
	    
		  ArrayList<Monster> monsters = node.monsterList();
		  ArrayList<Monster> succes = new ArrayList<Monster>();
		  
		  ui.out.println("You are brave indeed to face");
		  ui.printMonsters(monsters);
		  ui.out.println("");
		  
		  while(!node.combatOver()) {
			  ArrayList<String> options = new ArrayList<String>();
			  	options.add("flee");
			  if(atRange) {
				  options.add("charge into melee");
				  options.add("continue fighting a battle at range");
			  }	else {
				  options.add("escape into ranged combat");
				  options.add("continue close quarters fighting");
			  }
	      
			  switch(UI.menu("what would you like to do this round?", options)) {
			  	case 0:
			  		succes = initiative(monsters, p, atRange, true);
			  	if(succes.size() == 0) {
			  		ui.out.println("\ngood job! you escaped!");
			  		return true;
			  	} else {
			  		
			  		ui.out.println("\nsorry, you were caught by");
			  		ui.printMonsters(succes);
			  		
			  		if(!hitHealPlayer(j, succes, false)) {
			  			return false;
			  		}
			  		if(atRange) {
			  			ui.out.println("you are now in melee with the monsters");
			  			atRange = false;
			  		}
			  		else {
			  			ui.out.println("you remain in melee with the monsters");
			  		}
			  			ui.out.println("\nnow for the main combat phase");
			  	}
			  	break;
			  	case 1:
			  		if(atRange) {
			  			atRange = false;
			  			ArrayList<Monster> suprise = initiative(monsters, j, atRange, false);
			  			
			  			if(suprise.size() > 0) {
			  				ui.out.println("Bravo ! Attaque par surprise");
			  				ui.printMonsters(suprise);
			  				
			  				ArrayList<String> monsterMenu = new ArrayList<String>();
			  					for(int i = 0; i < suprise.size(); i++) {
			  						monsterMenu.add(suprise.get(i).toString());
			  					}
			  					if(!hitHealMonster(j, suprise, ui.menu("\nyou get an extra suprise melee attack! who would you like to perform the extra attack on?", monsterMenu), false)) {
			  					return true;
			  					}
			  				ui.out.println("\nnow for the main combat phase");
			  			}
			  		} else {
	          successful = initiative(monsters, j, atRange, true);
	          if(successful.size() == 0) {
	            UI.out.println("good job! you got some distance from the monsters!");
	            atRange = true;
	            UI.out.println("\nnow for the main combat phase");
	          }
	          else {
	            ui.out.println("Désolée tu as été stopper par");
	            ui.printMonsters(successful);
	            if(!hitHealPlayer(p, successful, false)) {
	              return false;
	            }
	            ui.out.println("you remain in melee");
	            ui.out.println("\nnow for the main combat phase");
	          }
	        }
	        break;
	        case 2:
	          // nothing to see here
	        break;
	      }

	      if(!hitHealMonster(p, monsters, utils.random(0, monsters.size()), atRange)) {
	        j.reset();
	        return true;
	      }

	      if(!hitHealPlayer(j, monsters, atRange)) {
	        j.reset();
	        return false;
	      }
	    }
	    j.reset();
	    return true;
	  }

	  public static boolean run(Joueur j, CombatNode node, boolean atRange){
	    
		  boolean returnValue = actualCombat(j, node, atRange);
		  j.reset();
	    
		  return returnValue;
	  }
}
