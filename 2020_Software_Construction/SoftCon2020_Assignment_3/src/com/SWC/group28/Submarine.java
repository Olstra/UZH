package com.SWC.group28;


public class Submarine extends Boat {

    //private static int unitCounter = 0;

    SubmarineCounter counter = SubmarineCounter.getInstance();

    int lives;

    //public String[] occupiedCells = new String[3];

    Submarine() {
        this.setSize(3);
        this.setChar('S');
        counter.incrementCounter();
        this.setName("Submarine " + counter.getNr());

        // to count when boat gets distroyed
        this.lives = 3;
        this.occupiedCells = new String[3];
    }

}
