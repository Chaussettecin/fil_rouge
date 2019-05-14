package screen;


 //Handles all gameplay.

public class GameScreen extends AbstractScreen {

    public EventState currentEvent;
   // public GameMap gameMap;
    public Hud hud;
    public BattleUIHandler battleUIHandler;
    public Battle battle;
    public TransitionScreen transition;
    public LevelUpScreen levelUp;
    public DialogScreen dialog;

    // input
    public InputMultiplexer multiplexer;

    // battle background
    private Background[] bg;

    // key
    private int worldIndex;
    private int levelIndex;

    // whether or not to reset the game map on show
    // used for transitioning between screen during a pause
    public boolean resetGame = true;

    public GameScreen(final Unlucky game, final ResourceManager rm) {
        super(game, rm);

        currentEvent = EventState.MOVING;

        //gameMap = new GameMap(this, game.player, rm);
        battle = new Battle(this, gameMap.tileMap, gameMap.player);
        hud = new Hud(this, gameMap.tileMap, gameMap.player, rm);
        battleUIHandler = new BattleUIHandler(this, gameMap.tileMap, gameMap.player, battle, rm);
        transition = new TransitionScreen(this, battle, battleUIHandler, hud, gameMap.player, rm);
        levelUp = new LevelUpScreen(this, gameMap.tileMap, gameMap.player, rm);
        dialog = new DialogScreen(this, gameMap.tileMap, gameMap.player, rm);

        // create bg
        bg = new Background[2];
        // sky
        bg[0] = new Background((OrthographicCamera) battleUIHandler.getStage().getCamera(), new Vector2(0.3f, 0));
        // field
        bg[1] = new Background((OrthographicCamera) battleUIHandler.getStage().getCamera(), new Vector2(0, 0));


        // input multiplexer
        multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(hud.getStage());
        multiplexer.addProcessor(battleUIHandler.getStage());
        multiplexer.addProcessor(levelUp.getStage());
        multiplexer.addProcessor(dialog.getStage());
    }

    public void init(int worldIndex, int levelIndex) {
        this.worldIndex = worldIndex;
        this.levelIndex = levelIndex;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(multiplexer);
        batchFade = renderBatch = true;

        // fade in animation
        hud.getStage().addAction(Actions.sequence(Actions.alpha(0), Actions.fadeIn(0.5f)));

        if (resetGame) {
            // init tile map
            setCurrentEvent(EventState.MOVING);
            hud.deathGroup.setVisible(false);
            //gameMap.init(worldIndex, levelIndex);
            //gameMap.player.moving = -1;
            battle.tileMap = gameMap.tileMap;
            hud.setTileMap(gameMap.tileMap);
            battleUIHandler.setTileMap(gameMap.tileMap);
            levelUp.setTileMap(gameMap.tileMap);
            dialog.setTileMap(gameMap.tileMap);

            // update bg
            //createBackground(gameMap.worldIndex);

            hud.toggle(true);
            hud.touchDown = false;
            hud.shade.setVisible(false);
            hud.startLevelDescriptor();
        }
    }


//---cCr�ation d'un Background ? -- 
    private void createBackground(int bgIndex) {
        
    	// background image array is ordered by depth
        TextureRegion[] images = rm.battleBackgrounds400x240[bgIndex];
        for (int i = 0; i < 2; i++) bg[i].setImage(images[i]);
        // set background movement for the specific worlds
        if (bgIndex == 0) bg[0].setVector(40, 0);
        else if (bgIndex == 1) bg[0].setVector(0, 0);
        else if (bgIndex == 2) bg[0].setVector(40, 0);
        bg[1].setVector(0, 0);
    }


//-- Lorsque le joueur meurt, il affiche un message "Cliquez pour continuer" avec ce qu'il a 
    //perdu.
    public void die() {
     //-- Reset le joueur apr�s le game over--
       
    	// gameMap.player.setHp(gameMap.player.getMaxHp());
        setCurrentEvent(EventState.DEATH);
        hud.toggle(false);
        hud.deathGroup.setVisible(true);
    }


//-- Met � jour la position de la cam�ra pour 
    //suivre le joueur sauf s'il se trouve sur les bords de la carte
    public void updateCamera() {
        // camera directs on the player
        if (gameMap.player.getPosition().x <= gameMap.tileMap.mapWidth * 16 - 7 * 16 &&
            gameMap.player.getPosition().x >= 6 * 16)
            cam.position.x = gameMap.player.getPosition().x + 8;
        if (gameMap.player.getPosition().y <= gameMap.tileMap.mapHeight * 16 - 4 * 16 &&
            gameMap.player.getPosition().y >= 4 * 16 - 8)
            cam.position.y = gameMap.player.getPosition().y + 4;
        cam.update();

        if (gameMap.player.getPosition().x < 6 * 16) cam.position.x = 104;
        if (gameMap.player.getPosition().y < 4 * 16 - 8) cam.position.y = 60.5f;
        if (gameMap.player.getPosition().x > gameMap.tileMap.mapWidth * 16 - 7 * 16)
            cam.position.x = (gameMap.tileMap.mapWidth * 16 - 7 * 16) + 8;
        if (gameMap.player.getPosition().y > gameMap.tileMap.mapHeight * 16 - 4 * 16)
            cam.position.y = (gameMap.tileMap.mapHeight * 16 - 4 * 16) + 4;
    }

    public void update(float dt) {
        if (currentEvent != EventState.PAUSE) {
            // update game time
            gameMap.time += dt;
        }

        if (currentEvent == EventState.MOVING) {
            updateCamera();

            gameMap.update(dt);
            hud.update(dt);
        }

        if (currentEvent == EventState.BATTLING) {
            // update bg
            for (int i = 0; i < bg.length; i++) {
                bg[i].update(dt);
            }
            battleUIHandler.update(dt);
        }

        if (currentEvent == EventState.TRANSITION) transition.update(dt);
        if (currentEvent == EventState.LEVEL_UP) levelUp.update(dt);
        if (currentEvent == EventState.TILE_EVENT) dialog.update(dt);
        if (currentEvent == EventState.INVENTORY) game.inventoryUI.update(dt);
    }

    /*public void render(float dt) {
        update(dt);

        // clear screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (renderBatch) {
            game.batch.begin();

            // fix fading
            if (batchFade) game.batch.setColor(Color.WHITE);

            if (currentEvent == EventState.BATTLING || transition.renderBattle) {
                // bg camera
                game.batch.setProjectionMatrix(battleUIHandler.getStage().getCamera().combined);
                for (int i = 0; i < bg.length; i++) {
                    bg[i].render(game.batch);
                }
            }

            if (currentEvent == EventState.MOVING || currentEvent == EventState.INVENTORY ||
                transition.renderMap || currentEvent == EventState.TILE_EVENT ||
                currentEvent == EventState.DEATH || currentEvent == EventState.PAUSE) {
                // map camera
                game.batch.setProjectionMatrix(cam.combined);
                // render map and player
                gameMap.render(dt, game.batch, cam);
            }

            game.batch.end();
        }

        if (currentEvent == EventState.MOVING || currentEvent == EventState.DEATH || currentEvent == EventState.PAUSE)
            hud.render(dt);
        if (currentEvent == EventState.BATTLING || transition.renderBattle)
            battleUIHandler.render(dt);
        if (currentEvent == EventState.LEVEL_UP || transition.renderLevelUp)
            levelUp.render(dt);
        if (currentEvent == EventState.TILE_EVENT) dialog.render(dt);
        if (currentEvent == EventState.INVENTORY) game.inventoryUI.render(dt);
        if (currentEvent == EventState.TRANSITION) transition.render(dt);

        //game.profile("GameScreen");
    }
    */

    public void dispose() {
        super.dispose();
        hud.dispose();
        battleUIHandler.dispose();
        dialog.dispose();
        levelUp.dispose();
    }

// --- Ajout d'une transition des events -
    public void setCurrentEvent(EventState event) {
        this.currentEvent = event;
    }

}