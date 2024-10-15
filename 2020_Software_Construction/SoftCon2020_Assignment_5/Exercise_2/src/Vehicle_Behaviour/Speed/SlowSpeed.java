package Vehicle_Behaviour.Speed;


/**
 * The class SlowSpeed is responsible for setting the Vehicles speed behaviour to be a slow vehicle
 */
public class SlowSpeed implements SpeedBehaviour {
    private String type = "slow speed";

    /**
     * getSpeedType() is used for giving the customer information about the vehicles speed.
     * @return returns the type of speed as a string.
     */
    @Override
    public String getSpeedType() {
        return type;
    }
}
