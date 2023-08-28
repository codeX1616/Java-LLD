package com.lld.carRentalSystem.entities.storeDetails;

import com.lld.carRentalSystem.entities.reservationDetails.Reservation;
import com.lld.carRentalSystem.entities.reservationDetails.User;
import com.lld.carRentalSystem.entities.vehicleDetails.Vehicle;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
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
}
