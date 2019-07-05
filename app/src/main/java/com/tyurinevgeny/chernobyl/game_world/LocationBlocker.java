package com.tyurinevgeny.chernobyl.game_world;

/** Type of blocker */

enum LocationBlockerType {
    FIRE, SMOKE
}

/**
 * Location blocker: fire, smoke etc. Movement threw location not possible.
 * */

class LocationBlocker {
    private LocationBlockerType blockerType;

    LocationBlocker(LocationBlockerType blockerType) {
        this.blockerType = blockerType;
    }

    LocationBlockerType getBlockerType() {
        return blockerType;
    }
}
