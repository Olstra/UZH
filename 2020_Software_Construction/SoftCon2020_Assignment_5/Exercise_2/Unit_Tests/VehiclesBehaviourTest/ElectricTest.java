package VehiclesBehaviourTest;

import Vehicle_Behaviour.Fuels.Electric;
import Vehicle_Behaviour.Fuels.FuelBehaviour;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ElectricTest {
    FuelBehaviour testElectric = new Electric();

    @Test
    void TestElectricHasType(){
        assertNotNull(testElectric.getFuelType());
        assertEquals("electric",testElectric.getFuelType());
    }
}