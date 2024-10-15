package Vehicle_Behaviour.Luggage;

/**
 * The class LargeLuggage is responsible for handling the maximum amount of possible large bags.
 * It stores the maximum amount and also the type of luggage.
 */
public class LargeLuggage implements LuggageBehaviour {
    private int amount;
    private String type = "large";

    /**
     * The constructor LargeLuggage is used to give the Vehicle handling of Luggage for large Bags.
     * @param amount  takes a specified amount at implements it as the amount of possible Bags
     */
    public LargeLuggage(int amount) throws IllegalArgumentException {
        if(amount < 0 ){
            throw new IllegalArgumentException("cannot specify negative amount");
        }
        this.amount = amount;
    }

    /**
     * the implemented method getLuggageProperties is handling one part of the String that will be returned to the customer
     * @return formatted string amount and type (large)
     *
     */
    @Override
    public String getLuggageProperties() {
        return amount +" " + type;
    }
}


