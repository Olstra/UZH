package VehiclesBehaviourTest;

import Vehicle_Behaviour.Price.PriceFixed;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceFixedTest {
    PriceFixed testPrice = new PriceFixed(12);
    @Test
    void HasFixedPrice(){
        assertNotNull(testPrice.getFormattedPrice());
        assertEquals("12 CHF", testPrice.getFormattedPrice());
        assertThrows(IllegalArgumentException.class , ()->new PriceFixed(-12) );
    }

}