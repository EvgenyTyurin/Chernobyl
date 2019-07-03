package com.tyurinevgeny.chernobyl.game_world;

class WorldLocation {
    private String name;
    private String label;
    private String description;
    private String northLocationName = "";
    private WorldLocation northLocation;
    private WorldLocation southLocation;
    private WorldLocation eastLocation;
    private WorldLocation westLocation;
    private WorldLocation upLocation;
    private WorldLocation downLocation;

    WorldLocation(String name, String label, String description) {
        this.name = name;
        this.label = label;
        this.description = description;
    }

    WorldLocation(String name, String label, String description,
                  String northLocation) {
        this(name, label, description);
        this.northLocationName = northLocation;
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

    public String getDescription() {
        return description;
    }

    public String getLabel() {
        return label;
    }

    public String getName() {
        return name;
    }

    String getNorthLocationName() {
        return northLocationName;
    }

    public void setNorthLocationName(String northLocationName) {
        this.northLocationName = northLocationName;
    }

    public WorldLocation getNorthLocation() {
        return northLocation;
    }

    public void setNorthLocation(WorldLocation northLocation) {
        this.northLocation = northLocation;
    }

    public WorldLocation getSouthLocation() {
        return southLocation;
    }

    public void setSouthLocation(WorldLocation southLocation) {
        this.southLocation = southLocation;
    }

    public WorldLocation getWestLocation() {
        return westLocation;
    }

    public void setWestLocation(WorldLocation westLocation) {
        this.westLocation = westLocation;
    }

    public WorldLocation getEastLocation() {
        return eastLocation;
    }

    public void setEastLocation(WorldLocation eastLocation) {
        this.eastLocation = eastLocation;
    }

    public WorldLocation getUpLocation() {
        return upLocation;
    }

    public void setUpLocation(WorldLocation upLocation) {
        this.upLocation = upLocation;
    }

    public WorldLocation getDownLocation() {
        return downLocation;
    }

    public void setDownLocation(WorldLocation downLocation) {
        this.downLocation = downLocation;
    }
}
