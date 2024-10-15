package Vehicle_Behaviour.Price;

/**
 Die FixedPrice class is responsible for the handling of the fixed prices that may occur,
 */
public class PriceFixed implements PriceBehaviour {
    private int price;

    /**
     * The Constructor FixedPrice is responsible for the setting of the fixed expenses.
     * @param price takes an integer and sets it as the given price.
     * @exception IllegalArgumentException for any negative amounts
     */
    public PriceFixed(int price) throws IllegalArgumentException{
        if(price < 0){throw new IllegalArgumentException("cannot specify negative price");}
        this.price = price;
    }

    /**
     * @return the already formatted price as a Sting.
     */
    @Override
    public String getFormattedPrice() {
        return  (price + " CHF");
    }
}
