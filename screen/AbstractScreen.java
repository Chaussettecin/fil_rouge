package screen;

import main.RPG;
import resource.ResourceManager;

// --- Affichage ---
public abstract class AbstractScreen implements Screen  {

    protected RPG game;
    protected ResourceManager rm;

    // camera that focuses on the player
    protected OrthographicCamera cam;
    // viewport that keeps aspect ratios of the game when resizing
    protected Viewport viewport;
    // main stage of each screen
    protected Stage stage;

    // to delay the batch rendering until after transition finishes
    protected boolean renderBatch = false;
    // to toggle color fading for batch draw calls
    protected boolean batchFade = true;
    // to remove previous clicks buffered before switching the screen
    protected boolean clickable = true;

    public AbstractScreen (final RPG game, final ResourceManager rm) {
        
    	this.game = game;
        this.rm = rm;

        cam = new OrthographicCamera(RPG.V_WIDTH, RPG.V_HEIGHT);
        cam.setToOrtho(false);
        // the game will retain it's scaled dimensions regardless of resizing
        viewport = new StretchViewport(RPG.V_WIDTH, RPG.V_HEIGHT, cam);

        stage = new Stage(viewport, game.batch);
    }

    public AbstractScreen(RPG game2, ResourceManager rm2) {
		// TODO Auto-generated constructor stub
	}

	@Override
    public void render(float dt) {
        stage.act(dt);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void show() {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        stage.dispose();
    }

    public Stage getStage() {
        return stage;
    }

    public OrthographicCamera getCamera() {
        return cam;
    }

    public SpriteBatch getBatch() {
        return game.batch;
    }

    public RPG getGame() { return game; }

//Bascule vers un nouvel écran tout en gérant le tampon de fondu
    //Transition en fondu
    public void setFadeScreen(final Screen screen) {
        if (clickable) {
            clickable = false;
            batchFade = false;
            // fade out animation
            stage.addAction(Actions.sequence(Actions.fadeOut(0.3f),
                Actions.run(new Runnable() {
                    @Override
                    public void run() {
                        clickable = true;
                        game.setScreen(screen);
                    }
                })));
        }
    }

//Bascule vers un nouvel écran tout en gérant le tampon de fondu
   //Faites glisser la transition vers la gauche ou la droite
    public void setSlideScreen(final Screen screen, boolean right) {
        
    	if (clickable) {
            clickable = false;
            batchFade = true;
            // slide animation
            stage.addAction(Actions.sequence(
                Actions.moveBy(right ? -RPG.V_WIDTH : RPG.V_WIDTH, 0, 0.15f),
                Actions.run(new Runnable() {
                    
                	@Override
                    public void run() {
                        clickable = true;
                        game.setScreen(screen);
                    }
                })));
        }
    }

    public boolean isRenderBatch() {
        return renderBatch;
    }

    public void setRenderBatch(boolean renderBatch) {
        this.renderBatch = renderBatch;
    }

    public boolean isBatchFade() {
        return batchFade;
    }

    public void setBatchFade(boolean batchFade) {
        this.batchFade = batchFade;
    }

    public boolean isClickable() {
        return clickable;
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }

}
