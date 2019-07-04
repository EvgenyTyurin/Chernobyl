package com.tyurinevgeny.chernobyl.game_world;

import java.util.ArrayList;

/**
 * Game World: Locations, passages, persons
 */

public class GameWorld {
    private static GameWorld gameWorld;
    private static ArrayList<WorldLocation> worldLocations = new ArrayList<>();
    private static ArrayList<LocationsPassage> locationsPassages = new ArrayList<>();
    private static ArrayList<GamePerson> gamePersons = new ArrayList<>();

    /** Creates game world */
    private GameWorld() {
        WorldLoader.loadFromResources(this);
        locationsPassages.add(new LocationsPassage(PassageOrientation.AXIS_Y,
                "1st Floor Hall",
                "Security Room",
                this));
        gamePersons.add(new GamePerson("Petrov",
                worldLocations.get(0)));
        gamePersons.add(new GamePerson("Akimov",
                worldLocations.get(0)));
    }

    /** @return Current game world */
    public static GameWorld getInstance() {
        if (gameWorld == null) {
            gameWorld = new GameWorld();
        }
        return gameWorld;
    }

    /** @return Person by name */
    GamePerson getPerson(String name) {
        for (GamePerson gamePerson : gamePersons) {
            if (gamePerson.getName().equals(name)) {
                return gamePerson;
            }
        }
        return null;
    }

    /** @return World location by it's name */
    WorldLocation getLocationByName(String name) {
        for (WorldLocation location : worldLocations) {
            if (location.getName().equals(name))
                return location;
        }
        return null;
    }

    ArrayList<GamePerson> getGamePersons() {
        return gamePersons;
    }

    ArrayList<WorldLocation> getWorldLocations() {
        return worldLocations;
    }
}
