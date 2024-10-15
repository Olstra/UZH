package bakery.sandwich;

/**
 * Implements the Decorator pattern
 * This is the abstract component of the pattern
 *
 * */

public class Sandwich{

    protected String description = "Sandwich";
    private int price;

    public Sandwich() { }

    public String getDescription(){
        return description;
    }

    public double cost() {
        return 2.0;
    }
}