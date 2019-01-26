package com.codecool.car_race;

import java.util.Random;

public class Car extends Vehicle{

    String[] names = {"Mastery", "Silver","Scorpion", "Symbol", "Vertex", "Aurora", "Curiosity", "Titan", "Velocity", "Magic", "Troll0", "Golden", "Assasin", "Milan", "Feca", "Mario", "Mongoose", "Black", "Knight"};


    public Car(){
        this.lowSpeed = 75;
        this.maxSpeed =  getMaxSpeed();
        this.actualSpeed = maxSpeed;
        this.distanceTraveled = 0;
        this.name = getName();

    }



    public String getName(){
        Random random = new Random();

        int random1 = random.nextInt(names.length);
        int random2 = random.nextInt(names.length);

        return names[random1]+" "+names[random2];
    }

    public int getMaxSpeed(){
        Random random = new Random();
        return (80 + random.nextInt(31));
    }


    @Override
    public void moveForAnHour() {
        this.distanceTraveled += actualSpeed;
    }

    @Override
    public void prepareForLap(Race race) {
        if (race.truckBreakdown){
            actualSpeed = 75;
        } else {
            actualSpeed = maxSpeed;
        }
    }

}
