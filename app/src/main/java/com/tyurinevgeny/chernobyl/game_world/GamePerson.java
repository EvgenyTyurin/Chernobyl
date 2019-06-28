package com.tyurinevgeny.chernobyl.game_world;

/**
 * Game person class
 */

class GamePerson {
    private String name;
    private WorldLocation currentLocation;

    /** Create new person */
    GamePerson(String name, WorldLocation currentLocation) {
        this.name = name;
        this.currentLocation = currentLocation;
    }

    /** @return Current status of person */
    public String getReport() {
        return "I'm in " + currentLocation;
    }

    public String getName() {
        return name;
    }
}
