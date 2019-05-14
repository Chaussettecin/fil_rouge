package event;

// -- Différents états pour des événements tels que marcher, se battre, ramasser des objets -

public enum EventState {
    NONE,
    MOVING,
    BATTLING,
    TRANSITION,
    LEVEL_UP,
    INVENTORY,
    TILE_EVENT,
    DEATH,
    PAUSE
}
