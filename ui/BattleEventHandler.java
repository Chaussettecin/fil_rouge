package ui;

import java.awt.Image;
import java.awt.Label;

import org.graalvm.compiler.phases.common.NodeCounterPhase.Stage;

import event.Battle;
import event.BattleEvent;
import map.TileMap;
import perso.Player;
import resource.ResourceManager;
import resource.Util;
import screen.GameScreen;

//-- Rend une boîte de dialogue qui crée des animations de texte à partir de texte
//-- Les animations de texte sont lancées avec des tableaux de chaînes où chaque élément représente
	//--un cycle d'animation et une transition d'un élément à l'autre réinitialise l'animation.
	//--Gère les événements de combat une fois les événements de texte terminés

public class BattleEventHandler extends BattleUI {

    private Stage stage;
    private float stateTime = 0;

    // the ui for displaying text
    private Image ui;
    // Label for text animation
    private Label textLabel;
    // invisible Label for clicking the window
    private Label clickLabel;

//--- Information Texte **** 
    private String currentText = "";
    private String[] currentDialog = new String[0];
    private String[] anim;
    private String resultingText = "";
    
    private int animIndex = 0;
    private int dialogIndex = 0;

    private boolean beginCycle = false;
    private boolean endCycle = false;
    
    private BattleEvent prevEvent = BattleEvent.NONE;
    private BattleEvent nextEvent = BattleEvent.NONE;

    // creates the blinking triangle effect when text is done animating
    private boolean posSwitch = false;
    private float posTime = 0;

    public BattleEventHandler(GameScreen gameScreen, TileMap tileMap, Player player, Battle battle,
                              BattleUIHandler uiHandler, Stage stage, final ResourceManager rm) {
        super(gameScreen, tileMap, player, battle, uiHandler, rm);

        this.stage = stage;

        //-- create main UI -- 
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
        textLabel.setSize(175, 26);
        textLabel.setAlignment(Align.topLeft);
        stage.addActor(textLabel);

        clickLabel = new Label("", font);
        clickLabel.setSize(200, 120);
        clickLabel.setPosition(0, 0);

        final Player p = player;
        clickLabel.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (dialogIndex + 1 == currentDialog.length && endCycle) {
                    if (!p.settings.muteSfx) rm.textprogression.play(p.settings.sfxVolume);
                    // the text animation has run through every element of the text array
                    endDialog();
                    handleBattleEvent(nextEvent);
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

//-- Démarre le processus d'animation de texte avec un tableau de chaînes
   //Prend également un BattleEvent appelé une fois la boîte de dialogue terminée.
    public void startDialog(String[] dialog, BattleEvent prev, BattleEvent next) {
        
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

//-- Total Reset -
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
         
            // un nouveau personnage est ajouté à l'animation TEXT_SPEED
            if (stateTime > Util.TEXT_SPEED && animIndex < anim.length && !endCycle) {
                resultingText += anim[animIndex];
                textLabel.setText(resultingText);
                animIndex++;
                stateTime = 0;
            }
        }
    }

    public void render(float dt) {
        
    	if (endCycle) {
            // blinking indicator
            posTime += dt;
            
            if (posTime >= 0.5f) {
                posTime = 0;
                posSwitch = !posSwitch;
            }

            //GameScreen.getBatch().setProjectionMatrix(stage.getCamera().combined);
           // GameScreen.getBatch().begin();
            // render red arrow to show when a text animation cycle is complete
            //if (posSwitch) GameScreen.getBatch().draw(rm.redarrow10x9, 182, 10);
            //else GameScreen.getBatch().draw(rm.redarrow10x9, 182, 12);
            //gameScreen.getBatch().end();
        }
    }

//-- Gère les événements de combat et le système tour par tour --
    public void handleBattleEvent(BattleEvent event) {
       
    	switch (event) {
            case NONE:
                return;
            case END_BATTLE:
                // update battle stats
            	player.stats.updateMax(player.stats.maxDamageSingleBattle, battle.cumulativeDamage);
                player.stats.updateMax(player.stats.maxHealSingleBattle, battle.cumulativeHealing);
                battle.cumulativeDamage = battle.cumulativeHealing = 0;
                rm.battleTheme.stop();

                player.resetShield();
                battle.resetBuffs();
                player.statusEffects.clear();
                gameScreen.setCurrentEvent(EventState.TRANSITION);
                gameScreen.transition.start(EventState.BATTLING, EventState.MOVING);
                break;
            case PLAYER_TURN:
                uiHandler.moveUI.toggleMoveAndOptionUI(true);
                uiHandler.currentState = BattleState.MOVE;

                // sacrifice move sets player hp to 1
                if (battle.buffs[Util.SACRIFICE]) {
                    battle.psacrifice = ((player.getHp() - 1) / (float) player.getMaxHp()) + 1;
                    player.hit(player.getHp() - 1);
                    player.applyDamage();
                    gameScreen.battleUIHandler.battleScene.playerHudLabel.setText("HP: " + player.getHp() + "/" + player.getMaxHp());
                }

                if (prevEvent == BattleEvent.ENEMY_TURN) {
                    player.statusEffects.clear();
                    if (battle.opponent.statusEffects.contains(StatusEffect.DMG_RED))
                        battle.opponent.statusEffects.clearAllButMultiTurnEffects();
                    else
                        battle.opponent.statusEffects.clear();

                    if (battle.buffs[Util.REFLECT]) {
                        battle.resetBuffs();
                        // double heal
                        if (battle.opponent.getPrevMoveUsed() != -1) {
                            battle.opponent.applyHeal();
                        }
                        // damage move
                        else {
                            player.setMoveUsed(player.getPrevMoveUsed());
                            player.setPrevMoveUsed(-1);
                            if (applyEnemyDamage()) return;
                        }
                    }
                    else {
                        if (applyPlayerDamage()) return;
                        battle.opponent.applyHeal();
                    }
                }
                break;
            case ENEMY_TURN:
                if (prevEvent == BattleEvent.PLAYER_TURN) {
                    // shield
                    if (battle.buffs[Util.SHIELD]) {
                        player.setShield((int) ((Util.P_SHIELD / 100f) * (float) player.getMaxHp()));
                    }
                    if (battle.opponent.statusEffects.contains(StatusEffect.DMG_RED))
                        battle.opponent.statusEffects.clearAllButSingleTurnEffects();
                    if (applyEnemyDamage()) return;
                    player.applyHeal();
                }
                String[] dialog = battle.enemyTurn();
                startDialog(dialog, BattleEvent.ENEMY_TURN, BattleEvent.PLAYER_TURN);
                break;
            case LEVEL_UP:
                // update battle stats
                player.stats.updateMax(player.stats.maxDamageSingleBattle, battle.cumulativeDamage);
                player.stats.updateMax(player.stats.maxHealSingleBattle, battle.cumulativeHealing);
                battle.cumulativeDamage = battle.cumulativeHealing = 0;
                player.resetShield();
                player.statusEffects.clear();
                gameScreen.setCurrentEvent(EventState.LEVEL_UP);
                gameScreen.levelUp.start();
                rm.battleTheme.stop();
                break;
            case PLAYER_DEAD:
                // update battle stats
                player.stats.updateMax(player.stats.maxDamageSingleBattle, battle.cumulativeDamage);
                player.stats.updateMax(player.stats.maxHealSingleBattle, battle.cumulativeHealing);
                battle.cumulativeDamage = battle.cumulativeHealing = 0;
                rm.battleTheme.stop();
                player.inMap = false;

                player.resetShield();
                player.statusEffects.clear();
                gameScreen.setCurrentEvent(EventState.TRANSITION);
                gameScreen.transition.start(EventState.BATTLING, EventState.DEATH);
                break;
        }
    }

 //-- Applique les dégâts infligés au joueur et vérifie s'ils sont morts -
    private boolean applyPlayerDamage() {
        
    	player.applyDamage();
        gameScreen.battleUIHandler.battleScene.playerHudLabel.setText("HP: " + player.getHp() + "/" + player.getMaxHp());
       // Joueur = GAME OVER - 
        if (player.isDead()) {
            // reset anime
            battle.opponent.setPrevMoveUsed(-1);
            battle.opponent.setMoveUsed(-1);
            player.resetShield();
            battle.resetBuffs();
            player.statusEffects.clear();

            uiHandler.moveUI.toggleMoveAndOptionUI(false);
            uiHandler.currentState = BattleState.DIALOG;
            // 1% chance for revival after dead
            if (Util.isSuccess(Util.REVIVAL)) {
                startDialog(new String[] {
                        "You took fatal damage and died!",
                        "However, it looks like luck was on your side and you revived!"
                }, BattleEvent.PLAYER_TURN, BattleEvent.PLAYER_TURN);
                player.setHp(player.getMaxHp());
                player.setDead(false);
                return true;
            }
            else {
                if (!player.settings.muteSfx) rm.death.play(player.settings.sfxVolume);
                startDialog(new String[] {
                        "Oh no, you took fatal damage and died!",
                        "You will lose " + Util.DEATH_PENALTY +
                            "% of your exp and gold and all the items obtained in this level as a penalty."
                }, BattleEvent.PLAYER_TURN, BattleEvent.PLAYER_DEAD);
                gameScreen.gameMap.setDeath();

                player.stats.numDeaths++;
                return true;
            }
        }
        return false;
    }

//-- Applique les dégâts infligés à l'ennemi et vérifie s'il est mort
    private boolean applyEnemyDamage() {
        
    	Battle.opponent.applyDamage();
      
        //-- Ennemis KO-- 
        if (battle.opponent.isDead()) {
            // reset animation
            player.setPrevMoveUsed(-1);
            player.setMoveUsed(-1);
            player.statusEffects.clear();
            battle.resetBuffs();

            uiHandler.moveUI.toggleMoveAndOptionUI(false);
            uiHandler.currentState = BattleState.DIALOG;

            if (bossDeathEvents()) return true;

            // 1% chance for enemy revival (bosses can't revive)
            if (Util.isSuccess(Util.REVIVAL) && !battle.opponent.isBoss()) {
                startDialog(new String[] {
                        "The enemy took fatal damage and died!",
                        "Oh no, it looks like the enemy has been revived!"
                }, BattleEvent.ENEMY_TURN, BattleEvent.ENEMY_TURN);
                battle.opponent.setHp(battle.opponent.getMaxHp());
                battle.opponent.setDead(false);
                return true;
            }
            // defeated enemy and gained experience and gold
            // maybe the player gets an item
            else {
                if (!player.settings.muteSfx) rm.death.play(player.settings.sfxVolume);

                int expGained = battle.getBattleExp();
                int goldGained = battle.getGoldGained();
                Item itemGained = battle.getItemObtained(rm);

                if (itemGained != null) {
                    player.stats.numItemsFromMonsters++;
                    if (itemGained.rarity == 0) player.stats.numCommonItems++;
                    else if (itemGained.rarity == 1) player.stats.numRareItems++;
                    else if (itemGained.rarity == 2) player.stats.numEpicItems++;
                    else if (itemGained.rarity == 3) player.stats.numLegendaryItems++;
                }

                // add things obtained to map record
                gameScreen.gameMap.expObtained += expGained;
                gameScreen.gameMap.goldObtained += goldGained;

                player.addGold(goldGained);
                player.stats.cumulativeGold += goldGained;
                player.stats.cumulativeExp += expGained;

                if (battle.opponent.isElite()) player.stats.elitesDefeated++;
                else if (battle.opponent.isBoss()) player.stats.bossesDefeated++;
                else player.stats.enemiesDefeated++;

             //--- level up  --- 
                if (player.getExp() + expGained >= player.getMaxExp()) {
                    int remainder = (player.getExp() + expGained) - player.getMaxExp();
                    player.levelUp(remainder);
                    startDialog(new String[] {
                            "Tu as perdu  " + battle.opponent.getId() + "!",
                            "Tu optiens " + goldGained + " gold.",
                            battle.getItemDialog(itemGained),
                            "Tu gagnes " + expGained + " d'XP.",
                            "Level up !!"
                    }, BattleEvent.ENEMY_TURN, BattleEvent.LEVEL_UP);
                    return true;
                }
                else {
                    player.addExp(expGained);
                    startDialog(new String[] {
                            "Tu as perdu " + battle.opponent.getId() + "!",
                            "Tu optiens  " + goldGained + " gold.",
                            battle.getItemDialog(itemGained),
                            "Tu gagnes  " + expGained + " d'XP."
                    }, BattleEvent.ENEMY_TURN, BattleEvent.END_BATTLE);
                    return true;
                }
            }
        }
        return false;
    }

//--- Le Boss peut avoir un évent spécial à sa mort - 
    private boolean bossDeathEvents() {
        
    	if (battle.opponent.isBoss()) {
            Boss b = (Boss) battle.opponent;

            // king slime respawn
            if (b.bossId == 0) {
                if (battle.opponent.numRespawn + 1 < 4) {
                    battle.opponent.numRespawn++;
                    // shrink king slime
                    battle.opponent.battleSize -= 8;
                    battle.opponent.setOnlyMaxHp((int) Math.ceil(battle.opponent.getMaxHp() / 2));
                    battle.opponent.setPreviousHp(0);
                    battle.opponent.setHp(battle.opponent.getMaxHp());
                    battle.opponent.setDead(false);

                    startDialog(new String[] {
                            "King Slime respawned with half its health points!",
                            "It will respawn " + (3 - battle.opponent.numRespawn) + " more time(s)!"
                    }, BattleEvent.ENEMY_TURN, BattleEvent.ENEMY_TURN);
                    return true;
                }
            }
        }
        return false;
    }

}
