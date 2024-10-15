package Vehicles;

import Vehicle_Behaviour.Fuels.Gasoline;
import Vehicle_Behaviour.Luggage.CombinedSmallLargeLuggage;
import Vehicle_Behaviour.Price.PricePerHour;
import Vehicle_Behaviour.Speed.NormalSpeed;

public class FamilyCar extends Vehicle{

    /**
     * The FamilyCar constructor is called to implement a family car with the specified behaviours inside of the body
     * it is gasoline powered, has an hourly price, is a normally fast vehicle and can fit two small and two large bags.
     */
    public FamilyCar(){
        super.setName("Family Car");
        super.setFuelBehaviour( new Gasoline());
        super.setPriceBehaviour(new PricePerHour(15));
        super.setSpeedBehaviour(new NormalSpeed());
        super.setLuggageBehaviour(new CombinedSmallLargeLuggage(2,2));
    }
}
