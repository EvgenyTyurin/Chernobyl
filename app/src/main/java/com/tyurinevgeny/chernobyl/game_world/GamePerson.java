package com.tyurinevgeny.chernobyl.game_world;

import java.util.ArrayList;

/**
 * Game person class
 */

public class GamePerson {
    private String name;
    private WorldLocation currentLocation;
    private WorldLocation previousLocation;
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
        message += currentLocation.getDescription() + " ";
        if (currentLocation.getBlocker() != null) {
            message += "Blocker: " +
                    currentLocation.getBlocker().getBlockerType().toString() + ". ";
        }
        message += "Passages: " + currentLocation.getPassagesStr() + ". ";
        messageList.add(message);
    }

    void moveTo(WorldLocation newLocation) {
        previousLocation = currentLocation;
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

    WorldLocation getPreviousLocation() {
        return previousLocation;
    }

}
