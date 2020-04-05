package cn.edu.csu.dyp.model.user;

public class Address {
    private String name;
    private String phoneNumber;
    private String province;
    private String city;
    private String county;
    private String village;
    private String detailedAddress;

    public Address(String name, String phoneNumber, String province, String city, String county, String village, String detailedAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.province = province;
        this.city = city;
        this.county = county;
        this.village = village;
        this.detailedAddress = detailedAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    @Override
    public String toString() {
        return province + ' ' + city + ' ' + county + ' ' + village + ' ' + detailedAddress + " \n" + name + ' ' + phoneNumber;
    }
}
