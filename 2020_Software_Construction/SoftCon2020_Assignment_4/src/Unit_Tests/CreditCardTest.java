package Unit_Tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import bank.CreditCard;
import bank.Customers.*;
import static bank.Customers.CustomerStatus.*;
import java.time.YearMonth;


class CreditCardTest {

    // Test set-up
    // Create test customers+cards of each type /////////////////////////////////////////////////////
    private final String testName = "Alfonso";
    private final String testSureName = "Ramirez";
    private final int testAge = 25;

    Customer testCustomer = new Customer(testName, testSureName, testAge, REGULAR);
    Customer testCustomerGolden = new Customer(testName, testSureName, testAge,GOLDEN);
    Customer testCustomerPlatinum = new Customer(testName, testSureName, testAge,PLATINUM);

    CreditCard testCard = new CreditCard(testCustomer);
    CreditCard testCardGolden = new CreditCard(testCustomerGolden);
    CreditCard testCardPlatinum = new CreditCard(testCustomerPlatinum);
    /////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Checks that the credit card contains the owner's name.
     *
     * */
    @Test
    void CreditCardContainsOwnerName() {
        assertEquals (this.testCustomer.getName(), this.testCard.getOwnerName() );
    }


    /**
     * Checks that the credit card contains the owner's surename.
     *
     * */
    @Test
    void CreditCardContainsOwnerSureName() {
        assertEquals (this.testCustomer.getSurname(), this.testCard.getOwnerSureName() );
    }

    /**
     * Checks that the credit card contains a serial number
     *
     * */
    @Test
    void CreditCardContainsSerialNr() {
        assertNotNull(this.testCard.getSerialNr());
    }

    /**
     * Checks that the credit card contains a security code
     *
     * */
    @Test
    void CreditCardContainsSecurityCode() {
        assertNotNull(this.testCard.getSecurityCode());
    }

    /**
     * Checks that the credit card's security code are 3 digits
     * aka is a number between 100 and 999
     *
     * */
    @Test
    void CreditCardContainsCorrectSecurityCode() {
        int code = this.testCardGolden.getSecurityCode();

        assertTrue(code >= 100 && code <= 999);
    }

    /**
     * Checks that the credit card contains an expiration date
     *
     * */
    @Test
    void CreditCardContainsExpirationDate() {
        assertNotNull(this.testCard.getExpirationDate());
    }

    /**
     * Checks that the credit card's expiration date is really a date
     *
     * */
    @Test
    void CreditCardContainsValidExpirationDate() {
        assertEquals(YearMonth.class, this.testCardGolden.getExpirationDate().getClass());
    }

    /**
     * Checks that the credit card' expiration date is really a date
     *
     * */
    @Test
    void CCBelongsToCustomer() {
       assertEquals(this.testCustomer.getCustomerStatus(), this.testCard.getType());
    }

    /**
     * Checks that the credit card' expiration date is really a date
     *
     * */
    @Test
    void GoldCCBelongsToGoldCustomer() {
        assertEquals(this.testCustomerGolden.getCustomerStatus(), this.testCardGolden.getType());
    }

    /**
     * Checks that the credit card' expiration date is really a date
     *
     * */
    @Test
    void PlatinumCCBelongsToPlatinumCustomer() {
       assertEquals(this.testCustomerPlatinum.getCustomerStatus(), this.testCardPlatinum.getType());
    }

}