package com.lld.entities.vehicleEntities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Vehicle {
    private int vehicleId;
    private int vechicleNumber;
    private VehicleType vehicleType;
    private String companyName;
    private String modelName;
    private int kmDriven;
    private Date manufacturingDate;
    private int average;
    private int cc;
    private int dailyRentalCost;
    private int hourlyRentalCost;
    private int noOfSeat;
    private Status status;
}
