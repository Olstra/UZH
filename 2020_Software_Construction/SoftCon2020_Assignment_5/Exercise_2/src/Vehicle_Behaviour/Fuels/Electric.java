package Vehicle_Behaviour.Fuels;


/**
 *  The class Electric is an implementation of possible kinds of ways of powering the vehicle
 */
public class Electric implements FuelBehaviour {
    private String fuelType = "electric";

    /**
     * @return the String fueltype, that would inform about which fuel the current vehicle is using.
     * In this case it is electric.
     */
    @Override
    public String getFuelType() {
        return fuelType;
    }
}
