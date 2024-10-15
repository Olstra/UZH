package Vehicles;

import Vehicle_Behaviour.Fuels.Diesel;
import Vehicle_Behaviour.Luggage.UnlimitedLuggage;
import Vehicle_Behaviour.Price.PriceFixed;
import Vehicle_Behaviour.Speed.SlowSpeed;

/**
 * The class Bus constructs an object "Bus" and every Bus is also a vehicle and has properties as such.
 */

public class Bus extends Vehicle{

    /**
     * The Bus constructor is called to implement a Bus with the specified behaviours inside of the body
     * it is Diesel powered, has a fixed price, is a slow vehicle and is not constrained regaring to any kind of luggage.
     */

    public Bus (){
        super.setName("Bus");
        super.setFuelBehaviour(new Diesel());
        super.setPriceBehaviour(new PriceFixed(5));
        super.setSpeedBehaviour(new SlowSpeed());
        super.setLuggageBehaviour(new UnlimitedLuggage());
    }
}
