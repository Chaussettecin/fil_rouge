import java.awt.Color;
import java.awt.Image;
import java.awt.Label;

import event.EventState;
import resource.ResourceManager;
import screen.GameScreen;

//-- Place une boîte de dialogue qui gère les événements à partir de l'état de l'événement.
//-- Fondamentalement identique à BattleEventHandler mais pour les événements de carte
 
public class DialogScreen extends UI {

    private float stateTime = 0;

    // the ui for displaying text
    private Image ui;
    // Label for text animation
    private Label textLabel;
    // invisible Label for clicking the window
    private Label clickLabel;

    // text animation
    private String currentText = "";
    private String[] currentDialog = new String[0];
    private int dialogIndex = 0;
    private String[] anim;
    private String resultingText = "";
    private int animIndex = 0;

    private boolean beginCycle = false;
    private boolean endCycle = false;
    
    private EventState prevEvent = EventState.NONE;
    private EventState nextEvent = EventState.NONE;

//// crée l'effet triangle clignotant lorsque le texte est animé
    private boolean posSwitch = false;
    private float posTime = 0;

    public DialogScreen(GameScreen GameScreen, Player player, final ResourceManager rm) {
        super(GameScreen, player, rm);

        // create main UI
        ui = new Image(rm.dialogBox400x80);
        ui.setSize(200, 40);
        ui.setPosition(0, 0);
        ui.setTouchable(Touchable.disabled);

        stage.addActor(ui);

        // create Labels
        BitmapFont bitmapFont = rm.pixel10;
        Label.LabelStyle font = new Label.LabelStyle(bitmapFont, new Color(0, 0, 0, 255));

        textLabel = new Label("", font);
        textLabel.setWrap(true);
        textLabel.setTouchable(Touchable.disabled);
        textLabel.setFontScale(1.7f / 2);
        textLabel.setPosition(8, 6);
        textLabel.setSize(350 / 2, 52 / 2);
        textLabel.setAlignment(Align.topLeft);
        stage.addActor(textLabel);

        clickLabel = new Label("", font);
        clickLabel.setSize(200, 120);
        clickLabel.setPosition(0, 0);

        Player p = player;
        clickLabel.addListener(new ClickListener() {
           
        	@Override
            public void clicked(InputEvent event, float x, float y) {
                if (dialogIndex + 1 == currentDialog.length && endCycle) {
                    if (!p.settings.muteSfx) rm.textprogression.play(p.settings.sfxVolume);
                    // the text animation has run through every element of the text array
                    endDialog();
                    handleEvent(nextEvent);
                }
                // after a cycle of text animation ends, clicking the UI goes to the next cycle
                else if (endCycle && dialogIndex < currentDialog.length) {
                    if (!p.settings.muteSfx) rm.textprogression.play(p.settings.sfxVolume);
                    dialogIndex++;
                    reset();
                    currentText = currentDialog[dialogIndex];
                    anim = currentText.split("");
                    beginCycle = true;
                }
                // clicking on the box during a text animation completes it early
                else if (beginCycle && !endCycle) {
                    resultingText = currentText;
                    textLabel.setText(resultingText);
                    beginCycle = false;
                    endCycle = true;
                }
            }
        });
        stage.addActor(clickLabel);
    }

//--  Démarre le processus d'animation de texte avec un tableau de chaînes
   //Prend également un BattleEvent appelé une fois la boîte de dialogue terminée.
    public void startDialog(String[] dialog, EventState prev, EventState next) {
        
    	ui.setVisible(true);
        textLabel.setVisible(true);
        clickLabel.setVisible(true);
        clickLabel.setTouchable(Touchable.enabled);

        currentDialog = dialog;
        currentText = currentDialog[0];
        anim = currentText.split("");

        prevEvent = prev;
        nextEvent = next;
        beginCycle = true;
    }

    public void endDialog() {
        reset();
        ui.setVisible(false);
        textLabel.setVisible(false);
        clickLabel.setVisible(false);
        clickLabel.setTouchable(Touchable.disabled);
        dialogIndex = 0;
        currentDialog = new String[0];
    }

//--- Reset toutes les variables -- 
    public void reset() {
       
    	stateTime = 0;
        currentText = "";
        textLabel.setText("");
        resultingText = "";
        animIndex = 0;
        anim = new String[0];
        beginCycle = false;
        endCycle = false;
    }

    public void update(float dt) {
       
    	if (beginCycle) {
            stateTime += dt;

            if (animIndex >= anim.length) endCycle = true;
            // a new character is appended to the animation every TEXT_SPEED delta time
            if (stateTime > Util.TEXT_SPEED && animIndex < anim.length && !endCycle) {
                resultingText += anim[animIndex];
                textLabel.setText(resultingText);
                animIndex++;
                stateTime = 0;
            }
        }
    }

    public void render(float dt) {
        
    	stage.act(dt);
        stage.draw();

        if (endCycle) {
            // blinking indicator
            posTime += dt;
            if (posTime >= 0.5f) {
                posTime = 0;
                posSwitch = !posSwitch;
            }

            GameScreen.getBatch().setProjectionMatrix(stage.getCamera().combined);
            GameScreen.getBatch().begin();
            // render red arrow to show when a text animation cycle is complete
            if (posSwitch) GameScreen.getBatch().draw(rm.redarrow10x9, 182, 10);
            else GameScreen.getBatch().draw(rm.redarrow10x9, 182, 12);
            GameScreen.getBatch().end();
        }
    }

    public void handleEvent(EventState event) {
       
    	switch (event) {
            
    		case MOVING:
                player.finishTileInteraction();
                TextureRegion none = null;
                GameScreen.gameMap.tileMap.setTile(GameScreen.gameMap.tileMap.toTileCoords(player.getPosition()),
                        new Tile(-1, none, GameScreen.gameMap.tileMap.toTileCoords(player.getPosition())));
                // player died from tile
                if (player.getHp() <= 0) {
                    GameScreen.gameMap.setDeath();
                    GameScreen.die();
                    return;
                }
                GameScreen.setCurrentEvent(EventState.MOVING);
                GameScreen.hud.toggle(true);
                break;
        }
    }

}