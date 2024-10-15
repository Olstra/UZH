package bakery.sandwich;

/**
 * Implements the Decorator pattern
 * This is a concrete decorator of the pattern
 *
 * */

public class Tomatoes extends SandwichDecorator {

    Sandwich sandwich;

    public Tomatoes(Sandwich sandwich){
        this.sandwich = sandwich;
    }

    /**
     *
     * @return returns the description of the sandwich with tomatoes
     */
    @Override
    public String getDescription() {
        return sandwich.getDescription() + " + tomatoes";
    }

    /**
     *
     * @return returns the price of the sandwich with tomatoes
     */
    @Override
    public double cost() {
        return sandwich.cost() + 1.5;
    }
}
