package com.codecool.car_race;

import java.util.Random;

public class Motorcycle extends Vehicle {
    private static int counter = 0;

    public Motorcycle() {
        counter ++;
        this.name = "Motorcycle " + getNumOfInstances();
        this.maxSpeed = 100;
        this.lowSpeed = getLowSpeed();
        this.actualSpeed = maxSpeed;
    }


    @Override
    public void prepareForLap(Race race) {
        if (race.raining) {
            this.actualSpeed = lowSpeed;
        } else {
            this.actualSpeed = maxSpeed;
        }
    }

    @Override
    public void moveForAnHour() {
        this.distanceTraveled += actualSpeed;
    }


    public static int getNumOfInstances() {
        return counter;
    }

    public int getLowSpeed() {
        Random random = new Random();
        return 50 + random.nextInt(46);
    }


}
