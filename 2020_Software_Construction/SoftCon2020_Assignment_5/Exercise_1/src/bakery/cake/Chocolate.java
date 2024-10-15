package bakery.cake;

/**
 * Implements the Decorator pattern
 * This is a concrete decorator of the pattern
 *
 * */

public class Chocolate extends CakeDecorator {

    Cake cake;

    public Chocolate(Cake cake){
        this.cake = cake;
    }

    /**
     *
     * @return returns the description of the cake with chocolate
     */
    @Override
    public String getDescription() {
        return cake.getDescription() + " + chocolate";
    }

    /**
     *
     * @return returns the price of the cake with chocolate
     */
    @Override
    public double cost() {
        return cake.cost() + 2.0; }
}
