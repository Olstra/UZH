package Vehicle_Behaviour.Luggage;

/**
 * Handles the behaviour of Luggage if the the vehicle has no limits to the type or amount of bags.
 */
public class UnlimitedLuggage implements LuggageBehaviour {
    /**
     * getLuggageProperties is used tell that there is no limit to the bags of any kind.
     * @return returns the String for giving the customer information
     */
    @Override
    public String getLuggageProperties() {
        return "no limit for any kind of ";
    }
}
