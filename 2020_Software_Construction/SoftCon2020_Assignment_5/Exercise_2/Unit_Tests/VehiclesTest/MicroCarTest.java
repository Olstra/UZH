package VehiclesTest;
//TODO Implement Luggage Tests
import Vehicle_Behaviour.Fuels.Electric;
import Vehicle_Behaviour.Luggage.SmallLuggage;
import Vehicle_Behaviour.Price.PricePerHour;
import Vehicle_Behaviour.Speed.NormalSpeed;
import Vehicles.MicroCar;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class MicroCarTest {
    /* MicroCar needs:
    -PricePerHour
    -one small bag
    -normal speed
    -Electric
    */

    MicroCar TestMicroCar = new MicroCar();

    @Test
    void MicroCarHasHourlyPrice() {
        assertNotNull(TestMicroCar.getPriceBehaviour());
        assertTrue(TestMicroCar.getPriceBehaviour().getClass() == PricePerHour.class);
    }

    @Test
    void MicroCarHasGasoline() {
        assertNotNull(TestMicroCar.getFuelBehaviour());
        assertTrue(TestMicroCar.getFuelBehaviour().getClass() == Electric.class);
    }

    @Test
    void MicroCarHasNormalSpeed() {
        assertNotNull(TestMicroCar.getSpeedBehaviour());
        assertTrue(TestMicroCar.getSpeedBehaviour().getClass() == NormalSpeed.class);
    }
    @Test
    void MicroCarHasLuggage(){
        assertNotNull(TestMicroCar.getLuggageBehaviour());
        assertTrue(TestMicroCar.getLuggageBehaviour().getClass() == SmallLuggage.class);
        assertEquals( "1 small", TestMicroCar.getLuggageBehaviour().getLuggageProperties());
    }
}
//Missing Luggage test