package bakery;

import java.util.ArrayList;
import java.util.List;

<<<<<<< Updated upstream
/**
 * Is a composite of the BakeryComponent.
 *
 */
 public class CityOffice extends BakeryComponent{

    /** List storing all bakeries. */
    private final List<BakeryComponent> bakeryList = new ArrayList<>();

    /** Name of the city office. */
    private final String name;

    /**
     * Constructor for CityOffice.
     * Name according to assignment description.
     * */
    public CityOffice(String cityName) {
        this.name = "city office of " + cityName;
=======

public class CityOffice extends BakeryComponent {

    private List<BakeryComponent> backeryList = new ArrayList<>();

    private String name;

    public CityOffice(String name) {
        this.name = name;
>>>>>>> Stashed changes
    }

    /**
     * @return  the name of the city office
     * */
    public String getName() { return this.name; }

    /**
     * Adds a bakery to the city office.
     * */
    public void addBakery(BakeryComponent bakery) {
        this.bakeryList.add(bakery);
    }

    /**
     * Prints all the bakeries names that belong to a city office.
     * */
    public void printAllBakeriesNames (){
        for (BakeryComponent bakeryComponent : bakeryList) {
            System.out.print( bakeryComponent.getName() + ", " );
        }
    }
}