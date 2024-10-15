package bakery.cake;

/**
 * Implements the Decorator pattern
 * This is the abstract component of the pattern
 *
 * */

public class Cake{

    protected String description = "Cake";

    /** @return returns the description of the cake. */
    public String getDescription(){
        return description;
    }

    /** @return returns the cost of the cake. */
    public double cost() {
        return 3.0;
    }

}