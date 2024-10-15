package VehiclesBehaviourTest;


import Vehicle_Behaviour.Speed.SlowSpeed;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SlowSpeedTest {
    SlowSpeed testSlowSpeed = new SlowSpeed();

    @Test
    void TestSlowSpeedHasType(){
        assertNotNull(testSlowSpeed.getSpeedType());
        assertEquals("slow speed",testSlowSpeed.getSpeedType());
    }
}