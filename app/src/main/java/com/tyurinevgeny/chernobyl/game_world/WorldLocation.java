package com.tyurinevgeny.chernobyl.game_world;

class WorldLocation {
    private String name;
    private String label;
    private String description;
    private String northLocationName = "";

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

    String getPassages() {
        // TODO: Add another directions
        String passages = "";
        if(!northLocationName.equals(""))
            passages += "North - " + northLocationName + " ";
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
}
