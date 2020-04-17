package cn.edu.csu.dyp.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class Address {
    @NotEmpty
    private String name;
    @NotEmpty
    private String phoneNumber;
    @NotEmpty
    private String province;
    @NotEmpty
    private String city;
    @NotEmpty
    private String county;
    @NotEmpty
    private String village;
    @NotEmpty
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

    @Override
    public String toString() {
        return province + ' ' + city + ' ' + county + ' ' + village + ' ' + detailedAddress + " \n" + name + ' ' + phoneNumber;
    }
}
