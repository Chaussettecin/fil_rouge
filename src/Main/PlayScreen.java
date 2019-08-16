package Main;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.KeyEvent;

import UI.*;

import Perso.Race;
import Perso.Perso;
import Enemy.Cultiste;

import Npc.Npc;
import Maps.Map;
import Maps.MapPosition;

import Mouvement.CultMouv;
import Mouvement.NpcMouv;
import Mouvement.PersoMouv;
import Mouvement.Vector2d;


import asciiPanel.AsciiPanel;
import Serialization.Donnees;



/*
 * Classe principale  
 * Carte & elements du jeu
 */
public class PlayScreen implements Screen {

	public static String nom; //Var pr le nom du joueur
	private Donnees d ; // var recup les données
	
	public Map map; //map
	public PersoMouv persD;
	
	static Npc randNpc;
	static Cultiste randCultist;
	
	//private Screen subscreen;
	public AsciiPanel terminal; 
	static PlayScreen screenBefore;
	
	public static boolean siColision = true;
	
	//private List<String> messages;
	
	public ArrayList<NpcMouv> npcMouv; //--- PNJ
	public ArrayList<CultMouv> cultMouv; //---Cultiste
	private ArrayList<Perso> persoArray = new ArrayList<Perso>();

	
//Constructor - Recup le nom du joueur 
	public PlayScreen(String nomJ) { this.nom=nomJ; }
	
	
 //Constructor recup les données existantes
	public PlayScreen(Donnees donnees) { this.d=donnees; }
	
	
// ---------  Methode création -----

// --- Creation Cultiste -
	public void createCult(AsciiPanel terminal) {
		
		MapPosition cultPos = new MapPosition();
		cultMouv = new ArrayList<CultMouv>();
		
		for(int i=0;i<9;i++) {
			
			cultMouv.add(new CultMouv(terminal, 
			map,cultPos.getCultMonde1().get(i), '#', Color.YELLOW));
			
		}
		
	}
	
 
//---  Creation d'un PNJ -- 
	public void createNpc(AsciiPanel terminal) {
		
		MapPosition npcPos = new MapPosition();
		npcMouv = new ArrayList<NpcMouv>();
		
		for(int i=0;i<npcPos.size();i++) {
			npcMouv.add(new NpcMouv(terminal, map,
			(Vector2d) npcPos.getNpcMonde1().get(i), '#', Color.RED ));
	    
		}
	
	}
	
		
//--- Verif si colision
	public int checkCollisionCult() {
		
		for (int i=0;i<cultMouv.size();i++) {
		
			if ((persD.position.Compare(cultMouv.get(i).position))) {
					
				siColision=!siColision;
				return i;
			}
		
		}
		return 100; // si c'est sup 100 il ne fait rien
		
	}	
	
	
	public int checkCollisionNpc() {
		
		for (int i=0;i<npcMouv.size();i++) {
		
			if ((persD.position.Compare(npcMouv.get(i).position))) {
	
				siColision=!siColision;
				return i;
			} 
		
		}
		return 100; // si c'est sup 100 il ne fait rien
		
	}

	
/*
 * --- Interaction avec les "bot" enemy ou pnj
 */
	public void interAction() {
			
		terminal.clear();
		terminal.repaint();
		siColision=!siColision;
		meetCultiste();
			
	}
	
	
//-- Rand Cultiste
	public static Cultiste meetCultiste() {
	    return randCultist = new Cultiste(siColision);
	
	}
	
	
//-- Rand NPC
	 public static Npc meetNpc() {
	    return randNpc = new Npc(nom, null, null, siColision);

	}

	
	@Override
	public void displayOutput(AsciiPanel terminal) {
		
		if (map == null) {
			
			try {
				map = new Map(terminal);
			
			} catch (IOException e) {
				e.printStackTrace();
			
			}
			//-- Display de l'equipe -
			persD = new PersoMouv(terminal,map,15,10,'@',Color.BLUE);
			
			createCult(terminal); 
			createNpc(terminal);
		}
        
		if(d!=null) {
				
			seDeplacerA(d.getPos());
			persD.setPerso(d.getNom());
			d=null;
			
		}
		
		terminal.clear();
			
		
		for(int i=0;i<npcMouv.size();i++) {
			//System.out.println(map);
			((NpcMouv) npcMouv.get(i)).deplacementAlea();
			((NpcMouv) npcMouv .get(i)).afficher();
			
		}
		
		for(int i=0;i<cultMouv.size();i++) {
			//System.out.println(map);
			((CultMouv) cultMouv.get(i)).deplacementAlea();
			((CultMouv) cultMouv .get(i)).afficher();
			
		}
		
		//String stats = String.format(" %3d/%3d PtV   %d/%d mana   %8s", Perso.getPtv());
		//terminal.write(stats, 1, 23);
		
		map.afficherMap();
		persD.afficherPlayer();
		
		//testDonnees();
		terminal.repaint();
	
	}
	
	
/*
 * Gestion des entrées clavier pour le déplacement de l'équipe	
 */
	@Override
	public Screen respondToUserInput(KeyEvent key) {
			
		int checkCult = 0;
		int checkNpc = 0;
		
		//int level = Perso.getLevel();
			
		switch (key.getKeyCode()) { 
	        
		//--Les valeurs contenue dans KeyEvent. 
		//--Elles commencent par VK_ et 
		//--finissent par le nom de la touche
	        case KeyEvent.VK_UP: 
	        		
	        	//-- si la touche enfoncée est celle du haut
	        	if (map.map [persD.position.dy-1]
	        				[persD.position.dx]== ' '||
	        		map.map [persD.position.dy-1]
	        				[persD.position.dx]== 'w'||
	        		map.map [persD.position.dy-1]
	        				[persD.position.dx]== '#')
	        		
	        		persD.DeplacerY(-1);
	        		checkCult=checkCollisionCult();
	        		checkNpc=checkCollisionNpc();
	        			
	        	
	        		if(checkCult<100) { 
	        			return new MeetCultScreen(this,checkCult);
	        		}	
	    	
	        		if(checkNpc<100) { 
	        			return new MeetNpcScreen(this,checkNpc);
	        		}	
	    	
	        break;
	        
	        case KeyEvent.VK_LEFT: 
	        //-- si la touche enfoncée est celle de gauche
	        		
	        	if (map.map [persD.position.dy]
	        				[persD.position.dx-1]== ' '||
	        		map.map [persD.position.dy]
	        				[persD.position.dx-1]== 'w'||
	        		map.map [persD.position.dy]
	        				[persD.position.dx-1]== '#')
	        			
	        		persD.DeplacerX(-1);
	        		checkCult=checkCollisionCult();
	        		checkNpc=checkCollisionNpc();
        			
        	
	        		if(checkCult<100) { 
	        			return new MeetCultScreen(this,checkCult);
	        		}	
    	
	        		if(checkNpc<100) { 
	        			return new MeetNpcScreen(this,checkNpc);
	        		}	
	       
	     break;
	        		
	        case KeyEvent.VK_RIGHT: 
	        		// si la touche enfonc�e est celle de droite -
	        		
	        	if (map.map [persD.position.dy]
	        				[persD.position.dx+1]== ' '||
	        		map.map	[persD.position.dy]
	        				[persD.position.dx+1]== 'w'||
	        		map.map	[persD.position.dy]
	        				[persD.position.dx+1]== '#')
	        			
	        		persD.DeplacerX(1);
	        	
	        		checkCult=checkCollisionCult();
	        		checkNpc=checkCollisionNpc();
        			
        	
	        		if(checkCult<100) { 
	        			return new MeetCultScreen(this,checkCult);
	        		}	
    	
	        		if(checkNpc<100) { 
	        			return new MeetNpcScreen(this,checkNpc);
	        		}	
	        				
	        break;
	        
	        case KeyEvent.VK_DOWN: 
	        	
	        		//-- si la touche enfonc�e est celle du bas
	        	if (map.map [persD.position.dy+1]
	        				[persD.position.dx]== ' '||
	        		map.map	[persD.position.dy+1]
	        				[persD.position.dx]== 'w'||
	        		map.map	[persD.position.dy+1]
	        				[persD.position.dx]== '#')
	        			
	        		persD.DeplacerY(1);
	        	
	        		checkCult=checkCollisionCult();
	        		checkNpc=checkCollisionNpc();
        			
        	
	        		if(checkCult<100) { 
	        			return new MeetCultScreen(this,checkCult);
	        		}	
    	
	        		if(checkNpc<100) { 
	        			return new MeetNpcScreen(this,checkNpc);
	        		}	
	        					
	       break;
	        
	       case KeyEvent.VK_D :
	        	
	    	   persD.dig();
	    	   break;
	        
	       case KeyEvent.VK_E :
	        	
	    	   seDeplacerA(155,78);
	    	   break;	
	        
	      } // En Switch 
			
			
		if(key.getKeyChar()=='p')
			return new PauseScreen(this);
			
		/*if (Perso.getLevel() > level) {
			}*/
		
		//if (Perso.getPtv() < 1)
			//return new LoseScreen(perso, persoArrayMouv, Perso.getPtv() == 0);
			
			return this;
		
		}


/*
 * 	--- Creation d'un tableau des perso / equipe - 
 */
	public void fillPersoArray() {
		
		persoArray.add(new Perso("Sidney Fox", Race.HUMAIN));
		persoArray.add(new Perso("Hatachar Godeth", Race.ELFE));
		persoArray.add(new Perso("Fes Forelash", Race.ORC));
		persoArray.add(new Perso("Jissi LightCat", Race.NAIN));
		
	
	}


/*
 * 	--- Deplacement de l'équipe : PersoD = equipe de persos 
 */
	private void seDeplacerA(int x, int y) {
		
		while (persD.position.dx != x || persD.position.dy != y) {
			
			if (persD.position.dx > x) {
				persD.DeplacerX(-1);
			
			} else if (persD.position.dx < x) {
				persD.DeplacerX(1);
			
			}
			
			if (persD.position.dy>y) {
				
				persD.DeplacerY(-1);
			
			} else if (persD.position.dy<y) {
				persD.DeplacerY(1);
			
			}
		}
	}
	
	
	private void seDeplacerA(Vector2d deplacement) {
		
		while (	persD.position.dx != deplacement.dx || 
				persD.position.dy != deplacement.dy) {
			
			if (persD.position.dx > deplacement.dx) {
				persD.DeplacerX(-1);
			
			} else if (persD.position.dx < deplacement.dx) {
				persD.DeplacerX(1);
			
			}
			if (persD.position.dy>deplacement.dy) {
				persD.DeplacerY(-1);
			
			} else if (persD.position.dy<deplacement.dy) {
				persD.DeplacerY(1);
			
			}
		}
	}


// --- Affiche les coordonnées de l'équipe dans la console -
	/*public void testDonnees() {
				
		System.out.println("Perso X : " + persD.position.dx+
								", Perso Y :" +persD.position.dy);
			
		//System.out.println("BotOther X " + ArrayMouv.get(0).position.dx+
									//" Y"+ ArrayMouv.get(3).position.dy);
	}*/
	
	
/*
 * --- SETTER & GETTER --	
 */
	public ArrayList <Perso> getPersoArray() { return persoArray; }
	
	
	public void setPersoArrayMouv(ArrayList<PersoMouv> persoArrayMouv) {
		this.persoArray = persoArray;
	}
	
	
	


}
