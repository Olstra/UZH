package com.SWC.group28;


public class PatrolBoat extends Boat {

    private static int unitCounter = 0;

    PatrolBoat() {
        this.setSize(2);
        this.setChar('P');
        unitCounter++;
        this.setName("Patrol boat "+ unitCounter);
    }

}
