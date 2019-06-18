package Battle;

public class BattleGameState extends BasicGameState {

	public static final int ID = 3;
	
	//private Image background;
	private BattleEnnemy ennemy = new BattleEnnemy();
	private BattlePlayer player = new BattlePlayer();

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		//this.background = new Image("background/battle.png");
		this.ennemy.init();
		this.player.init();

		InputProvider provider = new InputProvider(container.getInput());
		provider.bindCommand(new KeyControl(Input.KEY_A), BattleCommand.ATTACK);
		provider.bindCommand(new KeyControl(Input.KEY_D), BattleCommand.DEFEND);
		provider.bindCommand(new KeyControl(Input.KEY_F), BattleCommand.FLEE);
		provider.addListener(new BattleController(player, ennemy, game));
	}

	@Override
	public void enter(GameContainer container, StateBasedGame game) throws SlickException {
		this.ennemy.reset();
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		this.background.draw(0, 0, container.getWidth(), container.getHeight());
		this.player.render(container, g);
		this.ennemy.render(container, g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		this.player.update(delta);
		this.ennemy.update(delta);
	}

	@Override
	public int getID() {
		return ID;
	}
}
