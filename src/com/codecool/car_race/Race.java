package com.codecool.car_race;

import java.util.ArrayList;
import java.util.List;

public class Race {

    boolean raining = false;
    boolean truckBreakdown = false;

    List<Vehicle> carList = new ArrayList<>();
    List<Vehicle> motorcycleList = new ArrayList<>();
    List<Vehicle> truckList = new ArrayList<>();


    public void fillVehiclesList() {
        for (int i = 0; i < 10; i++) {
            carList.add(new Car());
        }

        for (int i = 0; i < 10; i++) {
            motorcycleList.add(new Motorcycle());
        }
        for (int i = 0; i < 10; i++) {
            truckList.add(new Truck());

        }
    }


    public void simulateRace(Race race) {
        fillVehiclesList();
        for (int i = 0; i <= 50; i++) {
            raining = Weather.isRaining();
            for (int j = 0; j < carList.size(); j++) {
                carList.get(j).moveForAnHour();
                carList.get(j).prepareForLap(race);
            }

            for (int j = 0; j < motorcycleList.size(); j++) {
                motorcycleList.get(j).moveForAnHour();
                motorcycleList.get(j).prepareForLap(race);
            }

            for (int j = 0; j < truckList.size(); j++) {
                truckBreakdown = Truck.isBreakDown();
                truckList.get(j).moveForAnHour();
                truckList.get(j).prepareForLap(race);
            }
        }
    }

    public void printRaceResults() {
        int maxDistance = 0;
        String maxDistanceName = "";

        List<List<Vehicle>> vehicleList = new ArrayList<>();
        vehicleList.add(carList);
        vehicleList.add(motorcycleList);
        vehicleList.add(truckList);

        List<String> vehicleNames = new ArrayList<>();
        vehicleNames.add("Cars");
        vehicleNames.add("Motorcycles");
        vehicleNames.add("Trucks");


        for (int i = 0; i < vehicleList.size(); i++) {
            System.out.println(vehicleNames.get(i)+ ":");
            for (Vehicle vec : vehicleList.get(i)
            ) {
                System.out.println(vec.name + " " + vec.distanceTraveled);
                if (vec.distanceTraveled > maxDistance) {
                    maxDistance = vec.distanceTraveled;
                    maxDistanceName = vec.name;
                }
            }
            System.out.println("--------------------");

        }
        System.out.println();
        System.out.println("******************************");
        System.out.println("The winner is: " + maxDistanceName + " with a distance of: " + maxDistance);
        System.out.println("******************************");
    }
}
