package VehiclesBehaviourTest;

import Vehicle_Behaviour.Fuels.Diesel;
import Vehicle_Behaviour.Fuels.FuelBehaviour;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class DieselTest {
FuelBehaviour testDiesel = new Diesel();

@Test
void TestDieselHasType(){
    assertNotNull(testDiesel.getFuelType());
    assertEquals("diesel",testDiesel.getFuelType());
}
}