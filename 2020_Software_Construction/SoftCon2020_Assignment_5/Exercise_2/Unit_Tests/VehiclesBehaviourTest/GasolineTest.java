package VehiclesBehaviourTest;

import Vehicle_Behaviour.Fuels.Gasoline;
import Vehicle_Behaviour.Fuels.FuelBehaviour;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class GasolineTest {
    FuelBehaviour testGasoline= new Gasoline();

    @Test
    void TestGasolineHasType(){
        assertNotNull(testGasoline.getFuelType());
        assertEquals("gasoline",testGasoline.getFuelType());
    }
}