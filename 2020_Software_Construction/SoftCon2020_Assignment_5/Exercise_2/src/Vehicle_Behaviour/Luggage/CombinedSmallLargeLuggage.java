package Vehicle_Behaviour.Luggage;

/**
 * The class CombinedSmallLargeLugges is used for handling the maximum amount of possible small and large Bags.
 * The handling of the specific large and small bags is left for their initial classes LargeLuggage and SmallLuggage to handle,
 * this class is responsible for combining the properties of small and large Luggage so the vehicle can use both.
 */
public class CombinedSmallLargeLuggage implements LuggageBehaviour {
    SmallLuggage small;
    LargeLuggage large;

    /**
     * The constructor CombinedSmallLargeLuggage takes on two parameters.
     * @param amountSmall is the maximum amount of possible small Bags
     * @param amountLarge is the maximum amount of possible large Bags
     * @exception IllegalArgumentException is thrown by respective smallLuggage and largeLuggage Constructor
     * it calls on the constructors for SmallLuggage and LargeLuggage and uses them to store the amounts
     */
    public CombinedSmallLargeLuggage(int amountSmall, int amountLarge) throws IllegalArgumentException{
        small = new SmallLuggage(amountSmall);
        large = new LargeLuggage(amountLarge);
    }

    /**
     * Handles the combined output for both bags
     * @return a String of the combined getLuggageProperties of the respective Classes LargeLuggage and SmallLuggage
     */
    @Override
    public String getLuggageProperties() {
        return small.getLuggageProperties() + " and " + large.getLuggageProperties();
    }
}
