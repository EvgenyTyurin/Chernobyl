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
        worldLocations.add(new WorldLocation("1st Floor Hall", "1st Floor Hall"));
        gamePersons.add(new GamePerson("Petrov",
                worldLocations.get(0)));
    }

    /** @return Game world */
    public static GameWorld getInstance() {
        if (gameWorld == null) {
            gameWorld = new GameWorld();
        }
        return gameWorld;
    }

    GamePerson getPerson(String name) {
        for (GamePerson gamePerson : gamePersons) {
            if (gamePerson.getName().equals(name)) {
                return gamePerson;
            }
        }
        return null;
    }

}
