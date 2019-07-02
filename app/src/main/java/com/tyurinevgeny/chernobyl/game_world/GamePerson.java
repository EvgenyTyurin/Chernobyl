package com.tyurinevgeny.chernobyl.game_world;

import java.util.ArrayList;

/**
 * Game person class
 */

public class GamePerson {
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
    private void updateStatus() {
        String message = name + ": I'm in " + currentLocation.getLabel() + ". ";
        message += currentLocation.getDescription();
        message += "Passages: " + currentLocation.getPassages() + ". ";
        messageList.add(message);
    }

    void moveTo(WorldLocation newLocation) {
        currentLocation = newLocation;
        updateStatus();
    }

    public String getName() {
        return name;
    }

    ArrayList<String> getMessageList() {
        return messageList;
    }

    WorldLocation getCurrentLocation() {
        return currentLocation;
    }
}
