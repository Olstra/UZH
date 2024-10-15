package Vehicle_Behaviour.Fuels;

/**
 *  The class Gasoline is an implementation of possible kinds of ways of powering the vehicle
 */
public class Gasoline implements FuelBehaviour {
    private String fuelType = "gasoline";

    /**
     * @return the String fueltype, that would inform about which fuel the current vehicle is using.
     * In this case it is gasoline.
     */
    @Override
    public String getFuelType() {
        return fuelType;
    }
}
