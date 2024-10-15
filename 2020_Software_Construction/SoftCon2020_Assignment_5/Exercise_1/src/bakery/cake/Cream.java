package bakery.cake;

/**
 * Implements the Decorator pattern
 * This is a concrete decorator of the pattern
 *
 * */

public class Cream extends CakeDecorator {

    Cake cake;

    public Cream(Cake cake){
        this.cake = cake;
    }


    /**
     *
     * @return returns the description of the cake with cream
     */
    @Override
    public String getDescription() {
        return cake.getDescription() + " + cream";
    }

    /**
     *
     * @return returns the price of the cake with cream
     */
    @Override
    public double cost() {
        return cake.cost() + 1.5;
    }
}
