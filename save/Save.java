package ui;

import perso.Player;
import perso.enemy;
import perso.perso;
import Battle.battleAttaque;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;





//--- UI - 
public abstract class UI {

    protected Player player;
 
    public static PrintStream out = System.out;
	public static Scanner in = new Scanner(System.in);
   

    public UI( Player player) {
        
        this.player = player;
      
    }

 
	public static void afficheCreature(ArrayList<perso> vilains){
	    
    	ArrayList<String[]> creatureNom = new ArrayList<String[]>();
	    
	    for (int i = 0; i < vilains.size(); i++){
	    	creatureNom.add(new String[]{vilains.get(i).toString(), vilains.get(i).toString()});
	    }
	    
	    
	    ArrayList<String[]> noms = new ArrayList<String[]>();
	    ArrayList<Integer> num = new ArrayList<Integer>();
	    
	    while(creatureNom.size() > 0) {
	      
	    	String[] actuel = creatureNom.remove(0);
	    	boolean existe = false;
	      
	    	for(int i = 0; i < noms.size(); i++) {
	        
	    	  if(noms.get(i)[0].equals(actuel[0])) {
	          num.set(i, num.get(i) + 1);
	          existe = true;
	    	  }
	    	  
	    	}
	      
	    	if(!existe) {
	    		noms.add(actuel);
	    		num.add(1);
	    	}
	    }

	    for(int j = 0; j < noms.size(); j++) {
	      
	    	if(num.get(j) == 1) {
	        System.out.println("1 " + noms.get(j)[0]);
	      } else {
	    	  System.out.println(Integer.toString(num.get(j)) + " " + noms.get(j)[1]);
	      }
	    }
	}//fin affiche creature
    
    public static void afficheCreatureetArme(ArrayList<enemy> attaques, ArrayList<battleAttaque> armes){
		
    	ArrayList<String[]> creaturesNom = new ArrayList<String[]>();
	    ArrayList<String[]> armesNom = new ArrayList<String[]>();
	    
	    for (int i = 0; i < attaques.size(); i++){
	    	creaturesNom.add(new String[]{attaques.get(i).toString(), attaques.get(i).toString()});
	    	armesNom.add(new String[]{armes.get(i).toString(), armes.get(i).toString()});
	    }
	    
	    ArrayList<String[]> uniqueCreatures = new ArrayList<String[]>();
	    ArrayList<String[]> uniqueArmes = new ArrayList<String[]>();
	    ArrayList<Integer> num = new ArrayList<Integer>();
	    
	    while(creaturesNom.size() > 0) {
	      
	    	String[] actuelCreature = creaturesNom.remove(0);
	    	String[] actuelArmes = uniqueArmes.remove(0);
	    	boolean existe = false;
	      
	      for(int i = 0; i < uniqueCreatures.size(); i++) {
	        if(uniqueCreatures.get(i)[0].equals(actuelCreature[0])) {
	          num.set(i, num.get(i) + 1);
	          existe = true;
	        }
	      }
	      
	      if(!existe) {
	    	  uniqueCreatures.add(actuelCreature);
	    	  uniqueArmes.add(actuelArmes);
	        num.add(1);
	      }
	    }

	    for(int j = 0; j < num.size(); j++) {
	      if(num.get(j) == 1) {
	        System.out.println("1 " + uniqueCreatures.get(j)[0] + " avec " + uniqueArmes.get(j)[0]);
	      }
	      else {
	        System.out.println(Integer.toString(num.get(j)) + " " + uniqueCreatures.get(j)[1] + " avec " + uniqueArmes.get(j)[1]);
	      }
	    }
	}
    
    public abstract void update(float dt);

    public abstract void render(float dt);

    public static void printMonsters(ArrayList<perso> cultiste) {}
    


}
