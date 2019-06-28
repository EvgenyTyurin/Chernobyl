package com.tyurinevgeny.chernobyl.game_world;

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

    public String getPersonReport(String name) {
        return gameWorld.getPerson(name).getReport();
    }

}
