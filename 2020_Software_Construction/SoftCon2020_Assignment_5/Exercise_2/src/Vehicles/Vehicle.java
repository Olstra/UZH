package Vehicles;

import Vehicle_Behaviour.Fuels.FuelBehaviour;
import Vehicle_Behaviour.Luggage.LuggageBehaviour;
import Vehicle_Behaviour.Price.PriceBehaviour;
import Vehicle_Behaviour.Speed.SpeedBehaviour;

/**
 * The abstract class Vehicle is used to implement several different types of vehicles like Busses Car and similar things.
 * It enables new subclasses of Vehicles to be implemented according to a specific type of behaviour. it stores the different kinds of behaviours as
 * class variables
 */
 public abstract class Vehicle {
    private String name;
    private FuelBehaviour fuelBehaviour;
    private PriceBehaviour priceBehaviour;
    private SpeedBehaviour speedBehaviour;
    private LuggageBehaviour luggageBehaviour;

    /**
     * sets the fuelBhaviour to be a specific class that implements it.
     * @param fuelBehaviour
     */
    public void setFuelBehaviour(FuelBehaviour fuelBehaviour) {
        this.fuelBehaviour = fuelBehaviour;
    }

    /**
     * sets the speedBehaviour to be a specific class that implements it.
     * @param speedBehaviour
     */
    public void setSpeedBehaviour(SpeedBehaviour speedBehaviour) {
        this.speedBehaviour = speedBehaviour;
    }

    /**
     * sets the priceBehviour to be a specific class that implements it.
     * @param priceBehaviour
     */
    public void setPriceBehaviour(PriceBehaviour priceBehaviour) {
        this.priceBehaviour = priceBehaviour;
    }

    /**
     * sets the luggageBehaviour to be a specific class that implements it.
     * @param luggageBehaviour
     */
    public void setLuggageBehaviour(LuggageBehaviour luggageBehaviour) {
        this.luggageBehaviour = luggageBehaviour;
    }

    /**
     * sets the name of the vehicle.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the current fuelBehaviour of a vehicle
     */
    public FuelBehaviour getFuelBehaviour() {
        return fuelBehaviour;
    }


    /**
     * @return the current priceBehaviour of a vehicle
     */
    public PriceBehaviour getPriceBehaviour() {
        return priceBehaviour;
    }


    /**
     * @return the current speedBehaviour of a vehicle
     */
    public SpeedBehaviour getSpeedBehaviour() {
        return speedBehaviour;
    }

    /**
     * @return the current luggageBehaviour of a vehicle
     */
    public LuggageBehaviour getLuggageBehaviour() {
        return luggageBehaviour;
    }


    /**
     * @return the name of the vehicle
     */
     public String getName() {
         return name;
     }


     }

