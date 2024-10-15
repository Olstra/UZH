package bakery.sandwich;

/**
 * Implements the Decorator pattern
 * This is a concrete decorator of the pattern
 *
 * */

public class Cheese extends SandwichDecorator {

    Sandwich sandwich;

    public Cheese(Sandwich sandwich){
        this.sandwich = sandwich;
    }

    /**
     *
     * @return returns the description of the sandwich with cheese
     */
    @Override
    public String getDescription() {
        return sandwich.getDescription() + " + cheese";
    }

    /**
     *
     * @return returns the price of the sandwich with cheese
     */
    @Override
    public double cost() {
        return sandwich.cost() + 1.0;
    }
}
