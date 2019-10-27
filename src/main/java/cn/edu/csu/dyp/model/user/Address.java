package cn.edu.csu.dyp.model.user;

import cn.edu.csu.dyp.model.location.DetailLocation;

public class Address {
    private String addressId;
    private String userId;
    private boolean isDefault;
    private String name;
    private String phoneNumber;
    private DetailLocation detailLocation;
    private String detailedAddress;

    public Address(String addressId, String userId, boolean isDefault, String name, String phoneNumber, DetailLocation detailLocation, String detailedAddress) {
        this.addressId = addressId;
        this.userId = userId;
        this.isDefault = isDefault;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.detailLocation = detailLocation;
        this.detailedAddress = detailedAddress;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
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

    public DetailLocation getDetailLocation() {
        return detailLocation;
    }

    public void setDetailLocation(DetailLocation detailLocation) {
        this.detailLocation = detailLocation;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }
}
