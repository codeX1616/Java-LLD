package com.lld.carRentalSystem.entities.storeDetails;

import com.lld.carRentalSystem.entities.reservationDetails.Reservation;
import com.lld.carRentalSystem.entities.reservationDetails.ReservationStatus;
import com.lld.carRentalSystem.entities.reservationDetails.ReservationType;
import com.lld.carRentalSystem.entities.reservationDetails.User;
import com.lld.carRentalSystem.entities.vehicleDetails.Vehicle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    private final Store store = new Store();

    @Test
    void createReservationTest() {

        User user = new User();
        Vehicle vehicle = new Vehicle();
        Reservation reservation = store.createReservation(vehicle, user);

        assertEquals(173, reservation.getResId());
        assertEquals(user, reservation.getUser());
        assertEquals(vehicle, reservation.getVehicle());
        assertEquals(ReservationType.DAILY, reservation.getReservationType());
        assertEquals(ReservationStatus.SCHEDULED, reservation.getReservationStatus());

        assertNotNull(store.getReservations());
        assertFalse(store.getReservations().isEmpty());
        assertEquals(reservation, store.getReservations().get(0));

    }
}
