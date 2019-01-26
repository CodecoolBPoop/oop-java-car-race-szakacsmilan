package com.codecool.car_race;

import java.util.Random;

public class Weather {

    static boolean raining = false;

    public static void setRaining() {
        Random random = new Random();
        int chance = random.nextInt(100) + 1;
        if (chance < 31) {
            raining = true;
        }else{
            raining = false;
        }
    }

    public static boolean isRaining(){
        setRaining();
        return raining;
    }
}
