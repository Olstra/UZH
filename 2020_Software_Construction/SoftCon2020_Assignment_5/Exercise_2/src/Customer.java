import Vehicles.Vehicle;
/**
 * The customer class handles the customers orders given a specific chosen vehicle.
 */
public class Customer {

    public Customer(){}

    /**
     * the method ride takes a vehicle and prints information of its properties. It tells what kink of vehicle it is, the limitations to the luggage,
     * the price and how fast the vehicle goes.
     * @param vehicle
     * @return output returns the String that is also printed on the Console for testing reasons mainly
     */
    public String ride(Vehicle vehicle){
        String name = vehicle.getName();
        String luggageProperties = vehicle.getLuggageBehaviour().getLuggageProperties();
        String price = vehicle.getPriceBehaviour().getFormattedPrice();
        String speed = vehicle.getSpeedBehaviour().getSpeedType();

        String output = name + "; "+luggageProperties+"Bags; "+speed + "; " +price;
        System.out.println(output);
        return output;

    }
}
