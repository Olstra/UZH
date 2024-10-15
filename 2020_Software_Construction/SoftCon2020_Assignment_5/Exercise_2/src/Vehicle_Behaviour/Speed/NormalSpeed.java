package Vehicle_Behaviour.Speed;

/**
 * The class NormalSpeed is responsible for setting the Vehicles speed behaviour to be a normally fast vehicle
 */
public class NormalSpeed implements SpeedBehaviour {
    private String type = "normal speed";

    /**
     * getSpeedType() is used for giving the customer information about the vehicles speed.
     * @return returns the type of speed as a string.
     */
    @Override
    public String getSpeedType() {
        return type;
    }
}
