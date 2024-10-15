package com.SWC.group28;

public class Battleship extends Boat {

    private static int unitCounter = 0;

    Battleship() {
        this.setSize(4);
        this.setChar('B');
        unitCounter++;
        this.setName("Battleship " + unitCounter);

        this.occupiedCells = new String[4];
    }

}
