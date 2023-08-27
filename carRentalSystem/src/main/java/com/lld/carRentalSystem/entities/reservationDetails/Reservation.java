package com.lld.carRentalSystem.entities.reservationDetails;

import com.lld.carRentalSystem.entities.storeDetails.Location;
import com.lld.carRentalSystem.entities.vehicleDetails.Vehicle;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.Date;

@AllArgsConstructor
public class Reservation {
    private int resId;
    private SecurityProperties.User user;
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
}
