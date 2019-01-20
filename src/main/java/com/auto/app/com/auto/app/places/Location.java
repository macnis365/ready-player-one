package com.auto.app.com.auto.app.places;

import java.util.List;

public interface Location {
    public List<Room> connectingRooms();
    public String describeLocation();
    public Room goNorth();
    public Room goSouth();
    public Room goWest();
    public Room goEast();
}
