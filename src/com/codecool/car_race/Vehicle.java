package com.codecool.car_race;

public abstract class Vehicle {

    int distanceTraveled;
    int lowSpeed;
    int maxSpeed;
    int actualSpeed;
    String name;


    public abstract void prepareForLap(Race race);


    public abstract void moveForAnHour();

}
