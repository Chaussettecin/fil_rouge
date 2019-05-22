package maps;

import Player.Player;
import enemys.enemy;
import main.Game;
import perso.perso;
import ui.UI;

public class Dungeon {

	  private static boolean northDirection = false;
	  private static boolean southDirection = false;
	  private static boolean westDirection = false;
	  private static boolean eastDirection = false;

	  public static Room[][] newRandomDungeon(Player currPlayer) {
	        
		  Room[][] dungeon = new Room[30][30];
	        
		  for (int i = 0; i < dungeon.length; i++) {
	            for (int j = 0; j < dungeon.length; j++) {
	                dungeon[i][j] = Room.newRoomInstance();
	            }
	      }
	        
		  currPlayer.setCurrRoom(dungeon[14][14]);
	        
		  return dungeon;
	 }

	    
	  public boolean roomExists(int x, int y) {
	        return (rowExists(x)) && (colExists(y));
	  }

	    
	  public boolean rowExists(int x) {
	        return (x >= 0) && (x <= 29);
	  }

	    
	 public boolean colExists(int y) {
	        return (y >= 0) && (y <= 29);
	  }

	public void playerMovement(Player player) {
	        
		northDirection = roomExists(player.getCurrX(), player.getCurrY() + 1);
	               
	    southDirection = roomExists(player.getCurrX(), player.getCurrY()  - 1);
	               
	    eastDirection = roomExists(player.getCurrX() + 1, player.getCurrY());
	                
	    westDirection = roomExists(player.getCurrX() - 1, player.getCurrY());
	                
	    UI.movePlayer(player);

	 }

	    
	public void battle(perso Perso, enemy enemy, Room[][] dungeon) {
	        
		UI.battleIntro(Perso, dungeon[Perso.getCurrX()][Perso.getCurrY()]);
	    UI.battle(Perso, enemy, dungeon[Perso.getCurrX()][Perso.getCurrY()]);
	}
	    /* dungeonLogic - while the player is alive, and the monster in the 
	    *  current room is alive, initiate a battle. Otherwise, if the player is
	    *  alive and the monster is dead, let the player move.
	    */
	    
	public void dungeonLogic(Player currPlayer, Room[][] dungeon) {
	       
		while (currPlayer.isAlive()) {
	            
			if (currPlayer.isAlive() && dungeon[currPlayer.getCurrX()][currPlayer.getCurrY()].getMonster().isAlive()) {
	                battle(currPlayer, dungeon[currPlayer.getCurrX()][currPlayer.getCurrY()].getMonster(), Game.currDungeon);
	            
	            playerMovement(currPlayer);
	        }
	     }
	 }

	    
	public static boolean isNorthDirection() {
	        return northDirection;
	    }

	    
	public static boolean isSouthDirection() {
	        return southDirection;
	    }

	    
	public static boolean isWestDirection() {
	        return westDirection;
	    }

	    
	public static boolean isEastDirection() {
	        return eastDirection;
	    }

}
