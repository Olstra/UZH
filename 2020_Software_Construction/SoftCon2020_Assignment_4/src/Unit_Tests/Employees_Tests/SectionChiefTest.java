package Unit_Tests.Employees_Tests;

import bank.Customers.Customer;
import bank.Customers.CustomerStatus;
import org.junit.jupiter.api.Test;

import static bank.Customers.CustomerStatus.*;
import static org.junit.jupiter.api.Assertions.*;
import bank.Employees.SectionChief;

class SectionChiefTest {

    // Employee test attributes
    private final String testName = "Justin";
    private final String testSurname = "Young";
    private final String testCity = "Santa Monica";

    // Customer test attributes
    private final String customerName = "Natalie";
    private final String customerSurname = "Portman";
    private final int customerAge = 39;

    private final SectionChief employee = new SectionChief(testName, testSurname, testCity);
    private final Customer customer = new Customer(customerName, customerSurname, customerAge, GOLDEN);

    /**
     * Testcase sees if the Section Chief has a city using the method
     * @return city of Section Chief
     **/

    @Test
    void SectionChiefHasCity() {

        assertEquals(testCity, employee.getCity());
    }


    /**
     * Tests if the Section chief can downgrade a customer to Regular status
     * @return getCustomerStatus() returns the status
     *
     * Checks if the method updates to the expected Status
     */

    @Test
    void SectionChiefDowngradesToRegular(){
        employee.downgradeToRegular(customer);
        CustomerStatus expected = REGULAR;
        assertEquals(expected,customer.getCustomerStatus());
    }

    /**
     * Tests if the Section chief can upgrade a customer to Platinum status
     * @return getCustomerStatus() returns the status
     *
     * Checks if the method updates to the expected Status
     */

    @Test
    void MainChiefUpgradesToPlatinum(){
        employee.upgradeToPlatinum(customer);
        CustomerStatus expected = PLATINUM;
        assertEquals(expected,customer.getCustomerStatus());
    }
}