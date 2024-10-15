package Vehicle_Behaviour.Price;

/**
 Die FixedPrice class is responsible for the handling of hourly rate prices that may occur,
 */
public class PricePerHour implements PriceBehaviour {
    private int price;

    /**
     * The Constructor PricePerHour is responsible for the setting of the hourly expenses.
     * @param price takes an integer and sets it as the given price per hour.
     * @exception IllegalArgumentException for any negative amounts
     */
    public PricePerHour(int price) throws IllegalArgumentException{
        if(price < 0){throw new IllegalArgumentException("cannot specify negative price");}
        this.price = price;
    }

    /**
     * @return the already formatted price as a Sting.
     */
    @Override
    public String getFormattedPrice() {
        return  (price + " CHF/h");
    }
}
