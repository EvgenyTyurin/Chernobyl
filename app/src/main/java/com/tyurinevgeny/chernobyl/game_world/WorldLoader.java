package com.tyurinevgeny.chernobyl.game_world;

import com.tyurinevgeny.chernobyl.ResourcesLoader;

import java.util.ArrayList;

/**
 * Loads game world from data storage
 */

class WorldLoader {

    private static final String WORLD_LOCATIONS_ARRAY = "world_locations";

    /**
     * Loads games world from android resources
     */
    static void loadFromResources(GameWorld world) {
        ArrayList<String> locationsStings = ResourcesLoader.getInstance()
                .getStringArray(WORLD_LOCATIONS_ARRAY);
        world.getWorldLocations().clear();
        for (String locationStr : locationsStings) {
            String[] locationParams = locationStr.split(";");
            world.getWorldLocations().add(new WorldLocation(locationParams[0],
                    locationParams[1], locationParams[2]));
        }
    }
}
