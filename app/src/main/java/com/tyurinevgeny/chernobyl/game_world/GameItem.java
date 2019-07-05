package com.tyurinevgeny.chernobyl.game_world;

/**
 * Game item
 */

enum GameItemType {
    EXTINGUISHER, AXE
}

class GameItem {
    GameItemType type;

    public GameItem(GameItemType type) {
        this.type = type;
    }
}
