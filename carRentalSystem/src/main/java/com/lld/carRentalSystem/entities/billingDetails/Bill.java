package com.lld.carRentalSystem.entities.billingDetails;

import com.lld.carRentalSystem.entities.reservationDetails.Reservation;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Bill {
    private Reservation reservation;
    private double billAmount;
    private boolean isBillPaid;
}
