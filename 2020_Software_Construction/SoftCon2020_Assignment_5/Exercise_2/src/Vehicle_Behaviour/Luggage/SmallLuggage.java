package Vehicle_Behaviour.Luggage;

/**
 * The class SmallLuggage is responsible for handling the maximum amount of possible small bags.
 * It stores the maximum amount and also the type of luggage.
 */
public class SmallLuggage implements LuggageBehaviour {

    private int amount;
    private String type = "small";

    /**
     * The constructor LargeLuggage is used to give the Vehicle handling of Luggage for small Bags.
     * @param amount  takes a specified amount at implements it as the amount of possible Bags
     * @exception IllegalArgumentException for negative amount of bags
     */
    public SmallLuggage(int amount) throws IllegalArgumentException {
        if( amount < 0){
            throw new IllegalArgumentException("cannot specify negative amount");
        }
        this.amount = amount;
    }

    /**
     * the implemented method getLuggageProperties is handling one part of the String that will be returned to the customer
     * @return formatted string amount and type (small)
     *
     */
    @Override
    public String getLuggageProperties() {
        return amount +" " + type;
    }
}
