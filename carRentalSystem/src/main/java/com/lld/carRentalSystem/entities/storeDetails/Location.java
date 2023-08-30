package com.lld.carRentalSystem.entities.storeDetails;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {
    private String address;
    private int pincode;
    private String city;
    private String state;
    private String country;

    public Location(int pincode, String city, String state, String country) {
        this.pincode = pincode;
        this.city = city;
        this.state = state;
        this.country = country;
    }
}
