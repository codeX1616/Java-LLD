package com.lld.carRentalSystem.entities.billingDetails;

import com.lld.carRentalSystem.entities.reservationDetails.Reservation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Bill {
    private Reservation reservation;
    private double billAmount;
    private boolean isBillPaid;
}
