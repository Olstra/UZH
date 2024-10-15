package com.SWC.group28;


public class Submarine extends Boat {

    private static int unitCounter = 0;

    Submarine() {
        this.setSize(3);
        this.setChar('S');
        unitCounter++;
        this.setName("Submarine "+unitCounter);
    }

}
