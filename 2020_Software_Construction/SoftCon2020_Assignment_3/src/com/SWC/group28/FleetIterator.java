package com.SWC.group28;

import java.util.Iterator;

public class FleetIterator implements Iterator {
    private Boat[] fleet;
    private int position;

    public FleetIterator(Boat[] fleet){
        this.fleet = fleet;
        position = 0;
    }


    @Override
    public boolean hasNext() {
        if(position >= fleet.length){
            return false;
        }
        return true;
    }

    @Override
    public Boat next() {
        return fleet[position++];
    }
}
