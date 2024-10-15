package VehiclesTest;
//TODO Implement Luggage Tests
import Vehicle_Behaviour.Fuels.Diesel;
import Vehicle_Behaviour.Luggage.UnlimitedLuggage;
import Vehicle_Behaviour.Price.PriceFixed;
import Vehicle_Behaviour.Speed.SlowSpeed;
import Vehicles.Bus;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class BusTest {
    /* Bus needs:
    -Fixed Price
    -UNLIMITED POW... uuuh  luggage
    -slow speed
    -Diesel
    */

    Bus TestBus = new Bus();

    @Test
    void BusHasFixedPrice() {
        assertNotNull(TestBus.getPriceBehaviour());
        assertTrue(TestBus.getPriceBehaviour().getClass() == PriceFixed.class);
    }
    @Test
    void BusHasDiesel(){
        assertNotNull(TestBus.getFuelBehaviour());
        assertTrue(TestBus.getFuelBehaviour().getClass() == Diesel.class);
    }
    @Test
    void BusIsSlow(){
        assertNotNull(TestBus.getSpeedBehaviour());
        assertTrue(TestBus.getSpeedBehaviour().getClass() == SlowSpeed.class);
    }
    @Test
    void BusHasUnlimitedLuggage(){
        assertNotNull(TestBus.getLuggageBehaviour());
        assertTrue(TestBus.getLuggageBehaviour().getClass() == UnlimitedLuggage.class);
    }
}
