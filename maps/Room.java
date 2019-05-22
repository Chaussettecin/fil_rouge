package maps;

import enemys.enemy;
import main.Game;

public class Room {

	private String description;
    private static enemy Enemy;
    private int numOfMonsters;
    private boolean isBossRoom;
    //private boolean lighting;

    private Room(String description, enemy Enemy, boolean isBossRoom, int numOfMonsters) {
        
    	this.description = description;
        this.Enemy = Enemy;
        //this.lighting = lighting;
        this.isBossRoom = isBossRoom;
        this.numOfMonsters = numOfMonsters;
    }

   
    public static Room newRoomInstance() {
       
    	String description = null;
        int numOfMonsters = 0;
        //boolean lighting = true;
        boolean isBossRoom = false;
        int random = Game.RAND.nextInt(3) + 1; //Change random value parameter to add more room types
        
        switch (random) {
            case 1:
                description = "A dark corridor with creeping, animated vines.";
                numOfMonsters = 1;
                //lighting = false;
                break;
            case 2:
                description = "A single lantern lays on the floor, illuminating"
                        + " a skeleton of a past explorer. Two pairs of eyes "
                        + "can be seen.";
                numOfMonsters = 1;
                //lighting = true;
                break;
            case 3:
                description = "A green, floral room full of massive plants.";
                numOfMonsters = 1;
                //lighting = true;
                break;
            /*case 4:
                description = "a giant dragon";
                numOfMonsters = 1;
                isBossRoom = true;
                break;      
            case 5:
                description = "";
                numOfMonsters = 1;
                break;
            case 6:
                description = "";
                numOfMonsters = 1;
                break;
            case 7:
                description = "";
                numOfMonsters = 1;
                break;
            case 8:
                description = "";
                numOfMonsters = 1;
                break;
            case 9:
                description = "";
                numOfMonsters = 1;
                break;
            case 10:
                description = "";
                numOfMonsters = 1;
                break;*/
        }
        return new Room(description, Enemy.newRandomMonster(), false,
                numOfMonsters);

    }

    @Override
    public String toString() {
        return description;
    }

    public boolean isBossRoom() {
        return isBossRoom;
    }

    public String getDescription() {
        return description;
    }

    public enemy getMonster() {
        return Enemy;
    }

    public int getNumOfMonsters() {
        return numOfMonsters;
    }

    public boolean isIsBossRoom() {
        return isBossRoom;
    }

}
