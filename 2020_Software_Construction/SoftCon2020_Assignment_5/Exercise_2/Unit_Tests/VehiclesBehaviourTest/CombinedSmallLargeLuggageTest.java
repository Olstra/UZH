package VehiclesBehaviourTest;

import Vehicle_Behaviour.Luggage.CombinedSmallLargeLuggage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombinedSmallLargeLuggageTest {
    CombinedSmallLargeLuggage testLuggage = new CombinedSmallLargeLuggage(2,2);
    // the handling has been already tested for the class small- and largeLuggage
    @Test
    void TestCombinedSmallLargeLuggage(){
        assertEquals("2 small and 2 large",testLuggage.getLuggageProperties());
        assertThrows(IllegalArgumentException.class, ()-> new CombinedSmallLargeLuggage(-2,2));
        assertThrows(IllegalArgumentException.class, ()-> new CombinedSmallLargeLuggage(2,-2));
    }
}