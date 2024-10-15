package VehiclesBehaviourTest;

import Vehicle_Behaviour.Speed.NormalSpeed;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class NormalSpeedTest {
    NormalSpeed testNormalSpeed = new NormalSpeed();

    @Test
    void TestNormalSpeedHasType(){
        assertNotNull(testNormalSpeed.getSpeedType());
        assertEquals("normal speed",testNormalSpeed.getSpeedType());
    }
}