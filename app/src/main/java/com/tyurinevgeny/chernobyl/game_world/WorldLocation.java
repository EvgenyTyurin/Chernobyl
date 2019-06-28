package com.tyurinevgeny.chernobyl.game_world;

import android.support.annotation.NonNull;

class WorldLocation {
    private String id;
    private String label;
    private WorldLocation northLocation;

    WorldLocation(String id, String label) {
        this.id = id;
        this.label = label;
    }

    @NonNull
    @Override
    public String toString() {
        return label;
    }
}
