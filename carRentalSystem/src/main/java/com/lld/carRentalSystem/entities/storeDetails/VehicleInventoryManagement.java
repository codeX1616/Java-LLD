package com.lld.carRentalSystem.entities.storeDetails;

import com.lld.carRentalSystem.entities.vehicleDetails.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class VehicleInventoryManagement {
    List<Vehicle> vehicles;
}
