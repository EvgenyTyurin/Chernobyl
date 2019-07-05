package com.tyurinevgeny.chernobyl.game_world;

import java.util.ArrayList;

class WorldLocation {
    private String name;
    private String label;
    private String description;
    private WorldLocation northLocation;
    private WorldLocation southLocation;
    private WorldLocation eastLocation;
    private WorldLocation westLocation;
    private WorldLocation upLocation;
    private WorldLocation downLocation;
    private LocationBlocker blocker;
    private ArrayList<GameItem> gameItems = new ArrayList<>();

    WorldLocation(String name, String label, String description) {
        this.name = name;
        this.label = label;
        this.description = description;
    }

    String getPassagesStr() {
        // TODO: Add another directions
        String passages = "";
        if(northLocation != null) {
            passages += "north - " + northLocation.getLabel() + " ";
        }
        if(eastLocation !=null) {
            passages += "east - " + eastLocation.getLabel() + " ";
        }
        if(southLocation !=null) {
            passages += "south - " + southLocation.getLabel() + " ";
        }
        if(westLocation !=null) {
            passages += "west - " + westLocation.getLabel() + " ";
        }
        if(upLocation !=null) {
            passages += "upstairs - " + upLocation.getLabel() + " ";
        }
        if(downLocation !=null) {
            passages += "downstairs - " + downLocation.getLabel() + " ";
        }
        return passages;
    }

    ArrayList<GameItem> getGameItems() { return gameItems; }

    public String getDescription() {
        return description;
    }

    String getLabel() {
        return label;
    }

    public String getName() {
        return name;
    }

    WorldLocation getNorthLocation() {
        return northLocation;
    }

    void setNorthLocation(WorldLocation northLocation) { this.northLocation = northLocation; }

    WorldLocation getSouthLocation() {
        return southLocation;
    }

    void setSouthLocation(WorldLocation southLocation) { this.southLocation = southLocation; }

    WorldLocation getWestLocation() {
        return westLocation;
    }

    void setWestLocation(WorldLocation westLocation) {
        this.westLocation = westLocation;
    }

    WorldLocation getEastLocation() {
        return eastLocation;
    }

    void setEastLocation(WorldLocation eastLocation) {
        this.eastLocation = eastLocation;
    }

    WorldLocation getUpLocation() {
        return upLocation;
    }

    void setUpLocation(WorldLocation upLocation) {
        this.upLocation = upLocation;
    }

    WorldLocation getDownLocation() {
        return downLocation;
    }

    void setDownLocation(WorldLocation downLocation) {
        this.downLocation = downLocation;
    }

    LocationBlocker getBlocker() {
        return blocker;
    }

    void setBlocker(LocationBlocker blocker) {
        this.blocker = blocker;
    }
}
