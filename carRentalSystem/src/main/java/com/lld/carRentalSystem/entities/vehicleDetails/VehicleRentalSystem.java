package com.lld.carRentalSystem.entities.vehicleDetails;

import com.lld.carRentalSystem.entities.reservationDetails.User;
import com.lld.carRentalSystem.entities.storeDetails.Location;
import com.lld.carRentalSystem.entities.storeDetails.Store;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class VehicleRentalSystem {
    private List<Store> storeList;
    private List<User> userList;

    /**
     * Method to get store from store list
     * @param location
     * @return {@link Store}
     */
    public Store getStore(Location location) {
        // Get store based on location
        return storeList.get(0);
    }
}
