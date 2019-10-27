package cn.edu.csu.dyp.model.location;

public class Location {
    private String locationId;
    private String locationName;
    private int level;

    public Location(String locationId, String locationName, int level) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
