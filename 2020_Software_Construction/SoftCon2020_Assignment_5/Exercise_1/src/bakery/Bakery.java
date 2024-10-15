package bakery;
import bakery.cake.*;
import bakery.sandwich.*;

<<<<<<< Updated upstream
=======
public class Bakery extends BakeryComponent {
>>>>>>> Stashed changes

public class Bakery extends BakeryComponent{

    private final String name;
    private final String address;

    public Bakery(String name, String address) {
        this.name = name;
        this.address = address;
    }

    /**
     * prints the name of the bakery to the console
     * */
    public void printName() {
        System.out.println( this.getName() );
    }

    /**
     * getter for the address of the bakery
     * @return  the address of the bakery
     * */
    public String getAddress() { return address; }

    /**
     * getter for the name of the bakery
     * @return  the name of the bakery
     * */
    public String getName() { return name; }

    /**
     * Enables order of a sandwich.
     * Should be implemented in the classes that support this operation (aka that sell bread).
     * */
    public void orderSandwich() {
        throw new UnsupportedOperationException();
    }

    /**
     * Enables order of a cake.
     * Should be implemented in the classes that support this operation (aka that sell sweets).
     * */
    public void orderSweets() {
        throw new UnsupportedOperationException();
    }

}
