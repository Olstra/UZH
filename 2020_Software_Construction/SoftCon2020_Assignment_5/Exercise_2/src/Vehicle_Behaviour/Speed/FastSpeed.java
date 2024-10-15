package Vehicle_Behaviour.Speed;

/**
 * The class FastSpeed is responsible for setting the Vehicles speed behaviour to be a fast vehicle
 */
public class FastSpeed implements SpeedBehaviour {
    private String type = "fast speed";

    /**
     * getSpeedType() is used for giving the customer information about the vehicles speed.
     * @return returns the type of speed as a string.
     */
    @Override
    public String getSpeedType() {
        return type;
    }
}
