package bakery.sandwich;

/**
 * Implements the Decorator pattern
 * This is a concrete decorator of the pattern
 *
 * */

public class Tuna extends SandwichDecorator {

    Sandwich sandwich;

    public Tuna(Sandwich sandwich){
        this.sandwich = sandwich;
    }

    /**
     *
     * @return returns the description of the sandwich with tuna
     */
    @Override
    public String getDescription() {

        return sandwich.getDescription() + " + tuna";
    }

    /**
     *
     * @return returns the price of the sandwich with tuna
     */
    @Override
    public double cost() {
        return sandwich.cost() + 3.0;
    }
}
