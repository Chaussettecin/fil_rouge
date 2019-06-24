package Adventure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Perso.Perso;
import Perso.Race;
import Quete.Quete;
import terminalOverflow.EnemyMouv;

/*
 * Classe PNJ du jeux
 */public class Npc  extends Perso {
	
	 private String physicalTrait;
	 private String personalityTrait;
	 private String occupation;
	 private String motivation;
	     
	 EnemyMouv npcMouv;
	 static ArrayList<Quete> QuetesList = new ArrayList<>();
	
//--- Constructor -
	public Npc() {
		super(nom, race);
	}
	 
	
	public void createNPC() {
	        
	        this.nom = nom;
	        this.setRace(race);
	        this.setPhysicalTrait(physicalTrait);
	        this.setPersonalityTrait(personalityTrait);
	        this.setOccupation(occupation);
	        this.setMotivation(motivation);
	        
	 }
	 
	//-- Faire une conversation en fonction du nombre des 5 pnj


	
//--- Liste des PNJ
	private static Map<String,Npc> possibleNpc = new HashMap<String,Npc>();
		
	public void runDialiogue() {
			
		possibleNpc.put("npcWorld1", new Npc());
				// Npc 1 - World 1 -  Quête 1
		possibleNpc.put("npcWorld2", new Npc());
				// Npc 2 -  World 2 - Quête 2
		possibleNpc.put("npcWorld3", new Npc());
				// Npc 3 -  World 3 -  Quête 3
		possibleNpc.put("npcWorld4", new Npc());
				// Npc 4 -  World 4 -  Quête 4
				               	
	}

//--- Recup liste des quêtes
	public static ArrayList<Quete> getQueteslist() {
			return QuetesList;
		}
 	
  
    public void printNPC() {
        System.out.println("nom: " + this.getNamNpc());
        
    }

   /**
     * @return le nom
    */
	public String getNamNpc() {
		return nom;
	}

	public void setNameNpc(String nameNpc) {
		nom =nameNpc;
	}
		
    /**
     * @return Race
    */
    public Race getRace() {
        return race;
    }

    /**
     * @param race the race to set
     */
    public void setRace(Race race) {
        this.race = race;
    }

    /**
     * @return the physicalTrait
     */
    public String getPhysicalTrait() {
        return physicalTrait;
    }

    /**
     * @param physicalTrait the physicalTrait to set
     */
    public void setPhysicalTrait(String physicalTrait) {
        this.physicalTrait = physicalTrait;
    }

    /**
     * @return the personalityTrait
     */
    public String getPersonalityTrait() {
        return personalityTrait;
    }

    /**
     * @param personalityTrait the personalityTrait to set
     */
    public void setPersonalityTrait(String personalityTrait) {
        this.personalityTrait = personalityTrait;
    }

    /**
     * @return the occupation
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * @param occupation the occupation to set
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     * @return the motivation
     */
    public String getMotivation() {
        return motivation;
    }

    /**
     * @param motivation the motivation to set
     */
    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

 }
		    

	    