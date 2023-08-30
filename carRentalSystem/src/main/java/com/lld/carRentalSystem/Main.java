package com.lld.carRentalSystem;

import com.lld.carRentalSystem.entities.billingDetails.Bill;
import com.lld.carRentalSystem.entities.billingDetails.Payment;
import com.lld.carRentalSystem.entities.reservationDetails.Reservation;
import com.lld.carRentalSystem.entities.reservationDetails.User;
import com.lld.carRentalSystem.entities.storeDetails.Location;
import com.lld.carRentalSystem.entities.storeDetails.Store;
import com.lld.carRentalSystem.entities.vehicleDetails.Car;
import com.lld.carRentalSystem.entities.vehicleDetails.Vehicle;
import com.lld.carRentalSystem.entities.vehicleDetails.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        List<User> users = addUsers();
        List<Vehicle> vehicles = addVehicles();
        List<Store> stores = addStores(vehicles);

        VehicleRentalSystem rentalSystem = new VehicleRentalSystem(stores, users);

        //0. User comes
        User user = users.get(0);

        //1. user search store based on location
        Location location = new Location(403012, "Bangalore", "Karnataka", "India");
        Store store = rentalSystem.getStore(location);

        //2. get All vehicles you are interested in (based upon different filters)
        List<Vehicle> storeVehicles = store.getVehicles(VehicleType.CAR);

        //3.reserving the particular vehicle
        Reservation reservation = store.createReservation(storeVehicles.get(0), users.get(0));

        //4. generate the bill
        Bill bill = new Bill();
        bill.setReservation(reservation);

        //5. make payment
        Payment payment = new Payment();
        payment.payBill(bill);

        //6. trip completed, submit the vehicle and close the reservation
        store.completeReservation(reservation.getResId());

    }



    public static List<Vehicle> addVehicles(){

        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle vehicle1 = new Car();
        vehicle1.setVehicleId(1);
        vehicle1.setVehicleType(VehicleType.CAR);

        Vehicle vehicle2 = new Car();
        vehicle1.setVehicleId(2);
        vehicle1.setVehicleType(VehicleType.CAR);

        vehicles.add(vehicle1);
        vehicles.add(vehicle2);
        return vehicles;
    }

    public static List<User> addUsers(){
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setUserId(1);

        users.add(user1);
        return users;
    }

    public static List<Store> addStores(List<Vehicle> vehicles){

        List<Store> stores = new ArrayList<>();
        Store store = new Store();
        store.setStoreId(1);
        store.setVehicles(vehicles);

        stores.add(store);
        return stores;
    }

}
