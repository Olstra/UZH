package Vehicle_Behaviour.Fuels;

/**
 *  The class Diesel is an implementation of possible kinds of ways of powering the vehicle
 */
public class Diesel implements FuelBehaviour {
    private String fuelType = "diesel";

    /**
     * @return the String fueltype, that would inform about which fuel the current vehicle is using.
     * In this case it is diesel.
     */
    @Override
    public String getFuelType() {
        return fuelType;
    }
}