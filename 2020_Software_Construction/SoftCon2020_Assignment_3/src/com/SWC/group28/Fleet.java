package com.SWC.group28;

import java.util.ArrayList;
import java.util.Iterator;

public class Fleet implements Iterable<Boat>{
    private final int totalBoats = 10;
    private Boat[] fleet = new Boat[totalBoats];

    public Fleet (Boat[] fleet)
    {
        this.fleet = fleet;
    }

    public Fleet(){
        // create fleet, 10 boats total
        // 1 carrier
        this.fleet[0] = new Carrier();
        // 2 battleships
        this.fleet[1] = new Battleship();
        this.fleet[2] = new Battleship();
        // 3 submarines
        this.fleet[3] = new Submarine();
        this.fleet[4] = new Submarine();
        this.fleet[5] = new Submarine();
        // 4 patrol boats
        this.fleet[6] = new PatrolBoat();
        this.fleet[7] = new PatrolBoat();
        this.fleet[8] = new PatrolBoat();
        this.fleet[9] = new PatrolBoat();
    };



    @Override
    public Iterator<Boat> iterator() {
        return new FleetIterator(fleet);
    }


}
