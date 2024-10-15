package bank.Technicians;

import bank.Individual;


public abstract class Technician extends Individual {

    public Technician(String name, String surname) throws IllegalArgumentException {
        super(name, surname);
    }

}
