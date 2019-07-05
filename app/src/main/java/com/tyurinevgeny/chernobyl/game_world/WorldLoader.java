package com.tyurinevgeny.chernobyl.game_world;

import com.tyurinevgeny.chernobyl.ResourcesLoader;

import java.util.ArrayList;

/**
 * Loads game world data from data storage
 */

class WorldLoader {

    private static final String WORLD_LOCATIONS_ARRAY = "world_locations";
    private static final String LOCATIONS_PASSAGES_ARRAY = "locations_passages";
    private static final String LOCATION_BLOCKERS_ARRAY = "location_blockers";
    private static final String GAME_ITEMS_ARRAY = "game_items";
    private static final String PERSONS_ARRAY = "persons";

    /**
     * Loads game's world from android resources
     */
    static void loadWorldFromResources(GameWorld world) {
        // Load locations
        ArrayList<String> arrayStrings = ResourcesLoader.getInstance()
                .getStringArray(WORLD_LOCATIONS_ARRAY);
        world.getWorldLocations().clear();
        for (String locationStr : arrayStrings) {
            String[] locationParams = locationStr.split(";");
            world.getWorldLocations().add(new WorldLocation(locationParams[0],
                    locationParams[1], locationParams[2]));
        }
        // Load passages
        arrayStrings = ResourcesLoader.getInstance()
                .getStringArray(LOCATIONS_PASSAGES_ARRAY);
        GameWorld.getLocationsPassages().clear();
        for (String passageStr : arrayStrings) {
            String[] passageParams = passageStr.split(";");
            GameWorld.getLocationsPassages().add(
                    new LocationsPassage(PassageOrientation.valueOf(passageParams[0]),
                    passageParams[1],
                    passageParams[2],
                    world));
        }
        // Load locations blockers
        arrayStrings = ResourcesLoader.getInstance()
                .getStringArray(LOCATION_BLOCKERS_ARRAY);
        for (String blockerStr : arrayStrings) {
            String[] blockerParams = blockerStr.split(";");
            world.getLocationByName(blockerParams[0]).setBlocker(
                    new LocationBlocker(LocationBlockerType.valueOf(blockerParams[1])));
        }
        // Load game items
        arrayStrings = ResourcesLoader.getInstance()
                .getStringArray(GAME_ITEMS_ARRAY);
        for(String itemStr : arrayStrings) {
            String[] itemParams = itemStr.split(";");
            world.getLocationByName(itemParams[1]).getGameItems().add(
                    new GameItem(GameItemType.valueOf(itemParams[0])));
        }
        // Load persons
        arrayStrings = ResourcesLoader.getInstance()
                .getStringArray(PERSONS_ARRAY);
        world.getGamePersons().clear();
        for (String personStr : arrayStrings) {
            String[] personParams = personStr.split(";");
            world.getGamePersons().add(new GamePerson(personParams[0],
                    world.getLocationByName(personParams[1])));
        }
    }
}
