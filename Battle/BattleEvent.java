package Battle;

//-- Toutes les transitions entre les événements à traiter --

public enum BattleEvent {

    // -- Event placeholder pour que rien ne se passe
    NONE,
   
    END_BATTLE,
    // Ennemi démare la baston
    PLAYER_TURN,
    //-- Tours de l'ennemy -- 
    ENEMY_TURN,
    // -- Perso = Level up - 
    LEVEL_UP,
    // player dies and leaves the map
    PLAYER_DEAD

}
