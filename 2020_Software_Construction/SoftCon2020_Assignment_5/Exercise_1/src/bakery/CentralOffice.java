package bakery;

import java.util.ArrayList;
import java.util.List;


<<<<<<< Updated upstream
/**
 * Is a composite of the BakeryComponent.
 *
 * Note: Since there will only be 1 central office, we decided to implement this class as a singleton.
 *
 * */
public class CentralOffice extends BakeryComponent{

    /** Unique instance of the central office. */
    private static CentralOffice centralOfficeInstance;
=======
// TODO we only need 1 of this... possible candidate for a singleton???
public class CentralOffice extends BakeryComponent {

    private List<BakeryComponent> list = new ArrayList<>();
>>>>>>> Stashed changes

    /** List storing all city offices. */
    private List<CityOffice> cityOffiecesL = new ArrayList<>();

    /** Private constructor since singleton pattern. */
    private CentralOffice() {}

    /**
     * @return return the single instance of the CentralOffice class
     * */
    public static CentralOffice getInstance() {
        if (CentralOffice.centralOfficeInstance == null) {
            CentralOffice.centralOfficeInstance = new CentralOffice();
        }

        return CentralOffice.centralOfficeInstance;
    }

    /**
     * Adds a city office to the central office.
     * */
    public void addCityOffice(CityOffice cityOffice) {
        this.cityOffiecesL.add(cityOffice);
    }

    /**
     * Prints all offices belonging to the central office
     * and all their corresponding bakeries.
     *
     * */
    public void printAllOffices (){
        for (CityOffice cityOffice : cityOffiecesL) {
            System.out.print( cityOffice.getName() + ", " );
            cityOffice.printAllBakeriesNames();
        }
    }

}