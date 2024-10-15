package Unit_Tests;
import bank.Customers.Customer;
import org.junit.jupiter.api.Test;
import static bank.Customers.CustomerStatus.*;
import static org.junit.jupiter.api.Assertions.*;

class IndividualTest {

    private final String testName = "Maximilian";
    private final String testSurname = "Müller";
    private final int testAge = 25;
    private final int testID = 1;
    private final Customer customer = new Customer(testName, testSurname, testAge, REGULAR);


    /**
     * TODO
     *
     * */
    @Test
    void CustomerHasName() {
        assertEquals(testName, customer.getName());
    }

    /**
     * TODO
     *
     * */
    @Test
    void CustomerHasSurname() {
        assertEquals(testSurname, customer.getSurname());
    }
    /**
     * TODO
     *
     * */
    @Test
    void CustomerHasUID() {
        customer.setID(1);
        assertEquals(testID, customer.getID());
        }
    }

