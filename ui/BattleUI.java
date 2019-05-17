import event.Battle;
import resource.ResourceManager;
import screen.GameScreen;

//Superclasse pour toutes les interfaces utilisateur liées aux événements de combat

public abstract class BattleUI extends UI {

    protected Battle battle;
    protected BattleUIHandler uiHandler;

    public BattleUI(GameScreen gameScreen, TileMap tileMap, Player player, Battle battle,
                    BattleUIHandler uiHandler, ResourceManager rm) {
        
    	super(gameScreen, tileMap, player, rm);
        
    		this.battle = battle;
    		this.uiHandler = uiHandler;
    
    }

}
