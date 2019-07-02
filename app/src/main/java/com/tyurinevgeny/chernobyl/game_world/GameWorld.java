package com.tyurinevgeny.chernobyl.game_world;

import java.util.ArrayList;

/**
 * Game World: Locations, persons
 */

public class GameWorld {
    private static GameWorld gameWorld;
    private static ArrayList<WorldLocation> worldLocations = new ArrayList<>();
    private static ArrayList<GamePerson> gamePersons = new ArrayList<>();

    /** Creates game world from file */
    private GameWorld() {
        // TODO: Load from file
        worldLocations.add(new WorldLocation("1st Floor Hall", "1st Floor Hall",
                "It's messy here. Windows are broken, chairs upside down.",
                "Security Room"));
        worldLocations.add(new WorldLocation("Security Room", "Security Room",
                "All lockers open."));
        gamePersons.add(new GamePerson("Petrov",
                worldLocations.get(0)));
        gamePersons.add(new GamePerson("Akimov",
                worldLocations.get(0)));
    }

    /** @return Game world */
    public static GameWorld getInstance() {
        if (gameWorld == null) {
            gameWorld = new GameWorld();
        }
        return gameWorld;
    }

    /** @return person by name */
    GamePerson getPerson(String name) {
        for (GamePerson gamePerson : gamePersons) {
            if (gamePerson.getName().equals(name)) {
                return gamePerson;
            }
        }
        return null;
    }

    /** @return world location by name */
    WorldLocation getLocation(String name) {
        for (WorldLocation location : worldLocations) {
            if (location.getName().equals(name))
                return location;
        }
        return null;
    }

    ArrayList<GamePerson> getGamePersons() {
        return gamePersons;
    }
}
