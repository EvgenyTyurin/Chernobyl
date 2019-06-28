package com.tyurinevgeny.chernobyl.game_world;

import java.util.ArrayList;

/**
 * Game person class
 */

class GamePerson {
    private String name;
    private WorldLocation currentLocation;
    private ArrayList<String> messageList = new ArrayList<>();

    /** Create new person */
    GamePerson(String name, WorldLocation currentLocation) {
        this.name = name;
        this.currentLocation = currentLocation;
        updateStatus();
    }

    /** Update status of person */
    public void updateStatus() {
        String message = name + ": I'm in " + currentLocation;
        messageList.add(message);
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getMessageList() {
        return messageList;
    }
}
