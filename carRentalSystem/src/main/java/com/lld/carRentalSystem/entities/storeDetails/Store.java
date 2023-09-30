package com.lld.carRentalSystem.entities.storeDetails;

import com.lld.carRentalSystem.entities.reservationDetails.Reservation;
import com.lld.carRentalSystem.entities.reservationDetails.User;
import com.lld.carRentalSystem.entities.vehicleDetails.Vehicle;
import com.lld.carRentalSystem.entities.vehicleDetails.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Store {
    int storeId;
    VehicleInventoryManagement inventoryManagement;
    Location storeLocation;
    List<Reservation> reservations = new ArrayList<>();

    /**
     * Method to set inventory management with vehicle list
     * @param vehicleList {@link List<Vehicle>}
     */
    public void setInventoryManagement(List<Vehicle> vehicleList) {
        this.inventoryManagement = new VehicleInventoryManagement(vehicleList);
    }

    /**
     * MEthod for creating reservation
     * @param vehicle
     * @param user
     * @return {@link Reservation}
     */
    public Reservation createReservation(Vehicle vehicle, User user) {
        Reservation reservation = new Reservation();
        int reservationId = reservation.createReserve(user, vehicle);
        System.out.println("Reservation id is: " + reservationId);
        reservations.add(reservation);
        return reservation;
    }

    /**
     * Method to complete reservation
     * @param reservationId
     * @return
     */
    public boolean completeReservation(int reservationId) {
        // Logic for completing reservation
        return true;
    }

    /**
     * Get vehicles from inventory management
     * @param type
     * @return {@link List<Vehicle>}
     */
    public List<Vehicle> getVehicles(VehicleType type) {
        return inventoryManagement.getVehicles();
    }

    /**
     * Method to set vehicle list to inventory management
     * @param vehicles
     */
    public void setVehicles(List<Vehicle> vehicles) {
        inventoryManagement = new VehicleInventoryManagement(vehicles);
    }

}
