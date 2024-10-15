package com.SWC.group28;

/**
 * Implements Singleton Pattern *
 * */


public class SubmarineCounter {

    private static SubmarineCounter counter;

    private int currentNr = 0;

    private SubmarineCounter(){}

    public static SubmarineCounter getInstance() {
        if (counter == null) {
            counter = new SubmarineCounter();
        }
        return counter;
    }

    public void incrementCounter() {
        currentNr++;
    }

    public int getNr() {
        return this.currentNr;
    }

}
