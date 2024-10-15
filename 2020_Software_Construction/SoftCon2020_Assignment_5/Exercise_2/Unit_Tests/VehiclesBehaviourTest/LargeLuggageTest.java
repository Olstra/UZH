package VehiclesBehaviourTest;

import Vehicle_Behaviour.Luggage.LargeLuggage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargeLuggageTest {
    LargeLuggage testLuggage = new LargeLuggage(2);

    @Test
    void TestHasSmallLuggage(){
        assertEquals("2 large" , testLuggage.getLuggageProperties());
        assertThrows(IllegalArgumentException.class, ()->new LargeLuggage(-2));
    }

}