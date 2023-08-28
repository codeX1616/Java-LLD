package com.lld.carRentalSystem.entities.reservationDetails;

import com.lld.carRentalSystem.entities.storeDetails.Location;
import com.lld.carRentalSystem.entities.vehicleDetails.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reservation {
    private int resId;
    private User user;
    private Vehicle vehicle;
    private Date date;
    private Date dateBookedFrom;
    private Date dateBookedTo;
    private Date fromTimeStamp;
    private Long toTimeStamp;
    private Location pickUpLocation;
    private Location dropLocation;
    private ReservationType reservationType;
    private ReservationStatus reservationStatus;
    private Location location;

    public int createReserve(User user, Vehicle vehicle) {
        resId = 173;
        this.user = user;
        this.vehicle=vehicle;
        reservationType = ReservationType.DAILY;
        reservationStatus = ReservationStatus.SCHEDULED;
        return resId;
    }
}
