package Battle;

public class BattleGame  extends StateBasedGame {

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new BattleGame(), 800, 600, false);
		app.setVSync(true);
		app.setShowFPS(false);
		app.start();
	}

	public BattleGame() {
		super("Lesson 18 :: BattleGame");
	}

	/**
	 * Ici il suffit d'ajouter nos boucles de jeux. La première ajoutèe sera celle qui sera utilisée
	 * au début
	 */
	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		addState(new MainScreenGameState());
		addState(new MapGameState());
		addState(new BattleGameState());
	}
}
