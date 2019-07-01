package com.tyurinevgeny.chernobyl.game_world;

class WorldLocation {
    private String id;
    private String label;
    private String description;
    private String northLocation = "";

    WorldLocation(String id, String label, String description) {
        this.id = id;
        this.label = label;
        this.description = description;
    }

    WorldLocation(String id, String label, String description,
                  String northLocation) {
        this(id, label, description);
        this.northLocation = northLocation;
    }

    String getPassages() {
        // TODO: Add another directions
        String passages = "";
        if(!northLocation.equals(""))
            passages += "North - " + northLocation + " ";
        return passages;
    }

    public String getDescription() {
        return description;
    }

    public String getLabel() {
        return label;
    }
}
