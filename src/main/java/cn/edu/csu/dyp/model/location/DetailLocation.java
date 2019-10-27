package cn.edu.csu.dyp.model.location;

public class DetailLocation {
    private String locationId;
    private String province;
    private String city;
    private String county;
    private String village;

    public DetailLocation(String locationId, String province, String city, String county, String village) {
        this.locationId = locationId;
        this.province = province;
        this.city = city;
        this.county = county;
        this.village = village;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }
}
