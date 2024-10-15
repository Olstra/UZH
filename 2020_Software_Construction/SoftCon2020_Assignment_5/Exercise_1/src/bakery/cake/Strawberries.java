package bakery.cake;

/**
 * Implements the Decorator pattern
 * This is a concrete decorator of the pattern
 *
 * */

public class Strawberries extends CakeDecorator {
    Cake cake;

    public Strawberries(Cake cake){
        this.cake = cake;
    }

    /**
     *
     * @return returns the description of the cake with strawberries
     */
    @Override
    public String getDescription() {
        return cake.getDescription() + " + strawberries";
    }

    /**
     *
     * @return returns the price of the cake with strawberries
     */
    @Override
    public double cost() {
        return cake.cost() + 1.0;
    }
}
