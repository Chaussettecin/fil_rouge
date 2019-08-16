package Npc;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Perso.Race;
import Quete.Quete;
import Mouvement.NpcMouv;

import Utils.SingleTonRandom;


/*
 * Classe PNJ du jeux
 */
public class Npc  {
	
	static Race race; //-- Même races que pr les autres perso -
	NpcMouv npcMouv;
	SingleTonRandom rand;
	
	boolean siColision = true;
	
	private String motivation;
	protected static String nom; 
	
	private ArrayList<String> npcList;
	protected static ArrayList<Quete> queteList = new ArrayList<>();
	

//--- Constructor -
	public Npc(	String nom, ArrayList<String> npcList, ArrayList <Quete> queteList,
			boolean siColision) {
				
	        Npc.nom = nom;
	        this.npcList = npcList;
	        Npc.queteList = queteList;
	        siColision = true;
	        
	 }

	


	//--- Liste gestion Npc / Map World 
	private static Map<String, Npc> possibleNpc = new HashMap<String,Npc>();
		
		public void runDialiogue() {
									
		//-- Npc 1 - World 1 - Qu�te 1
			possibleNpc.put("npcWorld1", (Npc) new Npc(nom,npcList, queteList, true));
		//-- Npc 2 - World 2 - Qu�te 2		
			possibleNpc.put("npcWorld2", (Npc) new Npc(nom, npcList, queteList,true));
		//-- Npc 3 - World 3 - Qu�te 3		
			//possibleNpc.put("npcWorld3", (Npc) new Npc(nom, npcList, queteList));
		//-- Npc 4 - World 4 - Qu�te 4		
			//possibleNpc.put("npcWorld4", (Npc) new Npc(nom, npcList, queteList));
		//-- Npc 5 - World 5 - Qu�te 5		
			//possibleNpc.put("npcWorld5", (Npc) new Npc(nom, npcList, queteList));		
				               	
		}
		


//--- PNJ --
	public 	Npc newGalov(){
			Npc galov = new Npc(nom,npcList, queteList,true);
		
			//world.addAtEmptyLocation(galov, depth);			
			return galov;
	}
	
	
	public 	Npc newSenek(){
			Npc senek = new Npc(nom, npcList, queteList, true);
		
			//world.addAtEmptyLocation(senek, depth);
			return senek;
	}
	
	
	/*public 	Npc newBalanwyr(){
			Npc balanwyr = new Npc(nom, npcList, queteList, true);
		
			//world.addAtEmptyLocation(balanwyr, depth);
		
			return balanwyr;
	}*/
	
	/*public 	Npc newKireth( Npc pnj){
			Npc kireth = new Npc(nom, 'z', "Kireth", AsciiPanel.white, npcList, queteList);
		
			//world.addAtEmptyLocation(kireth, depth);
		
			return kireth;
	}

	public 	Npc newXubrym(Npc pnj){
			Npc xubrym = new Npc(nom, 'g', "Xubrym", AsciiPanel.brightGreen,  npcList, queteList);
		
			//world.addAtEmptyLocation(kireth, depth);
			return xubrym;
	
	}*/

/*
 * Recup la liste des Quetes -- 
*/
	public static ArrayList<Quete> getQueteslist() { return queteList; }
 	
  
// Get & Setter nom NPC
	public String getNamNpc() { return nom; }
		 
	public void setNameNpc(String nameNpc) { nom =nameNpc; }
		
		
/**
    * @return Race
 */
    public Race getRace() { return race; }
        
    
/*
 * @param race the race to set
 */
    public void setRace(Race race) { Npc.race = race; }

 

/**
  * @return the motivation
  */
    public String getMotivation() { return motivation; }

/**
  * @param motivation the motivation to set
  */
    public void setMotivation(String motivation) { this.motivation = motivation; }

 
 }
		    

	    