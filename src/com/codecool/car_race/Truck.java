package com.codecool.car_race;

import java.util.Random;

public class Truck extends Vehicle{

    private String name;
    static int breakdownTurnsLeft;
    static boolean breakDown = false;



    public Truck(){
        this.name = getName();
    }


    public String getName(){
        Random random = new Random();

        String name = "Truck" + " " + random.nextInt(1000);

        return name;

    }

    @Override
    public void prepareForLap(Race race) {
        if (breakdownTurnsLeft > 0) {
            while (breakdownTurnsLeft > 0) {
                this.actualSpeed = 0;
                breakdownTurnsLeft = breakdownTurnsLeft -1;
            }
        } else {
            this.actualSpeed = 100;
            breakdownTurnsLeft = 0;
        }

    }

    @Override
    public void moveForAnHour() {this.distanceTraveled += actualSpeed;}

    public static boolean isBreakDown(){
        setBreakDrown();
        if (breakdownTurnsLeft < 0) {
            breakDown = false;
        } else {
            breakDown = true;
        }
        return breakDown;
    }


    public static void setBreakDrown(){
        Random random = new Random();
        int chance = random.nextInt(100);
        if (chance < 5){
            breakdownTurnsLeft +=2;
        } else {
            breakdownTurnsLeft = 0;
        }
    }

}
