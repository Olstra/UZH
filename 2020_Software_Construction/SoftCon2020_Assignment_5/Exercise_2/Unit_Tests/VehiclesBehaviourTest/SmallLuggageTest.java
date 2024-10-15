package VehiclesBehaviourTest;

import Vehicle_Behaviour.Luggage.SmallLuggage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmallLuggageTest {
    SmallLuggage testLuggage = new SmallLuggage(2);

    @Test
    void TestHasSmallLuggage(){
        assertEquals("2 small" , testLuggage.getLuggageProperties());
        assertThrows(IllegalArgumentException.class, ()->new SmallLuggage(-2));
    }

}