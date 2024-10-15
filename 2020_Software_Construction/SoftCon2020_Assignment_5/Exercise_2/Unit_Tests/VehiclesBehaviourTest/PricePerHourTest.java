package VehiclesBehaviourTest;

import Vehicle_Behaviour.Price.PricePerHour;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PricePerHourTest {
    PricePerHour testPrice = new PricePerHour(12);
    @Test
    void HasPricePerHour(){
        assertNotNull(testPrice.getFormattedPrice());
        assertEquals("12 CHF/h", testPrice.getFormattedPrice());
        assertThrows(IllegalArgumentException.class , ()->new PricePerHour(-12) );
    }

}