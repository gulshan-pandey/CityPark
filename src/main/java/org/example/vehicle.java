package org.example;

import java.util.ArrayList;
import java.util.List;

class Vehicle {
    private String licensePlate;

    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

}

class ParkingSpot{
    private int spotNumber;
    private boolean isAvailable;
    private Vehicle vehicle;

    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.isAvailable = true;
        this.vehicle = null;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void occupy(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isAvailable =false;
    }

    public void vacant(){
        this.vehicle = null;
        this.isAvailable = true;
    }

}


class ParkingLot{
    private List<ParkingSpot> spots;

    public ParkingLot(int capacity) {
        this.spots = new ArrayList<>();
        for(int i =0; i<capacity; i++){
            spots.add(new ParkingSpot(i));
        }
    }


    public boolean park(Vehicle vehicle){
        for(ParkingSpot spot : spots){
            if(spot.isAvailable()){
                spot.occupy(vehicle);
                System.out.println("Vehicle parked at spot :" + spot.getSpotNumber()+ " with license plate :" + vehicle.getLicensePlate());
                return true;
            }
        }
        System.out.println("parking is full!");
            return false;
    }


    public boolean removeVehicle(String licensePlate){
        for(ParkingSpot  spot :spots){
            if(!spot.isAvailable() && spot.getVehicle().getLicensePlate().equalsIgnoreCase(licensePlate)){
                spot.vacant();
                System.out.println("Vehicle with number : " +licensePlate + " removed form parking");
                return true;
            }
        }
        System.out.println("Vehicle with number : " +licensePlate + " not found");
        return false;
    }

}

class main{
    public static void main(String[] args) {
        ParkingLot parkinglot = new ParkingLot(5);


        Vehicle v1 = new Vehicle("UP2492");
        Vehicle v2 = new Vehicle("UP2493");
        Vehicle v3 = new Vehicle("UP2494");
        Vehicle v4 = new Vehicle("UP2496");
        Vehicle v5 = new Vehicle("UP2414");
        Vehicle v6 = new Vehicle("UP242554");
        Vehicle v7 = new Vehicle("UP9994");

        parkinglot.park(v1);
        parkinglot.park(v2);
        parkinglot.park(v3);
        parkinglot.park(v4);
        parkinglot.park(v5);
        parkinglot.park(v6);
        parkinglot.park(v7);

        parkinglot.removeVehicle("UP2492");
        parkinglot.removeVehicle("UP2493");
        parkinglot.removeVehicle("UP9994");


    }
}




