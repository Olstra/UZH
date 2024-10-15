package Vehicles;

import Vehicle_Behaviour.Luggage.CombinedSmallLargeLuggage;
import Vehicle_Behaviour.Speed.FastSpeed;
import Vehicle_Behaviour.Fuels.Gasoline;
import Vehicle_Behaviour.Price.PricePerHour;

public class SuperCar extends Vehicle{

    /**
     * The SuperCar constructor is called to implement a  Supercar with the specified behaviours inside of the body
     * it is gasoline powered, has an hourly price, is a very fast vehicle and can a small and a large bag.
     */
    public SuperCar(){
        super.setFuelBehaviour(new Gasoline());
        super.setPriceBehaviour(new PricePerHour(30));
        super.setSpeedBehaviour(new FastSpeed());
        super.setLuggageBehaviour(new CombinedSmallLargeLuggage(1,1));
        super.setName("Supercar");
    }
}
