package com.tyurinevgeny.chernobyl.game_world;

import android.widget.ListView;

import java.util.ArrayList;

/**
 * Game world communicator
 */

public class WorldComm {
    private static WorldComm worldComm;
    private static GameWorld gameWorld;

    private WorldComm(GameWorld gameWorld) {
        WorldComm.gameWorld = gameWorld;
    }

    public static WorldComm getInstance(GameWorld gameWorld) {
        if (worldComm == null) {
            worldComm = new WorldComm(gameWorld);
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

}
