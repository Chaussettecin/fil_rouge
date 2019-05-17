package ui;

import perso.Player;
import perso.perso;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import Battle.battleAttaque;
import main.RPG;
import map.TileMap;
import resource.ResourceManager;
import rpg.combat_attaque;
import rpg.perso_Mons;
import screen.GameScreen;

/**
 * Superclass for all UI
 * Contains useful variables and references
 *
 * @author Ming Li
 */
public abstract class UI implements Disposable {

    ///protected Stage stage;
    //protected Viewport viewport;

    protected ResourceManager rm;
    protected TileMap tileMap;
    protected Player player;
    protected GameScreen gameScreen;
    protected RPG game;

    public static PrintStream out = System.out;
	public static Scanner in = new Scanner(System.in);
    // graphics
    //protected ShapeRenderer shapeRenderer;

    public UI(final RPG game, Player player, ResourceManager rm) {
        
    	this.game = game;
        this.player = player;
        this.rm = rm;

        //viewport = new StretchViewport(RPG.V_WIDTH, RPG.V_HEIGHT, new OrthographicCamera());
        //stage = new Stage(viewport, game.batch);

        //shapeRenderer = new ShapeRenderer();
    }

    public UI(GameScreen gameScreen, TileMap tileMap, Player player, ResourceManager rm) {
        
    	this.game = gameScreen.getGame();
        this.gameScreen = gameScreen;
        this.tileMap = tileMap;
        this.player = player;
        this.rm = rm;

        //viewport = new StretchViewport(RPG.V_WIDTH, RPG.V_HEIGHT, new OrthographicCamera());
        //stage = new Stage(viewport, gameScreen.getBatch());

        //shapeRenderer = new ShapeRenderer();
    }

    public static void afficheCreature(ArrayList<perso> vilains){
	    
    	ArrayList<String[]> creatureNom = new ArrayList<String[]>();
	    
	    for (int i = 0; i < vilains.size(); i++){
	    	creatureNom.add(new String[]{vilains.get(i).toString(), vilains.get(i).DuoString()});
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
    
    public static void afficheCreatureetArme(ArrayList<perso> vilains, ArrayList<battleAttaque> armes){
		
    	ArrayList<String[]> creaturesNom = new ArrayList<String[]>();
	    ArrayList<String[]> armesNom = new ArrayList<String[]>();
	    
	    for (int i = 0; i < vilains.size(); i++){
	    	creaturesNom.add(new String[]{vilains.get(i).toString(), vilains.get(i).DuoString()});
	    	armesNom.add(new String[]{armes.get(i).toString(), armes.get(i).toPluralString()});
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

   // public Stage getStage() {
        //return stage;
   // }

   // @Override
    //public void dispose() {
        //stage.dispose();
        //shapeRenderer.dispose();
    //}
   
    public static void printMonsters(ArrayList<perso> cultiste) {
		
		
	}
    public void setTileMap(TileMap tileMap) { this.tileMap = tileMap; }

}