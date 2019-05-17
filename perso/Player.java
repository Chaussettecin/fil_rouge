package perso;

import java.util.ArrayList;

import Battle.SpecialMoveset;
import Battle.moveSet;
import Battle.statusSet;
import inventory.Equipment;
import inventory.Inventory;
import inventory.Item;
import map.GameMap;
import map.Tile;
import map.TileMap;
import resource.ResourceManager;
import resource.Statistics;
import resource.Util;
import save.Settings;

public class Player {

// -1 -- Stop
// 0 --- Down
// 1 --- Up 
// 2 - Right
// 3 - left
  
    public int moving = -1;
    // entity is in a continuous movement
    private float speed;
    // the Entity's current tile coordinates
    private int currentTileX;
    private int currentTileY;
    private int prevDir = -1;
    // tile causing a dialog event
    private boolean tileInteraction = false;
    // teleportation tiles
    private boolean teleporting = false;
    // end tiles
    public boolean completedMap = false;

    // Statistics
    public Statistics stats = new Statistics();

    // Battle
    private enemy opponent;
    private boolean battling = false;

    // exp and level up
    private int exp;
    private int maxExp;

    private int hpIncrease = 0;
    private int minDmgIncrease = 0;
    private int maxDmgIncrease = 0;
    private int accuracyIncrease = 0;
    private int maxExpIncrease = 0;

    // gold
    private int gold = 0;

    // inventory and equips
    public static Inventory inventory;
    public static Equipment equips;

    // battle status effects
    public statusSet statusEffects;
    // special moveset
    public SpecialMoveset smoveset;

    // special move cooldown
    // starts at 4 turns then every 10 levels it is reduced by 1 with a min of 1
    public int smoveCd = 4;

    // whether or not the player is currently in a map
    public boolean inMap = false;

    // player's level progress stored as a (world, level) key
    public int maxWorld = 0;
    public int maxLevel = 0;

    // the player's custom game settings
    public Settings settings = new Settings();

    public Player(String id, ResourceManager rm) {
        super(id, rm);

        inventory = new Inventory();
        equips = new Equipment();

        // attributes
        exp = maxExp = previousHp = Util.PLAYER_INIT_MAX_HP;
        accuracy = Util.PLAYER_ACCURACY;
        minDamage = Util.PLAYER_INIT_MIN_DMG;
        maxDamage = Util.PLAYER_INIT_MAX_DMG;

        level = 1;
        speed = 50.f;
        exp = 0;
      //-- décalage entre 3 et 5 --
        maxExp = Util.calculateMaxExp(1, MathUtils.random(3, 5));

        // create tilemap animation
       // am = new AnimationManager(rm.sprites16x16, Util.PLAYER_WALKING, Util.PLAYER_WALKING_DELAY);
        // create battle scene animation
        //bam = new AnimationManager(rm.battleSprites96x96, 2, Util.PLAYER_WALKING, 2 / 5f);

        moveset = new moveSet(rm);
        // damage seed is a random number between the damage range
        moveset.reset(minDamage, maxDamage, maxExp);

        statusEffects = new statusSet(true, rm);
        smoveset = new SpecialMoveset();
    }

    public void update(float dt) {
        super.update(dt);

        // movement
        handleMovement(dt);
        // special tile handling
        handleSpecialTiles();

        //-- Chef pour verifier les interaction 
        if (tileMap.containsEntity(tileMap.toTileCoords(position)) && canMove()) {
            opponent = (enemy) tileMap.getEntity(tileMap.toTileCoords(position));
            battling = true;
        }
    }

    /*public void render(SpriteBatch batch) {
        // draw shadow
        batch.draw(rm.shadow11x6, position.x + 3, position.y - 3);
        batch.draw(am.getKeyFrame(true), position.x + 1, position.y);
    }*/

 
//-- Déplace une entité vers une position cible d'une magnitude donnée - 
    //-- Mouvement du joueur déclenché par l'entrée-
    public void move(int dir) {
        
    	currentTileX = (int) (position.x / tileMap.tileSize);
        currentTileY = (int) (position.y / tileMap.tileSize);
        prevDir = dir;
        moving = dir;
        stats.numSteps++;
    
    }

    // -- Est ce que le perso peut bouger - 
    public boolean canMove() {
        return moving == -1;
    }

 //-- Méthode consiste à résoudre un problème où le joueur peut réinitialiser son
    // amplitudes de mouvement continues sur une tuile bloqué
    public boolean nextTileBlocked(int dir) {
        
    	currentTileX = (int) (position.x / tileMap.tileSize);
        currentTileY = (int) (position.y / tileMap.tileSize);
        
        switch (dir) {
            
        	case 0: // down
                return TileMap.getTile(currentTileX, currentTileY - 1).isBlocked();
            case 1: // up
                return TileMap.getTile(currentTileX, currentTileY + 1).isBlocked();
            case 2: // right
                return TileMap.getTile(currentTileX + 1, currentTileY).isBlocked();
            case 3: // left
                return TileMap.getTile(currentTileX - 1, currentTileY).isBlocked();
        }
        return false;
    }

//-- Retourne la prochaine coordonnée de la tuile à déplacer
    // currentPos +/- 1 ou currentPos si la prochaine tuile est bloquée
    public int nextPosition(int dir) {
        switch (dir) {
            case 0: // down
                Tile d = TileMap.getTile(currentTileX, currentTileY - 1);
                if (d.isBlocked() || currentTileY - 1 <= 0) {
                    return currentTileY;
                }
                return currentTileY - 1;
            case 1: // up
                Tile u = TileMap.getTile(currentTileX, currentTileY + 1);
                if (u.isBlocked() || currentTileY + 1 >= TileMap.mapHeight - 1) {
                    return currentTileY;
                }
                return currentTileY + 1;
            case 2: // right
                Tile r = TileMap.getTile(currentTileX + 1, currentTileY);
                if (r.isBlocked() || currentTileX + 1 >= TileMap.mapWidth - 1) {
                    return currentTileX;
                }
                return currentTileX + 1;
            case 3: // left
                Tile l = TileMap.getTile(currentTileX - 1, currentTileY);
                if (l.isBlocked() || currentTileX - 1 <= 0) {
                    return currentTileX;
                }
                return currentTileX - 1;
        }
        return 0;
    }

//-- Gère les mouvements suivants du joueur lorsqu'il se trouve sur une tuil/ maps  spéciale -
    // Rencontre un PNJ ? 
    public void handleSpecialTiles() {
        
    	int cx = (int) (position.x / tileMap.tileSize);
        int cy = (int) (position.y / tileMap.tileSize);
        Tile currentTile = TileMap.getTile(cx, cy);

        if (currentTile.isSpecial()) am.currentAnimation.stop();

        if (canMove()) {
            // Player goes forwards or backwards from the tile in the direction they entered
            if (currentTile.isChange()) {
                boolean k = MathUtils.randomBoolean();
                switch (prevDir) {
                    case 0: // down
                        if (k) changeDirection(1);
                        else changeDirection(0);
                        break;
                    case 1: // up
                        if (k) changeDirection(0);
                        else changeDirection(1);
                        break;
                    case 2: // right
                        if (k) changeDirection(3);
                        else changeDirection(2);
                        break;
                    case 3: // left
                        if (k) changeDirection(2);
                        else changeDirection(3);
                        break;
                }
            }
            // Player goes 1 tile in a random direction not the direction they entered the tile on
            else if (currentTile.isInAndOut()) {
                // output direction (all other directions other than input direction)
                int odir = MathUtils.random(2);
                switch (prevDir) {
                    case 0: // down
                        if (odir == 0) changeDirection(3);
                        else if (odir == 1) changeDirection(2);
                        else changeDirection(0);
                        break;
                    case 1: // up
                        if (odir == 0) changeDirection(3);
                        else if (odir == 1) changeDirection(2);
                        else changeDirection(1);
                        break;
                    case 2: // right
                        if (odir == 0) changeDirection(0);
                        else if (odir == 1) changeDirection(1);
                        else changeDirection(2);
                        break;
                    case 3: // left
                        if (odir == 0) changeDirection(0);
                        else if (odir == 1) changeDirection(1);
                        else changeDirection(3);
                        break;
                }
            }
            else if (currentTile.isDown()) {
                changeDirection(0);
            }
            else if (currentTile.isUp()) {
                changeDirection(1);
            }
            else if (currentTile.isRight()) {
                changeDirection(2);
            }
            else if (currentTile.isLeft()) {
                changeDirection(3);
            }
            // trigger dialog event
            else if (currentTile.isQuestionMark() || currentTile.isExclamationMark()) tileInteraction = true;
            // trigger teleport event
            else if (currentTile.isTeleport()) teleporting = true;
            // ice sliding
            else if (currentTile.isIce()) {
                if (!nextTileBlocked(prevDir)) {
                    move(prevDir);
                    am.setAnimation(prevDir);
                    am.stopAnimation();
                    pauseAnim = true;
                }
            }
            // map completed
            else if (currentTile.isEnd()) completedMap = true;
            else pauseAnim = false;
        }
    }

    public void changeDirection(int dir) {
        move(dir);
        prevDir = dir;
        am.setAnimation(dir);
    }

//--  Met à jour chaque tick et déplace une entité si elle ne se trouve pas sur la 
    //grille de tuiles
    public void handleMovement(float dt) {
        // down
        if (moving == 0) {
            int targetY = nextPosition(0);
            if (targetY == currentTileY) {
                moving = -1;
            } else {
                position.y -= speed * dt;
                if (Math.abs(position.y - targetY * TileMap.tileSize) <= speed * dt) {
                    position.y = targetY * TileMap.tileSize;
                    moving = -1;
                }
            }
        }
        // up
        if (moving == 1) {
            int targetY = nextPosition(1);
            if (targetY == currentTileY) {
                moving = -1;
            } else {
                position.y += speed * dt;
                if (Math.abs(position.y - targetY * TileMap.tileSize) <= speed * dt) {
                    position.y = targetY * TileMap.tileSize;
                    moving = -1;
                }
            }
        }
        // right
        if (moving == 2) {
            int targetX = nextPosition(2);
            if (targetX == currentTileX) {
                moving = -1;
            } else {
                position.x += speed * dt;
                if (Math.abs(position.x - targetX * TileMap.tileSize) <= speed * dt) {
                    position.x = targetX * TileMap.tileSize;
                    moving = -1;
                }
            }
        }
        // left
        if (moving == 3) {
            int targetX = nextPosition(3);
            if (targetX == currentTileX) {
                moving = -1;
            } else {
                position.x -= speed * dt;
                if (Math.abs(position.x - targetX * TileMap.tileSize) <= speed * dt) {
                    position.x = targetX * TileMap.tileSize;
                    moving = -1;
                }
            }
        }
    }

//--Incrémente le niveau et recalcule max XP
    //-- Définit les variables d'augmentation à afficher à l'écran
    //-- Compte récursivement n augmentations de niveau consécutives à partir de l'exp restant
    // * @param reste le montant exp restant après un niveau supérieur
    public void levelUp(int remainder) {
        
    	level++;

        hpIncrease += MathUtils.random(Util.PLAYER_MIN_HP_INCREASE, Util.PLAYER_MAX_HP_INCREASE);
        int dmgMean = MathUtils.random(Util.PLAYER_MIN_DMG_INCREASE, Util.PLAYER_MAX_DMG_INCREASE);

        //-- dévie de la moyenne par 0 à 2
        minDmgIncrease += (dmgMean - MathUtils.random(1));
        maxDmgIncrease += (dmgMean + MathUtils.random(1));
        //--la précision augmente de 1% tous les 10 niveaux
        accuracyIncrease += level % 10 == 0 ? 1 : 0;
        //--smoveCd réduit tous les 10 niveaux - 
        if (smoveCd > 1) smoveCd -= level % 10 == 0 ? 1 : 0;

        int prevMaxExp = maxExp;
        maxExp = Util.calculateMaxExp(level, MathUtils.random(3, 5));
        maxExpIncrease += (maxExp - prevMaxExp);

        // another level up
        if (remainder >= maxExp) {
            levelUp(remainder - maxExp);
        } else {
            exp = remainder;
        }
    }


// -- Augmente les statistiques réelles de leurs montants supérieurs//
    public void applyLevelUp() {
        
    	maxExp += hpIncrease;
        exp = maxExp;
        minDamage += minDmgIncrease;
        maxDamage += maxDmgIncrease;
        accuracy += accuracyIncrease;

        // reset variables
        hpIncrease = 0;
        minDmgIncrease = 0;
        maxDmgIncrease = 0;
        accuracyIncrease = 0;
        maxExpIncrease = 0;
    }

//-- Application des stats des equipement ok
    public void equip(Item item) {
        
    	maxExp += item.mhp;
        exp = maxExp;
        minDamage += item.dmg;
        maxDamage += item.dmg;
        accuracy += item.acc;
    }

// -- Supprime les statistiques des objets équipable - 
    public void unequip(Item item) {
        maxExp -= item.mhp;
        exp = maxExp;
        minDamage -= item.dmg;
        maxDamage -= item.dmg;
        accuracy -= item.acc;
    }

    public enemy getOpponent() {
        return opponent;
    }

    public void finishBattling() {
        battling = false;
        opponent = null;
        moving = -1;
    }

    public void finishTileInteraction() {
        tileInteraction = false;
        moving = -1;
    }

  
 // - Une fois la téléportation terminée, le joueur est
    ///déplacé hors de la tuile dans une direction aléatoire--
    public void finishTeleporting() {
        teleporting = false;
        changeDirection(MathUtils.random(3));
    }

    public void potion(int heal) {
        exp += heal;
        if (exp > maxExp) exp = maxExp;
    }

 //-- Applies a percentage health potion
    //--@param php
    public void percentagePotion(int php) {
        exp += (int) ((php / 100f) * maxExp);
        if (exp > maxExp) exp = maxExp;
    }

 //--point d'interrogation verts peuvent chuter 70% du temps
    //--  // si tombe:
    // 			or (50% du temps) (basé sur le niveau de la carte)
    // soigne en fonction du niveau de la carte (45% du temps)
   // items (5% du temps)
    public String[] getQuestionMarkDialog(int mapLevel, GameMap gameMap) {
        String[] ret = null;

        if (Util.isSuccess(Util.TILE_INTERATION)) {
            int k = MathUtils.random(99);
            // gold
            if (k < 50) {
                // gold per level scaled off map's average level
                int gold = 0;
                for (int i = 0; i < mapLevel; i++) {
                    gold += MathUtils.random(7, 13);
                }
                this.gold += gold;
                gameMap.goldObtained += gold;
                ret = new String[] {
                    "The random tile gave something!",
                    "You obtained " + gold + " gold!"
                };
            }
            // heal
            else if (k < 95) {
                int heal = 0;
                for (int i = 0; i < mapLevel; i++) {
                    heal += MathUtils.random(2, 5);
                }
                this.exp += heal;
                if (exp > maxExp) exp = maxExp;
                ret = new String[] {
                    "The random tile gave something!",
                    "It healed you for " + heal + " hp!"
                };
            }
            // item
            else if (k < 100) {
                Item item = rm.getRandomItem();
                if (inventory.isFull()) {
                    ret = new String[] {
                        "The random tile gave something!",
                        "It dropped a " + item.getDialogName() + "!",
                        "Oh no, too bad your inventory was full."
                    };
                }
                else {
                    ret = new String[]{
                        "The random tile gave something!",
                        "It dropped a " + item.getDialogName() + "!",
                        "The item was added to your inventory."
                    };
                    item.adjust(mapLevel);
                    inventory.addItem(item);
                    gameMap.itemsObtained.add(item);
                }
            }
        }
        else {
            ret = new String[] {
                "The random tile did not give anything."
            };
        }

        return ret;
    }

// -La tuile pourpre d'exclamation est une tuile destructive 
    //-- qui a 60% de chance de causer des dommages au joueur et
    	//--40% de chances de voler de l'or
    public String[] getExclamDialog(int mapLevel, GameMap gameMap) {
        String[] ret = null;

        if (Util.isSuccess(Util.TILE_INTERATION)) {
            if (Util.isSuccess(60)) {
                int dmg = 0;
                for (int i = 0; i < mapLevel; i++) {
                    dmg += MathUtils.random(1, 4);
                }
                exp -= dmg;
                // player dies from tile
                if (exp <= 0) {
                    ret = new String[] { "" +
                        "The random tile cursed you!",
                        "It damaged you for " + dmg + " damage!",
                        "Oh no, you took fatal damage and died!",
                        "You will lose " + Util.DEATH_PENALTY +
                            "% of your exp and gold and all the items obtained in this level as a penalty."
                    };
                }
                else {
                    ret = new String[] {
                        "The random tile cursed you!",
                        "It damaged you for " + dmg + " damage!"
                    };
                }
            }
            else {
                int steal = 0;
                for (int i = 0; i < mapLevel; i++) {
                    steal += MathUtils.random(4, 9);
                }
                gold -= steal;
                if (gold < 0) gold = 0;
                ret = new String[] {
                    "The random tile cursed you!",
                    "It caused you to lose " + steal + " gold!"
                };
            }
        }
        else {
            ret = new String[] {
                "The random tile did not affect you."
            };
        }

        return ret;
    }

 //-- Définit la position du joueur sur une autre tuile de téléportation n’importe où sur la carte -
    /*public void teleport() {
        
    	Tile currentTile = Tile.getTile(TileMap.toTileCoords(position));
        ArrayList<Tile> candidates = TileMap.getTeleportationTiles(currentTile);
        Tile choose = candidates.get(MathUtils.random(candidates.size() - 1));
        position.set(tileMap.toMapCoords(choose.tilePosition));
    }*/

//--Ajoute une quantité donnée d'exp à l'expérience 
    //actuelle du joueur et vérifie le niveau supérieur -
    public void addExp(int exp) {
        // level up with no screen
        
    	if (this.exp + exp >= maxExp) {
            int remainder = (this.exp + exp) - maxExp;
            levelUp(remainder);
            applyLevelUp();
        }
        else if (this.exp + exp < 0) {
            this.exp = 0;
        }
        else {
            this.exp += exp;
        }
    }

    public boolean isBattling() {
        return battling;
    }

//// Setter and Getter --- 
    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setMaxExp(int maxExp) {
        this.maxExp = maxExp;
    }

    public int getExp() {
        return exp;
    }

    public int getMaxExp() {
        return maxExp;
    }

    public int getHpIncrease() {
        return hpIncrease;
    }

    public void setHpIncrease(int hpIncrease) {
        this.hpIncrease = hpIncrease;
    }

    public int getMinDmgIncrease() {
        return minDmgIncrease;
    }

    public void setMinDmgIncrease(int minDmgIncrease) {
        this.minDmgIncrease = minDmgIncrease;
    }

    public int getMaxDmgIncrease() {
        return maxDmgIncrease;
    }

    public void setMaxDmgIncrease(int maxDmgIncrease) {
        this.maxDmgIncrease = maxDmgIncrease;
    }

    public int getAccuracyIncrease() {
        return accuracyIncrease;
    }

    public void setAccuracyIncrease(int accuracyIncrease) {
        this.accuracyIncrease = accuracyIncrease;
    }

    public int getMaxExpIncrease() { return maxExpIncrease; }

    public void addGold(int g) {
        if (this.gold + g < 0) this.gold = 0;
        else this.gold += g;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getGold() { return gold; }

    public int getCurrentTileX() {
        return currentTileX;
    }

    public int getCurrentTileY() {
        return currentTileY;
    }

    public boolean isMoving() {
        return moving != -1;
    }

    public boolean isTileInteraction() { return tileInteraction; }

    public boolean isTeleporting() { return teleporting; }

}
