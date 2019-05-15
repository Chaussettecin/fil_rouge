package event;

import Battle.move;
import Battle.statusEffect;
import inventory.Item;
import map.TileMap;
import perso.Player;
import perso.enemy;
import resource.ResourceManager;
import resource.Util;
import screen.GameScreen;

//-- Incarne des �v�nements et g�re les calculs --
public class Battle {

    // the enemy the player is facing
    public enemy opponent;

    private GameScreen gameScreen;
    public TileMap tileMap;
    private Player player;

    // dmg reduction from heals, -1 if no reduction
    public int playerRed = -1;
    public int enemyRed = -1;
    // special move buffs
    public boolean[] buffs;

    // sacrifice percentage dmg
    public float psacrifice = 0;

    // cumulative damage by player over the battle
    public int cumulativeDamage = 0;
    // cumulative healing by player over the battle
    public int cumulativeHealing = 0;

    public Battle(GameScreen gameScreen, TileMap tileMap, Player player) {
        this.gameScreen = gameScreen;
        this.tileMap = tileMap;
        this.player = player;

        buffs = new boolean[Util.NUM_SPECIAL_MOVES];
        resetBuffs();
    }

    public void resetBuffs() {
        for (int i = 0; i < buffs.length; i++) buffs[i] = false;
    }

    /**
     * Sets and scales the enemy's stats according to its level
     * If the enemy is an elite, then its stats are between 1.3-1.6x higher
     * If boss, then stats are 2.4-3.0x higher
     *
     * @param opponent
     */
    public void begin(enemy opponent) {
        this.opponent = opponent;

        // set opponent's level to be -1 to 1 added to the avg map level
        opponent.setLevel(Util.getDeviatedRandomValue(gameScreen.gameMap.avgLevel, 1));
        if (opponent.getLevel() <= 0) opponent.setLevel(1);

        opponent.setStats();
    }


//--  Handles and applies the damage/heal of a move to an Entity
    	// @param move 
    	// @return  a string array for the dialog ui description
    public String[] handleMove(move move) {
        
    	String[] dialog = null;

        // distract/enemy debuff
        if (buffs[Util.DISTRACT]) {
        	
            opponent.statusEffects.add(statusEffect.DISTRACT);
            opponent.setAccuracy(opponent.getAccuracy() - Util.P_DISTRACT);
        }
        else opponent.setAccuracy(MathUtils.random(Util.ENEMY_MIN_ACCURACY, Util.ENEMY_MAX_ACCURACY));

        // for red reaper boss's 30% acc debuff passive
        boolean redReaperDebuff = false;
        if (opponent.isBoss()) redReaperDebuff = ((Boss) opponent).bossId == 1;

        // accounting for player accuracy or accuracy buff
        if (Util.isSuccess(player.getAccuracy() - (redReaperDebuff ? 40 : 0)) || buffs[Util.FOCUS]) {
            // accurate or wide
            if (move.type < 2) {
                int damage = MathUtils.random(Math.round(move.minDamage), Math.round(move.maxDamage));
                if (buffs[Util.INTIMIDATE]) damage *= Util.INTIMIDATE_MULT;
                if (buffs[Util.SACRIFICE]) damage *= psacrifice;

                if (buffs[Util.INVERT]) {
                    // for heal animation
                    player.move(3);
                    player.heal(damage);
                    player.stats.hpHealed += damage;
                    player.stats.updateMax(player.stats.maxHealSingleMove, damage);
                    cumulativeHealing += damage;

                    dialog = new String[] {
                            "You used inverted " + move.name + "!",
                            "It healed you for " + damage + " health points!"
                    };
                }
                else {
                    
                	player.move(move.type);
                    damage = reduceDamage(damage);
                    cumulativeDamage += damage;
                    player.stats.damageDealt += damage;
                    player.stats.updateMax(player.stats.maxDamageSingleHit, damage);

                    opponent.hit(damage);
                    dialog = new String[]{
                            "Tu as utilis�s " + move.name + "!",
                            "il y a  " + damage + " d�gats sur " + opponent.getId() + "."
                    };
                }
            }
            // crit (3x damage if success)
            else if (move.type == 2) {
                int damage = Math.round(move.minDamage);
                int critChance;

                if (buffs[Util.INTIMIDATE]) damage *= Util.INTIMIDATE_MULT;
                if (buffs[Util.SACRIFICE]) damage *= psacrifice;
                if (buffs[Util.FOCUS]) critChance = move.crit + Util.P_FOCUS_CRIT;
                else critChance = move.crit;

                if (Util.isSuccess(critChance)) {
                    damage *= Util.CRIT_MULTIPLIER;
                    if (buffs[Util.INVERT]) {
                        player.move(3);
                        player.heal(damage);
                        player.stats.hpHealed += damage;
                        player.stats.updateMax(player.stats.maxHealSingleMove, damage);
                        cumulativeHealing += damage;

                        dialog = new String[] {
                                "You used inverted " + move.name + "!",
                                "It's a critical strike!",
                                "It healed you for " + damage + " health points!"
                        };
                    }
                    else {
                        player.move(move.type);
                        damage = reduceDamage(damage);
                        cumulativeDamage += damage;
                        player.stats.damageDealt += damage;
                        player.stats.updateMax(player.stats.maxDamageSingleHit, damage);

                        opponent.hit(damage);
                        dialog = new String[]{
                                "You used " + move.name + "!",
                                "It's a critical strike!",
                                "It did " + damage + " damage to " + opponent.getId() + "."
                        };
                    }
                } else {
                    if (buffs[Util.INVERT]) {
                        player.move(3);
                        player.heal(damage);
                        player.stats.hpHealed += damage;
                        player.stats.updateMax(player.stats.maxHealSingleMove, damage);
                        cumulativeHealing += damage;

                        dialog = new String[] {
                                "You used inverted " + move.name + "!",
                                "It healed you for " + damage + " health points!"
                        };
                    }
                    else {
                        player.move(move.type);
                        damage = reduceDamage(damage);
                        cumulativeDamage += damage;
                        player.stats.damageDealt += damage;
                        player.stats.updateMax(player.stats.maxDamageSingleHit, damage);

                        opponent.hit(damage);
                        dialog = new String[]{
                                "You used " + move.name + "!",
                                "It did " + damage + " damage to " + opponent.getId() + "."
                        };
                    }
                }
            }
            // heal + set dmg reduction for next turn
            else if (move.type == 3) {
                int heal = MathUtils.random(Math.round(move.minHeal), Math.round(move.maxHeal));
                if (buffs[Util.INVERT]) {
                    player.useMove(MathUtils.random(0, 2));
                    opponent.hit(heal);
                    cumulativeDamage += heal;
                    player.stats.damageDealt += heal;
                    player.stats.updateMax(player.stats.maxDamageSingleHit, heal);

                    dialog = new String[] {
                            "You used inverted " + move.name + "!",
                            "It did " + heal + " damage to " + opponent.getId() + "."
                    };
                }
                else {
                    player.move(move.type);
                    playerRed = move.dmgReduction;
                    player.heal(heal);
                    cumulativeHealing += heal;
                    player.stats.hpHealed += heal;
                    player.stats.updateMax(player.stats.maxHealSingleMove, heal);
                    player.statusEffects.addEffect(StatusEffect.DMG_RED);

                    dialog = new String[]{
                            "You used " + move.name + "!",
                            "The enemy's next attack does -" + move.dmgReduction + "% damage!",
                            "You healed for " + heal + " health points."
                    };
                }
            }
        }
        else {
            player.stats.numMovesMissed++;
            // move missed; enemy turn
            dialog = new String[] {"Oh no, your move missed!"};
        }

        return dialog;
    }


//--- Enemy picks a random move out of its random moveset
    //-- @return the dialog of the enemy's move and damage
    public String[] enemyTurn() {
        // skip turn if stunned
        if (buffs[Util.STUN]) {
            if (Util.isSuccess(Util.P_STUN)) {
                resetBuffs();
                opponent.statusEffects.addEffect(StatusEffect.STUN);
                return new String[] {
                        "The enemy was stunned and could not move!"
                };
            }
        }

        // get special boss moves
        if (opponent.isBoss()) {
            opponent.getMoveset().reset(opponent.getMinDamage(), opponent.getMaxDamage(), opponent.getMaxHp(), ((Boss) opponent).bossId);
        }
        else {
            opponent.getMoveset().reset(opponent.getMinDamage(), opponent.getMaxDamage(), opponent.getMaxHp());
        }
        String[] dialog = null;
        Move move = opponent.getMoveset().moveset[MathUtils.random(3)];

        if (opponent.isBoss() || opponent.isElite()) {
            // when below 20% hp, elite and bosses will always try to go for heal moves as first priority
            if (opponent.healthBelow(20)) move = opponent.getMoveset().getHealPriority();
            // when player is below 20%, elite and bosses will always go for damage moves
            if (player.healthBelow(20)) move = opponent.getMoveset().getDamagePriority();
        }

        if (Util.isSuccess(opponent.getAccuracy())) {
            // enemy's attack is reflected back at itself
            if (buffs[Util.REFLECT]) {
                // elites and bosses will try to counter reflect by prioritizing heal moves
                if (opponent.isBoss() || opponent.isElite()) move = opponent.getMoveset().getHealPriority();

                // accurate or wide
                if (move.type < 2) {
                    player.useMove(move.type);
                    int damage = MathUtils.random(Math.round(move.minDamage), Math.round(move.maxDamage));
                    opponent.hit(damage);
                    dialog = new String[]{
                            opponent.getId() + " used " + move.name + "!",
                            "The attack was reflected back and did " + damage + " damage to " + opponent.getId() + "!"
                    };
                }
                // crit (3x damage if success)
                else if (move.type == 2) {
                    player.useMove(move.type);
                    int damage = Math.round(move.minDamage);
                    if (Util.isSuccess(move.crit)) {
                        damage *= Util.CRIT_MULTIPLIER;
                        opponent.hit(damage);
                        dialog = new String[]{
                                opponent.getId() + " used " + move.name + "!",
                                "It's a critical strike!",
                                "The attack was reflected back and did " + damage + " damage to " + opponent.getId() + "!"
                        };
                    } else {
                        opponent.hit(damage);
                        dialog = new String[] {
                                opponent.getId() + " used " + move.name + "!",
                                "The attack was reflected back and did " + damage + " damage to " + opponent.getId() + "!"
                        };
                    }
                }
                // heal gets doubled when reflected
                else if (move.type == 3) {
                    opponent.useMove(move.type);
                    int heal = MathUtils.random(Math.round(move.minHeal), Math.round(move.maxHeal));
                    heal *= 2;
                    enemyRed = move.dmgReduction;
                    opponent.heal(heal);
                    dialog = new String[]{
                            opponent.getId() + " used " + move.name + "!",
                            "Your next attack does -" + move.dmgReduction + "% damage!",
                            "The heal was reflected and enhanced the enemy's healing!",
                            opponent.getId() + " healed for " + heal + " health points."
                    };
                }
            }
            else {
                opponent.useMove(move.type);
                // accurate or wide
                if (move.type < 2) {
                    int damage = MathUtils.random(Math.round(move.minDamage), Math.round(move.maxDamage));
                    damage = reduceDamage(damage);
                    player.stats.damageTaken += damage;
                    player.hit(damage);
                    dialog = new String[]{
                            opponent.getId() + " used " + move.name + "!",
                            "It did " + damage + " damage to you."
                    };

                    // ice golem passive
                    if (opponent.isBoss()) {
                        if (((Boss) opponent).bossId == 2 && move.type == 0) {
                            int heal = (int) (0.2 * (float) damage);
                            opponent.heal(heal);
                            dialog = new String[] {
                                opponent.getId() + " used " + move.name + "!",
                                "It did " + damage + " damage to you.",
                                opponent.getId() + "'s Lifesteal healed it for " + heal + " hp!"
                            };
                        }
                    }
                }
                // crit (3x damage if success)
                else if (move.type == 2) {
                    int damage = Math.round(move.minDamage);
                    if (Util.isSuccess(move.crit)) {
                        damage *= Util.CRIT_MULTIPLIER;
                        damage = reduceDamage(damage);
                        player.stats.damageTaken += damage;
                        player.hit(damage);
                        dialog = new String[]{
                                opponent.getId() + " used " + move.name + "!",
                                "It's a critical strike!",
                                "It did " + damage + " damage to you."
                        };
                    } else {
                        damage = reduceDamage(damage);
                        player.stats.damageTaken += damage;
                        player.hit(damage);
                        dialog = new String[]{
                                opponent.getId() + " used " + move.name + "!",
                                "It did " + damage + " damage to you."
                        };
                    }
                }
                // heal
                else if (move.type == 3) {
                    int heal = MathUtils.random(Math.round(move.minHeal), Math.round(move.maxHeal));
                    enemyRed = move.dmgReduction;
                    opponent.heal(heal);
                    opponent.statusEffects.addEffect(StatusEffect.DMG_RED);
                    dialog = new String[]{
                            opponent.getId() + " used " + move.name + "!",
                            "Your next attack does -" + move.dmgReduction + "% damage!",
                            opponent.getId() + " healed for " + heal + " health points."
                    };
                }
            }
        }
        else {
            dialog = new String[] { opponent.getId() + "'s move missed!"};
        }

        // only reset buffs that don't affect enemy's turn
        if (!buffs[Util.REFLECT]) resetBuffs();

        return dialog;
    }

//-- R�duit les dommages d'une entit� par la r�duction des dommages de gu�rison --
    public int reduceDamage(int damage) {
        int dmg = damage;
        if (playerRed != -1) {
            dmg -= ((playerRed / 100f) * damage);
            playerRed = -1;
        }
        else if (enemyRed != -1) {
            dmg -= ((enemyRed / 100f) * damage);
            enemyRed = -1;
        }
        return dmg;
    }

//-- Retourne les dialogues associ�s � chaque coup sp�cial --
    public String[] getSpecialMoveDialog(int index) {
        switch (index) {
            case Util.DISTRACT:
                return new String[] {
                        "You kicked some dirt into the enemy's face.",
                        "The enemy's next attack has " + Util.P_DISTRACT + "% reduced accuracy!"
                };
            case Util.FOCUS:
                return new String[] {
                        "You begin concentrating on your next attack.",
                        "Your next move has 100% accuracy and critical strike chance is increased by " + Util.P_FOCUS_CRIT + "%!"
                };
            case Util.INTIMIDATE:
                return new String[] {
                        "You intimidate the enemy causing it to lower its defense.",
                        "Your next attack has " + Util.P_INTIMIDATE + "% increased damage."
                };
            case Util.REFLECT:
                return new String[] {
                        "You intensely prepare for the enemy's next attack.",
                        "The enemy's next move will be reflected back at itself!"
                };
            case Util.STUN:
                return new String[] {
                        "You attempt to immobilize the enemy by hypnotizing it!",
                        "The enemy may be stunned and miss its turn."
                };
            case Util.INVERT:
                return new String[] {
                        "You manipulate the powers of your moveset.",
                        "Heal moves do damage and damage moves heal for one turn!"
                };
            case Util.SACRIFICE:
                return new String[] {
                        "You sacrifice all but 1 HP!",
                        "Your next attack has " + (int) Math.ceil(((player.getHp() - 1) / (float) player.getMaxHp()) * 100) +
                                "% increased damage!"
                };
            case Util.SHIELD:
                return new String[] {
                        "You channel your defenses for the enemy's next attack.",
                        "You summon a shield that absorbs " + (int) ((Util.P_SHIELD / 100f) * (float) player.getMaxHp()) + " damage!"
                };
        }
        return null;
    }

// --1-3 points d'exp�rience suppl�mentaires de l'ennemi pour �quilibrer la croissance des points d'exp�rience
    //-- * Les monstres d'�lite donnent 1.5x exp et les boss donnent 3x exp
    public int getBattleExp() {
        if (opponent.isElite())
            return (int) (1.5 * Util.calculateExpEarned(opponent.getLevel(), MathUtils.random(2) + 1));
        else if (opponent.isBoss())
            return (3 * Util.calculateExpEarned(opponent.getLevel(), MathUtils.random(2) + 1));
        else
            return Util.calculateExpEarned(opponent.getLevel(), MathUtils.random(2));
    }

//-- Or gagn� �chelles sur le niveau ennemi et le niveau de joueur
   // Le joueur recevra moins d'or plus la diff�rence de niveau sera grande et vice versa
    // (player.level - ennemi.level)
    public int getGoldGained() {
        int gold = 0;
        int diff = player.getLevel() - opponent.getLevel();

        for (int i = 0; i < opponent.getLevel(); i++) {
            gold += MathUtils.random(2) + 1;
        }
        gold -= (opponent.getLevel() * diff);
        if (gold <= 0) gold = 1;

        return gold;
    }

//-- Traite les probabilit�s que l��l�ment tombe de l�ennemi et
    //-- renvoie l'article qu'ils ont d�pos�
     //-- Retourne la valeur null si l'ennemi ne l�che pas d'objet
    public Item getItemObtained(ResourceManager rm) {
        if (opponent.isElite()) {
            if (Util.isSuccess(Util.ELITE_ITEM_DROP)) {
                // elite will drop rare, epic, and legendary items at 60/30/10 chances
                int k = MathUtils.random(99);
                // rare
                if (k < 60) {
                    return rm.getItem(1, opponent.getLevel());
                }
                else if (k < 90) {
                    return rm.getItem(2, opponent.getLevel());
                }
                else if (k < 100) {
                    return rm.getItem(3, opponent.getLevel());
                }
            }
        }
        else if (opponent.isBoss()) {
            if (Util.isSuccess(Util.BOSS_ITEM_DROP)) {
                // boss will only drop epic and legendary items at 70/30 chances
                int k = MathUtils.random(99);
                // epic
                if (k < 70) {
                    return rm.getItem(2, opponent.getLevel());
                }
                // legendary
                else {
                    return rm.getItem(3, opponent.getLevel());
                }
            }
        }
        else {
            if (Util.isSuccess(Util.NORMAL_ITEM_DROP)) {
                return rm.getRandomItem(opponent.getLevel());
            }
        }
        return null;
    }

    public String getItemDialog(Item item) {
        
    	String ret = "";

        // enemy didn't drop an item
        if (item == null) {
            ret = "The enemy didn't drop an item.";
        }
        else {
            // if the player's inventory is full then he cannot obtain the item
            if (player.inventory.isFull()) {
                ret = "The enemy couldn't drop an item since your inventory was full.";
            }
            else {
                ret = "The enemy dropped a " + item.getDialogName() + "! " +
                        "The item was added to your inventory.";
                // scale item stats to match enemy level
                item.adjust(opponent.getLevel());
                player.inventory.addItem(item);
                gameScreen.gameMap.itemsObtained.add(item);
            }
        }

        return ret;
    }

//-- Retourne � l'�tat de la carte -
    public void end() {
        
    	opponent = null;
        tileMap.removeEntity(tileMap.toTileCoords(player.getPosition()));
        player.finishBattling();
        gameScreen.setCurrentEvent(EventState.MOVING);
        gameScreen.hud.toggle(true);
    }

}