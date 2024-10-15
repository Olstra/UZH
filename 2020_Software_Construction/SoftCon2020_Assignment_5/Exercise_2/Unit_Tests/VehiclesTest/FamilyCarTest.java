package VehiclesTest;
//TODO Implement Luggage Tests
import Vehicle_Behaviour.Fuels.Gasoline;
import Vehicle_Behaviour.Luggage.CombinedSmallLargeLuggage;
import Vehicle_Behaviour.Luggage.UnlimitedLuggage;
import Vehicle_Behaviour.Price.PricePerHour;
import Vehicle_Behaviour.Speed.NormalSpeed;
import Vehicles.FamilyCar;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class FamilyCarTest {
    /* FamilyCar needs:
    -PricePerHour
    -two small Bags, two large bags
    -normal speed
    -Gasoline
    */

    FamilyCar TestFamilyCar = new FamilyCar();

    @Test
    void FamilyCarHasHourlyPrice() {
        assertNotNull(TestFamilyCar.getPriceBehaviour());
        assertTrue(TestFamilyCar.getPriceBehaviour().getClass() == PricePerHour.class);
    }
    @Test
    void FamilyCarHasGasoline(){
        assertNotNull(TestFamilyCar.getFuelBehaviour());
        assertTrue(TestFamilyCar.getFuelBehaviour().getClass() == Gasoline.class);
    }
    @Test
    void FamilyCarHasNormalSpeed(){
        assertNotNull(TestFamilyCar.getSpeedBehaviour());
        assertTrue(TestFamilyCar.getSpeedBehaviour().getClass() == NormalSpeed.class);
    }
    @Test
    void FamilyCarHasLuggage(){
        assertNotNull(TestFamilyCar.getLuggageBehaviour());
        assertTrue(TestFamilyCar.getLuggageBehaviour().getClass() == CombinedSmallLargeLuggage.class);
        assertEquals( "2 small and 2 large", TestFamilyCar.getLuggageBehaviour().getLuggageProperties());
    }
}
