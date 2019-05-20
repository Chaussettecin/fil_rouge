package Battle;

import perso.enemy;
import perso.enemyBoss;
import perso.enemyNormal;
import resource.utilsGame;
import ui.node;
import perso.Player;

import java.util.ArrayList;


public class battleNode extends node {
	
	  private int enemies = 0;
	  private int boss = 0;
	  private int minMonsters, maxMonsters;
	  
	  private ArrayList<enemyNormal> listCultiste;
	  private ArrayList<enemyBoss> listBoss;
	 
	  private node winNext, loseNext;
	  private boolean startAtRange;

//-- Constructor -- 
	  public battleNode (ArrayList<enemyNormal> listCultiste, 
			  			ArrayList<enemyBoss> listBoss, 
						int tempMinMonsters, int tempMaxMonsters, node tempWinNext, 
						node tempLoseNext, boolean tempStartAtRange) {
	    	
					super();
	    
					listCultiste = listCultiste;
					listBoss = listBoss;
					minMonsters = tempMinMonsters;
					maxMonsters = tempMaxMonsters;
					setStartAtRange(tempStartAtRange);
	    }
	
//-- Lance le combat - 
	  public void startCombat(){
	    
		  enemies = utilsGame.random(minMonsters, maxMonsters); //make a good enemy number generator
		  enemies = (int)(enemies * .85);
		  enemies = (int)(enemies - boss);
	  }
	 
//--  Création d'une arraylist avec tout les enemis au commencement du combat -
	  public ArrayList<enemy> monsterList(){
		  	
		  	ArrayList<enemy> monsterList = new ArrayList<enemy>();
	    
		  		while (boss != 0){
		  			monsterList.add(listBoss.get(utilsGame.random(1,3)));
		  			boss--;
		  		}
		  				
		  			while (boss !=0){
		  				monsterList.add(listCultiste.get(utilsGame.random(1,3)));
		  				boss--;}
		  			return monsterList;
	  }

	  public int getEnemies() {
	    return enemies;
	  }
	  
	  
	  public int killEnemies() {
	    
		  enemies--;
		  return enemies;
	  }
	  
//-- Check si le combat est fini 
	  public boolean combatOver() {
	    return (enemies <= 0);
	  }
	  
	  
//adds enemies to the fighting force
	  public int addEnemies(int numSummoned){
	    
		  return (enemies + numSummoned);
	  }

	public ArrayList<enemyBoss> getListBoss() {
		return listBoss;
	}

	public void setListBoss(ArrayList<enemyBoss> listBoss) {
		this.listBoss = listBoss;
	}

	@Override
	public node process(Player p) {
		// TODO Auto-generated method stub
		return null;
	}

	public node getLoseNext() {
		return loseNext;
	}

	public void setLoseNext(node loseNext) {
		this.loseNext = loseNext;
	}

	public node getWinNext() {
		return winNext;
	}

	public void setWinNext(node winNext) {
		this.winNext = winNext;
	}

	public boolean isStartAtRange() {
		return startAtRange;
	}

	public void setStartAtRange(boolean startAtRange) {
		this.startAtRange = startAtRange;
	}

	
}
