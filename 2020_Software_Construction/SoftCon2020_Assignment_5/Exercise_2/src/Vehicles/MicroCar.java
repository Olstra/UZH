package Vehicles;

import Vehicle_Behaviour.Fuels.Electric;
import Vehicle_Behaviour.Luggage.SmallLuggage;
import Vehicle_Behaviour.Price.PricePerHour;
import Vehicle_Behaviour.Speed.NormalSpeed;

public class MicroCar extends Vehicle{

    /**
     * The MicroCar constructor is called to implement a micro car with the specified behaviours inside of the body
     * it is electric powered, has an hourly price, is a normally fast vehicle and can fit a small bag.
     */
    public MicroCar(){
        super.setLuggageBehaviour(new SmallLuggage(1));
        super.setFuelBehaviour(new Electric());
        super.setPriceBehaviour(new PricePerHour(12));
        super.setSpeedBehaviour(new NormalSpeed());
        super.setName("Micro Car");
    }
}
