package bakery.sandwich;

/**
 * Implements the Decorator pattern
 * This is a concrete decorator of the pattern
 *
 * */

public class Ham extends SandwichDecorator {

    Sandwich sandwich;

    public Ham(Sandwich sandwich){
        this.sandwich = sandwich;
    }

    /**
     *
     * @return returns the description of the sandwich with ham
     */
    @Override
    public String getDescription() {
        return sandwich.getDescription() + " + ham";
    }

    /**
     *
     * @return returns the price of the sandwich with ham
     */
    @Override
    public double cost() {
        return sandwich.cost() + 2.0;
    }
}
