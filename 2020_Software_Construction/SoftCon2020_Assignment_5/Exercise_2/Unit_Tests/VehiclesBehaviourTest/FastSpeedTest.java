package VehiclesBehaviourTest;

import Vehicle_Behaviour.Speed.FastSpeed;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class FastSpeedTest {
    FastSpeed testFastSpeed = new FastSpeed();

    @Test
    void TestFastSpeedHasType(){
        assertNotNull(testFastSpeed.getSpeedType());
        assertEquals("fast speed",testFastSpeed.getSpeedType());
    }
}