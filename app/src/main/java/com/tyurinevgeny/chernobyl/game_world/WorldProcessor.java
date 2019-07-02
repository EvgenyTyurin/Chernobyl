package com.tyurinevgeny.chernobyl.game_world;

/**
 * Game world processes perform and control
 */

class WorldProcessor {
    private static WorldProcessor worldProcessor;
    private static GameWorld gameWorld;

    private WorldProcessor(GameWorld gameWorld) {
        WorldProcessor.gameWorld = gameWorld;
    }

    static WorldProcessor getInstance(GameWorld gameWorld) {
        if (worldProcessor == null) {
            worldProcessor = new WorldProcessor(gameWorld);
        }
        return worldProcessor;
    }

    String movePerson(String personName, WorldDirection direction) {
        String result = "";
        GamePerson person = gameWorld.getPerson(personName);
        WorldLocation currentLocation = person.getCurrentLocation();
        String newLocationName = "";
        switch (direction) {
            case NORTH: newLocationName = currentLocation.getNorthLocationName();
            break;
        }
        WorldLocation newLocation = gameWorld.getLocation(newLocationName);
        if (newLocation != null) {
            person.moveTo(newLocation);
        } else {
            result = "Negative";
        }
        return result;
    }
}
