package VehiclesTest;
//TODO Implement Luggage Tests
import Vehicle_Behaviour.Fuels.Gasoline;
import Vehicle_Behaviour.Luggage.CombinedSmallLargeLuggage;
import Vehicle_Behaviour.Price.PricePerHour;
import Vehicle_Behaviour.Speed.FastSpeed;
import Vehicles.SuperCar;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class SuperCarTest {
    /* SuperCar needs:
    -PricePerHour
    -one small bag
    -normal speed
    -Electric
    */

    SuperCar TestSuperCar = new SuperCar();

    @Test
    void SuperCarHasHourlyPrice() {
        assertNotNull(TestSuperCar.getPriceBehaviour());
        assertTrue(TestSuperCar.getPriceBehaviour().getClass() == PricePerHour.class);
    }

    @Test
    void SuperCarHasGasoline() {
        assertNotNull(TestSuperCar.getFuelBehaviour());
        assertTrue(TestSuperCar.getFuelBehaviour().getClass() == Gasoline.class);
    }

    @Test
    void SuperCarHasNormalSpeed() {
        assertNotNull(TestSuperCar.getSpeedBehaviour());
        assertTrue(TestSuperCar.getSpeedBehaviour().getClass() == FastSpeed.class);
    }
    @Test
    void SuperCarHasLuggage(){
        assertNotNull(TestSuperCar.getLuggageBehaviour());
        assertTrue(TestSuperCar.getLuggageBehaviour().getClass() == CombinedSmallLargeLuggage.class);
        assertEquals( "1 small and 1 large", TestSuperCar.getLuggageBehaviour().getLuggageProperties());
    }
}
