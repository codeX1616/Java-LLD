package com.lld.carRentalSystem.entities.storeDetails;

import com.lld.carRentalSystem.entities.reservationDetails.Reservation;
import com.lld.carRentalSystem.entities.reservationDetails.User;
import com.lld.carRentalSystem.entities.vehicleDetails.Vehicle;
import com.lld.carRentalSystem.entities.vehicleDetails.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Store {
    int storeId;
    VehicleInventoryManagement inventoryManagement;
    Location storeLocation;
    List<Reservation> reservations;

    public void setInventoryManagement(List<Vehicle> vehicleList) {
        this.inventoryManagement = new VehicleInventoryManagement(vehicleList);
    }

    public Reservation createReservation(Vehicle vehicle, User user) {
        Reservation reservation = new Reservation();
        int reservationId = reservation.createReserve(user, vehicle);
        System.out.println("Reservation id is: " + reservationId);
        reservations.add(reservation);
        return reservation;
    }

    public boolean completeReservation(int reservationId) {
        // Logic for completing reservation
        return true;
    }

    public List<Vehicle> getVehicles(VehicleType type) {
        return inventoryManagement.getVehicles();
    }

    public void setVehicles(List<Vehicle> vehicles) {
        inventoryManagement = new VehicleInventoryManagement(vehicles);
    }

}
