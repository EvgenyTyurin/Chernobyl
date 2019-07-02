package com.tyurinevgeny.chernobyl.game_world;

import java.util.ArrayList;

/**
 * Game world and UI communicator
 */

public class WorldComm {
    private static WorldComm worldComm;
    private static GameWorld gameWorld;
    private static WorldProcessor worldProcessor;

    private WorldComm(GameWorld gameWorld) {
        WorldComm.gameWorld = gameWorld;
    }

    public static WorldComm getInstance(GameWorld gameWorld) {
        if (worldComm == null) {
            worldComm = new WorldComm(gameWorld);
            worldProcessor = WorldProcessor.getInstance(gameWorld);
        }
        return worldComm;
    }

    public ArrayList<String> getPersonMessages(String name) {
        GamePerson gamePerson = gameWorld.getPerson(name);
        if (gamePerson != null) {
            return gamePerson.getMessageList();
        }
        else {
            return null;
        }
    }

    public String movePerson(String personName, WorldDirection direction) {
        return worldProcessor.movePerson(personName, direction);
    }

    public ArrayList<GamePerson> getActivePersons() {
        return gameWorld.getGamePersons();
    }

}
