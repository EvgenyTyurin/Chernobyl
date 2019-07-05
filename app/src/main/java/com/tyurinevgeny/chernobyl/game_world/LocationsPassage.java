package com.tyurinevgeny.chernobyl.game_world;

class LocationsPassage {
    private PassageOrientation orientation;
    private WorldLocation location1; /* south || east || bottom end of passage */
    private WorldLocation location2; /* north || west || top end  of passage */
    private String id;

    private LocationsPassage(PassageOrientation orientation,
                            WorldLocation location1,
                            WorldLocation location2) {
        this.orientation = orientation;
        this.location1 = location1;
        this.location2 = location2;
        this.id = location1.getName() + "," + location2.getName();
        switch (orientation) {
            case AXIS_X:
                location1.setWestLocation(location2);
                location2.setEastLocation(location1);
                break;
            case AXIS_Y:
                location1.setNorthLocation(location2);
                location2.setSouthLocation(location1);
                break;
            case AXIS_Z:
                location1.setUpLocation(location2);
                location2.setDownLocation(location1);
        }
    }

    LocationsPassage(PassageOrientation orientation,
                            String location1Name,
                            String location2Name,
                            GameWorld gameWorld) {
        this(orientation,
                gameWorld.getLocationByName(location1Name),
                gameWorld.getLocationByName(location2Name));
    }

    PassageOrientation getOrientation() {
        return orientation;
    }

    String getId() {
        return id;
    }
}
